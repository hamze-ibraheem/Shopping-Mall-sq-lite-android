package com.example.mallproject;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;

public class GetBiil extends Activity {
	AddProduct access;EditText t,t2,t3;
	   public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        t=(EditText)  findViewById(R.id.editText1);
	        t2=(EditText)  findViewById(R.id.editText2);
	        t3=(EditText)  findViewById(R.id.editText3);
	        EditText v=(EditText) findViewById(R.id.editText1);
        	Cursor c=access.db.rawQuery("SELECT * FROM MyTable", null);
        	c.moveToFirst();
        	int sum=0;
        	while (!c.isAfterLast()){
        		
       t.setText(c.getString(0));
       t2.setText(c.getInt(2));
       t3.setText(c.getInt(3));
       sum=sum+c.getInt(2);
        		c.moveToNext();
        	}
        	v.setText(sum);
	   }
	   
}
