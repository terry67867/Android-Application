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
		int width,height;//단말기 화면 가로,세로 크기
		int x,y,x1,y1;//토끼의 좌표
		int sx,sy,sx1,sy1;//한번에 이동하는 거리
		int rw,rh,rw1,rh1;//벽에 충돌한지 판단하기 위한 값
		Bitmap[] rabbit = new Bitmap[2];
		Bitmap[] dragon = new Bitmap[2];
		int counter=0, counter1=0;//토끼를 교대로 보여주기위한 값
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
			x=y=100;//토끼의 시작 좌표
			sx=sy=5;//토끼가 한 번에 3씩 이동
			handler.sendEmptyMessageDelayed(0,10);
		
		dragon[0]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.dragon1);
		dragon[1]=BitmapFactory.decodeResource(context.getResources(), 
				R.drawable.dragon2);
			rw1 = dragon[0].getWidth() / 2;
			rh1 = dragon[1].getHeight() / 2;
			x1=y1=100;//용 시작 좌표
			sx1=sy1=2;//용이 한 번에 5씩 이동
			handler.sendEmptyMessageDelayed(0,10);
			}
		Handler handler = new Handler(){
			public void handleMessage(Message msg) {
				invalidate();//onDraw호출
				handler.sendEmptyMessageDelayed(
					0, 10);//0.01초후 자기자신 호출
			}
		};
		int n,n1;
		protected void onDraw(Canvas canvas) {
			x=x+sx; y=y+sy;//좌표 이동
			counter++;
			n = (counter % 20) / 10;
			//충돌 유무 판단
			if(x < rw){//왼쪽 벽과 충돌
				x = rw; sx = -sx;
			}
			if(x > width - rw){//오른쪽 벽과 충돌
				x = width - rw; sx = -sx;
			}
			if(y < rh){//천정과 충돌
				y = rh; sy = -sy;
			}
			if(y > height - rh){//바닥과 충돌
				y = height - rh; sy = -sy;
			}
			canvas.drawBitmap(rabbit[n], 
				x-rw,y-rh,null);
		
			x1=x1+sx1; y1=y1+sy1;//좌표 이동
			counter1++;
			n1 = (counter1 % 20) / 10;
			//충돌 유무 판단
			if(x1 < rw1){//왼쪽 벽과 충돌
				x1 = rw1; sx1 = -sx1;
			}
			if(x1 > width - rw1){//오른쪽 벽과 충돌
				x1 = width - rw1; sx1 = -sx1;
			}
			if(y1 < rh1){//천정과 충돌
				y1 = rh1; sy1 = -sy1;
			}
			if(y1 > height - rh1){//바닥과 충돌
				y1 = height - rh1; sy1 = -sy1;
			}
			canvas.drawBitmap(dragon[n1], 
				x1-rw1,y1-rh1,null);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//제목바를 없앰
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//상태바를 없앰
		getWindow().setFlags(
		WindowManager.LayoutParams.FLAG_FULLSCREEN,
		WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(new MyView(this));
	}
}