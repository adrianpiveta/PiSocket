/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(432);
            System.out.println("Porta 432 aberta!");
            
            while (true){
                Socket cliente = servidor.accept();
                
                //Classe que irá fazer o tratamento da conexão
                TratamentoClass tratamento = new TratamentoClass(cliente);
                
                //lidando con threads
                Thread t = new Thread(tratamento);
                
                //inicialização do thread
                t.start();
                
                
            
            Scanner	scanner	=	new	Scanner(cliente.getInputStream());
            while (scanner.hasNextLine())	{
				System.out.println(scanner.nextLine());
}
            }
                
            
        } catch (IOException ex) {
            System.out.println("Falha ao iniciar servidor");
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
