package com.utad.excursions;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;



public class DownloadImageTask {
	
	private static final String TAG = "DownloadImageTask";
	
	public interface DownloadRequestListener{
		public void onDone(Bitmap image, Exception exception);	
	}
	
	public DownloadImageTask() {
		
	}
	
	private Exception mException = null;
	
	public void getHTTPImage(String imageURL, final DownloadRequestListener requestListener) {
		
		new AsyncTask<String, Void, Bitmap>() {

			@Override
			protected Bitmap doInBackground(String... params) {
				
				Bitmap mImage = null;
				String mImageURL = params[0];
                try {
                    mImage = BitmapFactory.decodeStream((InputStream) new URL(mImageURL).getContent());
                } catch (IOException err) {
                	mException = err;
                    Log.e(TAG, "getUserImageError in downloadUserImage: " + err.getMessage(), err);
                }
				
                return mImage;
            }

			@Override
			protected void onPostExecute(Bitmap result) {
				super.onPostExecute(result);
				
				requestListener.onDone(result, mException);
			}
			
		}.execute(imageURL);
		
	}
	

}
