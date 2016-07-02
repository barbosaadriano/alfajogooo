package br.com.munif.alfa.jogo.entidades;

import br.com.munif.alfa.jogo.services.Transportavel;

public class NPC implements Transportavel {

    private Lugar lugar;

    private String tipo;

    public NPC() {
        tipo = "Soldado";
    }

    public Lugar getLugar() {
        return lugar;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NPC{" + "tipo=" + tipo + '}';
    }

    @Override
    public void setLugar(Lugar novo) {
        this.lugar = novo;
    }

}
