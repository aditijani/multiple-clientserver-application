//Server Side

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
 
/** 
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since  November 2017, JDK 1.8
 * 
 * purpose: This is the main class to run the Main server and also the operation servers for the +,-,*,/
 *
 */

public class Main {
     
    private void startServer(){
        try {
            // create main server on port 1000
            Registry mainServer = LocateRegistry.createRegistry(1000);
            // create a new service named OperationServerRequestImpl which will the type of request on this server
            //which will listen to the request and return the address of desired server for the desired operation 
            mainServer.rebind("serverRequist", new OperationServerRequestImpl());

            
            // create adding server on port 1100
            Registry addServer = LocateRegistry.createRegistry(1100);
            addServer.rebind("Operation", new AddOperationImpl());
            
            // create subtracting server on port 1200
            Registry subServer = LocateRegistry.createRegistry(1200);
            subServer.rebind("Operation", new SubOperationImpl());

            // create multiplication server on port 1300
            Registry mulServer = LocateRegistry.createRegistry(1300);
            mulServer.rebind("Operation", new MulOperationImpl());

            // create division server on port 1400
            Registry divServer = LocateRegistry.createRegistry(1400);
            divServer.rebind("Operation", new DivOperationImpl());

            
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
        System.out.println("Servers are ready");
    }
     
    public static void main(String[] args) {
        Main main = new Main();
        main.startServer();
    }
}
