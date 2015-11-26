import java.io.*;

public class Bidder implements Serializable{

//default bidder account
    private int bidNumber;
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
        bidNumber = -1;
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
        bidNumber = num;
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
        return bidNumber;
    }

    public void setBidNumber(int bidNumber) {
        this.bidNumber = bidNumber;
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
}
