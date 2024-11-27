package com.maratonaApi.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.model.Empresa;
import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.repository.CorredoresRepository;
import com.maratonaApi.model.repository.EmpresasRepository;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.repository.InscricaoRepository;
import com.maratonaApi.model.repository.MaratonasRepository;

import com.maratonaApi.dto.MaratonaComEmpresaDTO;

@Service
public class MaratonaService {
	@Autowired
	private MaratonasRepository maratonaRepository;

	@Autowired
	private EmpresasRepository empresaRepository;
	
	@Autowired
    private InscricaoRepository inscricaoRepository;

	@Autowired
	private CorredoresRepository corredorRepository;

	@Autowired
	private EmailService emailService;
	
	// Obter todas as maratonas
	public List<Maratona> obterTodos(){
		return maratonaRepository.findAll();
	}

	//Obter maratonas concluidas de um determinado corredor
	public List<Maratona> obterConcluidasPorCorredor(Integer idCorredor) {
		return inscricaoRepository.findMaratonasConcluidasByIdCorredor(idCorredor);
	}

	//Lista maratonas abertas de um determinado corredor
	public List<Maratona> obterAbertasPorCorredor(Integer idCorredor) {
		return inscricaoRepository.findMaratonasAbertasByIdCorredor(idCorredor);
	}

	// Listar maratonas por status
	public List<Maratona> listarPorStatus(Maratona.StatusMaratona status) {
		return maratonaRepository.findByStatus(status);
	}

	// Listar maratonas por criador
	public List<Maratona> listarPorCriador(Integer criador) {
		return maratonaRepository.findByCriador(criador);
	}
	
	// Ler uma maratona pelo ID
	public MaratonaComEmpresaDTO getMaratonaWithEmpresa(Integer id) {
		return maratonaRepository.findMaratonaWithEmpresa(id);
	}

	// Verificar se a maratona está em andamento
	public boolean estaEmAndamento(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null) {
			// Verifica se o status é "EM_ANDAMENTO"
			return maratona.getStatus().equals(Maratona.StatusMaratona.EM_ANDAMENTO);
		}
		return false; // Se a maratona não for encontrada ou não estiver EM_ANDAMENTO
	}


	// Inserir uma nova maratona
	public Maratona insert(Maratona maratona) throws MessagingException, IOException {
		// Definindo o status inicial para "ABERTA"
		maratona.setStatus(Maratona.StatusMaratona.ABERTA_PARA_INSCRICAO);

		// Validando as datas de início e final
		if (maratona.getDataInicio().isAfter(maratona.getDataFinal())) {
			throw new IllegalArgumentException("A data de início não pode ser posterior à data final.");
		}

		// Salvando a maratona no banco de dados
		Maratona savedMaratona = maratonaRepository.save(maratona);

		// Recuperando informações da empresa criadora
		Empresa empresa = empresaRepository.findById(maratona.getCriador())
				.orElseThrow(() -> new EntityNotFoundException("Empresa criadora não encontrada!"));

		// Configurando os dados para o e-mail
		String emailTemplatePath = "templates/empresa-criou-maratona.html";
		Map<String, Object> templateModel = Map.of(
				"nomeUsuario", empresa.getUsuario(),
				"nomeMaratona", maratona.getNome(),
				"dataInicio", maratona.getDataInicio().toString(),
				"dataFinal", maratona.getDataFinal().toString()
		);

		// Enviando o e-mail de confirmação para a empresa criadora
		emailService.enviarEmailComTemplate(
				empresa.getEmail(),
				"Confirmação de Criação da Maratona",
				emailTemplatePath,
				templateModel
		);

		return savedMaratona;
	}

	// Atualizar uma maratona existente
	public Maratona update(Maratona maratona, Integer idMaratona) {
		Maratona maratonaUpdate = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setNome(maratona.getNome());
			maratonaUpdate.setLocal(maratona.getLocal());
			maratonaUpdate.setDataInicio(maratona.getDataInicio());
			maratonaUpdate.setDescricao(maratona.getDescricao());
			maratonaUpdate.setDataFinal(maratona.getDataFinal());
			maratonaUpdate.setLimiteParticipantes(maratona.getLimiteParticipantes());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setDistancia(maratona.getDistancia());
			maratonaUpdate.setRegras(maratona.getRegras());
			maratonaUpdate.setValor(maratona.getValor());
			maratonaUpdate.setTipoTerreno(maratona.getTipoTerreno());
			maratonaUpdate.setClimaEsperado(maratona.getClimaEsperado());

			if (maratona.getDataInicio().isAfter(maratona.getDataFinal())) {
				throw new IllegalArgumentException("A data de início não pode ser após a data final.");
			}
			return maratonaRepository.save(maratonaUpdate);
			
		}
		return maratonaUpdate; 
	}

	// Atualizar status para "ABERTA" de uma maratona e enviar e-mail
	public Maratona abrir(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.ABERTA) {
			maratona.setStatus(Maratona.StatusMaratona.ABERTA);
			Maratona maratonaAtualizada = maratonaRepository.save(maratona);

			// Recuperar corredores inscritos na maratona
			List<Inscricao> inscricoes = inscricaoRepository.findByIdMaratona(idMaratona);

			for (Inscricao inscricao : inscricoes) {
				// Recuperar informações do corredor
				Corredor corredor = corredorRepository.findById(inscricao.getIdCorredor())
						.orElseThrow(() -> new EntityNotFoundException("Corredor não encontrado!"));

				// Enviar e-mail ao corredor
				try {
					emailService.enviarEmailComTemplate(
							corredor.getEmail(),
							"Maratona Aberta!",
							"templates/corredor-maratona-aberta.html",
							Map.of(
									"nomeCorredor", corredor.getNome(),
									"nomeMaratona", maratona.getNome()
							)
					);
				} catch (Exception e) {
					e.printStackTrace(); // Log da falha no envio de e-mail
				}
			}

			return maratonaAtualizada;
		}
		return null; // Retorna null se a maratona já está aberta ou não existe
	}


	// Atualizar status para "EM_ANDAMENTO" de uma maratona
	public Maratona iniciar(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.EM_ANDAMENTO) {
			maratona.setStatus(Maratona.StatusMaratona.EM_ANDAMENTO);
			return maratonaRepository.save(maratona);
		}
		return null;  // Retorna null se a maratona já está em andamento ou não existe
	}

	// Atualizar status para "CONCLUIDA" de uma maratona e enviar e-mail
	public Maratona concluir(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.CONCLUIDA) {
			maratona.setStatus(Maratona.StatusMaratona.CONCLUIDA);
			Maratona maratonaAtualizada = maratonaRepository.save(maratona);

			// Recuperando informações da empresa criadora
			Empresa empresa = empresaRepository.findById(maratona.getCriador())
					.orElseThrow(() -> new EntityNotFoundException("Empresa criadora não encontrada!"));

			// Enviar e-mail ao criador da maratona
			try {
				emailService.enviarEmailComTemplate(
						empresa.getEmail(),
						"Maratona Concluída com Sucesso!",
						"templates/empresa-maratona-concluida.html",
						Map.of(
								"nomeUsuario", empresa.getUsuario(),
								"nomeMaratona", maratona.getNome()
						)
				);
			} catch (Exception e) {
				e.printStackTrace(); // Log da falha no envio de e-mail
			}

			return maratonaAtualizada;
		}
		return null; // Retorna null se a maratona já está concluída ou não existe
	}

	// Atualizar status para "CANCELADA" de uma maratona e enviar e-mail para todos os corredores
	public Maratona cancelar(Integer idMaratona) {
		Maratona maratona = maratonaRepository.findById(idMaratona).orElse(null);
		if (maratona != null && maratona.getStatus() != Maratona.StatusMaratona.CANCELADA) {
			maratona.setStatus(Maratona.StatusMaratona.CANCELADA);
			Maratona maratonaAtualizada = maratonaRepository.save(maratona);

			// Recuperando informações da empresa criadora
			Empresa empresa = empresaRepository.findById(maratona.getCriador())
					.orElseThrow(() -> new EntityNotFoundException("Empresa criadora não encontrada!"));

			// Enviar e-mail ao criador da maratona
			try {
				emailService.enviarEmailComTemplate(
						empresa.getEmail(),
						"Maratona Cancelada",
						"templates/empresa-maratona-cancelada.html",
						Map.of(
								"nomeUsuario", empresa.getUsuario(),
								"nomeMaratona", maratona.getNome()
						)
				);
			} catch (Exception e) {
				e.printStackTrace(); // Log da falha no envio de e-mail
			}

			// Recuperar todos os corredores inscritos na maratona cancelada
			List<Inscricao> inscricoes = inscricaoRepository.findByIdMaratona(idMaratona);

			// Enviar e-mail a cada corredor inscrito
			for (Inscricao inscricao : inscricoes) {
				Corredor corredor = corredorRepository.findById(inscricao.getIdCorredor())
						.orElseThrow(() -> new EntityNotFoundException("Corredor não encontrado!"));
				try {
					emailService.enviarEmailComTemplate(
							corredor.getEmail(),
							"Maratona Cancelada",
							"templates/corredor-maratona-cancelada.html",
							Map.of(
									"nomeCorredor", corredor.getNome(),
									"nomeMaratona", maratona.getNome()
							)
					);
				} catch (Exception e) {
					e.printStackTrace(); // Log da falha no envio de e-mail
				}
			}

			return maratonaAtualizada;
		}
		return null; // Retorna null se a maratona já está em andamento ou não existe
	}

	//atualizar status da maratona
	public Maratona updateStatus(Maratona maratona, Integer id) {
		Maratona maratonaUpdate = maratonaRepository.findById(id).orElse(null);
		if (maratonaUpdate != null) {
			maratonaUpdate.setStatus(maratona.getStatus());
			return maratonaRepository.save(maratonaUpdate);
		
		}
		return maratonaUpdate; 
	}
	
	// Deletar
	public void deleteById(Integer idMaratona) {
		maratonaRepository.deleteById(idMaratona);
	}
	
	
}
