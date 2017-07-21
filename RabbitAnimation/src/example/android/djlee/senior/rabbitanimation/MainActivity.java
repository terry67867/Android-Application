package example.android.djlee.senior.rabbitanimation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {
	class MyView extends View{
		int width,height;//�ܸ��� ȭ�� ����,���� ũ��
		int x,y,x1,y1;//�䳢�� ��ǥ
		int sx,sy,sx1,sy1;//�ѹ��� �̵��ϴ� �Ÿ�
		int rw,rh,rw1,rh1;//���� �浹���� �Ǵ��ϱ� ���� ��
		Bitmap[] rabbit = new Bitmap[2];
		Bitmap[] dragon = new Bitmap[2];
		int counter=0, counter1=0;//�䳢�� ����� �����ֱ����� ��
		public MyView(Context context) {
			super(context);
			Display display = ((WindowManager)context.getSystemService(
			context.WINDOW_SERVICE)).getDefaultDisplay();
			width=display.getWidth();
			height=display.getHeight();
			
			rabbit[0]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.rabbit_1);
			rabbit[1]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.rabbit_2);
			rw = rabbit[0].getWidth() / 2;
			rh = rabbit[1].getHeight() / 2;
			x=y=100;//�䳢�� ���� ��ǥ
			sx=sy=5;//�䳢�� �� ���� 3�� �̵�
			handler.sendEmptyMessageDelayed(0,10);
		
		dragon[0]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.dragon1);
		dragon[1]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.dragon2);
			rw1 = dragon[0].getWidth() / 2;
			rh1 = dragon[1].getHeight() / 2;
			x1=y1=100;//�� ���� ��ǥ
			sx1=sy1=2;//���� �� ���� 5�� �̵�
			handler.sendEmptyMessageDelayed(0,10);
			}
		Handler handler = new Handler(){
			public void handleMessage(Message msg) {
				invalidate();//onDrawȣ��
				handler.sendEmptyMessageDelayed(
					0, 10);//0.01���� �ڱ��ڽ� ȣ��
			}
		};
		int n,n1;
		protected void onDraw(Canvas canvas) {
			x=x+sx; y=y+sy;//��ǥ �̵�
			counter++;
			n = (counter % 20) / 10;
			//�浹 ���� �Ǵ�
			if(x < rw){//���� ���� �浹
				x = rw; sx = -sx;
			}
			if(x > width - rw){//������ ���� �浹
				x = width - rw; sx = -sx;
			}
			if(y < rh){//õ���� �浹
				y = rh; sy = -sy;
			}
			if(y > height - rh){//�ٴڰ� �浹
				y = height - rh; sy = -sy;
			}
			canvas.drawBitmap(rabbit[n], 
				x-rw,y-rh,null);
		
			x1=x1+sx1; y1=y1+sy1;//��ǥ �̵�
			counter1++;
			n1 = (counter1 % 20) / 10;
			//�浹 ���� �Ǵ�
			if(x1 < rw1){//���� ���� �浹
				x1 = rw1; sx1 = -sx1;
			}
			if(x1 > width - rw1){//������ ���� �浹
				x1 = width - rw1; sx1 = -sx1;
			}
			if(y1 < rh1){//õ���� �浹
				y1 = rh1; sy1 = -sy1;
			}
			if(y1 > height - rh1){//�ٴڰ� �浹
				y1 = height - rh1; sy1 = -sy1;
			}
			canvas.drawBitmap(dragon[n1], 
				x1-rw1,y1-rh1,null);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//����ٸ� ����
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//���¹ٸ� ����
		getWindow().setFlags(
		WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new MyView(this));
	}
}