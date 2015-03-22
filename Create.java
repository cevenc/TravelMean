package com.example.travel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Create extends Activity {
	private Button bt1;
	private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create);
        
        bt1=(Button)findViewById(R.id.crbt_cancer);
        
        bt1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Create.this,Login.class);
				startActivity(intent);
				Create.this.finish();
			}
        	
        });
        bt2=(Button)findViewById(R.id.crbt_registe);
        
        bt2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				
				/*TODO post the data to server*/
				
			   Intent intent=new Intent(Create.this,Login.class);
				startActivity(intent);
				Create.this.finish();
			}
        	
        });
    }

 
    
}
