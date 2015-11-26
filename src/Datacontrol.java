
/**
 * Created by max on 10/20/15.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface Datacontrol extends Remote {
    void readbidders(String f_name) throws RemoteException;
    void writebidders(String f_name) throws RemoteException;
    void readitems(String f_name) throws RemoteException;
    void writeitems(String f_name) throws RemoteException;
    Item makesbid(int bidnum, String itemnum, int bidamt, boolean numcheck) throws RemoteException;
    boolean validateitemnum(String itemnum) throws RemoteException;
    boolean validatebiddermnum(int bidnum) throws RemoteException;
    Vector<String> getitemtypes() throws RemoteException;
    Vector<Item> getitemsforbidder(int biddernum) throws RemoteException;
    Vector<Item> getitemsfortype(String type) throws RemoteException;
    Vector<Bidder> findbiddernum(String s) throws RemoteException;
    Vector<Bidder> getbidderforcashier(int cashiernum) throws RemoteException;
    Bidder getsbidderrecord(int biddernum) throws RemoteException;
    boolean updatebidderrecord(Bidder newbidder) throws RemoteException;
    int getnxtcashiernum() throws RemoteException;
}
