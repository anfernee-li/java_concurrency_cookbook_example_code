/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VideoConference;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author anferneelee
 */
public class VideoConference implements Runnable {
    private final CountDownLatch controller;

    public VideoConference(int number) {
		controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.", name);
        controller.countDown();
        System.out.printf("Video Conference: Waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
		System.out.printf("Video Conference: Initialization %d participants.\n", controller.getCount());
        try{
            controller.await();
            System.out.printf("Video conference: All the participants have come.\n");
            System.out.printf("Video conference: Let's start ...\n");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
