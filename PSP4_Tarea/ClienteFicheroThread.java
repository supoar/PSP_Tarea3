import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.Serializable;
import java.net.*;
import java.io.*;

public class ClienteFicheroThread implements Serializable{

    static final int puerto=1500;
    static final String HOST = "localhost";
    String nombreFichero="/home/supoar/NetBeansProjects/ServidorFichero/mensaje";
    DataOutputStream output;
    BufferedInputStream bis;
 BufferedOutputStream bos;
 
byte[] receivedData;
 int in;
 String file;
 ServerSocket server;  
     
    
     public ClienteFicheroThread( ){
         
        try
        {
          Socket socket = new Socket(HOST, puerto);  
          
           ObjectOutputStream oos = new ObjectOutputStream(socket
                    .getOutputStream()); 
           oos.writeObject(nombreFichero);         
           
           
           System.out.println("Recibiendo fichero... ");
           
           receivedData = new byte[1024];
           bis = new BufferedInputStream(socket.getInputStream());
           DataInputStream dis=new DataInputStream(socket.getInputStream());
           //Recibimos el nombre del fichero
            file = dis.readUTF();
            file = file.substring(file.indexOf('\\')+1,file.length());
           //Para guardar fichero recibido
            bos = new BufferedOutputStream(new FileOutputStream(file));
             while ((in = bis.read(receivedData)) != -1){
             bos.write(receivedData,0,in);
                }
            bos.close();
            dis.close();          
                     
                            
           System.out.println("Fichero recibido. Cerrar conexión");
                 
             
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
         public static void main(String[] args) {
        new ClienteFicheroThread();
    }
    
}
