package com.example.rexacademy;

public class magModel {
    String filename;
    String fileurl;

    public magModel() {
    }

    public magModel(String filename, String fileurl) {
        this.filename = filename;
        this.fileurl = fileurl;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileurl() {
        return fileurl;
    }

    public void setFileurl(String fileurl) {
        this.fileurl = fileurl;
    }
}
