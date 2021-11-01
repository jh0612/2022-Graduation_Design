package com.pweb.pojo;

import java.util.Date;

/**
 * customer--->対応
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  18:10
 * petweb
 */
public class Customer {
    private Integer custid;//顧客主キー
    private String custname;//顧客ユーザーネーム
    private String custpassword;//顧客パスワード
    private String custsex;//顧客性別0女 and 1男
    private String custemail;//顧客メール
    private String custaddress;//顧客住所
    private Date custbirth;//顧客誕生日



    public Customer() {
    }

    public Customer(Integer custid, String custname, String custpassword, String custsex, String custemail, String custaddress, Date custbirth) {
        this.custid = custid;
        this.custname = custname;
        this.custpassword = custpassword;
        this.custsex = custsex;
        this.custemail = custemail;
        this.custaddress = custaddress;
        this.custbirth = custbirth;
    }

    public Integer getcustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getcustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getcustpassword() {
        return custpassword;
    }

    public void setCustpassword(String custpassword) {
        this.custpassword = custpassword;
    }

    public String getcustsex() {
        return custsex;
    }

    public void setCustsex(String custsex) {
        this.custsex = custsex;
    }

    public String getcustemail() {
        return custemail;
    }

    public void setCustemail(String custemail) {
        this.custemail = custemail;
    }

    public String getcustaddress() {
        return custaddress;
    }

    public void setcustaddress(String custaddress) {
        this.custaddress = custaddress;
    }

    public Date getcustbirth() {
        return custbirth;
    }

    public void setcustbirth(Date custbirth) {
        this.custbirth = custbirth;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "custid=" + custid +
                ", custname='" + custname + '\'' +
                ", custpassword='" + custpassword + '\'' +
                ", custsex=" + custsex +
                ", custemail='" + custemail + '\'' +
                ", custaddress='" + custaddress + '\'' +
                ", custbirth=" + custbirth +
                '}';
    }
}
