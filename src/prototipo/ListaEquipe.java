/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package prototipo;
import programa.Equipe_Lista;
import java.io.*;
import programa.Validacao;


/**
 *
 * @author admin
 */
public class ListaEquipe implements Menus{
    
    
   
    private Validacao validador = new Validacao();
    private  static ListaEncadeada<Equipe_Lista> listaEquipe = new ListaEncadeada<>();

    public  static ListaEncadeada <Equipe_Lista> getListaEquipe() {
        return listaEquipe;
    }
    
    
    public Equipe_Lista retorneEquipe(String id){
		No <Equipe_Lista> noTemp = listaEquipe.getInicio();
		while(noTemp != null){
		    if(noTemp.getElemento().getId().equals(id)){
		    	break;				
		    }else{
			noTemp = noTemp.getProximo();
		    }			
		}
                return noTemp.getElemento();
	}
    
    
    BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
    
    //Metodo para atualizar a equipe
    public void actualizarEquipe() throws IOException{
        System.out.println(Menus.MENU_ACTUALIZAR_EQUIPE);
        char op = ' ';
        try{
            op = x.readLine().charAt(0);
        }catch(IOException e){
            
            System.out.println("Erro de Leitura!");
        }
        
        listaEquipe.mostrarLista();
        String id = "" + validador.validaInt("Indique o ID da equipe",0, 9999);
        
        switch(op){
            case '1':
                String novoNome = validador.validaString("Introduza o novo nome", (byte) 1, (byte) 50);
                retorneEquipe(id).setNome(novoNome);
            break;
            
            case '2':
                String novoNome_Coach = validador.validaString("Introduza o novo nome", (byte) 1, (byte) 50);
                retorneEquipe(id).setNome(novoNome_Coach);
                break;
            case '3':
                retorneEquipe(id).adicionarJogador();
                break;
            case '4':
                for(byte i = 0; i <= 15; i++){
                    if(retorneEquipe(id).getJogador(i) != null){
                        System.out.println("ID" +retorneEquipe(id).getJogador(i).getId() + " - Nome:"+retorneEquipe(id).getJogador(i).getNome());
                    }
                }
                byte idJogador = (byte) validador.validaInt("Introduza o ID do Jogador: ", 0,  14);
                retorneEquipe(id).removerJogador(idJogador);
                break;
            default:
                break;
        } 
        
    }
    
    public void eliminarEquipe() throws IOException{
       listaEquipe.mostrarLista();
       String id = "" + validador.validaInt("Introduza o ID da equipe: ", 0, 9999);
       listaEquipe.eliminar(retorneEquipe(id));
    }
    
    public void InserirEquipe() throws IOException{
        Equipe_Lista equipe = new Equipe_Lista();
        equipe.inserirNome();
        equipe.inserirNome_Coach();
        listaEquipe.inserir(equipe);
        System.out.println("Feito com sucesso");
    }

    public void pesquisarJogador() throws IOException{
        listaEquipe.mostrarLista();
        String id = "" + validador.validaInt("Introduza o ID da equipe", 0, 9999);
        String nome = validador.validaString("Introduza o nome do jogador", (byte) 1, (byte) 50);
        retorneEquipe(id).imprimaJogador(nome);
    }
    
}
