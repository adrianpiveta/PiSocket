/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.net.Socket;
import java.util.List;

/**
 *
 * @author danie
 */
class TratamentoClass implements Runnable{

    
    Cliente cliente;
    
    TratamentoClass(Socket cliente) {
        
    }

    @Override
    public void run() {
        Thread t= new Thread(cliente);
        t.start();
    }

    void accept() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
