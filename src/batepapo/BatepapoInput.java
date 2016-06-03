/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batepapo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class BatepapoInput implements Runnable{

    private ObjectInputStream entrada;
    
    public BatepapoInput(ObjectInputStream entrada ){
        this.entrada=entrada;
    }
    
    @Override
    public void run() {
        System.out.print("Recebido: ");
        try {
            System.out.println(entrada.readObject());
        } catch (IOException | ClassNotFoundException ex) {
            //Logger.getLogger(BatepapoInput.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
