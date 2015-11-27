/**
 * Done By: Ong Zong Bao
 * StudentID:2167843O
 */

import java.rmi.Naming;

public class Auctionserver {

    public Auctionserver() {
    //N.b. it is possible to host multiple objects on a server
    //by repeating the following method.
        try {
            Datacontrol d = new Datacontrolimpl();
            Naming.rebind("rmi://localhost/AuctionService", d);
        } catch (Exception e) {
            System.out.println("Server Error: " + e);
        }
    } // end of Auctionserver constructor
    public static void main(String args[]) {
        new Auctionserver();
    }
}
