

public class calculatorimpl extends java.rmi.server.UnicastRemoteObject implements calculator {

    public calculatorimpl() throws java.rmi.RemoteException {
        super();
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
