/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PrintQueue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author anferneelee
 */
public class PrintQueue {
    private final Lock queueLock=new ReentrantLock();
    
    public void printJob(Object document){
        queueLock.lock();
        try{
            Long duration=(long)(Math.random()*10000);
            System.out.println(Thread.currentThread().getName()+": PrintQueue: Printing a job during "+(duration/1000)+" seconds");
            Thread.sleep(duration);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        finally{
            queueLock.unlock();
        }
    }
}
