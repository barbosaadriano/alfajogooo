package br.com.munif.alfa.jogo;

import br.com.munif.alfa.jogo.entidades.Bandido;
import br.com.munif.alfa.jogo.entidades.Heroi;
import br.com.munif.alfa.jogo.entidades.Lugar;
import br.com.munif.alfa.jogo.entidades.NPC;
import br.com.munif.alfa.jogo.entidades.Personagem;
import br.com.munif.alfa.jogo.services.TransporteService;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Jogo {

    public static void main(String[] args) {

        Bandido bandido = new Bandido();
        bandido.setNome("Lula");
        bandido.setCrime("contrabandista");
        Heroi renan = new Heroi("Renan");
        Heroi renanJr = new Heroi("Renan");

        if (renan.equals(renanJr)) {
            System.out.println("Iguais");
        } else {
            System.out.println("Diferentes");
        }
        
        

        NPC[] npcs = new NPC[10];
        for (int i = 0; i < 10; i++) {
            npcs[i] = new NPC();
        }

        Lugar casa = new Lugar("Casa", "Esta é uma casa bonita");
        Lugar fabrica = new Lugar("Fábrica", "Esta é uma fábrica de chocolate");
        TransporteService ts = TransporteService.getInstancia();
        ts.transporta(renan, fabrica);
        ts.transporta(npcs[4], casa);

        descreve(renan);
        descreve(casa);

        System.out.println("---> Jogo com " + Personagem.getContador() + " personagens");

    }

    public static void descreve(Object obj) {
        Class classe = obj.getClass();
        System.out.println("--->Classe:" + classe.getSimpleName());

        Method[] metodos = classe.getMethods();
        for (Method m : metodos) {
            System.out.println("---->" + m.getName());
        }
        System.out.println("Atributos");
        ArrayList<Field> atributos = atributos(classe);
        try {
            System.out.print("insert into " + classe.getSimpleName() + "(");
            for (Field atributo : atributos) {
                System.out.print(atributo.getName() + ",");
            }
            System.out.print(") values (");

            for (Field atributo : atributos) {
                Object valor;
                atributo.setAccessible(true);
                valor = atributo.get(obj);

                System.out.print("'" + valor + "',");
            }
            System.out.println(")");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        try {
//            Method method = classe.getMethod("setNome", String.class);
//            method.invoke(obj, "SpiderRenan");
//
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }

    }

    public static ArrayList<Field> atributos(Class classe) {
        ArrayList<Field> atributos = new ArrayList<>();
        if (!classe.getSuperclass().equals(Object.class)) {
            ArrayList<Field> atributosDaSuper = atributos(classe.getSuperclass());
            atributos.addAll(atributosDaSuper);
        }

        for (Field f : classe.getDeclaredFields()) {
            atributos.add(f);
        }
        return atributos;
    }
}
