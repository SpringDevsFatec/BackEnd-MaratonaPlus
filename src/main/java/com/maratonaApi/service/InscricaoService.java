package com.maratonaApi.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import com.maratonaApi.model.Corredor;
import com.maratonaApi.model.Maratona;
import com.maratonaApi.model.repository.CorredoresRepository;
import com.maratonaApi.model.repository.MaratonasRepository;
import jakarta.mail.MessagingException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maratonaApi.model.Inscricao;
import com.maratonaApi.model.repository.InscricaoRepository;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepository;

	@Autowired
	private CorredoresRepository corredorRepository;

	@Autowired
	private MaratonasRepository maratonaRepository;

	@Autowired
	private EmailService emailService;

	// Obter todas as inscrições
	public List<Inscricao> obterTodo() { return inscricaoRepository.findAll(); }
	
	// Ler uma inscrição pelo ID
	public Inscricao read(Integer idInscricao) {
		return inscricaoRepository.findById(idInscricao).orElse(null);
	}
	
	// Inserir uma nova inscrição
	@Transactional
	public Inscricao insert(Inscricao inscricao) throws MessagingException, IOException {
		// Definindo o status e a data/hora de inscrição
		inscricao.setStatus(Inscricao.StatusInscricao.INSCRITO);
		inscricao.setDataHora(LocalDateTime.now());

		// Salvando a inscrição no banco de dados
		Inscricao savedInscricao = inscricaoRepository.save(inscricao);

		// Recuperando informações do corredor e da maratona
		Corredor corredor = corredorRepository.findById(inscricao.getIdCorredor())
				.orElseThrow(() -> new EntityNotFoundException("Corredor não encontrado!"));
		Maratona maratona = maratonaRepository.findById(inscricao.getIdMaratona())
				.orElseThrow(() -> new EntityNotFoundException("Maratona não encontrada!"));

		// Configurando os dados do e-mail
		String emailTemplatePath = "templates/corredor-inscricao.html";
		Map<String, Object> templateModel = Map.of(
				"nomeCorredor", corredor.getNome(),
				"nomeMaratona", maratona.getNome()
		);

		// Enviando o e-mail
		emailService.enviarEmailComTemplate(
				corredor.getEmail(),
				"Confirmação de Inscrição na Maratona",
				emailTemplatePath,
				templateModel
		);

		return savedInscricao;
	}

	public Integer getIdInscricao(Integer idCorredor, Integer idMaratona) {
		Inscricao inscricao = inscricaoRepository.findByIdCorredorAndIdMaratona(idCorredor, idMaratona);
		if (inscricao != null) {
			return inscricao.getIdInscricao();
		}
		return null; // Retorna null se não encontrar nenhuma inscrição
	}

	// Atualizar uma inscrição existente
	public Inscricao update(Inscricao inscricao, Integer idInscricao) {
		Inscricao inscricaoUpdate = inscricaoRepository.findById(idInscricao).orElse(null);  // Busca inscrição existente
		if (inscricaoUpdate != null) {
			// Impede a alteração do status se já foi finalizado ou desistido
			if (inscricaoUpdate.getStatus() == Inscricao.StatusInscricao.FINALIZADO || inscricaoUpdate.getStatus() == Inscricao.StatusInscricao.DESISTENCIA) {
				return null;  // Retorna null se o status não puder ser alterado
			}
			// Atualiza outros campos
			inscricaoUpdate.setIdCorredor(inscricao.getIdCorredor());
			inscricaoUpdate.setIdMaratona(inscricao.getIdMaratona());
			inscricaoUpdate.setFormaPagamento(inscricao.getFormaPagamento());
			inscricaoUpdate.setStatus(inscricao.getStatus());
			// Salva as alterações
			return inscricaoRepository.save(inscricaoUpdate);
		}
		return null;  // Retorna null caso a inscrição não seja encontrada
	}

	// Atualizar status para "DESISTENCIA" de uma inscrição
	public Inscricao desistirParticipacao(Integer idInscricao) {
		Inscricao inscricao = inscricaoRepository.findById(idInscricao).orElse(null);
		if (inscricao != null && inscricao.getStatus() != Inscricao.StatusInscricao.FINALIZADO) {
			inscricao.setStatus(Inscricao.StatusInscricao.DESISTENCIA);
			return inscricaoRepository.save(inscricao);
		}
		return null;  // Retorna null se a inscrição já foi finalizada ou não existe
	}
	// Atualizar status para "FINALIZADO" de uma inscrição
	public Inscricao finalizarParticipacao(Integer idInscricao) {
		Inscricao inscricao = inscricaoRepository.findById(idInscricao).orElse(null);
		if (inscricao != null && inscricao.getStatus() == Inscricao.StatusInscricao.PARTICIPANDO) {
			inscricao.setStatus(Inscricao.StatusInscricao.FINALIZADO);
			return inscricaoRepository.save(inscricao);
		}
		return null;  // Retorna null se a inscrição não estiver em status PARTICIPANDO
	}

    // Atualizar status para "FINALIZADO" de uma inscrição
    public Inscricao participacaoEmAndamento(Integer idInscricao) {
        Inscricao inscricao = inscricaoRepository.findById(idInscricao).orElse(null);
        if (inscricao != null && inscricao.getStatus() == Inscricao.StatusInscricao.INSCRITO) {
            inscricao.setStatus(Inscricao.StatusInscricao.PARTICIPANDO);
            return inscricaoRepository.save(inscricao);
        }
        return null;  // Retorna null se a inscrição não estiver em status PARTICIPANDO
    }

	/*/ atualizar o status da inscricao
	public Inscricao updateStatus(Inscricao inscricao, Integer idInscricao) {
		Inscricao inscricaoUpdate = inscricaoRepository.findById(idInscricao).orElse(null);
		if (inscricaoUpdate != null) {
			inscricaoUpdate.setStatus(inscricao.getStatus());
			inscricaoRepository.save(inscricaoUpdate);
		}
		return inscricaoUpdate;
	}
	*/

	// Deletar uma inscrição pelo ID
	public boolean deleteById(Integer idInscricao) {
		if (inscricaoRepository.existsById(idInscricao)) {
			inscricaoRepository.deleteById(idInscricao);
			return true;  // Retorna true se a inscrição foi deletada com sucesso
		}
		return false; // Retorna false se a inscrição não existir
	}
}
