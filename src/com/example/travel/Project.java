package com.example.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Project extends Activity {
private ImageButton bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        bt=(ImageButton)findViewById(R.id.proimageButton2);
     
    	Log.e("sdfsdf","sdfsdfsdf");
        bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Project.this,Write.class);
				startActivity(intent);
			}
        	
        	
        	
        });

    	Log.e("sdfsdf","sdfsdfsdf");
        
        
    }

 
 
    
}
