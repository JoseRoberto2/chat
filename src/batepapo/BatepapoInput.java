/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import static batepapo.BatepapoCliente_1.s;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class BatepapoInput implements Runnable{

    private Socket s;
    
    public BatepapoInput(Socket s){
        this.s=s;
    }
    
    @Override
    public void run() {
        //System.out.print("Recebido: ");
        while (true) {
            try {
                // cria uma conexao com o servidor e espera a msg
                //System.out.println("comecou2");
                InputStream con = s.getInputStream();
                // colocar o stream no formato de objeto
                //System.out.println("comecou1");
                ObjectInputStream entrada = new ObjectInputStream(con);
                //System.out.println("comecou4");
                System.out.println(entrada.readObject());
                //System.out.println("comecou5");
            } catch (IOException | ClassNotFoundException ex) {
                //Logger.getLogger(BatepapoInput.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
    }
    
}
