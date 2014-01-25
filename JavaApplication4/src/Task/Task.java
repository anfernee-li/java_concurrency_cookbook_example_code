/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author anferneelee
 */
public class Task implements Runnable {
    @Override
    public void run(){
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
