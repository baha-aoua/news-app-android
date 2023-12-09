package com.example.tp4;
public class item {
    String title ;
    int image ;
    String date ;
    static final String LINK = "https://www.aljazeera.com/where/palestine/" ;
    public item(String title, int image, String date) {
        this.title = title;
        this.image = image;
        this.date = date;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
