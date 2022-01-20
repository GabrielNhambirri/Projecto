
package programa;

import java.io.IOException;
import programa.Equipe_Lista;

/**
 *
 * @author Gabriel
 */
public class Programa {

   
    public static void main(final String[] args)throws IOException {
        
        final Equipe_Lista listaEquipe = new Equipe_Lista();
        listaEquipe.inserirNome_Coach();
        listaEquipe.inserirNome();
        listaEquipe.adicionarJogador();
        listaEquipe.imprimaJogador("" + 0);
    }
    
}
