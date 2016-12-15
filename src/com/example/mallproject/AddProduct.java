package com.example.mallproject;



import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddProduct extends Activity {
	
	EditText t,t2,t3,t4;
	SQLiteDatabase db=null;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
        t=(EditText)  findViewById(R.id.editText1);
        t2=(EditText)  findViewById(R.id.editText2);
        t3=(EditText)  findViewById(R.id.editText3);
        t4=(EditText)  findViewById(R.id.editText4);
        Button b=(Button) findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				  
			        try{
			        	db=openOrCreateDatabase("mx",MODE_PRIVATE,null);
			        	db.execSQL("CREATE TABLE IF NOT EXISTS MyTable(productname VARCHAR,productprovider VARCHAR,price INT(5),quantity INT(3));");
			        	Editable proname=t.getEditableText();
			        	Editable proprovider=t2.getEditableText();
			        	Editable pri=t3.getEditableText();
			        	Editable qua=t4.getEditableText();
			        	db.execSQL("INSERT INTO MyTable VALUES('"+ proname +"','"+proprovider+"','"+pri+"','"+qua+"')");
			        	
			        /*	Cursor c=db.rawQuery("SELECT * FROM MyTable", null);
			        	c.moveToFirst();
			        	String name="";
			        	while (!c.isAfterLast()){
			        		name+=c.getString(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3);
			        		c.moveToNext();
			        	}
			        	TextView v1=(TextView) findViewById(R.id.textView5);
			        	v1.setText(name);
			        	*/
			         }
			        catch (Exception e){
			        	e.printStackTrace();
			        }
			        finally
			        {
			        	db.close();
			        }
			        
			}
		});
        
 
      
        
    }
}
