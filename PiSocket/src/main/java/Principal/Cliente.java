/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Cliente {
    public static void main(String[] args) {
        
    
        try {
            Socket cliente = new Socket("192.168.1.105", 432);
            System.out.println("CLiente conectado ao servidor");
            
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            
            while (teclado.hasNextLine()){
                saida.print(teclado.nextLine()+"\n");
            }
            saida.close();
            teclado.close();
            cliente.close();
            
        } catch (IOException ex) {
            System.out.println("falha na conexão");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
