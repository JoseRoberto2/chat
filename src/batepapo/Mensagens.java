/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import static batepapo.BatepapoServ.listaCli;
import static batepapo.BatepapoServ.msgBuffer;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author Miklécio
 */
public class Mensagens implements Runnable {
    private ArrayList<String> nomes;
    
    
    public Mensagens(){
        nomes=BatepapoServ.nome;
    }
    
    @Override
    public void run() {
    
        while (true) {
            try {
                Thread.sleep(1000);
                //System.out.println("clientes: " + listaCli.size());
                for (int i = 0; i < listaCli.size(); i++) {
                    // criar o objeto de envio de msg
                    //if (coneXliente.getOutputStream() != this.listaCli.get(i)) {
                        // escrever a msg
                        //System.out.println("mensagens: " + msgBuffer.size());
                    String Requered="";
                    String msg;
                    for(String nome1: nomes)
                        Requered+="#"+nome1;
                    msg="#Requered"+Requered;
                    
                    
                    ObjectOutputStream broadcast = new ObjectOutputStream(listaCli.get(i));
                    broadcast.writeObject(msg);
                    broadcast.flush();

                        
                    for (int j = 0; j < msgBuffer.get(i).size(); j++) {
                        ObjectOutputStream saida = new ObjectOutputStream(listaCli.get(i));
                        saida.writeObject(msgBuffer.get(i).get(j));
                        saida.flush();
                    }
                    msgBuffer.get(i).clear();
                    //}
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
