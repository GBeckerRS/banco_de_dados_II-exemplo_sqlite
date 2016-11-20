package br.unisinos.exemplosqlite;

/**
 * Created by Cassio on 19/11/2016.
 */
public class Personagem {
    private int id;
    private String nome;

    Personagem(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    Personagem(String nome){
        this.nome = nome;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }
}
