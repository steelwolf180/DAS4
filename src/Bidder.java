import java.io.Serializable;

public class Bidder implements Serializable{

//default bidder account
    private int bidNum;
    private String name;
    private String phone;
    private int cashAmt;
    private int checkAmt;
    private int checkNum;
    private int chargeAmt;
    private int chargeAmt2;
    private int cashierNum;
    private int code;

    public Bidder()
    {
        bidNum = -1;
        name = "";
        phone = "";
        cashAmt = 0;
        checkAmt = 0;
        checkNum = -1;
        chargeAmt = 0;
        chargeAmt2 = 0;
        cashierNum = 0;
        code = 0;
    }

    public Bidder(int num, String pName)
    {
        bidNum = num;
        name = pName;
        phone = "";
        cashAmt = 0;
        checkAmt = 0;
        checkNum = -1;
        chargeAmt = 0;
        chargeAmt2 = 0;
        cashierNum = 0;
        code = 0;
    }

    public int getBidNumber() {
        return bidNum;
    }

    public void setBidNumber(int bidNumber) {
        this.bidNum = bidNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCashAmt() {
        return cashAmt;
    }

    public void setCashAmt(int cashAmt) {
        this.cashAmt = cashAmt;
    }

    public int getCheckAmt() {
        return checkAmt;
    }

    public void setCheckAmt(int checkAmt) {
        this.checkAmt = checkAmt;
    }

    public int getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(int checkNum) {
        this.checkNum = checkNum;
    }

    public int getChargeAmt() {
        return chargeAmt;
    }

    public void setChargeAmt(int chargeAmt) {
        this.chargeAmt = chargeAmt;
    }

    public int getChargeAmt2() {
        return chargeAmt2;
    }

    public void setChargeAmt2(int chargeAmt2) {
        this.chargeAmt2 = chargeAmt2;
    }

    public int getCashierNum() {
        return cashierNum;
    }

    public void setCashierNum(int cashierNum) {
        this.cashierNum = cashierNum;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalAmt(){
        return cashAmt+checkAmt+chargeAmt+chargeAmt2;
    }

    public void infromCVS (String arg)
    {
        String[] results = getfromCVS (arg);
        try{
            bidNum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e) {
            bidNum = -1;
        }

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
            checkNum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            checkNum = -1;
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
            cashierNum = Integer.parseInt (results[0]);
        }
        catch (NumberFormatException e)
        {
            cashierNum = 0;
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
        String retString = "" + bidNum + ",";

        retString = retString + putinCVS (name) + "," +

                putinCVS (phone) + "," +
                cashAmt + "," + checkAmt + "," +
                checkNum + "," + chargeAmt + "," +
                chargeAmt2 + "," + cashierNum;

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
