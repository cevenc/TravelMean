package com.example.travel;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Creatrval extends Activity {
private ImageButton bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
         setContentView(R.layout.creatrval);
        bt=(ImageButton)findViewById(R.id.cretrabt_finish);
     
        bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			   Intent intent=new Intent(Creatrval.this,Travallist.class);
				startActivity(intent);
				Creatrval.this.finish();
			}
        	
        	
        	
        });
        
    }

 
 
    
}
