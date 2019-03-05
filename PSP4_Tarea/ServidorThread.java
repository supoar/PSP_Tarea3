import java.io.* ;

import java.net.* ;

public class ServidorThread extends Thread {
    
    Socket skCliente;

    static final int Puerto=2000;
    
     int numeroRecibido;
     BufferedReader entradaservidor ;
     int numeroaleatorio;
     boolean incorrecto=true;

     
    public ServidorThread(Socket sCliente) {

        skCliente=sCliente;
        numeroaleatorio=(int)(Math.random()*100+1);
        System.out.println("El numero es: "+numeroaleatorio);

    }




    
    public static void main(String[] args) {
        
       
        
            try{

        // Inicio el servidor en el puerto

        ServerSocket skServidor = new ServerSocket(Puerto);

        System.out.println("Esperando una conexión:" );

        
                while(true){

             // Se conecta un cliente

        Socket skCliente = skServidor.accept(); 

        System.out.println("Cliente conectado");

        // Atiendo al cliente mediante un thread

        new ServidorThread(skCliente).start();

                }

    } catch (Exception e) {;}

}


public void run(){

        try {

             entradaservidor = new BufferedReader(new InputStreamReader(skCliente.getInputStream()));
		
		while(incorrecto){
                    
                    numeroRecibido=entradaservidor.read();
               
                
                
                System.out.println("el numero que me mandan es: "+numeroRecibido);
                
                
		if(numeroRecibido>numeroaleatorio){
                       System.out.println("el numero es menor");              
                                }
                if(numeroRecibido<numeroaleatorio){
                       System.out.println("el numero es mayor");              
                                }
                if(numeroRecibido==numeroaleatorio){
                       System.out.println("el numero es correcto. Cierro conexion"); 
                        incorrecto=false;

     // Se cierra la conexión

     skCliente.close();

     System.out.println("Cliente desconectado");


     } 

}
        }catch(Exception e )
            

        {
			System.out.println("Error: "+e.getMessage());
			
				}
}
}
        
    
    

