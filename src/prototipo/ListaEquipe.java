/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package prototipo;
import programa.Equipe;
import java.util.Vector;
import programa.Equipe_Lista;
import prototipo.Menus;
import java.io.*;


/**
 *
 * @author admin
 */
public class ListaEquipe implements Menus {
    
    
    private ListaEncadeada<Equipe_Lista> listaEquipe;
    
    
    public ListaEquipe() {

        this.listaEquipe = new ListaEncadeada<>();
    }
    
    
    
    BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    public void actualizarEquipe(String id){
        System.out.println(Menus.MENU_ACTUALIZAR_EQUIPE);
        char op = ' ';
        try{
            op = x.readLine().charAt(0);
        }catch(IOException e){
            
            System.out.println("Erro de Leitura!");
        }
        
        switch(op){
            case '1':
                listaEquipe.mostrarLista();
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            default:
                break;
        }
        
        
    }
    
}
