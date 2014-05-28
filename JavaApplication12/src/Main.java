
import Participant.Participant;
import VideoConference.VideoConference;

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
	public static void main(String[] args) {
		VideoConference conference = new VideoConference(10);
		Thread threadConference = new Thread((Runnable) conference);
		threadConference.start();
		for(int i=0; i<10; i++) {
			Participant p = new Participant(conference, "Participant "+i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
