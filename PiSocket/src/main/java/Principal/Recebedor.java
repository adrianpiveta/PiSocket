/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Recebedor implements Runnable{
    
    private InputStream servidor;

    public Recebedor(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        //recebe as mensagens do servidor e faz os devidos prints
        Scanner s = new Scanner(this.servidor);
        while(s.hasNextLine()){
            System.out.println(s.nextLine());
        }
    }
    
    
    
}
