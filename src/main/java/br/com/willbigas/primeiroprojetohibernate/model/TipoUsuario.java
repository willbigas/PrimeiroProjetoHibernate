package br.com.willbigas.primeiroprojetohibernate.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Will
 */
@Entity
public class TipoUsuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean ativo;
    private Integer tipoPermissao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getTipoPermissao() {
        return tipoPermissao;
    }

    public void setTipoPermissao(Integer tipoPermissao) {
        this.tipoPermissao = tipoPermissao;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "id=" + id + ", nome=" + nome + ", ativo=" + ativo + ", tipoPermissao=" + tipoPermissao + '}';
    }

}
