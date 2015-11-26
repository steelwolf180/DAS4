import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class Datacontrolimpl extends java.rmi.server.UnicastRemoteObject implements Datacontol {

    private SortedMap<Integer, Bidder> bidders;
    private SortedMap<String, Item> items;
    private int cashierNumber;

    public Datacontrolimpl() throws java.rmi.RemoteException {
        super();

        bidders = Collection.synchronizedSortedMap(new TreeMap<Integer,Bidder>());
        items = Collection.synchronizedSortedMap(new TreeMap<String,Item>());
        cashiernum = 0;
    }
    public long add(long a, long b) throws java.rmi.RemoteException {
        return a + b;
    }
    public long sub(long a, long b) throws java.rmi.RemoteException {
        return a - b;
    }

    public long mul(long a, long b) throws java.rmi.RemoteException {
        return a * b;
    }
    public long div(long a, long b) throws java.rmi.RemoteException {
        return a / b;
    }
    public long pow(long a, int b) throws java.rmi.RemoteException {
        if (b==0)
            return 1;
        else
            return a*pow(a, b-1);
    }
}
