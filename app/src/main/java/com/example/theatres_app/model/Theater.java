package com.example.theatres_app.model;

import java.io.Serializable;

public class Theater implements Serializable {
    private int imageId;
    private String name;
    private String address;
    private String site;
    private String vk;
    private String tel;
    private String troupeUrl;
    public Theater(String name, String address, String site, String  vk, String tel, String troupeUrl){
        this.name = name;
        this.address = address;
        this.site = site;
        this.vk = vk;
        this.tel = tel;
        this.troupeUrl = troupeUrl;
    }

    public int getImageId() {
        return imageId;
    }


    public void setImageId(int imageId) {
        //TODO описать сеттер ????
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTroupeUrl() {
        return troupeUrl;
    }

    public void setTroupeUrl(String troupeUrl) {
        this.troupeUrl = troupeUrl;
    }
}
