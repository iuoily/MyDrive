package com.iuoly.entity;

public class Files {
    private int id;
    private String fname;
    private String fsize;
    private String uploader;

    public Files() {
    }

    public Files(int id, String fname, String fsize, String uploader) {
        this.id = id;
        this.fname = fname;
        this.fsize = fsize;
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", fsize='" + fsize + '\'' +
                ", uploader='" + uploader + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
