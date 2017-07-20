package example.rabob.haejang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//기본 뷰 
	ImageView iv1,iv2;
	Button btn;
	TextView txt;
	int[] b_dice = {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6};//검은 주사위
	int[] r_dice = {R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//버튼 받아옴
		btn = (Button)findViewById(R.id.btn1);
		btn.setOnClickListener(new OnClickListener(){ //이벤트 처리
			@Override
			public void onClick(View v) {
				int black = (int)(Math.random()*6);//흑색 난수
				int red = (int)(Math.random()*6);//적색 난수
				
				iv1 = (ImageView)findViewById(R.id.image1);
				iv2 = (ImageView)findViewById(R.id.image2);//이미지 뷰 받아옴
				
				iv1.setImageResource(b_dice[black]);
				iv2.setImageResource(r_dice[red]);//난수에 맞는 이미지 출력
				
				txt = (TextView)findViewById(R.id.text1);
				if(black>red){
					txt.setText("흑색 승");
				}else if(black == red){
					txt.setText("무승부");
				}else{
					txt.setText("적색 승");
				}
			}
		});
	}
}
