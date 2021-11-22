/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class ClienteTxt {
    public static void main(String[] args) {
        
    
        try {
            Socket cliente = new Socket("192.168.1.105", 433);
            System.out.println("CLiente conectado ao servidor txt");
            
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            InputStream	is	=	new	FileInputStream("D:/"
                    + "NetBeansProjects/JavaIO/src/main/java/Principal/teste.txt");
            InputStreamReader	isr	=	new	InputStreamReader(is);
            BufferedReader	br	=	new	BufferedReader(isr);
            String	s	=	br.readLine();	// primeira linha
            while	(s	!=	null)	{
                saida.print(s+"\n"); //manda uma saida com o print
                s=br.readLine();
            }
            saida.close();
            cliente.close();
            
        } catch (IOException ex) {
            System.out.println("falha na conexão");
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
