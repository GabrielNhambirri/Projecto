/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import prototipo.Identificavel;

/**
 *
 * @author Gabriel
 */
public class Jogo implements Identificavel
{
   
    Equipe equipeA;
    Equipe equipeB;
    private byte nrGolosA;
    private byte nrGolosB;
    private String id;
    private static int contaID = 0;
    
    
    
    public Jogo(byte nrGolosA, byte nrGolosB)
    {
        this.id = "" + contaID;
        contaID ++;
        equipeA = new Equipe();
        equipeB = new Equipe();
        this.nrGolosA = nrGolosA;
        this.nrGolosB = nrGolosB;
    }
    
    public Jogo(byte nrGolosA,byte nrGolosB, Equipe_Lista equipeA,Equipe_Lista equipeB){
        this.id = "" + contaID;
        contaID ++;
        this.equipeA = equipeA;
        this.equipeB = equipeB;
        this.nrGolosA = nrGolosA;
        this.nrGolosB = nrGolosB;
    }

    public Equipe getEquipeA()
    {
        return equipeA;
    }

    public void setEquipeA(Equipe equipeA)
    {
        this.equipeA = equipeA;
    }

    public Equipe getEquipeB()
    {
        return equipeB;
    }

    public void setEquipeB(Equipe equipeB)
    {
        this.equipeB = equipeB;
    }

    public byte getNrGolosA()
    {
        return nrGolosA;
    }

    public void setNrGolosA(byte nrGolosA)
    {
        this.nrGolosA = nrGolosA;
    }

    public byte getNrGolosB()
    {
        return nrGolosB;
    }

    public void setNrGolosB(byte nrGolosB)
    {
        this.nrGolosB = nrGolosB;
    }

    public String getId() {
        return  this.id;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String getNome() {
       return "{EquipeA - nome: "+ this.equipeA.getNome() + ", Golos: " + this.nrGolosA +"\n"
              +"EquipeB - nome: }"+this.equipeB.getNome() + ", Golos: " + this.nrGolosA +"}\n\n";
    }

    
}