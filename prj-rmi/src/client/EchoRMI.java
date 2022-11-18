package client;

import java.io.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.EchoInt;

public class EchoRMI {

	public static void main(String[] args) {
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter stdOut = new PrintWriter(System.out);

		String input,fin,output;
		try
		{
			
            EchoInt eo = (EchoInt) Naming.lookup("rmi://localhost:5000/echo");
            System.out.print( eo.echo("hola server"));
			input="";
			fin="fin";
			output = "";
			while(!input.equals(fin)) 
			{
				stdOut.println("Escriba cadena para invocar su eco...");
				stdOut.flush();
	          	input = stdIn.readLine(); //Lee cadena introducida por teclado
	  	        //EJERCICIO: Invocar para la cadena leida el m�todo echo del objeto RMI
                output = eo.echo(input);
	          	stdOut.println(output); //Escribe la respuesta del eco en la pantalla
				stdOut.flush();
			}  	
		}
        catch(Exception e)
        {
			System.out.println("Error en el cliente de echo RMI : " + e.getMessage());
		}
	}

}