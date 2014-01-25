/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import MyThreadGroup.MyThreadGroup;
import Task.Task;

/**
 *
 * @author anferneelee
 */
public class Main {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task task = new Task();
        for(int i=0; i<2; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}
