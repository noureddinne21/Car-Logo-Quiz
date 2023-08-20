package com.example.carlogoquiz;

public class Model {

    private int model_id ;
    private  String model_name;
    private String model_img;

    public Model(int model_id, String model_name, String model_img) {
        this.model_id = model_id;
        this.model_name = model_name;
        this.model_img = model_img;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getModel_img() {
        return model_img;
    }

    public void setModel_img(String model_img) {
        this.model_img = model_img;
    }
}
