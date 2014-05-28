/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Buffer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author anferneelee
 */
public class Buffer {
    private LinkedList<String> buffer;
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition spaces;
    private boolean pendingLines;
    
    public Buffer(int maxSize){
        this.maxSize=maxSize;
        buffer = new LinkedList<>();
        lock = new ReentrantLock();
        lines = lock.newCondition();
        spaces = lock.newCondition();
        pendingLines = true;
    }
    
    public void insert(String line){
        lock.lock();
        try{
            while(buffer.size()==maxSize){
                spaces.await();
            }
            buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
            lines.signalAll();
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }
    
    public String get(){
        String line = null;
        lock.lock();
        try{
            while((buffer.size()==0) && (hasPendingLines())){
                lines.await();
            }
            
            if(hasPendingLines()){
                line = buffer.poll();
                System.out.printf("%s : Line Read: %d\n", Thread.currentThread().getName(), buffer.size());
                spaces.signalAll();
            }
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return line;
    }
    
    public void setPendingLines(boolean pendingLines){
        this.pendingLines = pendingLines;
    }
    
    public boolean hasPendingLines(){
        return pendingLines || buffer.size()>0;
    }
}
