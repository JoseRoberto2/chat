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
    private ArrayList<String> nome;

    public conexoes(Socket cliente, ArrayList<OutputStream> listaCli, ArrayList<ArrayList<Object>> msgBuffer, int meuIndice){
        this.cliente=cliente;
        this.listaCli=listaCli;
        this.msgBuffer=msgBuffer;
        this.meuIndice=meuIndice;
        //this.listaCli=new ArrayList<>()
        //this.nome=nome;
    }
    
    @Override
    public void run() {
        
        
        //recebe e resposnde a solicitação da nova conexão
        ///ObjectInputStream solicitarClientes;
        /*try {
            /*
            solicitarClientes = new ObjectInputStream(this.cliente.getInputStream());
            String entradaindice=solicitarClientes.readObject().toString();
            System.out.println(entradaindice);
            *//*
            ObjectOutputStream enviarClientes = new ObjectOutputStream(listaCli.get(listaCli.size()-1));
            
            String ClienteCon="";
            for (String nome1 : BatepapoServ.nome) {
                ClienteCon=nome1+"#";
            }   
            this.msgBuffer.get(listaCli.size()-1).add("Request#"+ClienteCon);
            
            //enviarClientes.writeObject("Request#"+ClienteCon);
            enviarClientes.flush();
            
            
        } catch (IOException ex) {
            Logger.getLogger(conexoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        */       
                
        
        
        
        while(true){
            
            try {
                ObjectInputStream entradaTroca;
                //System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
                entradaTroca = new ObjectInputStream(this.cliente.getInputStream());
                String entradaindice=entradaTroca.readObject().toString();
                System.out.println(entradaindice);
                int indice = Integer.valueOf(entradaindice);
                    
                String msg = "";
                while (!msg.equals("sair")) {
                    ObjectInputStream entrada;
                    //System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
                    entrada = new ObjectInputStream(this.cliente.getInputStream());
                    msg = entrada.readObject().toString();

                    msg = "Cliente " + this.meuIndice + " disse: " + msg;
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