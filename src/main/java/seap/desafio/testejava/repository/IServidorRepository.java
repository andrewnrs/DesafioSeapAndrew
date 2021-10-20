package seap.desafio.testejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seap.desafio.testejava.model.Servidor;

import java.util.List;

@Repository
public interface IServidorRepository extends JpaRepository<Servidor, Integer> {

    Servidor findByNome(String nome);

    List<Servidor> findAllByNomeIsLike(String nome);

    Servidor findByMatricula(String matricula);

    List<Servidor> findAllByMatriculaIsLike(String matricula);
}
