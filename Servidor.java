import java.net.*;

import java.io.*;




import java.net.*;

import java.io.*;




public class Servidor {
	static final int PUERTO=2000;
	ServerSocket sc;

	Socket so;
	
	
	
        int numeroRecibido;
	BufferedReader entradaservidor ;
        int numeroaleatorio;
        boolean incorrecto=true;
	
	public Servidor(){
            
            numeroaleatorio=(int)(Math.random()*100+1);
            System.out.println("El numero es: "+numeroaleatorio);
            
	try{
		sc = new ServerSocket(PUERTO );
		so=new Socket();/* crea socket servidor que escuchara en puerto*/
		System.out.println("Esperando una conexión:");
		so = sc.accept();//Inicia el socket, ahora esta esperando una conexión por parte del cliente
		
		System.out.println("Un cliente se ha conectado.");
		
		//Canales de entrada y salida de datos
		
		entradaservidor = new BufferedReader(new InputStreamReader(so.getInputStream()));
		
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
                      
                                }
                 }
                
                sc.close();
		
		}catch(Exception e )
		
		{
			System.out.println("Error: "+e.getMessage());
			
				}
}
public static void main (String [ ] args) {

 

                        new Servidor();
 

        }
}

			
		