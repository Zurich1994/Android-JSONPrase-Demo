package com.example.jsons;

import a.b.c.task;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
    Button buttonq;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buttonq=(Button) findViewById(R.id.button1);
		buttonq.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				task mytask=new task(MainActivity.this);
				mytask.execute("http://image.baidu.com/i?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%B8%A6%E5%9C%9F&step_word=&ie=utf-8&in=10951&cl=2&lm=-1&st=undefined&cs=3692009338,649857713&os=1713918826,137442344&pn=15&rn=1&di=71869608250&ln=1000&fr=&fr=ala&fmq=1432212636936_R&ic=undefined&s=undefined&se=1&sme=0&tab=0&width=&height=&face=undefined&is=0,0&istype=0&ist=&jit=&objurl=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fwh%253D600%252C800%2Fsign%3D3c9546da6a600c33f02cd6ce2a7c7d37%2Ff703738da9773912e4ed00aff9198618377ae231.jpg&bdtype=0");
			}
             

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
