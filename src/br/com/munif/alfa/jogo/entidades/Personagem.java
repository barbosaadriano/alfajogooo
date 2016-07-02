/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.alfa.jogo.entidades;

/**
 * Esta é a classe Personagem que serve para
 */
public abstract class Personagem {

    protected String nome;
    /**
     * Se chegar a zero morreu
     */
    private int energia;

    public Personagem() {
        System.out.println("Executando o construtor sem parâmetros de Personagem");
        nome = "Sem nome";
        energia = 100;
    }

    public Personagem(String nome) {
        System.out.println("Executando o construtor com parâmetros de Personagem");
        this.nome = nome;
        energia = 100;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEnergia(int energia) {
        if (energia >= 0 && energia <= 1000) {
            this.energia = energia;
        } else {
            throw new RuntimeException("Valor da energia inválido(" + energia + ")");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    abstract public String getDescricao();

    @Override
    public String toString() {
        String aRetornar;
        aRetornar = this.nome + " " + this.energia;
        return aRetornar;
    }

}
