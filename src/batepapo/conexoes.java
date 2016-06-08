/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.InetAddress;
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
    private ArrayList<OutputStream> listaCli;
    private ArrayList<ArrayList<Object>> msgBuffer;
    private int meuIndice;

    public conexoes(Socket cliente, ArrayList<OutputStream> listaCli, ArrayList<ArrayList<Object>> msgBuffer, int meuIndice){
        this.cliente=cliente;
        this.listaCli=listaCli;
        this.msgBuffer=msgBuffer;
        this.meuIndice=meuIndice;
        //this.listaCli=new ArrayList<>()
    }
    
    @Override
    public void run() {
        
        
        while(true){
            
            try {
                ObjectInputStream entradaTroca;
                //System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
                entradaTroca = new ObjectInputStream(this.cliente.getInputStream());
                int indice = Integer.valueOf(entradaTroca.readObject().toString());
                
                String msg = "";
                while (!msg.equals("sair")) {
                    ObjectInputStream entrada;
                    //System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
                    entrada = new ObjectInputStream(this.cliente.getInputStream());
                    msg = "Cliente " + this.meuIndice + " disse: " + entrada.readObject().toString();
                    System.out.println(msg);
                    if (indice < msgBuffer.size()) {
                        this.msgBuffer.get(indice).add(msg);
                    }
                }
                
                
                
            } catch (IOException | ClassNotFoundException ex) {
                //Logger.getLogger(conexoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //this.cliente.close();
        
    }
}