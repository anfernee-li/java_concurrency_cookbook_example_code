/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SearchTask;

import Result.Result;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anferneelee
 */
public class SearchTask implements Runnable{
    private Result result;
    public SearchTask(Result result){
        this.result = result;
    }
    @Override
    public void run(){
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: start\n", name);
        try{
            doTask();
            result.setName(name);
        } catch(InterruptedException e){
            System.out.printf("Thread %s: interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: ended.\n", name);
    }
    
    private void doTask() throws InterruptedException {
        Random random = new Random((new Date()).getTime());
        int value = (int)(random.nextDouble()*100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value);
    }
}
