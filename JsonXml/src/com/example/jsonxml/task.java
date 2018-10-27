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
		/*��onPreExecute()��ɺ�����ִ�У�
		����ִ�н�Ϊ��ʱ�Ĳ�����
		�˷�����������������ͷ��ؼ�������
		��ִ�й����п��Ե���publishProgress(Progress... values)�����½�����Ϣ��*/
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
		//����̨��������ʱ���˷������ᱻ���ã�����������Ϊ�������ݵ��˷����У�ֱ�ӽ������ʾ��UI����ϡ�
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
		//��execute(Params... params)�����ú�����ִ�У�һ��������ִ�к�̨����ǰ��UI��һЩ��ǡ�
		// TODO Auto-generated method stub
		super.onPreExecute();
		Toast.makeText(activity, "��Ҫ��������", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		//�ڵ���publishProgress(Progress... values)ʱ���˷�����ִ�У�ֱ�ӽ�������Ϣ���µ�UI����ϡ�
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}


	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
