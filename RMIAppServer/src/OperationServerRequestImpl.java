
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
 
/**
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since November 2017, JDK 1.8
 * 
 *        purpose: This is a UnicastRemoteObject class which is implementing the
 *        Interface OperationServerRequest This class represent the select operation
 *        service
 *
 */
public class OperationServerRequestImpl extends UnicastRemoteObject implements OperationServerRequest {
 
	public OperationServerRequestImpl() throws RemoteException {       
    }
     
	/**
	 * This method takes the operation name as an input and return 
	 * the corresponding server address for the operation to the client
	 *  
	 */
    @Override
    public String OperationServerReturn(String operationName) throws RemoteException {
        
    	String result;
    	
    	 switch(operationName) {
         case "add" :
            result="1100";
            break;
         case "sub" :
             result="1200";
            break;
         case "mul" :
             result="1300";
            break;
         case "div" :
             result="1400";
            break;
         default :
             result="0000";
            System.out.println("Invalid Operation");
      }
    	
        System.out.println("Required server is " + operationName + " server address is "+ result);
        return result;
    }
     
}