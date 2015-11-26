
/**
 * Created by max on 10/20/15.
 */
public interface calculator extends java.rmi.Remote {
    public long add(long a, long b) throws java.rmi.RemoteException;
    public long sub(long a, long b) throws java.rmi.RemoteException;
    public long mul(long a, long b) throws java.rmi.RemoteException;
    public long div(long a, long b) throws java.rmi.RemoteException;
    public long pow(long a, int b) throws java.rmi.RemoteException;
}
