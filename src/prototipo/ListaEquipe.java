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
        if(noTemp == null){
            return null;
        }else{
            while(noTemp != null){
                if(noTemp.getElemento().getId().equals(id)){
                    return noTemp.getElemento();   
                }else{
                    noTemp = noTemp.getProximo();
                }
            }
            return null;
            
        }
        
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
                if(retorneEquipe(id)!=null){
                    String novoNome = validador.validaString("Introduza o novo nome", (byte) 1, (byte) 50);
                    retorneEquipe(id).setNome(novoNome);
                    System.out.println("Alterado com Sucesso");
                }else{
                    System.out.println("Nao Existe a equipe com o ID especificado");
                }
                
                break;
                
            case '2':
                if(retorneEquipe(id)!=null){
                    String novoNome_Coach = validador.validaString("Introduza o novo nome", (byte) 1, (byte) 50);
                    retorneEquipe(id).setNome(novoNome_Coach);
                    System.out.println("Alterado com Sucesso");
                }else{
                    System.out.println("Nao Existe a equipe com o ID especificado");
                }
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
        if(retorneEquipe(id)!=null){
            listaEquipe.eliminar(retorneEquipe(id));
            System.out.println("Eliminado com Sucesso!");
        }else{
            System.out.println("Nao Existe a equipe com o ID especificado");
        }
        
    }
    
    public void InserirEquipe() throws IOException{
        BufferedReader x = new BufferedReader(new InputStreamReader(System.in));
        String resp = "S";
        while(resp.equalsIgnoreCase("S")){
            Equipe_Lista equipe = new Equipe_Lista();
            equipe.inserirNome();
            equipe.inserirNome_Coach();
            listaEquipe.inserir(equipe);
            System.out.println("Feito com sucesso");
            System.out.println("------------------------");
            System.out.println("Deseja inserir mais equipes?[S/N]");
            resp = x.readLine();
        }
    }
    
    public void pesquisarJogador() throws IOException{
        listaEquipe.mostrarLista();
        String id = "" + validador.validaInt("Introduza o ID da equipe", 0, 9999);
        String nome = validador.validaString("Introduza o nome do jogador", (byte) 1, (byte) 50);
        retorneEquipe(id).imprimaJogador(nome);
    }
    
}
