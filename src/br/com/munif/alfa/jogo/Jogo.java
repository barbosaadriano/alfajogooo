package br.com.munif.alfa.jogo;

import br.com.munif.alfa.jogo.entidades.Bandido;
import br.com.munif.alfa.jogo.entidades.Heroi;
import javax.swing.JOptionPane;

public class Jogo {

    public static void main(String[] args) {
        Bandido bandido=new Bandido();
        bandido.setNome("Lula");
        bandido.setCrime("contrabandista");
        
        Heroi renan = new Heroi("Renan");
        System.out.println(renan.getDescricao());
        System.out.println(bandido.getDescricao());
        try {
            renan.setEnergia(153);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Problemas", JOptionPane.ERROR_MESSAGE);

            System.out.println("Problema:" + ex.getMessage());
        }

    }
}


