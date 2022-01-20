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

import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validacao {
    BufferedReader x = new BufferedReader(new InputStreamReader(System.in));

    public String validaString(String msg, byte min, byte max) throws IOException {
        String str = "";
        do {
            System.out.println(msg);
            str = this.x.readLine();
            if (str.length() >= min && str.length() <= max) continue;
            System.out.println("O comprimento deve ser no minimo " + min + " e no maximo " + max);
        } while (str.length() < min || str.length() > max);
        return str;
    }

    public byte validaByte(String msg, byte min, byte max) throws IOException {
        byte valor;
        do {
            System.out.println(msg);
            valor = Byte.parseByte(this.x.readLine());
            if (valor >= min && valor <= max) continue;
            System.out.println("O comprimento deve ser no minimo " + min + " e no maximo " + max);
        } while (valor < min || valor > max);
        return valor;
    }

    public byte validaByte(byte min, byte max) throws IOException {
        byte valor;
        do {
            if ((valor = Byte.parseByte(this.x.readLine())) >= min && valor <= max) continue;
            System.out.println("O comprimento deve ser no minimo " + min + " e no maximo " + max);
        } while (valor < min || valor > max);
        return valor;
    }
    
    public int validaInt(String msg,int min, int max) throws IOException {
        int valor;
        try{
        do {
               System.out.println(msg);
            if ((valor = Integer.parseInt(this.x.readLine())) >= min && valor <= max) continue;
            System.out.println("O comprimento deve ser no minimo " + min + " e no maximo " + max);
        } while (valor < min || valor > max);
        }catch(IOException ex){
            System.out.println("Erro de leitura: " + ex.getMessage());
            valor = -1;
        }
        return valor;
    }
}