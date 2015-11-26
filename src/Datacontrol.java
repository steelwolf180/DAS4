
/**
 * Created by max on 10/20/15.
 */
import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.rmi.*;

public interface Datacontrol extends Remote {
    public void readbidders (String f_name) throws RemoteException;
    public void writebidders (String f_name) throws RemoteException;
    public void writeitems (String f_name) throws RemoteException;
    public Item makesbid (int bidnum, String itemnum, int bidamt, boolean numcheck) throws RemoteException;
    public boolean validateitemnum (String itemnum) throws RemoteException;
    public boolean validatebiddermnum (int bidnum) throws RemoteException;
    public Vector<String> getitemtypes  () throws RemoteException;
    public Vector<Item> getitemsforbidder (int biddernum) throws RemoteException;
    public Vector<Item> getitemsfortype (String type) throws RemoteException;
    public Vector<Bidder> findbiddernum (String s) throws RemoteException;
    public Vector<Bidder> getbidderforcashier (int cashiernum) throws RemoteException;
    public Bidder getsbidderrecord (int biddernum) throws RemoteException;
    public boolean updatebidderrecord (Bidder newbidder) throws RemoteException;
    public int getnxtcashiernum () throws RemoteException;
}
