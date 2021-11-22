/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.*;
import java.net.*;

/**
 *
 * @author danie
 */
public class Servidor {
    public static void main(String[] args) {
        ServerSocket servidor = null;
        try {
            servidor = new ServerSocket(432);
            //System.out.println("Porta 432 aberta!");
            servidor.setReuseAddress(true);
            
            while (true){
                Socket cliente = servidor.accept();
                System.out.println("CLiente conectado: "+cliente.toString());
                
                ClientRun r1 = new ClientRun(cliente);
                
                new Thread(r1).start();
                //inicialização do thread
                /*Scanner	scanner	=	new	Scanner(cliente.getInputStream());
                while (scanner.hasNextLine())	{
				System.out.println(scanner.nextLine());
                                System.out.println("Scanner rodando no while");
}
            }*/
            }
            
        } catch (IOException ex) {
            System.out.println("Falha ao iniciar servidor");
            ex.printStackTrace();
        }
        finally{
            if (servidor!=null){
                try {
                    servidor.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
     
    }
    public static class ClientRun implements Runnable{
        private final Socket clienteSocket;
    
        public ClientRun(Socket socket){
            this.clienteSocket = socket;
        }


        public void run() {
            PrintWriter saida = null;
            BufferedReader entrada= null;

            try {
                //saida
                saida= new PrintWriter(clienteSocket.getOutputStream(),true);

                //entrada
                entrada = new BufferedReader(new InputStreamReader(clienteSocket.
                        getInputStream()));

                String linha;
                while ((linha = entrada.readLine()) != null){
                    System.out.println("Enviado do cliente: "+linha);
                    saida.println(linha);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            finally{
                try {
                    if (saida !=null){
                        saida.close();
                    }
                    if (entrada != null){
                        entrada.close();
                        clienteSocket.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }

    }
