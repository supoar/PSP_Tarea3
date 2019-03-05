import java.net.*;
import java.io.*;
import java.util.Scanner;



public class ClienteDirectorio{
	
	final String HOST = "localhost";
	final int PUERTO=2000;
	Socket sc;
	DataOutputStream mensaje1;
   
	BufferedReader entrada;
        String respuesta;
        String usuariocontraseña;
        
        boolean respuestaincorrecto=true;
        
	PrintWriter salida = null;
        PrintWriter salida2 = null;
	public ClienteDirectorio (){
		
		try{
			sc = new Socket( HOST , PUERTO );
			
				mensaje1 = new DataOutputStream(sc.getOutputStream());
                                 salida = new PrintWriter(new BufferedWriter(new 
                                OutputStreamWriter(sc.getOutputStream())),true);
				
				
                                entrada = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                               
				Scanner teclado=new Scanner(System.in);                              
                               
                                
                                 System.out.println("Introduzca usuario/contraseña");
                                 
                                usuariocontraseña=teclado.nextLine();
                                
                                salida.println(usuariocontraseña);
                                System.out.println("usuario "+usuariocontraseña);
                                
                                
                                
                                
                                
                                
                                
				
				
				}catch(Exception e )
				{
					System.out.println("Error: "+e.getMessage());
				}
	}
        
        
        public static void main (String [ ] args) {

 

                        new ClienteDirectorio();
 

        }
}







