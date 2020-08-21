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
public class customer {
        RandomAccessFile file = new RandomAccessFile("customer.dat","rw");
        private String name, cnic, username, password;
        private double amount;

    public customer(String name, String cnic, String username, String password, double amount)  throws FileNotFoundException {
        this.name = name;
        this.cnic = cnic;
        this.username = username;
        this.password = password;
        this.amount = amount;
    }

    customer() throws FileNotFoundException {
       
    }
    
    public boolean login(String username, String password) throws IOException {
        file.seek(0);
        boolean ans = false;
         int n = (int) (file.length())/size();
        for(int i = 0; i < n; i++) {
            read();
            if(this.username.equals(username) && this.password.equals(password)) {
                ans = true;
                break;
            }
            
        }
        return ans;
    
        
    }
    
     public boolean checkUsername(String username) throws IOException {
        file.seek(56);
        boolean ans = false;
        int n = (int) (file.length())/size();
        for(int i = 0; i < n; i++) {
            char[] temp = new char[15];
            for (int j = 0; j < temp.length; j++)
                temp[j] = file.readChar();
            String uname = new String(temp);
    
            if(uname.trim().equals(username)) {
                ans = true;
                break;
            }
            file.seek(file.getFilePointer() + size() - 30);
        }
        return ans;
    }
    
    public void write() throws IOException {
        
        file.seek(file.length());
        StringBuffer sb;
        
        
      
        sb = new StringBuffer(name);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
       
        sb = new StringBuffer(cnic);    
        sb.setLength(13);
        file.writeChars(sb.toString());

        sb = new StringBuffer(username);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        
     
        sb = new StringBuffer(password);
        sb.setLength(15);
        file.writeChars(sb.toString());
        
        file.writeDouble(amount);
    }
    
     public void read() throws IOException {
       
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        name = new String(temp);
        name = name.trim();
        
        temp = new char[13];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        cnic = new String(temp);
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        username = new String(temp);
        username = username.trim();
        
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = file.readChar();
        password = new String(temp);
        password = password.trim();
        
        amount = file.readDouble();
       
    }
     
     
     public int size() {
        return 2*(15 + 13 + 15 + 15) + 8 ;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getAmount() {
        return amount;
    }
        
}
