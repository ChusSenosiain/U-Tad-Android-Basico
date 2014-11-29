package com.utad.bacuus.controller.fragment;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.activity.SettingsActivity;
import com.utad.bacuus.controller.activity.WebActivity;
import com.utad.bacuus.model.Constants;
import com.utad.bacuus.model.Wine;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class WineFragment extends Fragment{
	
	private static final String CURRENT_SCALE = "CURRENT_SCALE";
	public static final String ARG_WINE = "WINE_SELECTED";

	
	ImageView mWineImage = null;
	private Wine mWine = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_wine, container, false);
		
		mWine = (Wine) getArguments().getSerializable(ARG_WINE);
        
        if (mWine == null) {
        	mWine = new Wine();
        }
        
        
        mWineImage = (ImageView) root.findViewById(R.id.wine_image);
        
        TextView tvName = (TextView) root.findViewById(R.id.tv_name);
        TextView tvType = (TextView) root.findViewById(R.id.tv_type);
        TextView tvWinehouse = (TextView) root.findViewById(R.id.tv_winehouse);
        TextView tvDescription = (TextView) root.findViewById(R.id.tv_description);
        
	   
        if (savedInstanceState != null && savedInstanceState.getSerializable(CURRENT_SCALE) != null) {
        	mWineImage.setScaleType((ScaleType) savedInstanceState.getSerializable(CURRENT_SCALE));
        } else {
        	SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
    		scaleWineImage(pref.getInt(Constants.PREF_SCALE, -1));
        }
        
        Button btnWeb = (Button) root.findViewById(R.id.btn_web);
        btnWeb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
				alert.setTitle("¿Ande vas?");
				alert.setMessage("Ojo-cuidado, que nos vamos fuera de la pp, tu verás lo que haces");
				alert.setPositiveButton("tranki", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent webActivity = new Intent(getActivity(), WebActivity.class);
						webActivity.putExtra(WebActivity.EXTRA_URL, mWine.getURL());
						startActivity(webActivity);
					}
				});
				
				alert.setNegativeButton("Más acojonao", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
				
				alert.show();
				
			}
		});
        
        
        
        RatingBar rating = (RatingBar) root.findViewById(R.id.rating);
        
        LinearLayout grapesContainer = (LinearLayout) root.findViewById(R.id.grapes);
        for (String grape: mWine.getGrapes()) {
        	TextView text = new TextView(getActivity());
        	text.setText(grape);
        	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        			LinearLayout.LayoutParams.MATCH_PARENT,
        			LinearLayout.LayoutParams.WRAP_CONTENT);
        	text.setLayoutParams(params);
        	
        	grapesContainer.addView(text);
        	
        }
        
        tvName.setText(mWine.getName());
        tvType.setText(mWine.getType());
        tvWinehouse.setText(mWine.getWineHouse());
        tvDescription.setText(mWine.getDescription());
        
        
        //mWineImage.setImageResource(mWine.getImage());
        mWineImage.setImageBitmap(mWine.getBitmap(getActivity()));
        
        
        rating.setRating(mWine.getRating());
		
		
		return root;
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		if (mWineImage != null) {
			ScaleType currentScale = mWineImage.getScaleType();
			outState.putSerializable(CURRENT_SCALE, currentScale);
		}

	}
	
	

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == SettingsFragment.REQUEST_SELECT_SCALETYPE && resultCode == getActivity().RESULT_OK) {
			scaleWineImage(data.getIntExtra(SettingsFragment.OPTION_SELECTED, -1));
		}
	}
	
	
	public void scaleWineImage(int scaleType) {
		
		if (scaleType == SettingsFragment.OPTION_NORMAL) {
			// A la imagen le doy un type normal
			mWineImage.setScaleType(ScaleType.FIT_CENTER);

		}
		else if (scaleType == SettingsFragment.OPTION_FIT) {
			// A la imagen le doy un type estirado
			mWineImage.setScaleType(ScaleType.FIT_XY);
			
		}
		
	}
	
	
	
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		boolean defaultValue = super.onOptionsItemSelected(item);
		
		if (item.getItemId() == R.id.menu_settings) {
			SettingsFragment dialog = new SettingsFragment();
			dialog.setTargetFragment(this, SettingsFragment.REQUEST_SELECT_SCALETYPE);
			dialog.show(getFragmentManager(), null);
			return true;
		} else{
			return defaultValue;
		}
	}
	
	

	
	
	
	
	

}
