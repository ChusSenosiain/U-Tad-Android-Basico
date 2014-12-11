package com.utad.practicasexamen;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OptionsFragmentDialog extends DialogFragment implements OnClickListener{

	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		super.onCreateDialog(savedInstanceState);
		
		
		View root = getActivity().getLayoutInflater().inflate(R.layout.fragment_dialog_options, null);
		
		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
		dialog.setTitle("Options");
		dialog.setPositiveButton("ACEPTAR", this);
		dialog.setNegativeButton("CANCELAR", this);
		dialog.setView(root);
				
		
		return dialog.create();
		
	}
	
	
	private void save() {
		
		Fragment fragment = getTargetFragment();
		Activity activity = getActivity();
		
		Intent intent = new Intent();
		intent.putExtra("RESULTADO", 1);
		
		if (fragment != null) {
			fragment.onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
		} else {
			activity.setResult(Activity.RESULT_OK, intent);
		}
		this.dismiss();
	}
	
	private void cancel() {
		this.dismiss();
	}

	@Override
	public void onClick(DialogInterface dialog, int which) {
		
		switch (which) {
		
		case DialogInterface.BUTTON_POSITIVE:
			
			save();
			break;
			
		case DialogInterface.BUTTON_NEGATIVE:
			cancel();
			break;
		
		}
		
	}

		
	
	

}
