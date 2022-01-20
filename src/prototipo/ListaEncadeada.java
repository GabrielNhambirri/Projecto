
package prototipo;

public class ListaEncadeada <T extends Identificavel> {
    
    private No<T> inicio;
    private No<T> actual;
    
    public void inserir(T elemento){
        No<T> novoElemento = new No<T> (elemento);
        if(this.inicio == null && this.actual== null){
            
            this.inicio = novoElemento;
            this.actual = novoElemento;
        }else{
            
            this.actual.setProximo(novoElemento); ;
            this.actual = novoElemento;
        }
        
    }

    public No<T> getInicio() {
        return inicio;
    }
    
    public int contarNos(){  //Conta os nos que temos na lista
        
        int tamanho = 0;
        No noTemp = inicio;
        while(noTemp != null){
            tamanho++;
            noTemp = noTemp.getProximo();
        }
        
        return tamanho;
    }
    
    public void eliminar(T elemento){
        No noTemp = inicio;//no temporario
        No noAnt = null;//no anterior
        if(inicio.getElemento().equals(elemento)){
            inicio = inicio.getProximo();
        }else{
            while((noTemp != null) && !(noTemp.getElemento().equals(elemento))){
                noAnt = noTemp;
                noTemp = noTemp.getProximo();
            }
            if(noTemp.getElemento() == elemento){
                noAnt.setProximo(noTemp.getProximo());
            }
        }
        
    }
    
    public boolean buscaNo(T elemento){
        
        No noTemp = inicio;
        boolean encontrou = false;
        
        while(noTemp!= null && !(encontrou)){
            if(noTemp.getElemento().equals(elemento)){
                encontrou = true;
            }else{
                noTemp = noTemp.getProximo();
            }
        }
        
        return encontrou;
    }
    
    public No<T> retornarElemento(T elemento){
        
        
        No noTemp = inicio;//no temporario
        No noAnt = null;//no anterior
        if(inicio.getElemento().equals(elemento)){
          
            return inicio;
        }else{
            while((noTemp != null) && !(noTemp.getElemento().equals(elemento))){
                noAnt = noTemp;
                noTemp = noTemp.getProximo();
            }
            if(noTemp.getElemento() == elemento){
               return noTemp;
            }
        }
        
        return null;
    }
    
    public void mostrarLista(){
        
        No <T> noTemp = inicio;
        while(noTemp !=null){
            System.out.println("ID: " + noTemp.getElemento().getID() + " - Nome: " + noTemp.getElemento().getNome());
            noTemp = noTemp.getProximo();
          
        }
        
    }
    
    
    
    @Override
    public String toString() {
        return "ListaEncadeada{" + "inicio=" + inicio + ", proximo=" + actual + '}';
    }
    
    
    
}
