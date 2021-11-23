/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class TrataCliente implements Runnable{
    
    private InputStream cliente;
    private Servidor servidor;

    public TrataCliente(InputStream cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }
    
    @Override
    public void run() {
        
        //Entrada de dados 
        Scanner entrada = new Scanner(this.cliente);
        while (entrada.hasNextLine()){
            servidor.distribuiMensagem(entrada.nextLine());
        }
        entrada.close();
    }
}
