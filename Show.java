package com.example.travel;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;
import android.widget.ViewSwitcher.ViewFactory;

    public class Show extends Activity{
   
    private ImageSwitcher mSwitcher;
    private int[] mThumbIds=null;
    private int[] mImageIds =null;
    private int traid;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.show);
	    Log.e("asdf","asdfasdfasdf");
	    Bundle extras = getIntent().getExtras(); 
        traid = extras.getInt("traid");

	    Log.e("asdf","asdfasdfasdf");
       // mThumbIds = new int[]{ R.drawable.sample_thumb_0, R.drawable.sample_thumb_1, R.drawable.sample_thumb_2, R.drawable.sample_thumb_3, R.drawable.sample_thumb_4, R.drawable.sample_thumb_5, R.drawable.sample_thumb_6, R.drawable.sample_thumb_7};
        mImageIds =new int[]{ R.drawable.sample_0, R.drawable.sample_1, R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4, R.drawable.sample_5, R.drawable.sample_6, R.drawable.sample_7};
       // get picture from  dir named by traid
        
	    mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
	    mSwitcher.setFactory(new ViewFactory(){
	    	   public ImageView makeView() {
	    		    ImageView i = new ImageView(Show.this);
	    		    i.setBackgroundColor(0xFF000000);
	    		    i.setScaleType(ImageView.ScaleType.FIT_CENTER);
	    		    i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	    		    return i;
	    	    }
	    	   });
	    mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in)); 
	    mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
	    Gallery g = (Gallery) findViewById(R.id.gallery);
	    g.setAdapter(new ImageAdapter(this));
	    g.setOnItemSelectedListener(new OnItemSelectedListener(){
			public void onItemSelected(AdapterView parent, View v, int position, long id) { 
		    	mSwitcher.setImageResource(mImageIds[position]);
		    } 
			public void onNothingSelected(AdapterView< ?> arg0) { }
	    	});
	    
    }
   
 
  
    public class ImageAdapter extends BaseAdapter {
		    public ImageAdapter(Context c) {mContext = c;  }
		    public int getCount() {return mThumbIds.length;}
		    public Object getItem(int position) {return position;}
		    public long getItemId(int position) {return position;}
		    public ImageView getView(int position, View convertView, ViewGroup parent) {
				    ImageView i = new ImageView(mContext);
				    i.setImageResource(mImageIds[position]);
				    i.setAdjustViewBounds(true);
				    i.setLayoutParams(new Gallery.LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				 
				    i.setBackgroundResource(R.drawable.picture_frame);
				    return i;
		    	}
		    private Context mContext;
    }

    }