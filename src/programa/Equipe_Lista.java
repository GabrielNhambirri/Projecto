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
import prototipo.Identificavel;

public class Equipe_Lista extends Equipe implements Identificavel {
    //Antigo nome_equipe Equipe_Lista
    //O objecto equipe foi eliminado, ao inves disso fiz a classe estender Equipe
    //Nas linhas onde havia this.equipe essa parte foi eliminada, chamndo apenas os metodos
    //Atributo nome_equipe apagado, pois é herdado da classe Equipe
    //getters e setters foram substituidos pela chamada do proprio atributo

    public Equipe_Lista() { //Novo construtor adicionado
        super();
    }

    Validacao valida = new Validacao();
    private static byte qtd_jogador = 0;
    private static byte menorIndice = 0;
    private final BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    
    

    public void inserirNome() throws IOException {
        System.out.println("Introduza o nome da equipe: ");
        this.nome_equipe = this.x.readLine();
        if (this.nome_equipe.equalsIgnoreCase("")) {
            System.out.print("Introduza um nome valido!");
            this.inserirNome();
        } else {
            setNome(this.nome_equipe);
        }
    }

    public void inserirNome_Coach() throws IOException {
        System.out.println("Introduza o nome do treinador: ");
        this.nome_coach = this.x.readLine();
        if (this.nome_coach.equalsIgnoreCase("")) {
            System.out.print("Introduza um nome valido!");
            this.inserirNome_Coach();
        } else {
            setNome_coach(this.nome_coach);
        }
    }

    public void adicionarJogador() throws IOException {
        if (qtd_jogador != 15) {
            String pedido = "Introduza o nome do Jogador:  ";
            String nome = this.valida.validaString(pedido, (byte) 5, (byte) 45);
            pedido = "Introduza a sua idade";

            byte idade = this.valida.validaByte(pedido, (byte) 5, (byte) 35);

            byte numero = menorIndice;

            Jogador jogador = new Jogador(nome, idade, numero, "1234");
            for (int i = menorIndice + 1; i < qtd_jogador; ++i) {
                if (super.jogador[i] != null) {
                    continue;
                }
                menorIndice = (byte) i;
                break;
            }
            setJogador(numero, jogador);
            qtd_jogador = (byte) (qtd_jogador + 1);
        } else {
            System.out.println("A equipe esta lotada!");
        }
    }

    public void removerJogador(byte num) {
        if (num < 15) {
            setJogador(num, null);
            if (num < menorIndice) {
                menorIndice = num;
            }
        }
    }

    public void imprimaJogador(String nomeJogador) {
        Jogador jog;
        if (jogadorExiste(nomeJogador)) {
            for (Jogador j : jogador) {
                if (j != null) {
                    if (j.getNome().equalsIgnoreCase(nomeJogador)) {
                        jog = j;
                        System.out.println("==============================");
                        System.out.println("    Informacoes do Jogador    ");
                        System.out.println("==============================");
                        System.out.println("NOME: " + jog.getNome());
                        System.out.println("IDADE: " + jog.getIdade());
                        System.out.println("EQUIPE: " + nome_equipe);
                        System.out.println("TREINADOR: " + getNome_coach());
                        break;
                    }
                }
            }
        }else{
            System.out.println("Jogador de nome" + nomeJogador + "nao foi encontrado");
        }

    }

    public boolean jogadorExiste(String nome) {
        boolean resultado = false;
        for (Jogador j : jogador) {
            if (j != null) {
                if (j.getNome().equalsIgnoreCase(nome)) {
                    resultado = true;
                    break;
                }
            }
        }

        return resultado;
    }

    @Override
    public String getID() {
        return super.id;
    }
}
