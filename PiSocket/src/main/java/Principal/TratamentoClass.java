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

    List<Socket> clientes;
    TratamentoClass(Socket cliente) {
        System.out.println("Nova conexão 	com o cliente	" +
                    cliente.getInetAddress().getHostAddress());
    }

    @Override
    public void run() {
        for (int i = 0; i < clientes.size(); i++) {
            
        }
    }
    
}
