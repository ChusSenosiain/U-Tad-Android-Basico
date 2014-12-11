package com.utad.practicasexamen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainFragment extends Fragment {
	
	private static final String PREFS = "PREFS";
	private static final String PRUEBA_STRING = "PRUEBA_STRING";
	private static final Integer MENU_ITEM_1 = 1;
	
	private EditText mEditText;
	private ActionBar mActionBar;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		mActionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		
		View root = inflater.inflate(R.layout.fragment_main, container, false);
		
		TextView textView = (TextView) root.findViewById(R.id.textView1);
		mEditText = (EditText) root.findViewById(R.id.editText);
		
		SharedPreferences pref = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
		String cadena = pref.getString(PRUEBA_STRING, null);
		
		if (cadena != null) {
			mActionBar.setTitle(cadena);
			textView.setText("Antes " + cadena);
		}
		
		Button btnOpciones = (Button) root.findViewById(R.id.btn_options);
		btnOpciones.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				OptionsFragmentDialog dialog = new OptionsFragmentDialog();
				dialog.setTargetFragment(MainFragment.this, 1001);
				dialog.show(getChildFragmentManager(), null);
				
				
			}
		});
		
		Button btnSiguiente = (Button) root.findViewById(R.id.btn_siguiente);
		btnSiguiente.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			
				Intent siguiente = new Intent(getActivity(), ListActivity.class);
				siguiente.putExtra(ListActivity.EXTRA_SELECTED_ITEM, 2);
				startActivity(siguiente);
			}
		});
		
		return root;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		
		MenuItem menuItem = menu.add(Menu.NONE, MENU_ITEM_1, 0, "SAVE");
		MenuItemCompat.setShowAsAction(menuItem, MenuItemCompat.SHOW_AS_ACTION_ALWAYS); 
		
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == MENU_ITEM_1) {
			
			SharedPreferences pref = getActivity().getSharedPreferences(PREFS, Context.MODE_PRIVATE);
			pref.edit().putString(PRUEBA_STRING, mEditText.getText().toString())
			.commit();
						
		}
		
		return super.onOptionsItemSelected(item);
	}

	
	
}
