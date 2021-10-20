package seap.desafio.testejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seap.desafio.testejava.model.Lotacao;
import seap.desafio.testejava.model.Servidor;
import seap.desafio.testejava.repository.ILotacaoRepository;

import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LotacaoService {

    private final ILotacaoRepository _lotacaoRepository;

    @Autowired
    public LotacaoService(ILotacaoRepository lotacaoRepository){
        this._lotacaoRepository = lotacaoRepository;
    }

    @Transactional
    public Optional<Lotacao> BuscaPorNome(@NotNull String nome){
        return Optional.ofNullable(_lotacaoRepository.findByNome(nome));
    }

    @Transactional
    public Optional<List<Lotacao>> BuscaTodosPorNome(@NotNull String nome){
        return Optional.ofNullable(_lotacaoRepository.findAllByNomeIsLike(nome));
    }

    @Transactional
    public Optional<List<Lotacao>> BuscaTodosComDescricao(@NotNull String descricao){
        return Optional.ofNullable(_lotacaoRepository.findAllByDescricaoIsLike(descricao));
    }

    @Transactional
    public Optional<List<Lotacao>> BuscaTodos() {
        return Optional.of(_lotacaoRepository.findAll());
    }

    @Transactional
    public Lotacao  Salvar(Lotacao lotacao) {
        lotacao.setDataCadastro(Timestamp.valueOf(LocalDateTime.now()));
        return _lotacaoRepository.save(lotacao);
    }
}
