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
public class Jogador
{
    private String nome, id;
    private byte idade;
    private byte numero;
    
    public Jogador(final String nome, final byte idade, final byte numero, final String id) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
        this.id = id;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
        this.nome = nome;
    }
    
    public byte getIdade() {
        return this.idade;
    }
    
    public void setIdade(final byte idade) {
        this.idade = idade;
    }
    
    public byte getNumero() {
        return this.numero;
    }
    
    public void setNumero(final byte numero) {
        this.numero = numero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
