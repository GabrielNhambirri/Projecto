/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author Gabriel
 */
public class Equipe
{//Comentei agora
 //Atributos private foram substituidos por protected, devido a heranca aplicada em equipe lista   
    protected String nome_equipe, id;
    protected String nome_coach;
    protected Jogador[] jogador;
    
    public Equipe() {
        this.jogador = new Jogador[15];
    }
    
    public Equipe(final String nome, final String nome_coach) {
        this.jogador = new Jogador[15];
        this.nome_equipe = nome;
        this.nome_coach = nome_coach;
    }
    
    public String getNome() {
        return this.nome_equipe;
    }
    
    public void setNome(final String nome) {
        this.nome_equipe = nome;
    }
    
    public String getNome_coach() {
        return this.nome_coach;
    }
    
    public void setNome_coach(final String nome_coach) {
        this.nome_coach = nome_coach;
    }
    
    public Jogador getJogador(final byte num) {
        return this.jogador[num];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    public void setJogador(final byte num, final Jogador jogador) {
        this.jogador[num] = jogador;
    }
}