/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static prototipo.IO.print;
import static prototipo.IO.println;

/**
 *
 * @author admin
 */
public class Menu implements Menus{
    //Classe com metodos para gerir o menu
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final ListaEquipe listaEquipe = new ListaEquipe();
    private static final ListaJogos  listaJogos = new ListaJogos();

    public Menu() throws IOException {
        menu();
    }
    
    public static void menu() throws IOException{
        
        char op; //opcao
        
        println(MENU_PRINCIPAL);
        print(">> ");
        
        //Lendo a opcao escolhida
        try{
        op = br.readLine().charAt(0);
        }catch(IOException ioe){
            op = ' ';
            println("Erro ao tentar ler a opcao escolhida");
        }
        
        switch(op){
            case '1':
                println(MENU_GESTAO);
                gestao();
                menu();
            break;
                
            
            case '2':
                println(MENU_ESTATISTICAS);
                estatisticas();
                menu();
            break;
            
            case '3':
                println(MENU_PESQUISAS);
                pesquisa();
                menu();
            break;
            
            case '4':
                println(MENU_LISTAGEM);
                listar();
                menu();
            break; 
            
            default:
                
            break;    
            
        }
        
        
    }
    
    private static void gestao() throws IOException{
        char op;
        try{
            op = br.readLine().charAt(0);
        }catch(IOException ioe){
            op = ' ';
            println("Erro ao tentar ler a opcao escolhida");
        }
        
        switch(op){
            case '1':
                listaEquipe.InserirEquipe();
                
            break;
            
            case '2':
                listaEquipe.actualizarEquipe();
                
            break;
            
            case '3':
                listaEquipe.eliminarEquipe();
              
            break;
            
            case '4':
                listaJogos.inserirJogo();
             
            break;
            
            case '5':
                listaJogos.actualizarJogo();
          
            break;
            
            case '6':
                listaJogos.eliminarJogo();
               
            break;    
        }
    }

    private static void estatisticas() throws IOException{
       char op = ' ';
        
        op = br.readLine().charAt(0);
        
            Analisador analisador = new Analisador();
            analisador.atualizar();
        switch(op){
            case '1':
                Analisador.getMaiorMarcador().getObjec2().mostrarLista();
            break;
            
            case '2':
                Analisador.getMaisMarcado().getObjec2().mostrarLista();
            break;
            
            case '3':
                Analisador.getIdadeMediaMaxima().getObjec2().mostrarLista();
            break; 
            
            case '4':
                Analisador.getIdadeMediaMinima().getObjec2().mostrarLista();
            break; 
            
            case '5':
                Analisador.getJogadorIdadeMaxima().getObjec2().mostrarLista();
            break; 
            
            case '6':
                Analisador.getJogadorIdadeMinima().getObjec2().mostrarLista();
            break; 
            
            case '7':
                Analisador.getComMaisGolos().getObjec2().mostrarLista();
            break; 
            case '8':
                Analisador.getComMenosGolos().getObjec2().mostrarLista();;
            break; 
        
        }
         
    }

    private static void pesquisa() throws IOException{
        char op = ' ';
        
        op = br.readLine().charAt(0);
        
        switch(op){
            case '1':
                listaEquipe.pesquisarJogador();
            break;
            
            case '2':
               listaJogos.pesquisarJogos();
            break;
        } 
    }

    private static void listar() throws IOException{
        char op = ' ';
        op = br.readLine().charAt(0);
        
        switch(op){
            case '1':
                ListaEquipe.getListaEquipe().mostrarLista();
            break;
            
            case '2':
               ListaJogos.getListaJogos();
            break;
        }
    }
}
