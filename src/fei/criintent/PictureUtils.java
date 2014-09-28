package fei.criintent;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.Display;
import android.widget.ImageView;

public class PictureUtils {
	public static BitmapDrawable getScaledDrawable(Activity a, String path) {
		Display display = a.getWindowManager().getDefaultDisplay();
		float destWidth = display.getWidth();
		float destHeight = display.getHeight();
		
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(path, options);
		
		float srcWidth = options.outWidth;
		float srcHeight = options.outHeight;
		
		int inSmapleSize = 1;
		if ((srcWidth > destWidth) || (srcHeight > destHeight)) {
			if (srcWidth > srcHeight) {
				inSmapleSize = Math.round((float)srcHeight / (float)destHeight);
			} else {
				inSmapleSize = Math.round((float)srcWidth / (float)destWidth);
			}
		}
		
		options = new BitmapFactory.Options();
		options.inSampleSize = inSmapleSize;
		Bitmap bitmap= BitmapFactory.decodeFile(path, options);
		return new BitmapDrawable(a.getResources(), bitmap);
	}
	
	public static void cleanImageView(ImageView imageView) {
		BitmapDrawable b = (BitmapDrawable) imageView.getDrawable();
		b.getBitmap().recycle();
		imageView.setImageDrawable(null);
	}
}
