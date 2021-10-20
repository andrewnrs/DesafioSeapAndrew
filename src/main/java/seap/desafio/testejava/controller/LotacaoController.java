package seap.desafio.testejava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import seap.desafio.testejava.model.Lotacao;
import seap.desafio.testejava.service.LotacaoService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/Lotacao")
public class LotacaoController {

    private final LotacaoService _lotacaoService;

    @Autowired
    public LotacaoController(LotacaoService lotacaoService) {
        this._lotacaoService = lotacaoService;
    }

    @GetMapping
    public Optional<List<Lotacao>> BuscaTodosItens(){
        return _lotacaoService.BuscaTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lotacao salva(@Valid @RequestBody Lotacao lotacao) {

        Optional<Lotacao> produtoComNome = _lotacaoService.BuscaPorNome(lotacao.getNome());

        if (produtoComNome.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma Lotação cadastrado com o mesmo nome");
        }

        return _lotacaoService.Salvar(lotacao);
    }

    @GetMapping("/PorNome/{nome}")
    public Optional<Lotacao> BuscaPorNome(@PathVariable String nome){
        return _lotacaoService.BuscaPorNome(nome);
    }

    @GetMapping("/TodosPorNome/{nome}")
    public Optional<List<Lotacao>> BuscaTodosPorNome(@PathVariable String nome){
        return _lotacaoService.BuscaTodosPorNome(nome);
    }
}
