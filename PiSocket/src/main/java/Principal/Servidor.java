/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danie
 */
public class Servidor {
    
    public static void main(String[] args) {
        new Servidor(432).executa();
    }
        private List<PrintStream> clientes = new ArrayList<PrintStream>();
        private ServerSocket servidor = null;
        private int porta;
        
        public Servidor (int porta){
            this.porta=porta;
            this.clientes = new ArrayList<PrintStream>();
        }
            
        public void executa(){       
            try {
                servidor = new ServerSocket(432);
                System.out.println("Porta 432 aberta!");
            
                while (true){
                    Socket cliente = servidor.accept();
                    System.out.println("CLiente conectado: "+cliente.toString());
                    
                    //adiciona o cliente a lista
                    this.clientes.add(new PrintStream(cliente.getOutputStream()));
                    
                    TrataCliente tc = new TrataCliente(cliente.getInputStream(), this);
                
                    new Thread(tc).start();
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
/* //Metodo antigo que não funfou
    public void distribuiMensagem(List<PrintStream> clientes, String mensagem) {
            clientes.forEach(x -> x.print(mensagem+"\n"));
    }
*/
    void distribuiMensagem(String mensagem) {
        clientes.forEach(x -> x.print(mensagem+"\n"));
        System.out.println(mensagem);
    }
        
    
    
    
    public static class ClientRun implements Runnable{
        private final Socket clienteSocket;
        private List<PrintStream> clientes;
        
    
        public ClientRun(Socket socket){
            this.clienteSocket = socket;
        }

        private ClientRun(Socket clienteSock, List<PrintStream> clientes) {
            this.clienteSocket = clienteSock;
            this.clientes=clientes;
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
