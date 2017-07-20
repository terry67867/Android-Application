package example.rabob.haejang;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	//�⺻ �� 
	ImageView iv1,iv2;
	Button btn;
	TextView txt;
	int[] b_dice = {R.drawable.b1,R.drawable.b2,R.drawable.b3,R.drawable.b4,R.drawable.b5,R.drawable.b6};//���� �ֻ���
	int[] r_dice = {R.drawable.r1,R.drawable.r2,R.drawable.r3,R.drawable.r4,R.drawable.r5,R.drawable.r6};
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//��ư �޾ƿ�
		btn = (Button)findViewById(R.id.btn1);
		btn.setOnClickListener(new OnClickListener(){ //�̺�Ʈ ó��
			@Override
			public void onClick(View v) {
				int black = (int)(Math.random()*6);//��� ����
				int red = (int)(Math.random()*6);//���� ����
				
				iv1 = (ImageView)findViewById(R.id.image1);
				iv2 = (ImageView)findViewById(R.id.image2);//�̹��� �� �޾ƿ�
				
				iv1.setImageResource(b_dice[black]);
				iv2.setImageResource(r_dice[red]);//������ �´� �̹��� ���
				
				txt = (TextView)findViewById(R.id.text1);
				if(black>red){
					txt.setText("��� ��");
				}else if(black == red){
					txt.setText("���º�");
				}else{
					txt.setText("���� ��");
				}
			}
		});
	}
}
