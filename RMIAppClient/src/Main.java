//Client side
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/** 
 * 
 * @author Hadi Ghafouri and Seyed Majed Shobbar
 * @version 1.0
 * @since  November 2017, JDK 1.8
 * 
 * purpose: This is the main class to run the client side 
 *
 */
public class Main {
     
	private void doTest() {
		try {
			// connecting to main server on port 1000
			Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1000);
			// search for serverRequist service and connect to it
			OperationServerRequest req1 = (OperationServerRequest) myRegistry.lookup("serverRequist");

			int count = 1;
			Scanner reader = new Scanner(System.in);

			while (count != 0) {
				System.out.println("\n1-add\n2-subtraction\n3-Multiplication\n4-division\n0-Exit\n");

				System.out.println("Enter the number of the operation: ");
				count = reader.nextInt(); // Scans the next token of the input as an int.
				String optKind;
				switch (count) {
				case 1:
					optKind = "add";
					break;
				case 2:
					optKind = "sub";
					break;
				case 3:
					optKind = "mul";
					break;
				case 4:
					optKind = "div";
					break;
				default:
					optKind = "Exit";
				}
				System.out.println("you selected the operation " + optKind);

				if (count == 0)
					break;

				// obtaining the server address for the desired operation
				String res = req1.OperationServerReturn(optKind);
				System.out.println("The address of the requested server is " + res);

				// connect to the corresponding server for the desired operation
				Registry operationServer = LocateRegistry.getRegistry("127.0.0.1", Integer.parseInt(res));
				
				System.out.println("\nEnter the first number: ");
				int num1 = reader.nextInt(); // Scans the first number
				System.out.println("Enter the second number: ");
				int num2 = reader.nextInt(); // Scans the second number

				// sending the information to the corresponding service on the corresponding server
				//and obtaining the result
				Operation doOperation = (Operation) operationServer.lookup("Operation");
				System.out.println("The "+optKind+" result from the "+optKind+" server is " + doOperation.doOperation(num1, num2));

			}
			// once finished
			reader.close();

			System.out.println("Client Closed");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
     
    public static void main(String[] args) {
        Main main = new Main();
        main.doTest();
    }
}