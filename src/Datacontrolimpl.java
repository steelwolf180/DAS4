import java.io.*;
import java.util.*;

public class Datacontrolimpl
        extends 	java.rmi.server.UnicastRemoteObject
        implements	Datacontrol {

    private SortedMap<Integer, Bidder> bidders;
    private SortedMap<String, Item> items;
    private int cashierNum;

    public Datacontrolimpl() throws java.rmi.RemoteException {
        super();

        bidders = Collection.synchronizedSortedMap(new TreeMap<Integer,Bidder>());
        items = Collection.synchronizedSortedMap(new TreeMap<String,Item>());
        cashierNum = 0;
    }

    public void readbidders (String fname)
            throws java.rmi.RemoteException
    {
        try
        {
            String s1;
            Bidder b1;

            BufferedReader br = new BufferedReader (new FileReader (fname));

            s1 = br.readLine();

            while (s1 != null)
            {
                b1 = new Bidder();
                b1.infromCVS(s1);

                bidders.put ( b1.getBidNumber(), b1);

                s1 = br.readLine();
            }

            br.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void writebidders (String fname)
            throws java.rmi.RemoteException
    {
        try
        {
            // Set up the output file
            FileWriter fwriter = new FileWriter (fname);
            BufferedWriter bwriter = new BufferedWriter (fwriter);
            PrintWriter pwriter = new PrintWriter (bwriter);

            // for all items in the TreeMap
            for (Map.Entry<Integer, Bidder> e : bidders.entrySet())
                pwriter.println(e.getValue().outasCVS());

            pwriter.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void readitems (String fname)
            throws java.rmi.RemoteException
    {
        String s1;
        Item i1;

        try
        {
            BufferedReader br = new BufferedReader (new FileReader (fname));

            s1 = br.readLine();

            while (s1 != null)
            {
                i1 = new Item();
                i1.infromCVS(s1);

                items.put ( i1.getitemnum(), i1);

                s1 = br.readLine();
            }

            br.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public void writeitems (String filename)
            throws java.rmi.RemoteException
    {
        try
        {
            // Set up the output file
            FileWriter fw = new FileWriter (filename);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter pw = new PrintWriter (bw);

            // for all items in the TreeMap
            for (Map.Entry<String, Item> e : items.entrySet())
                pw.println(e.getValue().outasCVS() );

            pw.close();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }

    public Item makesbid (int biddernum, String itemnum, int bidamt, boolean noCheck)
            throws java.rmi.RemoteException
    {
        Item returnItem = new Item();
        Item bidItem;

        // verify item exists
        if (!items.containsKey (itemnum))
        {
            returnItem.setcode (-2);   // no such item exists
            return returnItem;
        }

        // verify bidder exists
        if (!bidders.containsKey (biddernum))
        {
            returnItem.setcode (-4);   // no such bidder exists
            return returnItem;
        }

        // get item from Item Map
        bidItem = items.get (itemnum );

        // check if a bid has been made
        if (noCheck == false && bidItem.getbidder() != -1)
        {
            returnItem.setcode (-3); // item already has bid
            returnItem.makebid (bidItem.getbidder(), bidItem.getbidAmt());
            return returnItem;
        }

        // store the bid
        bidItem.makebid (biddernum, bidamt);
        returnItem.setcode (1);	// successful bid
        return returnItem;
    }

    public boolean validateitemnum (String inum)
            throws java.rmi.RemoteException
    {
        // verify item exists
        return items.containsKey(inum);
    }

    public boolean validatebiddermnum (int bidnum)
            throws java.rmi.RemoteException
    {
        //System.out.println ("In validatebiddermnum: " + bidnum);
        // verify item exists
        return bidders.containsKey(bidnum);
    }


    public Vector<String> getitemtypes ()
            throws java.rmi.RemoteException
    {
        Vector<String> typeVector = new Vector<String> ();

        // for all items in the Item Map
        for (Map.Entry<String, Item> e : items.entrySet())
        {
            if (!typeVector.contains(e.getValue().getcategory() ) )
            {
                typeVector.addElement (e.getValue().getcategory() );
            }
        }
        return typeVector;
    }

    public Vector<Item> getitemsfortype (String type)
            throws java.rmi.RemoteException
    {
        Vector<Item> itemVector = new Vector<Item> ();

        // for all items in the Item Map
        for (Map.Entry<String, Item> e : items.entrySet())
        {
            if (e.getValue().getcategory().equals(type))
            {
                itemVector.addElement (e.getValue() );
            }
        }
        return itemVector;
    }


    public Vector<Item> getitemsforbidder (int bidderNum)
            throws java.rmi.RemoteException
    {
        Vector<Item> itemVector = new Vector<Item> ();

        // for all items in the Item Map
        for (Map.Entry<String, Item> e : items.entrySet())
        {
            if (e.getValue().getbidder() == bidderNum)
            {
                itemVector.addElement (e.getValue() );
                //System.out.println(e.getValue().outAsCVS() );
            }
        }
        return itemVector;
    }

    public Vector<Bidder> getbidderforcashier (int cnum)
            throws java.rmi.RemoteException
    {
        Vector<Bidder> bidderVector = new Vector<Bidder> ();

        for (Map.Entry<Integer, Bidder> e : bidders.entrySet())
        {
            if (cnum == 0 || e.getValue().getCashierNum() == cnum)
            {
                bidderVector.addElement(e.getValue());
            }
        }
        return bidderVector;
    }

    public Vector<Bidder> findbiddernum (String s)
            throws java.rmi.RemoteException
    {
        Vector<Bidder> bidderVector = new Vector<Bidder> ();

        for (Map.Entry<Integer, Bidder> e : bidders.entrySet())
        {
            if (e.getValue().getName().toLowerCase().startsWith(s.toLowerCase()))
            {
                bidderVector.addElement(e.getValue());
            }
        }
        return bidderVector;
    }

    public Bidder getsbidderrecord (int bnum)
            throws java.rmi.RemoteException
    {
        if (validatebiddermnum(bnum))
            return bidders.get(bnum);
        else
            return null;
    }

    public boolean updatebidderrecord (Bidder newBidder)
            throws java.rmi.RemoteException
    {
        if (validatebiddermnum(newBidder.getBidNumber()))
        {
            bidders.put (newBidder.getBidNumber(), newBidder);
            return true;
        }
        else
            return false;
    }

    public int getnxtcashiernum ()
            throws java.rmi.RemoteException
    {
        cashierNum ++;

        return cashierNum;
    }

    static public void main (String[] args)
    {
        try
        {
            Datacontrolimpl dc = new Datacontrolimpl ();

            dc.readbidders ("Bidders.csv");

            dc.writebidders ("outBid.txt");

            dc.readitems ("Items.csv");

            dc.writeitems ("outItem.txt");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
