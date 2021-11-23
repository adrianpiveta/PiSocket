/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class Cliente{

    public static void main(String[] args) {
        new Cliente("192.168.1.105", 432).executa();
    }
    private String host;
    private int porta;
    
    public Cliente(String host, int porta) {
        this.host=host;
        this.porta=porta;
    }

    public void executa(){
        try (Socket cliente = new Socket("192.168.1.105", 432)){
            System.out.println("CLiente "+cliente.toString() +" conectado ao servidor");
            
            //Saida para servidor
            //PrintWriter saida = new PrintWriter(cliente.getOutputStream(), true);
            
            //Leitura do servidor
            Recebedor recebedor= new Recebedor(cliente.getInputStream());
            new Thread(recebedor).start();
            
            Scanner scan = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            
            while (scan.hasNextLine()){
                
                //leitura do usuario
                //linha = scan.nextLine();

                saida.println(scan.nextLine());
                saida.flush();
                                
                //imprimindo resposta
                //System.out.println("Resposta do server: " + entrada.readLine());
            }
            scan.close();
            saida.close();
            cliente.close();
        }
       catch (IOException ex) {
           ex.printStackTrace();
        }
    }
}
