package com.example.rexacademy;

import com.google.firebase.storage.StorageReference;

public class comicModel {


    String filename;
    String fileurl;
    String writer;
    String description;
    String image;

    public comicModel() {
    }

    public comicModel(String filename, String fileurl, String writer, String description, String image) {
        this.filename = filename;
        this.fileurl = fileurl;
        this.writer = writer;
        this.description = description;
        this.image = image;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
