/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author munif
 */
public class Lugar {

    private String nome;
    private String descricao;

    private List<Personagem> pernsonagens;

    public Lugar() {
        init();
    }

    public Lugar(String nome, String descricao) {
        init();
        this.nome = nome;
        this.descricao = descricao;
    }

    public List<Personagem> getPernsonagens() {
        return pernsonagens;
    }

    public void setPernsonagens(List<Personagem> pernsonagens) {
        this.pernsonagens = pernsonagens;
    }

    public String getNome() {
        return nome;
    }

    private void init() {
        pernsonagens = new LinkedList<>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Lugar{" + "nome=" + nome + ", descricao=" + descricao + '}';
    }

}
