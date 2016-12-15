package com.example.mallproject;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class Registration extends Activity{

	EditText t,t2,t3,t4,t5,t6,t7,t8;
	
	AddProduct add;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.registeration);
	    
	       
	        
	        final Spinner s = (Spinner) findViewById(R.id.Spinner01);
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	                R.array.city, android.R.layout.simple_spinner_item);

	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	     // Apply the adapter to the spinner
	     s.setAdapter(adapter);
	        Button b=(Button) findViewById(R.id.button1);
	        t=(EditText)  findViewById(R.id.editText1);
	        t2=(EditText)  findViewById(R.id.editText2);
	     b.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					  
				        try{
				        	//db=openOrCreateDatabase("mx",MODE_PRIVATE,null);
				        	add.db.execSQL("CREATE TABLE IF NOT EXISTS MyTable2(username VARCHAR,password VARCHAR,firstname VARCHAR,lastname VARCHAR,phone VARCHAR,email VARCHAR,address VARCHAR,city VARCHAR);");
				        	Editable user=t.getEditableText();
				        	Editable pass=t2.getEditableText();
				        	Editable firstna=t3.getEditableText();
				        	Editable lastna=t4.getEditableText();
				        	Editable phone=t5.getEditableText();
				        	Editable email=t6.getEditableText();
				        	Editable address=t7.getEditableText();
				        	Editable city=(Editable) s.getOnItemLongClickListener();
				        	add.db.execSQL("INSERT INTO MyTable2 VALUES('"+ user +"','"+pass+"','"+firstna+"','"+lastna+"','"+phone+"','"+email+"','"+address+"','"+city+"')");
				        	
				        	/*Cursor c=add.db.rawQuery("SELECT * FROM MyTable", null);
				        	c.moveToFirst();
				        	String name="";
				        	while (!c.isAfterLast()){
				        		name+=c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(7);
				        		c.moveToNext();
				        	}
				        	TextView v1=(TextView) findViewById(R.id.textView9);
				        	v1.setText(name);
				        	*/
				         }
				        catch (Exception e){
				        	e.printStackTrace();
				        }
				        finally
				        {
				        	add.db.close();
				        }
				        
				}
			});
	    }

	   
}
