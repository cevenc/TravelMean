package com.example.travel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity {
private Button bt1;
private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        bt1=(Button)findViewById(R.id.homebt_createtra);
     
        bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Home.this,Creatrval.class);
				startActivity(intent);
				Home.this.finish();
			}
        	
        	
        	
        });
        bt2=(Button)findViewById(R.id.homebt_trals);
        
        bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Home.this,Travallist.class);
				startActivity(intent);
				Home.this.finish();
				
			}
        	
        	
        	
        });

        
    }
}
