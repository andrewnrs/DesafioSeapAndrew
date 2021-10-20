package seap.desafio.testejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import seap.desafio.testejava.model.Servidor;
import seap.desafio.testejava.service.ServidorService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/Servidor")
public class ServidorController {

    private final ServidorService _servidorService;

    @Autowired
    public ServidorController(ServidorService servidorService) {
        this._servidorService = servidorService;
    }

    @GetMapping
    public List<Servidor> BuscaTodosItens(){
        return _servidorService.BuscaTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servidor salva(@Valid @RequestBody Servidor servidor) {

        Optional<Servidor> produtoComNome = _servidorService.BuscaPorNome(servidor.getNome());
        Optional<Servidor> produtoComMatricula = _servidorService.BuscaPorMatricula(servidor.getMatricula());

        if (produtoComNome.isPresent() ||  produtoComMatricula.isPresent() ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe um Servidor cadastrado com mesmo nome ou Matricula");
        }

        return _servidorService.Salvar(servidor);
    }

    @GetMapping("/PorNome/{nome}")
    public Optional<Servidor> BuscaPorNome(@PathVariable String nome){
        return _servidorService.BuscaPorNome(nome);
    }

    @GetMapping("/TodosPorNome/{nome}")
    public Optional<List<Servidor>> BuscaTodosPorNome(@PathVariable String nome){
        return _servidorService.BuscaTodosPorNome(nome);
    }

    @GetMapping("/PorMatricula/{matricula}")
    public Optional<Servidor> BuscaPorMatricula(@PathVariable String matricula){
        return _servidorService.BuscaPorMatricula(matricula);
    }

    @GetMapping("/TodosPorMatricula/{matricula}")
    public Optional<List<Servidor>> BuscaTodosPorMatricula(@PathVariable String matricula){
        return _servidorService.BuscaTodosPorMatricla(matricula);
    }
}
