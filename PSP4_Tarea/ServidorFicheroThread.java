

import java.io.* ;

import java.net.* ;


class ServidorFicheroThread extends Thread implements Serializable{

    Socket skCliente;

    static final int Puerto=1500;
    BufferedInputStream bis;
      BufferedOutputStream bos;
      byte[] byteArray;
      int in;
      

    public ServidorFicheroThread(Socket sCliente) {

        skCliente=sCliente;

    }


public static void main( String[] arg ) {

    try{

        // Inicio el servidor en el puerto

        ServerSocket skServidor = new ServerSocket(Puerto);

        System.out.println("Escucho el puerto " + Puerto );


        while(true){

             // Se conecta un cliente

Socket skCliente = skServidor.accept(); 

System.out.println("Cliente conectado");

// Atiendo al cliente mediante un thread

new ServidorFicheroThread (skCliente).start();

        }

    } catch (Exception e) {;}

}



public void run(){

        try {      
           
            
           
            
            
            ObjectInputStream ois = new ObjectInputStream(skCliente
                    .getInputStream());
            String mensaje = ois.readObject().toString();
             File fichero = new File(mensaje);
            System.out.println("Me piden: "+fichero);
            
            if(fichero.exists()){
                
               System.out.println("Envío fichero el fichero");
                bis = new BufferedInputStream(new FileInputStream(fichero));
                bos = new BufferedOutputStream(skCliente.getOutputStream());
               //Enviamos el nombre del fichero
          DataOutputStream dos=new DataOutputStream(skCliente.getOutputStream());
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
            skCliente.close();
           

     

     } catch( Exception e ) {

         System.out.println( e.getMessage() );

     }

    }

}

