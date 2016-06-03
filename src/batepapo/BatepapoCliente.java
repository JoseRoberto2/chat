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
public class BatepapoCliente {
    
    public final static int Porta=1234;
    
    
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String host = "127.0.0.3";
        Scanner teclado = new Scanner(System.in);
        String digitado;
        
        Socket s=new Socket(host, Porta);
        //BatepapoInput entrada = new BatepapoInput((ObjectInputStream) s.getInputStream());
        
        //Thread t=new Thread(entrada);
        //t.start();
        

        while (true) {
            ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
            //digitado=teclado.nextLine();
            saida.writeObject(teclado.nextLine());
            saida.flush();
            
        }
        

        //teclado.close();

        //s.close();
        
    }
    
}
