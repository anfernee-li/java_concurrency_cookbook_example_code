/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EventStorage;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anferneelee
 */
public class EventStorage {
    private int maxSize;
    private LinkedList<Date> storage;
    
    public EventStorage(){
        maxSize=10;
        storage=new LinkedList<>();
    }
    
    public synchronized void set(){
        while(storage.size()==maxSize){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Set %d\n", storage.size());
        notifyAll();
    }
    
    public synchronized void get(){
        while(storage.size()==0){
            try{
                wait();
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>)storage).poll());
        notifyAll();
    }
}
