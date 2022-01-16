/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;
import programa.Jogo;
import programa.Validacao;
import java.util.Vector;

/**
 *
 * @author admin
 */
public class ListaJogos {
    
    private Vector <Jogo> jogos;
    private Validacao validador;
    
    public ListaJogos(){
        jogos = new Vector();
        validador = new Validacao();
    }
}
