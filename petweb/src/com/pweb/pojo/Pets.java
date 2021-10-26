package com.pweb.pojo;

import java.io.FileInputStream;

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
    private String instruction;//説明
    //图片这样应该只能放一张需要给文件地址，配置文件使用？？
    private FileInputStream fis;

    public Pets(Integer id, String petsname, String species, Integer amount, String instruction) {
        this.id = id;
        this.petsname = petsname;
        this.species = species;
        this.amount = amount;
        this.instruction = instruction;
    }

    public String getPetsname() {
        return petsname;
    }

    public void setPetsname(String petsname) {
        this.petsname = petsname;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "id=" + id +
                ", petsname='" + petsname + '\'' +
                ", species='" + species + '\'' +
                ", amount=" + amount +
                ", instruction='" + instruction + '\'' +
                ", fis=" + fis +
                '}';
    }

    public Pets() {
    }

    public Pets(Integer id, String petsname, String species, Integer amount, String instruction, FileInputStream fis) {
        this.id = id;
        this.petsname = petsname;
        this.species = species;
        this.amount = amount;
        this.instruction = instruction;
        this.fis = fis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getpetsname() {
        return petsname;
    }

    public void setpetsname(String petsname) {
        this.petsname = petsname;
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
