package com.pweb.pojo;

/**
 * company--->対応
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  18:04
 * petweb
 */
public class Company {
    private Integer compid;//主キー
    private String compusername;//ユーザーネーム
    private String comppassword;//パスワード
    private String compname;//会社名
    private String compemail;//会社メール
    private String legalname;//法人
    private String compaddress;//会社住所

    @Override
    public String toString() {
        return "company{" +
                "compid=" + compid +
                ", compusername='" + compusername + '\'' +
                ", comppassword='" + comppassword + '\'' +
                ", compname='" + compname + '\'' +
                ", compemail='" + compemail + '\'' +
                ", legalname='" + legalname + '\'' +
                ", compaddress='" + compaddress + '\'' +
                '}';
    }

    public Company() {
    }

    public Company(Integer compid, String compusername, String comppassword, String compname, String compemail, String legalname, String compaddress) {
        this.compid = compid;
        this.compusername = compusername;
        this.comppassword = comppassword;
        this.compname = compname;
        this.compemail = compemail;
        this.legalname = legalname;
        this.compaddress = compaddress;
    }

    public Integer getCompid() {
        return compid;
    }

    public void setCompid(Integer compid) {
        this.compid = compid;
    }

    public String getCompusername() {
        return compusername;
    }

    public void setCompusername(String compusername) {
        this.compusername = compusername;
    }

    public String getComppassword() {
        return comppassword;
    }

    public void setComppassword(String comppassword) {
        this.comppassword = comppassword;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getCompemail() {
        return compemail;
    }

    public void setCompemail(String compemail) {
        this.compemail = compemail;
    }

    public String getLegalname() {
        return legalname;
    }

    public void setLegalname(String legalname) {
        this.legalname = legalname;
    }

    public String getCompaddress() {
        return compaddress;
    }

    public void setCompaddress(String compaddress) {
        this.compaddress = compaddress;
    }
}
