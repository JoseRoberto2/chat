/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.io.IOException;
import java.io.InputStream;
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
    public static Socket s;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    //public static void conecta() throws IOException, ClassNotFoundException {
        String host = "127.0.0.2";
        Scanner teclado = new Scanner(System.in);
        String digitado;
        
        s=new Socket(host, Porta);
        
        if (s.isConnected()) {

            //System.out.println("comecou");
            new Thread(new BatepapoInput(s)).start();
            //System.out.println("terminou");
            

            
            while (true) {
                ObjectOutputStream saidaTroca = new ObjectOutputStream(s.getOutputStream());
                //digitado=teclado.nextLine();
                System.out.println("Digite o índice do contato: ");
                String msgTroca = teclado.nextLine();
                saidaTroca.writeObject(msgTroca);
                saidaTroca.flush();

                String msg = "";
                while (!msg.equals("sair")) {
                    ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
                    //digitado=teclado.nextLine();
                    msg = teclado.nextLine();
                    saida.writeObject(msg);
                    saida.flush();

                }
            }

//            while (true) {
//                //teclado.nextLine();
//                saida = new ObjectOutputStream(s.getOutputStream());
//                digitado=teclado.nextLine();
//                saida.writeObject(digitado);
//                saida.flush();
//
//
//            }
        }
        else {
            System.out.println("Erro na conexão!");
        }
        

        //teclado.close();

        //s.close();
        
    }
    
    public static void envia(String digitado) throws IOException {
        ObjectOutputStream saida = new ObjectOutputStream(s.getOutputStream());
        saida.writeObject(digitado);
        saida.flush();
    }
    
}
