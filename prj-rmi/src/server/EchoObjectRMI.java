package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import rmi.EchoInt;

public class EchoObjectRMI {

	public static void main(String[] args) throws AlreadyBoundException 
        {
			try 
            {
                Registry registry = LocateRegistry.createRegistry(5000);
				EchoInt stub = (EchoInt) UnicastRemoteObject.exportObject(new EchoObject(), 0);
				registry.bind("echo", stub);
				System.out.println("el server se encuentra operable");
			} 
            catch (RemoteException e) 	
            {
				e.getMessage();
				System.err.println("Ocurrio algo malo en el extremo remoto" + " " +  e.toString());
	            System.exit(-1); 
			}
			System.out.println("el servidor de echo esta listo");
	}
}