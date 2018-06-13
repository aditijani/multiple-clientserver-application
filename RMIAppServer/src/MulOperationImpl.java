
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since November 2017, JDK 1.8
 * 
 *        purpose: This is a UnicastRemoteObject class which is implementing the
 *        Interface Operation This class represent the Multiplication operation
 *        service and how the operation must be done for this particular
 *        operation
 *
 */
public class MulOperationImpl extends UnicastRemoteObject implements Operation {

	/**
	 * class constructor
	 * @throws RemoteException
	 */
	public MulOperationImpl() throws RemoteException {
	}

	/**
	 * The operation method for the interface that must be implemented base on
	 * the desired operation
	 */
	@Override
	public int doOperation(int num1, int num2) throws RemoteException {
		System.out.println("Mul operation is done and the result sent back to the client");
		return num1 * num2;
	}

}