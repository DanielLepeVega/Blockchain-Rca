/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.blockchainrcanetb;

/**
 *
 * @author yo_da
 */
public class StringInt {
    public String msg;
    public int quantity;
    
    public StringInt(){
        this.msg = "";
        this.quantity = 0;
    }
    
    public void setMsg(String msg){
        this.msg = msg;
    }
    
    public void setInt(int quantity){
        this.quantity = quantity;
    }
    
    public String getMsg(){
        return this.msg;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public void addMsg(String msg){
        this.msg += msg;
    }
    
    public void printObject(){
        System.out.println(this.msg);
        System.out.println(this.quantity);
    }
}
