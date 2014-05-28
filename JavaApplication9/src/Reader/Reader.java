/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reader;

import PricesInfo.PricesInfo;

/**
 *
 * @author anferneelee
 */
public class Reader implements Runnable{
    private PricesInfo pricesInfo;
    
    public Reader(PricesInfo pricesInfo){
        this.pricesInfo=pricesInfo;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.printf("%s: Price1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s: Price2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}
