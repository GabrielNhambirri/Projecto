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
    private String nome;
    private String nome_coach;
    private Jogador[] jogador;
    ////////////////
    public Equipe() {
        this.jogador = new Jogador[15];
    }
    
    public Equipe(final String nome, final String nome_coach) {
        this.jogador = new Jogador[15];
        this.nome = nome;
        this.nome_coach = nome_coach;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
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
    
    public void setJogador(final byte num, final Jogador jogador) {
        this.jogador[num] = jogador;
    }
}