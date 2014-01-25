
import MyThreadFactory.MyThreadFactory;
import Task.Task;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
    Usually you can improve you implementation of ThreadFactory by adding some variants by:
    Creating personalized threads, saving thread statistaics, thread limits, validation .etc.
*/
/**
 *
 * @author anferneelee
 */
public class Main {
    public static void main(String[] args) {
        MyThreadFactory factory=new MyThreadFactory("MyThreadFactory");
        Task task=new Task();
        
        Thread thread;
        System.out.printf("Starting the threads\n");
        for(int i=0; i<10; i++){
            thread=factory.newThread(task);
            thread.start();
        }
        System.out.printf("Factory stats:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}
