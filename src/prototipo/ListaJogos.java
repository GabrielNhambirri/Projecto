/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package prototipo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import programa.Jogo;
import programa.Validacao;
/**
 *
 * @author admin
 */
public class ListaJogos {
    private Validacao validador = new Validacao();
    byte goloA;
    private final static ListaEncadeada<Jogo> listaJogos = new ListaEncadeada<>();;
    
    public static ListaEncadeada<Jogo> getListaJogos() {
        return listaJogos;
    }
    
    public void mostrarListaJogos(){
        
      No <Jogo> noTemp = listaJogos.getInicio();
      try{
          while(noTemp!=null){
              System.out.println(noTemp.getElemento().toString());
              noTemp = noTemp.getProximo();
          }
      }catch(NullPointerException np){
          
      }
    }
    
    public Jogo retorneJogo(String id){
        No <Jogo> noTemp = listaJogos.getInicio();
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
    public void actualizarJogo() throws IOException{
        System.out.println(Menus.MENU_ATUALIZAR_JOGO);
        char op = ' ';
        try{
            op = x.readLine().charAt(0);
        }catch(IOException e){
            
            System.out.println("Erro de Leitura!");
        }
        
        mostrarListaJogos();
        String id = "" + validador.validaInt("Indique o ID do jogo",0, 9999);
        
        
        
        switch(op){
            case '1':
                System.out.println(retorneJogo(id).toString());
                byte goloMarcadosA = (byte) validador.validaInt("Introduza o novo numero de golos marcados pela equipe A", (byte) 0,(byte) 50);
                byte golosAnterioresA = retorneJogo(id).getNrGolosA();
                retorneJogo(id).setNrGolosA(goloMarcadosA);
                break;
                
            case '2':
                System.out.println(retorneJogo(id).toString());
                byte goloMarcadosB = (byte) validador.validaInt("Introduza o novo numero de golos marcados pela equipe B", (byte) 0,(byte) 50);
                retorneJogo(id).setNrGolosB(goloMarcadosB);
                break;
                
            default:
                break;
        }
        
    }
    
    
    
    public void eliminarJogo() throws IOException{
        listaJogos.mostrarLista();
        String id = "" + validador.validaInt("Introduza o ID da equipe: ", 0, 9999);
        listaJogos.eliminar(retorneJogo(id));
    }
    
    public void inserirJogo()throws IOException{
        ListaEquipe.getListaEquipe().mostrarLista();
        String  idA, idB;
        idA =""+  validador.validaInt("Introduza o ID da primeira equipe: ", 0, 9999);
        idB ="" +  validador.validaInt("Introduza o ID da segunda equipe: ", 0, 9999);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("                    Informacoes acerca dos Golos                           ");
        System.out.println("---------------------------------------------------------------------------");
        byte goloA = (byte) validador.validaInt("Introduza o numero de golos da primeira equipe", 0, 50);
        byte goloB = (byte) validador.validaInt("Introduza o numero de golos da segunda equipe", 0, 50);
        
        
        if(idA.equalsIgnoreCase(idB))
            System.out.println("Erro: As duas equipes s??o iguais!");
        else{
            ListaEquipe lista = new ListaEquipe();
            Jogo jogo = new Jogo(goloA, goloB, lista.retorneEquipe(idA), lista.retorneEquipe(idB));
            listaJogos.inserir(jogo);
            System.out.println("Registrado com Sucesso!");
        }
    }
    
    public void pesquisarJogos()throws IOException{
        int i = 0;
        byte goloA = (byte) validador.validaInt("Introduza o numero de golos da primeira equipe", 0, 50);
        byte goloB = (byte) validador.validaInt("Introduza o numero de golos da primeira equipe", 0, 50);
        
        No <Jogo> noTemp = listaJogos.getInicio();
        while(noTemp != null){
            if(noTemp.getElemento().getNrGolosA() == goloA && noTemp.getElemento().getNrGolosB() == goloB){
                i++;
                System.out.println(noTemp.getElemento());
            }
            
            if(i == 0){}
            System.out.println("Nenhum jogo foi encontrado com resultados " + goloA + " - " + goloB);
        }
    }
    
    
}
