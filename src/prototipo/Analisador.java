/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;

import programa.Equipe_Lista;
import programa.Jogador;
import programa.Jogo;


/**
 *
 * @author admin
 */
public class Analisador {
    private static Par <Float ,ListaEncadeada <Equipe_Lista>> idadeMediaMaxima = new Par<>(), idadeMediaMinima = new Par<>();
    private static Par <Byte ,ListaEncadeada<Jogador>> jogadorIdadeMaxima = new Par<>(), jogadorIdadeMinima = new Par();
    private static Par <Byte ,ListaEncadeada<Jogo>>  comMaisGolos = new Par<>(), comMenosGolos = new Par<>();
    private static Par <Byte ,ListaEncadeada <Equipe_Lista>>maisMarcado = new Par<>(), maiorMarcador = new Par<>();

  
    public void atualizar(){
        analisaListaEquipe();
        preencherIdadeMedia();
        preencherIdade();
        analisaListaJogos();
        AnalisaMarcacao();
    }
    
    public static void setMaiorMarcador(Par<Byte, ListaEncadeada<Equipe_Lista>> maiorMarcador) {
        Analisador.maiorMarcador = maiorMarcador;
    }
    
    public static Par<Byte, ListaEncadeada<Jogo>> getComMaisGolos() {
        return comMaisGolos;
    }

    public static void setComMaisGolos(Par<Byte, ListaEncadeada<Jogo>> comMaisGolos) {
        Analisador.comMaisGolos = comMaisGolos;
    }

    public static Par<Byte, ListaEncadeada<Equipe_Lista>> getMaiorMarcador() {
        return maiorMarcador;
    }
    
    public static Par<Byte, ListaEncadeada<Jogo>> getComMenosGolos() {
        return comMenosGolos;
    }

    public static void setComMenosGolos(Par<Byte, ListaEncadeada<Jogo>> comMenosGolos) {
        Analisador.comMenosGolos = comMenosGolos;
    }

    public static Par<Byte, ListaEncadeada<Equipe_Lista>> getMaisMarcado() {
        return maisMarcado;
    }

    public static void setMaisMarcado(Par<Byte, ListaEncadeada<Equipe_Lista>> maisMarcado) {
        Analisador.maisMarcado = maisMarcado;
    }

    public static Par<Float, ListaEncadeada<Equipe_Lista>> getIdadeMediaMaxima() {
        return idadeMediaMaxima;
    }

    public static void setIdadeMediaMaxima(Par<Float, ListaEncadeada<Equipe_Lista>> idadeMediaMaxima) {
        Analisador.idadeMediaMaxima = idadeMediaMaxima;
    }

    public static Par<Float, ListaEncadeada<Equipe_Lista>> getIdadeMediaMinima() {
        return idadeMediaMinima;
    }

    public static void setIdadeMediaMinima(Par<Float, ListaEncadeada<Equipe_Lista>> idadeMediaMinima) {
        Analisador.idadeMediaMinima = idadeMediaMinima;
    }

    public static Par<Byte, ListaEncadeada<Jogador>> getJogadorIdadeMaxima() {
        return jogadorIdadeMaxima;
    }

    public static void setJogadorIdadeMaxima(Par<Byte, ListaEncadeada<Jogador>> jogadorIdadeMaxima) {
        Analisador.jogadorIdadeMaxima = jogadorIdadeMaxima;
    }

    public static Par<Byte, ListaEncadeada<Jogador>> getJogadorIdadeMinima() {
        return jogadorIdadeMinima;
    }

    public static void setJogadorIdadeMinima(Par<Byte, ListaEncadeada<Jogador>> jogadorIdadeMinima) {
        Analisador.jogadorIdadeMinima = jogadorIdadeMinima;
    }
    
    private float calculaIdadeMedia(Equipe_Lista el){
        float m = 0;
        int n = 0;
        for(Jogador j: el.getJogador()){
            n++;
            m += j.getIdade();
        }
        
        if(n != 0){
            return m/n;
        }else
            return 0;
    }
    
    private void analisaListaJogos(){
        zeraGolos(); //Para nao duplicar a contagem de golos
        No <Jogo> noTemp = ListaJogos.getListaJogos().getInicio();
        byte golos, maxGolos, minGolos;
        byte maximoGolosSofridos, maxGolosMarcados;
        
        if(noTemp != null){
            golos = somaGolos(noTemp.getElemento());
            maxGolos = minGolos = golos;
            atribuiGolos(noTemp.getElemento());
            noTemp = noTemp.getProximo();
            
            
            
            while(noTemp != null){
                golos = somaGolos(noTemp.getElemento());
                atribuiGolos(noTemp.getElemento());
                if(golos < minGolos){
                    minGolos = golos;
                }else if(golos > maxGolos){
                    maxGolos = golos;
                }
                
                noTemp = noTemp.getProximo();
            }
            comMenosGolos.setObject1(minGolos);
            comMaisGolos.setObject1(maxGolos);
        }
        
        //Preencher
        noTemp = ListaJogos.getListaJogos().getInicio();
        comMenosGolos.setObject2(new ListaEncadeada<>());
        comMaisGolos.setObject2(new ListaEncadeada<>());
        if(noTemp != null){
           
            
            while(noTemp != null){
             if(somaGolos(noTemp.getElemento()) == comMenosGolos.getObject1()){
                 comMenosGolos.getObjec2().inserir(noTemp.getElemento());
             }
             if(somaGolos(noTemp.getElemento()) == comMaisGolos.getObject1()){
                 comMaisGolos.getObjec2().inserir(noTemp.getElemento());
             }
             noTemp = noTemp.getProximo();   
            } 
        }
        
        
    }
    
    private static byte somaGolos(Jogo jogo){
        return (byte) (jogo.getNrGolosA() + jogo.getNrGolosB());
    }
    
    private void atribuiGolos(Jogo jogo){
       byte aux =  jogo.getEquipeA().getQuantidadeGolosMarcados();
       jogo.getEquipeA().setQuantidadeGolosMarcados((byte)(aux + jogo.getNrGolosA()));
       aux =  jogo.getEquipeA().getQuantidadeGolosSofridos();
       jogo.getEquipeA().setQuantidadeGolosSofridos((byte)(aux + jogo.getNrGolosB()));
       
       aux =  jogo.getEquipeB().getQuantidadeGolosMarcados();
       jogo.getEquipeA().setQuantidadeGolosMarcados((byte)(aux + jogo.getNrGolosB()));
       aux =  jogo.getEquipeB().getQuantidadeGolosSofridos();
       jogo.getEquipeA().setQuantidadeGolosSofridos((byte)(aux + jogo.getNrGolosA()));
    }
    
    private void zeraGolos(){
        No <Equipe_Lista> noTemp = ListaEquipe.getListaEquipe().getInicio();
        while(noTemp != null){
            noTemp.getElemento().setQuantidadeGolosMarcados((byte) 0) ;
            noTemp.getElemento().setQuantidadeGolosSofridos((byte) 0);
            noTemp = noTemp.getProximo();
        }
    }
        
    private void analisaListaEquipe(){ //Busca de dados
        //Procura
        byte idade, idadeMax, idadeMin;
        float idadeMediaMax, idadeMediaMin;
        float idadeMedia = 0, n;
        
        No <Equipe_Lista> noTemp = ListaEquipe.getListaEquipe().getInicio();
        
        
        if(noTemp != null){
            idade = noTemp.getElemento().getJogador()[0].getIdade(); //Isso garante que obteremos a idade maxima e a idade minima na lista
             
            idadeMax = idadeMin = idade;
           
            n = 0;
            for(Jogador j: noTemp.getElemento().getJogador()){
                    idade = j.getIdade();
                    idadeMedia += idade;
                    n++;
                    
                    if(idade < idadeMin){
                        idadeMin = idade;
                    } else if(idade > idadeMax){
                        idadeMax = idade;
                    }
            }
            idadeMediaMax = idadeMediaMin =  idadeMedia /n; //Isso garante que obteremos a idade minima e a maxima na lista
            
            
            noTemp = noTemp.getProximo();
            
            
            while(noTemp != null){ //Para pegar a media em todas equipes
                n = 0;
                for(Jogador j: noTemp.getElemento().getJogador()){
                    idadeMedia = 0;
                    idade = j.getIdade();
                    idadeMedia += idade;
                    n++;
                    
                    if(idade < idadeMin){
                        idadeMin = idade;
                    } else if(idade > idadeMax){
                        idadeMax = idade;
                    }
                }

                if(n != 0){
                    idadeMedia = idadeMedia/n;
                    
                    if(idadeMedia < idadeMediaMin){
                        idadeMediaMin = idadeMedia;
                    }else if(idadeMedia > idadeMediaMax){
                        idadeMediaMax = idadeMedia;
                    }
                }
                noTemp = noTemp.getProximo();
            }
            idadeMediaMaxima.setObject1(idadeMediaMax);
            idadeMediaMinima.setObject1(idadeMediaMin);
            jogadorIdadeMaxima.setObject1(idadeMax);
            jogadorIdadeMinima.setObject1(idadeMin);
        }
        
        
        
        //Preenchimento
    }
    
    private void preencherIdadeMedia(){
       idadeMediaMaxima.setObject2(new ListaEncadeada<>());
       idadeMediaMinima.setObject2(new ListaEncadeada<>());
       No <Equipe_Lista> noTemp = ListaEquipe.getListaEquipe().getInicio();
       while(noTemp != null){
           if(calculaIdadeMedia(noTemp.getElemento()) == idadeMediaMaxima.getObject1()){
                idadeMediaMaxima.getObjec2().inserir(noTemp.getElemento());
           }
           if(calculaIdadeMedia(noTemp.getElemento()) == idadeMediaMinima.getObject1()){
                idadeMediaMinima.getObjec2().inserir(noTemp.getElemento());
           }
           
           noTemp = noTemp.getProximo();
       }
    }
    
    private void preencherIdade(){
        jogadorIdadeMaxima.setObject2(new ListaEncadeada());
        jogadorIdadeMinima.setObject2(new ListaEncadeada());
        No <Equipe_Lista> noTemp = ListaEquipe.getListaEquipe().getInicio();
        while(noTemp != null){
            for(Jogador j: noTemp.getElemento().getJogador()){
                if(j.getIdade() == jogadorIdadeMaxima.getObject1()){
                    jogadorIdadeMaxima.getObjec2().inserir(j);
                }
                
                if(j.getIdade() == jogadorIdadeMinima.getObject1()){
                    jogadorIdadeMinima.getObjec2().inserir(j);
                }
            }
            noTemp = noTemp.getProximo();
        }
    }
    
    private void AnalisaMarcacao(){
        byte golosMarcados, golosSofridos,  maximoSofrido, maximoMarcado;
        
        maiorMarcador.setObject2(new ListaEncadeada<>());
        maisMarcado.setObject2(new ListaEncadeada<>());
        
        No <Equipe_Lista> noTemp = ListaEquipe.getListaEquipe().getInicio();
        if(noTemp != null){
            golosMarcados = noTemp.getElemento().getQuantidadeGolosMarcados();
            golosSofridos = noTemp.getElemento().getQuantidadeGolosSofridos();
            
            maximoMarcado = golosMarcados;
            maximoSofrido = golosSofridos;
            noTemp = noTemp.getProximo();
            
           while(noTemp != null){
                golosMarcados = noTemp.getElemento().getQuantidadeGolosMarcados();
                golosSofridos = noTemp.getElemento().getQuantidadeGolosSofridos();
                
                if(golosMarcados > maximoMarcado){
                    maximoMarcado = golosMarcados;
                }
                
                if(golosSofridos > maximoSofrido){
                    maximoSofrido = golosSofridos;
                }
                noTemp = noTemp.getProximo();
            }
            maiorMarcador.setObject1(maximoMarcado);
            maisMarcado.setObject1(maximoSofrido);
            
            
            
            noTemp = ListaEquipe.getListaEquipe().getInicio();
            
            while(noTemp != null){
                if(noTemp.getElemento().getQuantidadeGolosMarcados() == maiorMarcador.getObject1()){
                    maiorMarcador.getObjec2().inserir(noTemp.getElemento());
                }
                
                if(noTemp.getElemento().getQuantidadeGolosSofridos() == maisMarcado.getObject1()){
                    maisMarcado.getObjec2().inserir(noTemp.getElemento());
                }
                noTemp = noTemp.getProximo();
            }
            
        }     
    }
}
