package com.example.recycleviewimplemenntation;

public class RecycleViewData {
    private int img;
    private String imgName;

    RecycleViewData(int img , String imgName){
        this.img = img ;
        this.imgName = imgName ;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getImg() {
        return img;
    }

    public String getImgName() {
        return imgName;
    }
}
