package utils;

import lgc.xiaonaozhong.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.Bitmap.Config;

public class BitmapUtil {
	public Bitmap getIconWithTitle(Context context, Bitmap icon,String title) {
		//获取已有的Drawable图片
		Resources res = context.getResources();
		Bitmap bitmap=BitmapFactory.decodeResource(res,R.drawable.naozhong_icon);
		
		// 初始化画�?		
		int bitmapSize = (int) context.getResources().getDimension(
				android.R.dimen.app_icon_size);
		Bitmap contactbitmap = Bitmap.createBitmap(bitmapSize, bitmapSize,
				Config.ARGB_8888);
		Canvas canvas = new Canvas(contactbitmap);

		// 拷贝图片
		Paint bitmapPaint = new Paint();//用来设置要填充的图片的效�?		bitmapPaint.setAlpha(150);
		bitmapPaint.setDither(true);// 防抖�?		bitmapPaint.setFilterBitmap(true);// 用来对Bitmap进行滤波处理，这样，当你选择Drawable时，会有抗锯齿的效果
		Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());//原图片的大小
		Rect dst = new Rect(0, 0, bitmapSize, bitmapSize);//底板的大�?		canvas.drawBitmap(bitmap, src, dst, bitmapPaint);//�?��用于缩放

		// 启用抗锯齿和使用设备的文本字�?		
		Paint countPaint = new Paint(Paint.ANTI_ALIAS_FLAG
				| Paint.DEV_KERN_TEXT_FLAG);
		countPaint.setColor(0xffFF6633);
		//屏幕适配尺寸
		int textSize,x,y;
		switch (10) {
		case 10:
			
			break;

		default:
			break;
		}
		countPaint.setTextSize(45f);
		countPaint.setTypeface(Typeface.SANS_SERIF);
		canvas.drawText(title, 2, 11*bitmapSize/16,
				countPaint);
		return contactbitmap;
	}
}
