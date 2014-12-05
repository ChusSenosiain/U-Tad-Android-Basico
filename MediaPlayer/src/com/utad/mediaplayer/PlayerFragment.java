package com.utad.mediaplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.utad.mediaplayer.PlayerService.RadioBinder;

public class PlayerFragment extends Fragment implements OnClickListener, ServiceConnection {
	
	
	MediaPlayer mMediaPlayer;
	
	private static final String TAG_PLAY = "PLAY";
	private static final String TAG_PAUSE = "PAUSE";
	
	private Button btnPP;
	private Button btnStop;
	private boolean mIsPrepared = false;
	private RadioBinder mRadioBinder = null;
	
	
	public static PlayerFragment newInstance() {
		
		PlayerFragment fragment = new PlayerFragment();
		return fragment;
	}
	
	
	public PlayerFragment() {}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		
		View root = inflater.inflate(R.layout.fragment_player, container, false);
		
		btnPP = (Button) root.findViewById(R.id.btn_play_pause);
		btnStop = (Button) root.findViewById(R.id.btn_stop);
		Button btnService = (Button) root.findViewById(R.id.btn_start_service);
		Button btnStopService = (Button) root.findViewById(R.id.btn_stop_service);
		Button btnBindService = (Button) root.findViewById(R.id.btn_bind_service);
		Button btnAddService = (Button) root.findViewById(R.id.btn_add_service);
		Button btnUnbindService = (Button) root.findViewById(R.id.btn_unbind_service);
		
		
		btnPP.setText(TAG_PLAY);
		
		btnPP.setOnClickListener(this);
		btnStop.setOnClickListener(this);
		
		btnService.setOnClickListener(this);
		btnStopService.setOnClickListener(this);
		
		btnBindService.setOnClickListener(this);
		btnAddService.setOnClickListener(this);
		btnUnbindService.setOnClickListener(this);
		
		btnStop.setVisibility(View.GONE);
		
		return root;
	}


	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.btn_play_pause:
			
			if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
				mMediaPlayer.pause();
				btnPP.setText(TAG_PLAY);
			}
			else {
				
				try {
					if (mMediaPlayer == null) {
						Uri uri = Uri.parse("http://5293.live.streamtheworld.com:80/MAXIMAFM_SC");
						mMediaPlayer = new MediaPlayer();
						mMediaPlayer.setDataSource(getActivity(), uri);
						mMediaPlayer.setOnPreparedListener(new OnPreparedListener() {
							@Override
							public void onPrepared(MediaPlayer mp) {
								mIsPrepared = true;
								play();
							}
						});
						mMediaPlayer.prepareAsync();	
					}
				
				} catch (Exception e) {
					
				}
				
			} 
			
			break;

		case R.id.btn_stop:
			
			btnPP.setText(TAG_PLAY);
			
			if (mMediaPlayer != null) {
				mMediaPlayer.stop();
				mMediaPlayer.reset();
				mMediaPlayer.release();		
				mMediaPlayer = null;
				mIsPrepared = false;
			}
		
			break;
			
			
		case R.id.btn_start_service:
			Intent intent = new Intent(getActivity(), PlayerService.class);
			intent.putExtra(PlayerService.EXTRA_URL, "http://5293.live.streamtheworld.com:80/MAXIMAFM_SC");
			getActivity().startService(intent);
			break;
			
			
		case R.id.btn_stop_service:
			Intent intentStop = new Intent(getActivity(), PlayerService.class);
			getActivity().stopService(intentStop);
			break;
			
			
		case R.id.btn_bind_service:
			
			if (mRadioBinder == null) {
				Intent intentBind = new Intent(getActivity(), PlayerService.class);
				intentBind.putExtra(PlayerService.EXTRA_URL, "http://5293.live.streamtheworld.com:80/MAXIMAFM_SC");
				getActivity().bindService(intentBind, this, Context.BIND_AUTO_CREATE);
			}
			break;
			
		case R.id.btn_unbind_service:
			if (mRadioBinder == null) {
				getActivity().unbindService(this);
				mRadioBinder = null;
				break;
			}
		case R.id.btn_add_service:
			
			if (mRadioBinder != null) {
				Toast.makeText(
						getActivity(), 
						"La suma de 2 + 3 es..." + mRadioBinder.suma(2, 3), 
						Toast.LENGTH_LONG).show();
			}
			break;
		} 
		
	}
	
	
	private void play() {
		mMediaPlayer.start();
		btnStop.setVisibility(View.VISIBLE);
		btnPP.setText(TAG_PAUSE);						
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		
		if (mMediaPlayer != null) {
			mMediaPlayer.stop();
			mMediaPlayer.reset();
			mMediaPlayer.release();		
	
		}
		
		
	}


	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {		
		mRadioBinder = (RadioBinder) service;
	}


	@Override
	public void onServiceDisconnected(ComponentName name) {
		mRadioBinder = null;
	}
	
	
	
	

}
