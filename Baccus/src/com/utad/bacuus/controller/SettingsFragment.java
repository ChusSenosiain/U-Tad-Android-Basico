package com.utad.bacuus.controller;

import com.utad.bacuus.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsFragment extends Fragment{
	
	
	RadioGroup mRadios = null;
	
	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	public static final int REQUEST_SELECT_SCALETYPE = 0;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_settings, container, false);
		
		
		mRadios = (RadioGroup) root.findViewById(R.id.radioOptions);
		
		Button btnCancel = (Button) root.findViewById(R.id.btn_cancelar);
		
		Button btnAceptar = (Button) root.findViewById(R.id.btn_aceptar);
		
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getActivity().setResult(Activity.RESULT_CANCELED);
				getActivity().finish();
			}
		});
		
		
		btnAceptar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = getActivity().getIntent();
				
				if (mRadios.getCheckedRadioButtonId() == R.id.radio_normal) {
					intent.putExtra(OPTION_SELECTED, OPTION_NORMAL);
				} else {
					intent.putExtra(OPTION_SELECTED, OPTION_FIT);
				}
				
				getActivity().setResult(Activity.RESULT_OK, intent);
				getActivity().finish();
				
			}
		});
		
		return root;
	}
	
	
	

}
