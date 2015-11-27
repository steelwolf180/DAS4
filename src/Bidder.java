/**
 * Done By: Ong Zong Bao
 * StudentID:2167843O
 */
import java.io.Serializable;

public class Bidder implements Serializable{

    private int biddernum;
    private String lname;
    private String fname;
    private String phone;
    private int cashAmt;
    private int checkAmt;
    private int checknum;
    private int chargeAmt;
    private int chargeAmt2;
    private int cashiernum;
    private int code;

    public Bidder()
    {
        biddernum = -1;
        lname = "";
        fname = "";
        phone = "";
        cashAmt = 0;
        checkAmt = 0;
        checknum = -1;
        chargeAmt = 0;
        chargeAmt2 = 0;
        cashiernum = 0;
        code = 0;
    }

    public Bidder(int num, String pName)
    {
        biddernum = num;
        lname = pName;
        fname = "";
        phone = "";
        cashAmt = 0;
        checkAmt = 0;
        checknum = -1;
        chargeAmt = 0;
        chargeAmt2 = 0;
        cashiernum = 0;
        code = 0;
    }

    public void setbidernum(int val)
    {
        biddernum = val;
    }

    public int getbiddernum ()
    {
        return biddernum;
    }

    public void setname (String val)
    {
        lname = val;
    }

    public String getname ()
    {
        return lname + ", " + fname;
    }

    public void setlname (String val)
    {
        lname = val;
    }

    public String getlname ()
    {
        return lname;
    }

    public void setfname (String val)
    {
        fname = val;
    }

    public String getfname ()
    {
        return fname;
    }

    public void setphone (String val)
    {
        phone = val;
    }

    public String getphone ()
    {
        return phone;
    }

    public void setcashAmt (int val)
    {
        cashAmt = val;
    }

    public int getcashAmt ()
    {
        return cashAmt;
    }

    public void setcheckAmt (int val)
    {
        checkAmt = val;
    }

    public int getcheckAmt ()
    {
        return checkAmt;
    }

    public void setchecknum (int val)
    {
        checknum = val;
    }

    public int getchecknum ()
    {
        return checknum;
    }

    public void setchargeAmt (int val)
    {
        chargeAmt = val;
    }

    public int getchargeAmt ()
    {
        return chargeAmt;
    }

    public void setchargeAmt2 (int val)
    {
        chargeAmt2 = val;
    }

    public int getchargeAmt2 ()
    {
        return chargeAmt2;
    }

    public int gettotalAmt ()
    {
        return cashAmt + checkAmt + chargeAmt + chargeAmt2;
    }

    public void setcode (int val)
    {
        code = val;
    }

    public int getcode ()
    {
        return code;
    }

    public void setcashier (int val)
    {
        cashiernum = val;
    }

    public int getcashier ()
    {
        return cashiernum;
    }

    public void infromCVS ( String arg)
    {
        String[] results = getfromCVS (arg);
        try{
            biddernum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            biddernum = -1;
        }

        results = getfromCVS (results[1]);
        lname = results[0];

        results = getfromCVS (results[1]);
        fname = results[0];

        results = getfromCVS (results[1]);
        phone = results[0];

        results = getfromCVS (results[1]);
        try{
            cashAmt = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            cashAmt = 0;
        }

        results = getfromCVS (results[1]);
        try{
            checkAmt = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            checkAmt = 0;
        }

        results = getfromCVS (results[1]);
        try{
            checknum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            checknum = -1;
        }

        results = getfromCVS (results[1]);
        try{
            chargeAmt = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            chargeAmt = 0;
        }

        results = getfromCVS (results[1]);
        try{
            chargeAmt2 = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            chargeAmt2 = 0;
        }

        results = getfromCVS (results[1]);
        try{
            cashiernum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            cashiernum = 0;
        }
    }

    static public String [] getfromCVS (String arg)
    {
        String[] results = new String[2];
        int endPos;
        boolean goOn;

        if (arg.length() == 0)
        {
            results[0] = "";
            results[1] = "";
        }
        else if (arg.charAt(0) == '\"')
        {
            endPos = 1;
            goOn = true;

            while (goOn)
            {
                if (arg.charAt(endPos) != '\"')
                    endPos++;

                else if (endPos+1 >= arg.length())
                    goOn = false;

                else if (arg.charAt(endPos+1) == '\"')
                    endPos = endPos + 2;

                else
                    goOn = false;
            }
            String temp = arg.substring (1,endPos);
            results[0] = temp.replaceAll("\"\"", "\"");
            results[1] = arg.substring (endPos+2);
        }
        else
        {
            results = arg.split (",", 2);
        }
        return results;
    }

    public String outasCVS ()
    {
        String retString = "" + biddernum + ",";

        retString = retString + putinCVS (lname) + "," +
                putinCVS (fname) + "," +
                putinCVS (phone) + "," +
                cashAmt + "," + checkAmt + "," +
                checknum + "," + chargeAmt + "," +
                chargeAmt2 + "," + cashiernum;

        return retString;
    }

    static public String putinCVS (String arg)
    {
        String retString = "";
        boolean putInQuotes = false;

        if (arg.contains(",") || arg.contains("\""))
        {
            putInQuotes = true;
            retString = retString + "\"";
        }

        String[] result = arg.split ("\"", -1);
        retString = retString + result[0];
        for (int i = 1; i < result.length; i++)
            retString = retString + "\"\"" + result[i];

        if (putInQuotes)
            retString = retString + "\"";

        return (retString);
    }

}
