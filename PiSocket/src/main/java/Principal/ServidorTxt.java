/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class ServidorTxt {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(433);
            System.out.println("Porta 433 server txt aberta!");
            
            while (true){
                String saida="";
                Socket cliente = servidor.accept();

                
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:/"
                    + "NetBeansProjects/PiSocket/PiSocket/src/main/java/"
                    + "Principal/SaidaServer.txt", true)); //arquivo escrito
            
            Scanner	scanner	=	new	Scanner(cliente.getInputStream());
            while (scanner.hasNextLine())	{
				saida+=(scanner.nextLine()+"\n");
            }
            writer.write(saida);
            saida="";
            writer.close();
        }
                
            
        } catch (IOException ex) {
            System.out.println("Falha ao iniciar servidor");
            Logger.getLogger(ServidorTxt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
