
import Job.Job;
import PrintQueue.PrintQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anferneelee
 */
public class Main {
    public static void main(String[] args){
        PrintQueue printQueue = new PrintQueue();
        Thread thread[] = new Thread[10];
        for(int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue), "Thread "+i);
        }
        for(int i=0; i<10; i++){
            thread[i].start();
        }
        
    }
}
