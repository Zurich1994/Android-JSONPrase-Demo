package com.example.jsonxml;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class task extends AsyncTask{
    Activity activity;
	public task(Activity activity) {
		super();
		this.activity=activity;
		// TODO Auto-generated constructor stub
	}


	protected byte[] doInBackground(String... arg0) {
		/*在onPreExecute()完成后立即执行，
		用于执行较为费时的操作，
		此方法将接收输入参数和返回计算结果。
		在执行过程中可以调用publishProgress(Progress... values)来更新进度信息。*/
		// TODO Auto-generated method stub
		byte[] result=httpClient(null);
		return result;
	}

	private byte[] httpClient(String url) {
		// TODO Auto-generated method stub
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URI.create(url));
			HttpResponse resp;
			resp = client.execute(request);
			HttpEntity resEntity = resp.getEntity();
			byte[] result = EntityUtils.toByteArray(resEntity);
			return result;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	
	}

	protected void onPostExecute(byte[] result) {
		//当后台操作结束时，此方法将会被调用，计算结果将做为参数传递到此方法中，直接将结果显示到UI组件上。
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		LinearLayout container=(LinearLayout) activity.findViewById(R.id.container);
		String json=null;
		try {
			json=new String(result,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson=new Gson();
		TypeToken<List<student>> tt=new TypeToken<List<student>>(){};
		List<student> students=gson.fromJson(json,tt.getType());
		for(student s:students){
			TextView t=new TextView(activity);
			container.addView(t);
			t.setText(s.toString());
		}
}

	@Override
	protected void onPreExecute() {
		//在execute(Params... params)被调用后立即执行，一般用来在执行后台任务前对UI做一些标记。
		// TODO Auto-generated method stub
		super.onPreExecute();
		Toast.makeText(activity, "我要发请求了", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		//在调用publishProgress(Progress... values)时，此方法被执行，直接将进度信息更新到UI组件上。
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}


	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
