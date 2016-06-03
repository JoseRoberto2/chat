/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author roberto
 */
public class BatepapoCliente_1 {
    
    public final static int Porta=1234;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "127.0.0.2";
        Scanner teclado = new Scanner(System.in);
        String digitado;
        
        Socket s=new Socket(host, Porta);
        

        while (true) {
            ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
            //teclado.nextLine();
            digitado=teclado.nextLine();
            saida.writeObject(digitado);
            saida.flush();
        
            
        }
        

        //teclado.close();

        //s.close();
        
    }
    
}
