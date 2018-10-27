package com.example.jsonxml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.R.integer;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class xmltask extends AsyncTask {
	private ListView activity;
    private int type ;
	public xmltask(Activity activity,int type) {
		super();
		this.activity = (ListView) activity;
		this.type = type;
	}
	protected byte[] doInBackground(String... params) {
		// TODO Auto-generated method stub、
		//byte[] result = httpClientGet(params[0]);

		byte[] result=null;
		try {
			InputStream in=activity.getAssets().open("ListView.xml");
			ByteArrayOutputStream out=new ByteArrayOutputStream();
			byte[] buffer=new byte[1024];
			while(true){
				int length=in.read(buffer);
				if(length==-1) break;
				out.write(buffer,0,length);
			}
			result=out.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	protected void onPostExecute(byte[] result) {
		if(result==null) return;
		super.onPostExecute(result);
		 
			List<String> list =  parseListXML(result);
			activity.updateUI(list);
    }
	private List<String> parseListXML(byte[] result) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		try {
			File f = new File(activity.getFilesDir(),"list.xml");
			FileOutputStream   file = new FileOutputStream(f);
			file.write(result);
			file.close();
			//1. 使用DocumentBuilderFactory创建DOM解析器
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			//3. 获取XML文档解析入口
			Document doc = builder.parse(f);
			//4.获取根节点
			Element root = doc.getDocumentElement();
			NodeList nodeList = root.getElementsByTagName("article");
			for(int i = 0 ; i <nodeList.getLength();i++){
				Node node = nodeList.item(i);
				 
				if(node.getNodeType() == Node.ELEMENT_NODE){
					Element e = (Element) node;
					String id =e.getAttribute("id");
					String logo =e.getAttribute("logo");
				    list.add(logo);
					Log.e("id",id);
					Log.e("logo",logo);
					NodeList childList = e.getChildNodes();//获取子节点Node
					for(int j = 0 ; j < childList.getLength();j++){
						Node child = childList.item(j);
						if(child.getNodeType() == Node.ELEMENT_NODE){
							Element childElement = (Element) child;
							//Log.e("tag",childElement.getTagName());
							Log.e(childElement.getTagName(),childElement.getTextContent());
						}
					}
				}
				//list.add(a);
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		Toast.makeText(activity,"我要发请求了！", Toast.LENGTH_LONG);
	}
	@Override
	protected void onProgressUpdate(Object... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	@Override
	protected Object doInBackground(Object... arg0) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
