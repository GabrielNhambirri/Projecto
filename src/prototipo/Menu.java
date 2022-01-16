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
    
    public static void menu() {
        
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
            break;
                
            
            case '2':
                println(MENU_ESTATISTICAS);
                menu();
            break;
            
            case '3':
                println(MENU_PESQUISAS);
                menu();
            break;
            
            case '4':
                println(MENU_LISTAGEM);
                menu();
            break; 
            
            default:
                
            break;    
            
        }
        
        
    }
    
    private static void gestao(){
        char op;
        try{
            op = br.readLine().charAt(0);
        }catch(IOException ioe){
            op = ' ';
            println("Erro ao tentar ler a opcao escolhida");
        }
        
        switch(op){
            case '1':
                
            break;
            
            case '2':
                
            break;
            
            case '3':
            
            break;
            
            case '4':
                
            break;
            
            case '5':
                
            break;
            
            case '6':
                
            break;    
        }
    }
}
