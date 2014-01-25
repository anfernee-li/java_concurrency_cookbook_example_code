/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Task;

import java.util.Random;

/**
 *
 * @author anferneelee
 */
public class Task implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while(true) {
            result = 1000/((int)(random.nextDouble()*1000));
            System.out.printf("%s : %f\n", Thread.currentThread().getId(), result);
            if (Thread.currentThread().isInterrupted()){
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }
    }
}
