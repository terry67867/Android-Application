package com.example.rabbitrace;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class RabbitView extends View {
	public int rabbit_1=0;
	public int rabbit_2=0;
	public int rabbit_3=0;
	public Boolean flag = false;  // ��üŸ������ ���� - ����ȭ�� ����
	                            //boolean�� ����???
	public String name;
	public RabbitView(Context context){
		super(context);
		//ù��° �䳢�� �����̴� ������
		FirstRabbit fr = new FirstRabbit(this);
		//�ι�° �䳢�� �����̴� ������
		SecondRabbit sr = new SecondRabbit(this);
		ThirdRabbit tr = new ThirdRabbit(this);
		
		fr.start(); sr.start(); tr.start();
	}
	
	protected void onDraw(Canvas canvas) {
		Bitmap r1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		canvas.drawBitmap(r1, 100, 800-(rabbit_1*50), null);
							//�̹���,��ǥ,���� �׸��� ��밴ü
		Bitmap r2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		canvas.drawBitmap(r2, 500, 800-(rabbit_2*50), null);
		
		Bitmap r3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		canvas.drawBitmap(r3, 900, 800-(rabbit_3*50), null);
		
		if(flag==true){ // ���� �����ϴ� �䳢�� ������ ǥ��
			Paint paint = new Paint();
			paint.setAntiAlias(true);
			paint.setTextSize(70);
			paint.setColor(Color.BLUE);
			canvas.drawText(name+"�䳢�� �����߽��ϴ�.", 50, 350, paint);
		}
	}
}	