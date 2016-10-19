package com.example.administrator.entity;

/**
 * Created by Administrator on 2016/10/12.
 */

public class BookLists {
    private int _id;
    private int typeId;
    private String bookName;
    private String author;
    private int star;
    private int words;
    private int tickets;
    private int fans;

    public BookLists(String bookName, String author, int star, int words, int tickets, int fans) {
        this.bookName = bookName;
        this.author = author;
        this.star = star;
        this.words = words;
        this.tickets = tickets;
        this.fans = fans;
    }

    public BookLists(int _id, int typeId, String bookName, String author, int star, int words, int tickets, int fans) {
        this._id = _id;
        this.typeId = typeId;
        this.bookName = bookName;
        this.author = author;
        this.star = star;
        this.words = words;
        this.tickets = tickets;
        this.fans = fans;
    }

    public BookLists(int _id, String bookName, String author, int star, int words, int tickets, int fans) {
        this._id = _id;
        this.bookName = bookName;
        this.author = author;
        this.star = star;
        this.words = words;
        this.tickets = tickets;
        this.fans = fans;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getfans() {
        return fans;
    }

    public void setfans(int fans) {
        this.fans = fans;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bookName) {
        this.bookName = bookName;
    }
}
