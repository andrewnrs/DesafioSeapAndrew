package seap.desafio.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seap.desafio.testejava.model.Lotacao;
import seap.desafio.testejava.model.Servidor;

import java.util.List;

@Repository
public interface ILotacaoRepository extends JpaRepository<Lotacao, Integer> {

    Lotacao findByNome(String nome);

    List<Lotacao> findAllByNomeIsLike(String nome);

    List<Lotacao> findAllByDescricaoIsLike(String descricao);
}
