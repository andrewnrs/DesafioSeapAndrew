package seap.desafio.testejava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import seap.desafio.testejava.model.Servidor;
import seap.desafio.testejava.repository.IServidorRepository;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ServidorService {

    private final IServidorRepository _servidorRepository;

    @Autowired
    public ServidorService(IServidorRepository servidorRepository){
        this._servidorRepository = servidorRepository;
    }

    @Transactional
    public Optional<Servidor> BuscaPorNome(@NotNull String nome){
        return Optional.ofNullable(_servidorRepository.findByNome(nome));
    }

    @Transactional
    public Optional<List<Servidor>> BuscaTodosPorNome(@NotNull String nome){
        return Optional.ofNullable(_servidorRepository.findAllByNomeIsLike(nome));
    }

    @Transactional
    public Optional<Servidor> BuscaPorMatricula(@NotNull String matricula){
        return Optional.ofNullable(_servidorRepository.findByMatricula(matricula));
    }

    @Transactional
    public Optional<List<Servidor>> BuscaTodosPorMatricla(@NotNull String matricula){
        return Optional.ofNullable(_servidorRepository.findAllByMatriculaIsLike(matricula));
    }

    @Transactional
    public List<Servidor> BuscaTodos() {
        return _servidorRepository.findAll();
    }

    @Transactional
    public Servidor Salvar(Servidor servidor) {
        servidor.setDataCadastro(Timestamp.valueOf(LocalDateTime.now()));
        return _servidorRepository.save(servidor);
    }
}
