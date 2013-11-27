/**
 * cabot  
 * Nov 18, 2013
 */
package com.cabot.custommapview;

import java.util.ArrayList;

import com.cabot.sampleimageviewzoom.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;
/**
 * @author Linson Alfred
 *
 */
public class MainActivity extends Activity implements IconClicklistener {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TouchImageView touchImageView=new TouchImageView(this,createIcons());
		touchImageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		touchImageView.setImageResource(R.drawable.map);
		touchImageView.invalidate();
		
		setContentView(touchImageView);
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/* 
	 * icon click listener 
	 */
	@Override
	public void iconClicked(Icon icon) {
		
		Toast.makeText(MainActivity.this, icon.name+" Clicked", Toast.LENGTH_SHORT).show();
		
	}

	
	/**
	 * Here we add icons to the iconlist , you can specify the postitions, drawable image 
	 * and icon name to identify it
	 */
	private ArrayList<Icon> createIcons() {
		
		//sample x and y cordinates
		
		int x=70;
	    int y=200;
	    
	    ArrayList<Icon>iconList=new ArrayList<Icon>();
		iconList.add(createIcon(x,y,R.drawable.marker,"Icon 1"));
		iconList.add(createIcon(1000, y+50, R.drawable.marker,"Icon 2"));
		
		return iconList;
		
	}
	/**
	 * Creates icon to mark in the map
	 * 
	 * @param x x-cordinate of the icon to mark in image
	 * @param y y-cordinate of the icon to mark in image
	 * @param resource id - resource id of the markers image.
	 * @param IconName - this is to identify the icon 
	 */
	private Icon createIcon(int x, int y, int resid, String iconName) {
		
		 Bitmap bmp = BitmapFactory.decodeResource(getResources(), resid);
         return new Icon(x, y, bmp,iconName);
				
	}
		
		
		

}
