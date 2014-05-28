/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Participant;

import VideoConference.VideoConference;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author anferneelee
 */
public class Participant implements Runnable {
    private VideoConference conference;
    private String name;
    
    public Participant(VideoConference conference, String name) {
	this.conference = conference;
	this.name = name;
    }

    @Override
    public void run() {
        long duration = (long)(Math.random()*10);
        try{
            TimeUnit.SECONDS.sleep(duration);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
