package com.example.mallproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Login extends Activity {
	AddProduct access;
	EditText t,t2;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.login);
	    
	        t=(EditText)  findViewById(R.id.editText1);
	        t2=(EditText)  findViewById(R.id.editText2);
	        Intent intent=new Intent(Login.this,GetBiil.class);
        	Cursor c=access.db.rawQuery("SELECT * FROM MyTable2", null);
        	c.moveToFirst();
        	
        	while (!c.isAfterLast()){
        		
        		if (t.getText().toString()== c.getString(0) && t2.getText().toString()== c.getString(1))
        		
        		startActivity(intent);
        		c.moveToNext();
        	}
	    }

}
