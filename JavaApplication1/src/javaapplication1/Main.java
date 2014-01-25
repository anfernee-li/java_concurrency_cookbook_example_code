/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import Result.Result;
import SearchTask.SearchTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anferneelee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);
        
        for(int i=0; i<5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Infomation about the thread Group\n");
        threadGroup.list();
        
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for(int i=0; i<threadGroup.activeCount(); i++){
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }
        waitFinish(threadGroup);
        threadGroup.interrupt();
    }
    
    private static void waitFinish(ThreadGroup threadGroup) {
        while(threadGroup.activeCount()>9) {
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}
