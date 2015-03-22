package com.example.travel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Travallist extends Activity {
	private ListView tralv=null;
	private String[] trals=null;
	private String[] tratime=null;
	private String[] traid=null;
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.travallist);
	        
	        trals=getResources().getStringArray(R.array.trals);
			tratime=getResources().getStringArray(R.array.traitime);
			traid=getResources().getStringArray(R.array.traid);
			
		
	       tralv=(ListView)findViewById(R.id.share_trals);
		   SimpleAdapter traadapter= new  SimpleAdapter(getApplicationContext(), getshareItems(),
		       		R.layout.travallist_item, new String[]{"trals","tratime"}, 
		               new int[]{R.id.traname,R.id.tratime,});
		   tralv.setAdapter(traadapter);
		   tralv.setOnItemClickListener(new OnItemClickListener(){
				 public void onItemClick(AdapterView<?> adapterView, View view, final int position,long id) {
						
					 new AlertDialog.Builder(Travallist.this).setTitle("操作").setItems(
						     new String[] { "查看","分享", "编辑" }, new OnClickListener(){
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									// TODO Auto-generated method stub
									Toast.makeText( Travallist.this, "You choose " +which, Toast.LENGTH_LONG).show();
									Intent intent=null;
								
									switch(which){
									case 0:
										/*intent=new Intent(Travallist.this,Show.class);
										intent.putExtra("traid", traid[position]);
										startActivity(intent);*/
										break;
									case 1: break;
									case 2:
										intent=new Intent(Travallist.this,Write.class);
										intent.putExtra("traid", traid[position]);
										startActivity(intent);
										break;
									}
									}
								}).setNegativeButton("取消", null).show();
				 		}
			
				});
	 }

	 
	private List<? extends Map<String, ?>> getshareItems() {
		// TODO Auto-generated method stub
		
		 List<Map<String,Object>> listItems= new  ArrayList<Map<String,Object>>();
		  
        for(int i=0;i<trals.length;i++){
            Map<String,Object> map= new HashMap<String,Object>();
            map.put("trals",trals[i]);          
            map.put("tratime",tratime[i]);
            listItems.add(map);
        }
       
        
     return listItems;
	}
	

	
}
