package com.example.jpamanytomany.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;
import javax.swing.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@IdClass(BookPublisher.BookPublisherId.class)
public class BookPublisher implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Id
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;

    public BookPublisher() {
    }

    public BookPublisher(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public static class BookPublisherId implements Serializable{

        private Book book;
        private Publisher publisher;

        public BookPublisherId() {}

        public BookPublisherId(Book book, Publisher publisher) {
            this.book = book;
            this.publisher = publisher;
        }
    }

}
