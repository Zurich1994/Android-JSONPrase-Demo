package com.test.AndroidXML;

import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.test.AndroidXML.entity.Book;
import com.test.AndroidXML.xml.AndroidSaxXml;

public class AndroidXML extends Activity {
	private Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				InputStream is = this.getClass().getClassLoader().getResourceAsStream("books.xml");
				try{
					System.out.println("start-------------->");
					List<Book> books = AndroidSaxXml.readXML(is);
					for(Book book:books){
						System.out.println("id---->"+book.getId()+" name--->"+book.getName()+" price--->"+book.getPrice());
					}
					
				}catch(Exception e){
				}
			}
		});
    }
}