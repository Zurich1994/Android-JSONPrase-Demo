package com.jiangqq.csdn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.jiangqq.bean.Person;
import com.jiangqq.util.JsonParse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button mButton;
	private ListView mListView;
	private static final String urlPath = "http://10.16.31.207/JsonWeb/JsonServlet";
	private static final String TAG = "MainActivity";
	private List<Person> persons;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mButton = (Button) findViewById(R.id.button1);
		mListView = (ListView) findViewById(R.id.listView1);
		mButton.setOnClickListener(new MyOnClickListener());
	}

	private class MyOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			try {
				// 得到Json解析成功之后数据
				persons = JsonParse.getListPerson(urlPath);
				List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
				for (int i = 0; i < persons.size(); i++) {
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("name", persons.get(i).getName());
					map.put("address", persons.get(i).getAddress());
					map.put("age", persons.get(i).getAge());
					data.add(map);
				}
				SimpleAdapter _Adapter = new SimpleAdapter(MainActivity.this,
						data, R.layout.listview_item, new String[] { "name",
								"address", "age" }, new int[] { R.id.textView1,
								R.id.textView2, R.id.textView3 });
				mListView.setAdapter(_Adapter);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "解析失败", 2000);
				Log.i(TAG, e.toString());

			}
		}
	}
}