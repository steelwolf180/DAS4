/**
 * Done By: Ong Zong Bao
 * StudentID:2167843O
 */

import java.io.Serializable;

class Item implements Serializable
{
    private String category;
    private String itemnum;
    private String descr;
    private int value;
    private int cost;
    private int bidder;
    private int bidAmt;
    private int code;

    public Item ()
    {
        category = "";
        itemnum = "";
        descr = "";
        value = 0;
        cost = 0;
        bidder = -1;
        bidAmt = 0;
        code = 0;
    }

    public Item(String num, String pdescr, int pval)
    {
        category = "";
        itemnum = num;
        descr = pdescr;
        value = pval;
        cost = 0;
        bidder = -1;
        bidAmt = 0;
        code = 0;
    }

    public Item(String num, String pdescr, int pval, int pcost)
    {
        category = "";
        itemnum = num;
        descr = pdescr;
        value = pval;
        cost = pcost;
        bidder = -1;
        bidAmt = 0;
        code = 0;
    }

    public void setcategory (String val)
    {
        category= val;
    }

    public String getcategory ()
    {
        return category;
    }

    public void setitemnum(String val)
    {
        itemnum = val;
    }

    public String getitemnum ()
    {
        return itemnum;
    }

    public void setdescr (String val)
    {
        descr = val;
    }

    public String getdescr ()
    {
        return descr;
    }

    public void setvalue (int val)
    {
        value = val;
    }

    public int getvalue ()
    {
        return value;
    }

    public void makebid (int pbidder, int pbid)
    {
        bidder = pbidder;
        bidAmt = pbid;
    }

    public int getbidder()
    {
        return bidder;
    }

    public int getbidAmt()
    {
        return bidAmt;
    }

    public int getdonationAmt ()
    {
        if (value >= bidAmt)
            return 0;
        else
            return bidAmt - value;
    }

    public int getprofitAmt ()
    {
        return bidAmt - cost;
    }

    public void setcode (int val)
    {
        code = val;
    }

    public int getcode ()
    {
        return code;
    }

    public void infromCVS ( String arg)
    {
        //System.out.println (arg);

        String[] results = getfromCVS (arg);
        category = results[0];

        results = getfromCVS (results[1]);
        itemnum = results[0];

        results = getfromCVS (results[1]);
        descr = results[0];

        results = getfromCVS (results[1]);
        try{
            value = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            value = 0;
        }

        results = getfromCVS (results[1]);
        try{
            bidder = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            bidder = -1;
        }

        results = getfromCVS (results[1]);
        try{
            bidAmt = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            bidAmt = 0;
        }
    }

    static public String [] getfromCVS (String arg)
    {
        String[] results = new String[2];
        int end_Pos;
        boolean CarryOn;

        if (arg.length() == 0)
        {
            results[0] = "";
            results[1] = "";
        }
        else if (arg.charAt(0) == '\"')
        {
            end_Pos = 1;
            CarryOn = true;

            while (CarryOn)
            {
                if (arg.charAt(end_Pos) != '\"')
                    end_Pos++;

                else if (end_Pos+1 >= arg.length())
                    CarryOn = false;

                else if (arg.charAt(end_Pos+1) == '\"')
                    end_Pos = end_Pos + 2;

                else
                    CarryOn = false;
            }
            String temp = arg.substring (1,end_Pos);
            results[0] = temp.replaceAll("\"\"", "\"");
            results[1] = arg.substring (end_Pos+2);
        }
        else
        {
            results = arg.split (",", 2);
        }
        return results;
    }

    public String outasCVS ()
    {
        String retString = putinCVS(category) + "," +
                putinCVS(itemnum) + "," +
                putinCVS (descr) + "," +
                value + "," + bidder + "," + bidAmt;

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