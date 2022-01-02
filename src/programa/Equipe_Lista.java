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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Equipe_Lista {
    Equipe equipe = new Equipe();
    Validacao valida = new Validacao();
    private String nome;
    private static byte qtd_jogador = 0;
    private static byte menorIndice = 0;
    BufferedReader x = new BufferedReader(new InputStreamReader(System.in));

    public void inserirNome() throws IOException {
        System.out.println("Introduza o nome da equipe: ");
        this.nome = this.x.readLine();
        if (this.nome.equalsIgnoreCase("")) {
            System.out.println("Introduza um nome valido!");
            this.inserirNome();
        } else {
            this.equipe.setNome(this.nome);
        }
    }

    public void inserirNome_Coach() throws IOException {
        System.out.println("Introduza o nome do treinador: ");
        this.nome = this.x.readLine();
        if (this.nome.equalsIgnoreCase("")) {
            System.out.println("Introduza um nome valido!");
            this.inserirNome_Coach();
        } else {
            this.equipe.setNome_coach(this.nome);
        }
    }

    public void adicionarJogador() throws IOException {
        if (qtd_jogador != 15) {
            String pedido = "Introduza o nome do Jogador:  ";
            String nome = this.valida.validaString(pedido, (byte)5, (byte)45);
            pedido = "Introduza a sua idade";
            byte idade = this.valida.validaByte(pedido, (byte)5, (byte)35);
            byte numero = menorIndice;
            Jogador jogador = new Jogador(nome, idade, numero);
            for (int i = menorIndice + 1; i < qtd_jogador; ++i) {
                if (this.equipe.getJogador((byte)i) != null) continue;
                menorIndice = (byte)i;
                break;
            }
            this.equipe.setJogador(numero, jogador);
            qtd_jogador = (byte)(qtd_jogador + 1);
        } else {
            System.out.println("A equipe esta lotada!");
        }
    }

    public void removerJogador(byte num) {
        if (num < 15) {
            this.equipe.setJogador(num, null);
            if (num < menorIndice) {
                menorIndice = num;
            }
        }
    }

    public void imprimaJogador(byte num) {
        if (num < 15) {
            System.out.println("==============================");
            System.out.println("    Informacoes do Jogador    ");
            System.out.println("==============================");
            System.out.println("NOME: " + this.equipe.getJogador(num).getNome());
            System.out.println("IDADE: " + this.equipe.getJogador(num).getIdade());
            System.out.println("EQUIPE: " + this.equipe.getNome());
            System.out.println("TREINADOR: " + this.equipe.getNome_coach());
        } else {
            System.out.println("Jogador nao existe");
        }
    }

    public void verificaJogador(byte num) {
        if (num < 15) {
            if (this.equipe.getJogador(num) == null) {
                System.out.println("O Jogador nao exite");
            } else {
                System.out.println("O Jogador existe");
            }
        } else {
            System.out.println("O indice nao e valido!");
        }
    }
}