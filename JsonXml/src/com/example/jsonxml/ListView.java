package com.example.jsonxml;

import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ListView extends Activity {
    ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		listView.findViewById(R.id.listView1);
		String url;
		xmltask x=new xmltask(ListView.this, 2);
		x.execute("http://192.168.1.103:8084/Mobile01_SimpleHttpServer/xml?type=list");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_view, menu);
		return true;
	}

	public void updateUI(List<String> list) {
		// TODO Auto-generated method stub
		
	}

}
