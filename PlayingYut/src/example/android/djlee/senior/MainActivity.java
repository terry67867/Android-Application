package example.android.djlee.senior;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
//난수에 따라서 도개걸윷모를 구한다.
//결과에 따라서 윷이미지를 ImageView넣는다.
//결과를 TextView에 넣는다.
	String[] mal={"모","도","개","걸","윷"};
	int[] imgYut={R.drawable.yut_1,R.drawable.yut_0};
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn=(Button)findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener(){
			ImageView iv1,iv2,iv3,iv4;
			TextView tv;
			public void onClick(View v) {
				Random rnd = new Random();
				int n1=1 - rnd.nextInt(10) / 6;
				int n2=1 - rnd.nextInt(10) / 6;
				int n3=1 - rnd.nextInt(10) / 6;
				int n4=1 - rnd.nextInt(10) / 6;
				int n = n1+n2+n3+n4;//0:모,1:도,4:윷
				iv1=(ImageView)findViewById(R.id.imageView1);
				iv1.setImageResource(imgYut[n1]);
				iv2=(ImageView)findViewById(R.id.imageView2);
				iv2.setImageResource(imgYut[n2]);
				iv3=(ImageView)findViewById(R.id.imageView3);
				iv3.setImageResource(imgYut[n3]);
				iv4=(ImageView)findViewById(R.id.imageView4);
				iv4.setImageResource(imgYut[n4]);
				tv=(TextView)findViewById(R.id.txt_result);
				tv.setText(mal[n]);
			}
		});
	}
}









