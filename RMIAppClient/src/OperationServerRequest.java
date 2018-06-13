
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since November 2017, JDK 1.8
 * 
 *        purpose: This is an interface class for any operation of +,-,*,?  
 *        which represent the desired operation service request
 *		  the implementation of this class will do the desired operation 
 *		  and return the result to the requester
 *		  we use this interface on the client side to send the desired information 
 *		  to the server and obtain the result
 */
public interface OperationServerRequest extends Remote {
	abstract String OperationServerReturn(String operationName) throws RemoteException;
}