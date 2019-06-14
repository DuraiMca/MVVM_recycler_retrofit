package com.murugan.durai.logindesignwednesday.MODEL;

import com.google.gson.annotations.SerializedName;

public class ModelClass {

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @SerializedName("avatar_url")
    String imgurl;

    public ModelClass(String imgurl) {
        this.imgurl = imgurl;
    }
}
