package com.pweb.pojo;


/**
 * pets--->対応
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-25  18:18
 * petweb
 */
public class Pets {
    private Integer id;//主キー
    private String petsname;//ペットネーム
    private String species;//種類
    private Integer amount;//数
    private String instruction;//説明　日本語文字数254文字以下---->极限
    private String picture;//url使用图床

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", petsname='" + petsname + '\'' +
                ", species='" + species + '\'' +
                ", amount=" + amount +
                ", instruction='" + instruction + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }

    public Pets() {
    }
    public Pets(Integer id, String petsname, String species, Integer amount, String instruction, String picture) {
        this.id = id;
        this.petsname = petsname;
        this.species = species;
        this.amount = amount;
        this.instruction = instruction;
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPetsname() {
        return petsname;
    }

    public void setPetsname(String petsname) {
        this.petsname = petsname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
