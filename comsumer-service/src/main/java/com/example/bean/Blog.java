package com.example.bean;

public class Blog {
    private String title;
    private String author;
    public Blog(){}

    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Blog(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
