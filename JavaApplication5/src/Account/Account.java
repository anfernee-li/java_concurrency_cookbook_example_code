/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Account;

/**
 *
 * @author anferneelee
 */
public class Account {
    private double balance;
    
    public double getBalance(){
        return balance;
    }
    
    public void setBalance(double balance){
        this.balance=balance;
    }
    
    public synchronized void addAmount(double amount){
        double tmp=balance;
        try{
            Thread.sleep(10);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        tmp+=amount;
        balance=tmp;
    }
    
    public synchronized void subtractAmount(double amount){
        double tmp=balance;
        try{
            Thread.sleep(10);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        tmp-=amount;
        balance=tmp;
    }
}
