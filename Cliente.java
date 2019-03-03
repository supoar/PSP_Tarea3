import java.net.*;
import java.io.*;
import java.util.Scanner;



public class Cliente{
	
	final String HOST = "localhost";
	final int PUERTO=2000;
	Socket sc;
	DataOutputStream mensaje;
	BufferedReader entrada;
        String respuesta;
        int numerocliente;
        boolean respuestaincorrecto=true;
	
	public Cliente (){
		
		try{
			sc = new Socket( HOST , PUERTO );
			
				mensaje = new DataOutputStream(sc.getOutputStream());
				
				
                                entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                               
				Scanner teclado=new Scanner(System.in);                              
                               
                                while(respuestaincorrecto){
                                 System.out.println("Introduzca un numero  entre 0 y 100");
                                numerocliente=teclado.nextInt();
                                
				System.out.println("El numero que escribe el cliente es: "+numerocliente);
                                
                                mensaje.write(numerocliente);
                                
                                
                                
                                }
                                
				
				
				}catch(Exception e )
				{
					System.out.println("Error: "+e.getMessage());
				}
	}
        
        
        public static void main (String [ ] args) {

 

                        new Cliente();
 

        }
}







