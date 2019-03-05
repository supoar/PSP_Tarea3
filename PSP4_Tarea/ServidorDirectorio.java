

import java.net.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;



public class ServidorDirectorio {
	static final int PUERTO=2000;
	ServerSocket sc;

	Socket so;
	
	     
	BufferedReader entradaservidor1 ;
       
        
        boolean contraseñaincorrecta=true;
        String usuariocontraseña;
        String contenidofichero;
        void muestraContenido(String archivo) throws FileNotFoundException, IOException {
            String cadena;
            FileReader f = new FileReader(archivo);
            BufferedReader b = new BufferedReader(f);
            while((cadena = b.readLine())!=null) {
                System.out.println(cadena);
            }
            b.close();
        }
        
        
        
	
	public ServidorDirectorio(){
            
           
	try{
		sc = new ServerSocket(PUERTO );
		so=new Socket();/* crea socket servidor que escuchara en puerto*/
		System.out.println("Esperando una conexión:");
		so = sc.accept();//Inicia el socket, ahora esta esperando una conexión por parte del cliente
		
		System.out.println("Un cliente se ha conectado.");
		
		//Canales de entrada y salida de datos
		
		entradaservidor1 = new BufferedReader(new InputStreamReader(so.getInputStream()));
                
		 usuariocontraseña=entradaservidor1.readLine();
                 
              
                 
             
                  
                       
		while(contraseñaincorrecta){
                    
                 
                 System.out.println("usuario "+usuariocontraseña);  
                
                
                
              
                
		if(usuariocontraseña.equalsIgnoreCase("javier/secreta")){
                    
                    
                    
                 
                        
                       System.out.println("Usuario y contraseña correctos!");    
                       
                    
                       
                                        
                       contraseñaincorrecta=false;
                System.out.println("Mostrando archivos de la ruta /home/supoar/NetBeansProjects/ServidorDirectorio/ejemplo"); 
                
                
                Files.walk(Paths.get("/home/supoar/NetBeansProjects/ServidorDirectorio/ejemplo")).forEach(ruta-> {
                if (Files.isRegularFile(ruta)) {
                    System.out.println(ruta);
                    }
                });
                
                System.out.println("Mostrando contenido del archivo holamundo");
                       
                
                       
                        muestraContenido("/home/supoar/NetBeansProjects/ServidorDirectorio/ejemplo/holamundo");
                       
                       
                       
                       
                       
                       
                       
                       
                }
                
                
                else{
                    System.out.println("usuario o contraseña incorrecto");   
                    contraseñaincorrecta=false;
                }
                }
                
                                
                
                
                sc.close();
		
		}catch(Exception e )
		
		{
			System.out.println("Error: "+e.getMessage());
			
				}
}
public static void main (String [ ] args) {

 

                        new ServidorDirectorio();
 

        }
}

			