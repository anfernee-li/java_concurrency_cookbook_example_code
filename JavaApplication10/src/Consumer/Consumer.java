/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Consumer;

import Buffer.Buffer;
import java.util.Random;

/**
 *
 * @author anferneelee
 */
public class Consumer implements Runnable {
    private Buffer buffer;
    
    public Consumer(Buffer buffer){
        this.buffer=buffer;
    }
    
    @Override
    public void run(){
        while (buffer.hasPendingLines()){
            String line = buffer.get();
            processLine(line);
        }
    }
    
    private void processLine(String line){
        try{
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
