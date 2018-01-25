package com.example.sambal.quicknews.Model;

/**
 * Created by Sambal on 1/6/2018.
 */

public class Icon {

    private String url;
    private int width, height, bytes;
    private String format,shalum;
    private Object error;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getShalum() {
        return shalum;
    }

    public void setShalum(String shalum) {
        this.shalum = shalum;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
