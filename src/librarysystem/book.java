/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Dell
 */
public class book {
    RandomAccessFile file = new RandomAccessFile("books.dat","rw");
        private String title, author, genre;
        private int year, quantity;
        private double price;

    public book(String title, String author, String genre, int year, int quantity, double price) throws FileNotFoundException {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.quantity = quantity;
        this.price = price;
    }

    book() throws FileNotFoundException{
        
    }

    public void write() throws IOException {
        
        file.seek(file.length());
        StringBuffer sb;
    
        sb = new StringBuffer(title);
        sb.setLength(50);
        file.writeChars(sb.toString());
          
        sb = new StringBuffer(author);    
        sb.setLength(50);
        file.writeChars(sb.toString());

        sb = new StringBuffer(genre);
        sb.setLength(50);
        file.writeChars(sb.toString());
        
        file.writeInt(year);
        
        file.writeInt(quantity);
        
        file.writeDouble(price);
    }
    
     public void read() throws IOException {
       
        char[] temp = new char[50];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        title = new String(temp);
        title = title.trim();
        
        temp = new char[50];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        author = new String(temp);
        author = author.trim();
        
        temp = new char[50];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        genre = new String(temp);
        genre = genre.trim();
        
        year = file.readInt();
        
        quantity = file.readInt();
        
        price = file.readDouble();
       
    }
     
     
     public int size() {
        return 2*(50 + 50 + 50)  + 4 + 4 + 8 ;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
        
}
