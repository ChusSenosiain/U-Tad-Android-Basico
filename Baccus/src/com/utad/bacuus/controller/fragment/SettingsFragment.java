package com.utad.bacuus.controller.fragment;

import com.utad.bacuus.R;
import com.utad.bacuus.model.Constants;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

public class SettingsFragment extends DialogFragment implements OnClickListener{
	
	
	RadioGroup mRadios = null;
	
	public static final String OPTION_SELECTED = "OPTION_SELECTED";
	public static final int OPTION_NORMAL = 0;
	public static final int OPTION_FIT = 1;
	public static final int REQUEST_SELECT_SCALETYPE = 0;
	
	protected View mRoot = null;
	private SharedPreferences mPref = null;


	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		View root = getActivity().getLayoutInflater().inflate(R.layout.fragment_settings, null);
		
		mPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle(R.string.action_settings);
		dialog.setPositiveButton("OK", this);
		dialog.setNegativeButton("Cancel", this);
		dialog.setView(root);
		
		mRadios = (RadioGroup) root.findViewById(R.id.radioOptions);
		
		int scaleType = mPref.getInt(Constants.PREF_SCALE, OPTION_NORMAL);
		if (scaleType == OPTION_FIT) {
			mRadios.check(R.id.radio_fit);
		} else {
			mRadios.check(R.id.radio_normal);
		}
		
		
		
		
		
		
		return dialog.create();
	}
	
	
	private void save() {
		
		
		
		Activity activity = getActivity();
		Intent intent = new Intent();
		
		int optionSelected = OPTION_FIT;
		
		if (mRadios.getCheckedRadioButtonId() == R.id.radio_normal) {
			optionSelected = OPTION_NORMAL;
		}
		
		intent.putExtra(OPTION_SELECTED, optionSelected);
		mPref.edit()
			.putInt(Constants.PREF_SCALE, optionSelected)
			.commit();

		Fragment targetFragment = getTargetFragment();
		if (targetFragment == null) {
			activity.setResult(Activity.RESULT_OK, intent);
			activity.finish();
		} else {
			targetFragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
		}
	}


	private void cancel() {
		
		Fragment targetFragment = getTargetFragment();
		if (targetFragment == null) {
			getActivity().setResult(Activity.RESULT_CANCELED);
			getActivity().finish();
		} else {
			targetFragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_CANCELED, null);
		}
		
	}


	@Override
	public void onClick(DialogInterface dialog, int which) {
		
		switch(which) {
			case DialogInterface.BUTTON_POSITIVE:
				save();
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				cancel();
				break;
		}
		
	}

}
