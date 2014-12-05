package com.utad.mediaplayer;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class PlayerService extends Service {
	
	public static final String EXTRA_URL = "com.utad.mediaplayer.PlayerService.EXTRA_URL";
	
	private String mUrl;
	private MediaPlayer mMediaPlayer;
	private boolean mIsPrepared = false;
	
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		Log.v("#############", intent.getStringExtra(EXTRA_URL));
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		
		Log.v("#############", "Servicio parado!");
	}

	@Override
	public IBinder onBind(Intent intent) {
		mUrl = intent.getStringExtra(EXTRA_URL);
		return new RadioBinder();
	}
	
	
	public interface OnPlayListener {
		public void onPlay();
	}
	
	
	public class RadioBinder extends Binder {
		
		public int suma(int a, int b) {
			return a + b;
		}
		
		public void play(final OnPlayListener listener) {
			
			if (mMediaPlayer == null) {
				
				mMediaPlayer = new MediaPlayer();
				try {
					mMediaPlayer.setDataSource(PlayerService.this, Uri.parse(mUrl));
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				mMediaPlayer.setOnPreparedListener(new OnPreparedListener() {
					@Override
					public void onPrepared(MediaPlayer mp) {
						mMediaPlayer.start();
						listener.onPlay();
						mIsPrepared = true;
					}
				});
				mMediaPlayer.prepareAsync();	
			}
			
		}
		
		public void pause() {
			
			if (mMediaPlayer != null) {
				mMediaPlayer.pause();
			}
			
		}
		
		public void stop() {
			
			if (mMediaPlayer != null) {
				mMediaPlayer.stop();
				mMediaPlayer.reset();
				mMediaPlayer.release();
				mMediaPlayer = null;
			}
			
			mIsPrepared = false;
			
		}
		
	}

}
