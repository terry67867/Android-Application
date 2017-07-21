package com.example.rabbitrace;

import java.util.Random;

public class SecondRabbit extends Thread {
	RabbitView rv; public int speed;
	Random rnd;
	SecondRabbit(RabbitView rv){
		this.rv=rv; rnd = new Random();
	}
	public void run(){
		for(int i=0; i<20; i++){
			speed=rnd.nextInt(1500);
			rv.rabbit_2=i;
			rv.postInvalidate(); //������ ������ ������� ����ȭ
			try{
				Thread.sleep(speed);
			}catch(Exception e){}
		}
		synchronized(rv.flag){
			if(rv.flag==false){
				rv.flag = true;
				rv.name = "���";
			}
		}
		rv.postInvalidate();
	}
}