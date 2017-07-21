package com.example.rabbitrace;

import java.util.Random;

public class ThirdRabbit extends Thread {
	RabbitView rv; public int speed;
	Random rnd;
	ThirdRabbit(RabbitView rv){
		this.rv=rv; rnd = new Random();
	}
	public void run(){
		for(int i=0; i<20; i++){
			speed=rnd.nextInt(1500);
			rv.rabbit_3=i;
			rv.postInvalidate(); //스레드 안전한 방법으로 동기화
			try{
				Thread.sleep(speed);
			}catch(Exception e){}
		}
		synchronized(rv.flag){
			if(rv.flag==false){
				rv.flag = true;
				rv.name = "오른쪽";
			}
		}
		rv.postInvalidate();
	}
}

