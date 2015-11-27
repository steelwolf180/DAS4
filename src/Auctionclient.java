/**
 * Done By: Ong Zong Bao
 * StudentID:2167843O
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Auctionclient {
    public static  void  main(String[] args){

        try {
        // Create the reference to the remote object through the rmiregistry
            Datacontrol d = (Datacontrol)
                    Naming.lookup("rmi://localhost/AuctionService");

        }
        // Catch the exceptions that may occur – bad URL, Remote exception
        // Not bound exception or the arithmetic exception that may occur in
        // one of the methods creates an arithmetic error (e.g. divide by zero)
        catch (MalformedURLException murle) {
            System.out.println("MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}
