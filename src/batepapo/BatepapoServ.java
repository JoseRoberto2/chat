/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.awt.List;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author roberto
 */
public class BatepapoServ {

    public final static int PortaSer=1234;
    
    public static ArrayList<PrintStream> listaCli = new ArrayList<>();
    
            
    public static void main(String[] args) throws IOException {
        
        ServerSocket serv=new ServerSocket(PortaSer);
        
        System.out.println("Servidor Rodando");
        
        int i=0;
        
        Socket coneXliente;
        while(true){
            
            try{ 
                coneXliente= serv.accept();
                System.out.println("conexão aceita");
                
                PrintStream ps = new PrintStream(coneXliente.getOutputStream());
                boolean teste = listaCli.add(ps);
                
                conexoes cli = new conexoes(coneXliente, listaCli);
                Thread roda = new Thread(cli);
                roda.start();

                /*cli.Host=String.valueOf(coneXliente.getLocalAddress());
                cli.Host=String.valueOf(coneXliente.getLocalSocketAddress());
                cli.Ip=String.valueOf(coneXliente.getLocalAddress());
                
                AdicionarConexoes newConection=new AdicionarConexoes();
                newConection.add(i, cli);
                //System.out.println(newConection.pega(i));
                //newConection.pega(i,3);
                System.out.println(newConection);
                System.out.println("ip Serve"+coneXliente.getLocalAddress());
                
                i+=1;*/
            }
            finally{
                
            }
                
            
            
        }
        
    }
    
}
