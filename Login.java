package com.example.travel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class Login extends Activity {
private Button bt1;
private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        
        bt1=(Button)findViewById(R.id.loregist);
     
        bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Login.this,Create.class);
				startActivity(intent);
			}
        	
        });
        bt2=(Button)findViewById(R.id.lologin);
        
        bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Login.this,Home.class);
				startActivity(intent);
				Login.this.finish();
			}
        	
        });
        
        
    }

 
 
    
}
