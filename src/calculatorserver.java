
import java.rmi.Naming;//Import naming classes to bind to rmiregistry

/**
 * Created by max on 10/20/15.
 */
public class calculatorserver {

    public calculatorserver() {
    //N.b. it is possible to host multiple objects on a server
    //by repeating the following method.
        try {
            calculator c = new calculatorimpl();
            Naming.rebind("rmi://localhost/AuctionService", c);
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    } // end of calculatorserver constructor
    public static void main(String args[]) {
        new calculatorserver();
    }
}
