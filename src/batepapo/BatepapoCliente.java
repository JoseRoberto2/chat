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
        
        if (s.isConnected()) {
//            // cria uma conexao com o servidor e espera a msg
//            InputStream con = s.getInputStream();
//            // colocar o stream no formato de objeto
//            ObjectInputStream entrada = new ObjectInputStream(con);

            new Thread(new BatepapoInput(s)).start();
            
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
        }
        else {
            System.out.println("Erro na conexão!");
        }
        

        //teclado.close();

        //s.close();
        
    }
    
}
