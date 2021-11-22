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
            Socket cliente = new Socket("192.168.0.7", 432);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            Scanner teclado = new Scanner(System.in);
            while (teclado.hasNextLine()){
                saida.print(teclado.nextLine());
            }
            saida.close();
            teclado.close();
            
        } catch (IOException ex) {
            System.out.println("falha na conexão");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
