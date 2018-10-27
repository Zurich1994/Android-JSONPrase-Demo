package a.b.c;

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

import com.example.jsons.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class task  extends AsyncTask<String,Void,byte[]>{
	
    private Activity activity;
	public task(Activity activity) {
		super();
		this.activity = activity;
	}

	public task() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected byte[] doInBackground(String... params) {
		// TODO Auto-generated method stub
		byte[] result=httpClientGet(params[0]);
		return result;
	}

	@Override
	protected void onPostExecute(byte[] result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Toast.makeText(activity, "我要发送请求啦~~", Toast.LENGTH_LONG).show();
		/*TextView t;
		t=(TextView) activity.findViewById(R.id.textView1);*/
		LinearLayout container = (LinearLayout) activity.findViewById(R.id.container);
			String json = null;
			try {
				json = new String(result,"utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Gson gson=new Gson();
			TypeToken <List<request>> tt =new TypeToken<List<request>>(){};		
			List<request> students = gson.fromJson(json, tt.getType());
			for(request s:students)
			{
				TextView t=new TextView(activity);
				container.addView(t);
				t.setText(s.toString());
			    
				Log.e("id",s.getId());
				Log.e("title",s.getTitle());
				Log.e("imgurl",s.getImgurl());
				Log.e("date",s.getDate());
			}
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	static byte[] httpClientGet(String url) {

		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(URI.create(url));
			HttpResponse resp = client.execute(request);
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
}
