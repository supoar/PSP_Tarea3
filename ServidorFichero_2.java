import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;



/**
 *
 * @author supoar
 */
public class ServidorFichero implements Serializable{
    
      static final int puerto=1500;
      BufferedInputStream bis;
      BufferedOutputStream bos;
      byte[] byteArray;
      int in;
 
      
      
     public ServidorFichero( ){
         
        try
        {
            
            ServerSocket socketServidor = new ServerSocket(puerto);
             System.out.println("Escucho el puerto " + puerto );

            Socket cliente = socketServidor.accept();

            
            System.out.println("Aceptado cliente");
            
            ObjectInputStream ois = new ObjectInputStream(cliente
                    .getInputStream());
            String mensaje = ois.readObject().toString();
             File fichero = new File(mensaje);
            System.out.println("Me piden: "+fichero);
            
            if(fichero.exists()){
                
               System.out.println("Envío fichero el fichero");
                bis = new BufferedInputStream(new FileInputStream(fichero));
                bos = new BufferedOutputStream(cliente.getOutputStream());
               //Enviamos el nombre del fichero
          DataOutputStream dos=new DataOutputStream(cliente.getOutputStream());
          dos.writeUTF(fichero.getName());
          //Enviamos el fichero
          byteArray = new byte[8192];
          while ((in = bis.read(byteArray)) != -1){
          bos.write(byteArray,0,in);
           }

        bis.close();
        bos.close();
          
           }
           else
            {
                
                System.err.println (
                        "Mensaje no esperado ");
            }
           // Si el mensaje es de petición de fichero
           
            
            // Cierre de sockets 
            cliente.close();
            socketServidor.close();
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    

    public static void main(String[] args) {
        
         new ServidorFichero();
    }
    
}
                                                                                                               