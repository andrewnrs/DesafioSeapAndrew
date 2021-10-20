package seap.desafio.testejava.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Servidor {
    private int id;
    private String matricula;
    private String nome;
    private Timestamp dataCadastro;
    private int lotacaoId;
//    private Lotacao Lotacao;

    @Id
    @Column(name = "id", table = "servidor", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "matricula", table = "servidor", nullable = false, length = 30)
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Basic
    @Column(name = "nome", table = "servidor", nullable = true, length = 400)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "data_cadastro", table = "servidor", nullable = true)
    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Basic
    @Column(name = "lotacao_id", table = "servidor", nullable = false)
    public int getLotacaoId() {
        return lotacaoId;
    }

    public void setLotacaoId(int lotacaoId) {
        this.lotacaoId = lotacaoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Servidor servidor = (Servidor) o;

        if (id != servidor.id) return false;
        if (lotacaoId != servidor.lotacaoId) return false;
        if (matricula != null ? !matricula.equals(servidor.matricula) : servidor.matricula != null) return false;
        if (nome != null ? !nome.equals(servidor.nome) : servidor.nome != null) return false;
        if (dataCadastro != null ? !dataCadastro.equals(servidor.dataCadastro) : servidor.dataCadastro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        result = 31 * result + lotacaoId;
        return result;
    }

//    @OneToOne
//    @JoinColumn(name = "Lotacao_id", referencedColumnName = "id", nullable = false, table = "servidor")
//    public Lotacao getLotacao() {
//        return Lotacao;
//    }
//
//    public void setLotacao(Lotacao lotacao) {
//        Lotacao = lotacao;
//    }
}
