/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

/**
 *
 * @author Gabriel
 */
public class Jogo
{
   ///
    Equipe equipeA;
    Equipe equipeB;
    private byte nrGolosA;
    private byte nrGolosB;
    
    
    
    public Jogo(byte nrGolosA, byte nrGolosB)
    {
        equipeA = new Equipe();
        equipeB = new Equipe();
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

    
}