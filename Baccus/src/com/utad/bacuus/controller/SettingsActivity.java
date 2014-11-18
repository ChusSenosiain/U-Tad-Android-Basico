package com.utad.bacuus.controller;

import com.utad.bacuus.R;
import com.utad.bacuus.R.id;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;


public class SettingsActivity extends Activity {
	
	RadioGroup mRadios = null;
	
	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	public static final int REQUEST_SELECT_SCALETYPE = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		
		mRadios = (RadioGroup) findViewById(R.id.radioOptions);
		
		Button btnCancel = (Button) findViewById(R.id.btn_cancelar);
		
		Button btnAceptar = (Button) findViewById(R.id.btn_aceptar);
		
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED);
				finish();
			}
		});
		
		
		btnAceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = getIntent();
				
				if (mRadios.getCheckedRadioButtonId() == R.id.radio_normal) {
					intent.putExtra(OPTION_SELECTED, OPTION_NORMAL);
				} else {
					intent.putExtra(OPTION_SELECTED, OPTION_FIT);
				}
				setResult(RESULT_OK, intent);
				finish();
				
			}
		});
		
	}
}
