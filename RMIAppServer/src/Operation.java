
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since November 2017, JDK 1.8
 * 
 *        purpose: This is an interface class for the main server operation 
 *        which represent the operation service request
 *
 */
public interface Operation extends Remote {
	abstract int doOperation(int num1, int num2) throws RemoteException;
}