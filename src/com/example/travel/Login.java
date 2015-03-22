package com.example.travel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Login extends Activity {
private Button bt1;
private Button bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
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
