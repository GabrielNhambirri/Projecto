/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.io.IOException;
import programa.Equipe_Lista;

/**
 *
 * @author Gabriel
 */
public class Programa {

    /**
     * @param args the command line arguments
     */
    public static void main(final String[] args)throws IOException {
        // TODO code application logic here     final Equipe_Lista listaEquipe = new Equipe_Lista();
        final Equipe_Lista listaEquipe = new Equipe_Lista();
        listaEquipe.inserirNome_Coach();
        listaEquipe.inserirNome();
        listaEquipe.adicionarJogador();
        listaEquipe.imprimaJogador((byte)0);
    }
    
}
