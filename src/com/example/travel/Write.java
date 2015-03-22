package com.example.travel;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Write extends Activity {
	private static final int REQUEST_CODE_CAPTURE_CAMEIA = 0;
	private static final int REQUEST_CODE_PICK_IMAGE = 1;
	private String savepath = "pic";
	private ImageButton bt_pic=null;
	private Button bt_OK=null;
	private Button bt_cancer=null;
	private String capturePath = null;
	private int traid;
	private	File savedir=null;
	private Bitmap photo=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.write);
    
        Bundle extras = getIntent().getExtras(); 
        traid = extras.getInt("traid");
        
        savedir = new File(traid+"");
        if (!savedir.exists()) {savedir.mkdirs();}
        
        
        bt_pic=(ImageButton) findViewById(R.id.write_pic);
       
        bt_pic.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String[] dialoglist=getResources().getStringArray(R.array.write_dialoglist);
				new AlertDialog.Builder(Write.this).setTitle(getResources().getString(R.string.operate)).setItems(
					     dialoglist, 
					     new DialogInterface.OnClickListener(){
					    	 @Override
					    	 public void onClick(DialogInterface dialog,int which) {
					    		// Toast.makeText( Write.this, "You choose " +which, Toast.LENGTH_LONG).show();
					    		
								if (which==0){
									getImageFromAlbum();
								}else {
									getImageFromCamera();
								}
					    	 }
					    }).setNegativeButton(getResources().getString(R.string.cancer), null).show();
			}
        });
      
        bt_OK=(Button)findViewById(R.id.write_OK);
        bt_OK.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText( Write.this, "you click the OK button", Toast.LENGTH_LONG).show();
				//String spath=savedir.toString()+"/hello_file.jpg";                      
		    	//saveImage(photo, spath);
		    	//Log.e( "aaaaaaaaa",savedir.toString()+"      "+savedir.getPath());  
		    	
			}});
        
        
        bt_cancer=(Button)findViewById(R.id.write_cancer);
        bt_cancer.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText( Write.this, "you click the CANCER button", Toast.LENGTH_LONG).show();
			}});
    
    }
    
    
    protected void getImageFromAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }
    
    protected void getImageFromCamera() {
        String state = Environment.getExternalStorageState();
        Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE_CAMEIA);
              
    }

 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    
    	Uri uri = data.getData();  
    	ContentResolver resolver = getContentResolver();
    	
    	if (requestCode == REQUEST_CODE_PICK_IMAGE) {  
               try {
            	   photo = MediaStore.Images.Media.getBitmap(resolver, uri);
       				
       			} catch (FileNotFoundException e) {
       				// TODO Auto-generated catch block
       				e.printStackTrace();
       			} catch (IOException e) {
       				// TODO Auto-generated catch block
       				e.printStackTrace();
       			}
        } else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA ) {           
        	
	            //use bundle to get data
        			Bundle bundle = data.getExtras();  
	                if (bundle != null) {               
	                	photo = (Bitmap) bundle.get("data");
	                } else {         
	                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();         
	                 return;  } 
	            
        	}
	
    	bt_pic.setImageBitmap(photo);
    	
      
 }
    public static void saveImage(Bitmap photo, String spath) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(spath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        return ;
    }
    
    
}
