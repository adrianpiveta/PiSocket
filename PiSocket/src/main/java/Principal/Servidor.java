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
            
            
            Socket cliente = servidor.accept();
            System.out.println("Nova	conexão	com	o	cliente	"	+	
				cliente.getInetAddress().getHostAddress());
            Scanner	scanner	=	new	Scanner(cliente.getInputStream());
            while	(scanner.hasNextLine())	{
				System.out.println(scanner.nextLine());
}
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
