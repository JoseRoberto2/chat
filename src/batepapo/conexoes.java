/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class conexoes implements Runnable{
    
    private Socket cliente=new Socket();
    private ArrayList<PrintStream> listaCli;

    public conexoes(Socket cliente, ArrayList<PrintStream> listaCli){
        this.cliente=cliente;
        this.listaCli=listaCli;
        //this.listaCli=new ArrayList<>()
    }
    
    @Override
    public void run() {
        
        
        while(true){
            
            try {
                ObjectInputStream entrada;
                //System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
                entrada = new ObjectInputStream(this.cliente.getInputStream());
                System.out.println(entrada.readObject());
                
                
                
            } catch (IOException | ClassNotFoundException ex) {
                //Logger.getLogger(conexoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //this.cliente.close();
        
    }
}