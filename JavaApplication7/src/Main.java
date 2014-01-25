
import Consumer.Consumer;
import EventStorage.EventStorage;
import Producer.Producer;

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
        EventStorage storage=new EventStorage();
        Producer producer=new Producer(storage);
        Thread thread1=new Thread(producer);
        Consumer consumer=new Consumer(storage);
        Thread thread2=new Thread(consumer);
        thread2.start();
        thread1.start();
    }
}
