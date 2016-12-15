package com.example.mallproject;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private ListView m_listview;
  	Intent intent;
  	Intent intent2;
  	Intent intent3;
  	AddProduct access;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    
    	intent=new Intent(MainActivity.this,Registration.class);
    	 intent2=new Intent(MainActivity.this,AddProduct.class);
    	 intent3=new Intent(MainActivity.this,Login.class);
      
      TextView v=(TextView) findViewById(R.id.textView2);
       
      TextView v2=(TextView) findViewById(R.id.textView3);
      TextView v3=(TextView) findViewById(R.id.textView4);
        EditText t= (EditText) findViewById(R.id.autoCompleteTextView1);
      	Cursor c=access.db.rawQuery("SELECT * FROM MyTable", null);
    	c.moveToFirst();
    	
    	while (!c.isAfterLast()){
    		
    		if (t.getText().toString()== c.getString(0))
    		v.setText(c.getString(0));
    		v2.setText(c.getString(2));
    		v3.setText(c.getString(3));
    		c.moveToNext();
    	}
    	
 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.omenu, menu);
       
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
       
    	if (item.getItemId()== R.id.item4)
    	{
    	    try{
            	startActivity(intent);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
    	}
    	if (item.getItemId()== R.id.item6)
    	{
    	    try{
            	startActivity(intent2);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
    	} 
      	if (item.getItemId()== R.id.item5)
    	{
    	    try{
            	startActivity(intent3);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
    	} 
     	if (item.getItemId()== R.id.item1)
    	{
    	    try{
            	startActivity(intent3);
            }
            catch (Exception e)
            {
            	e.printStackTrace();
            }
    	}
        return true;
    }

}
