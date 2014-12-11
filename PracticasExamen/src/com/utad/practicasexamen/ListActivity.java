package com.utad.practicasexamen;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ListActivity extends ActionBarActivity implements ListFragment.OnItemSelected{
	
	public static final String EXTRA_SELECTED_ITEM = "EXTRA_SELECTED_ITEM";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_list);
		
		Integer itemSelected = getIntent().getIntExtra(EXTRA_SELECTED_ITEM, 0);
		
		FragmentManager manager = getSupportFragmentManager();
		
		ListFragment fragment = (ListFragment) manager.findFragmentById(R.id.placeholder_fragment);
		
		if (fragment == null) {
			fragment = new ListFragment();
			Bundle arguments = new Bundle();
			arguments.putInt(ListFragment.ARG_SELECTED_ITEM, itemSelected);
			fragment.setArguments(arguments);
			manager.beginTransaction()
			.add(R.id.placeholder_fragment, fragment)
			.commit();
		}
		
		fragment.setListener(this);
		
		
		if (findViewById(R.id.placeholder_fragment_selected_item) != null) {
		
			SelectedItemFragment fragment2 = (SelectedItemFragment) manager.findFragmentById(R.id.placeholder_fragment_selected_item);
			
			if (fragment2 == null) {
				Bundle arguments = new Bundle();
				arguments.putInt(ListFragment.ARG_SELECTED_ITEM, itemSelected);
				fragment2 = new SelectedItemFragment();
				fragment2.setArguments(arguments);
				manager.beginTransaction()
				.add(R.id.placeholder_fragment_selected_item, fragment2)
				.commit();
			}
 		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemSelected(int item) {
		
		
		if (findViewById(R.id.placeholder_fragment_selected_item) != null) {
			
			SelectedItemFragment fragment = (SelectedItemFragment) getSupportFragmentManager().findFragmentById(R.id.placeholder_fragment_selected_item);
			fragment.cambiarTexto("Item seleccionado: " + item);
		}
	
		
	}
	
}
