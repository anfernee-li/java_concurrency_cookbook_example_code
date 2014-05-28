/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Producer;

import Buffer.Buffer;
import FileMock.FileMock;

/**
 *
 * @author anferneelee
 */
public class Producer implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;
    
    public Producer(FileMock fileMock, Buffer buffer){
        this.fileMock = fileMock;
        this.buffer = buffer;
    }
    
    @Override
    public void run(){
        buffer.setPendingLines(true);
        while(fileMock.hasMoreLines()){
            String line = fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
