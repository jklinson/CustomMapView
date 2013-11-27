/**
 * cabot  
 * Nov 18, 2013
 */
package com.cabot.custommapview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.widget.Toast;

/**
 * @author Linson Alfred
 * 
 * Class for Icons to show in the image. It have the properties of icons 
 * like name, position points, image(bitmap), width and height
 * 
 */
public class Icon {

	MapIconPoints points;
	public Bitmap bitmap;
	int width=0;
	int height=0;
	String name="";
	/**
	 * 
	 */
	public Icon() {

	}
   
	
	/**
	 * @param x
	 * @param y
	 * @param bitmap
	 */
	public Icon(int x, int y, Bitmap bitmap,String name) {
		super();
		this.points=new MapIconPoints();
		this.points.exactPoint.x=x;
		this.points.exactPoint.y=y;
		this.bitmap = bitmap;
		this.name=name;
		this.width=bitmap.getWidth();
		this.height=bitmap.getHeight();
	}
	public void onDraw(Canvas canvas,float scaleFatorX,float scaleFarctorY,PointF movedOrgin) {
		
        update(scaleFatorX, scaleFarctorY, movedOrgin);
//        Paint paint=new Paint();
//        paint.setColor(Color.RED);
        
        canvas.drawBitmap(bitmap, this.points.cuurentPoints.x, this.points.cuurentPoints.y, null);
//        canvas.drawCircle(movedOrgin.x, movedOrgin.y,4.0f, paint);
        
  }
	

	/**
	 * @param movedOrgin 
	 * @param scaleFator 
	 * 
	 */
	private void update(float scaleFatorX,float scaleFactorY,PointF movedOrgin) {
			
		this.points.cuurentPoints.x=this.points.exactPoint.x*scaleFatorX+movedOrgin.x;
		this.points.cuurentPoints.y=this.points.exactPoint.y*scaleFactorY+movedOrgin.y;
	}
	
	public boolean isClicked(float x2, float y2,Context context) {
		Log.i("Icon", "In is clickedd******* \nx2="+x2+"\ncuurentPoints.x="+this.points.cuurentPoints.x+
				"\nwidth="+width+"\ny2="+y2+"\ncuurentPoints.y="+this.points.cuurentPoints.y+
				"\nheight="+height);
		
		
        return x2 > this.points.cuurentPoints.x && x2 < this.points.cuurentPoints.x + width && 
        		y2 > this.points.cuurentPoints.y && y2 < this.points.cuurentPoints.y + height;
  }
}
