/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MyThreadGroup;

/**
 *
 * @author anferneelee
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name){
        super(name);
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("The thread %s has thrown an exception\n", t.getId());
        e.printStackTrace();
        System.out.printf("Terminating the rest of the threads\n");
        interrupt();
    }
}
