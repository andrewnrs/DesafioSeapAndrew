package seap.desafio.testejava.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Lotacao {
    private int id;
    private String nome;
    private String descricao;
    private Timestamp dataCadastro;

    @Id
    @Column(name = "id", table = "lotacao", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nome", table = "lotacao", nullable = false, length = 400)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "descricao", table = "lotacao", nullable = true, length = 200)
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Basic
    @Column(name = "data_cadastro", table = "lotacao", nullable = true)
    public Timestamp getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Timestamp dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotacao lotacao = (Lotacao) o;

        if (id != lotacao.id) return false;
        if (descricao != null ? !descricao.equals(lotacao.descricao) : lotacao.descricao != null) return false;
        if (dataCadastro != null ? !dataCadastro.equals(lotacao.dataCadastro) : lotacao.dataCadastro != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dataCadastro != null ? dataCadastro.hashCode() : 0);
        return result;
    }
}
