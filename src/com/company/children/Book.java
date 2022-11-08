package com.company.children;

public class Book {
    //книга содержит: автора, название, стоимость в рублях и год издания
    private String author;
    private String title;
    private double price;
    private int year;

    public Book() {
        //конструктор по умолчанию
        this("Не определено", "Не определено",0.0,0);
    }

    public Book(String author,String title,double price,int year) {
        //конструктор принимает все 4 параметра
        this.author = author;
        this.title = title;
        this.price = price;
        this.year = year;
    }

    public Book(String author, int year) {
        //конструктор имеет 2 параметра: автора и год издания, с использованием кон-структора по умолчанию
        this();
        this.author = author;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
