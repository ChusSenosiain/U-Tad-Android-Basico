package com.utad.bacuus.controller.fragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.adapter.WineFragmentAdapter;
import com.utad.bacuus.model.Constants;

public class WineHouseFragment extends Fragment {
	
	
	public static final String ARG_WINE_INDEX = "WINE_SELECTED";
	
	private WineFragmentAdapter mAdapter;
	private android.support.v7.app.ActionBar mActionBar;
	private ViewPager mViewPager;
	
	
	private final int MENU_PREV = 0;
	private final int MENU_NEXT = 1;
	private int wineIndex = 0;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}


	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_wine_house, container, false);
		
		wineIndex = getArguments().getInt(ARG_WINE_INDEX);
		mViewPager = (ViewPager) root.findViewById(R.id.pager);
		
		
		new AsyncTask<FragmentManager, Void, WineFragmentAdapter>() {
			
			private ProgressDialog pDialog = null;
	
			@Override
			protected void onPreExecute() {
				super.onPreExecute();
				pDialog = new ProgressDialog(getActivity());
				pDialog.setTitle("Descargando vinos...");
				pDialog.setIndeterminate(true);
				pDialog.setCancelable(false);
				pDialog.show();
			}

			@Override
			protected void onPostExecute(WineFragmentAdapter result) {
				super.onPostExecute(result);
				pDialog.dismiss();
				mAdapter = result;
				mViewPager.setAdapter(mAdapter);
				updateActionBarAndSaveLastWine(wineIndex);
				mViewPager.setCurrentItem(wineIndex);
			}

			@Override
			protected WineFragmentAdapter doInBackground(FragmentManager... params) {
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return new WineFragmentAdapter(params[0]);
			}
			
			
		}.execute(getFragmentManager());
		
		
		
		
		mActionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		
		
		
		
		
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				updateActionBarAndSaveLastWine(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
		
		return root;
	
	}
	
	
	private void updateActionBarAndSaveLastWine(int position) {
		mActionBar.setSubtitle(mAdapter.getPageTitle(position));
		//mActionBar.setIcon(mAdapter.getResourceImage(position));
		saveLastWine();
	}


	private void saveLastWine() {
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
		pref.edit()
			.putInt(Constants.PREF_LAST_WINE, mViewPager.getCurrentItem())
			.commit();
	}
	
	public void showWine(int index) {
		updateActionBarAndSaveLastWine(index);
		mViewPager.setCurrentItem(index);
	}


	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
		
		MenuItem prev = menu.add(Menu.NONE, MENU_PREV, 0, R.string.action_prev);
		MenuItem next = menu.add(Menu.NONE, MENU_NEXT, 0, R.string.action_next);
		
		MenuItemCompat.setShowAsAction(prev, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		MenuItemCompat.setShowAsAction(next, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

		if (mAdapter != null) {
			int index = mViewPager.getCurrentItem();
			next.setEnabled(index < mAdapter.getCount() -1);
			prev.setEnabled(index > 0);
		} else {
			next.setEnabled(false);
			prev.setEnabled(false);
		}
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case MENU_PREV:
				if (mViewPager.getCurrentItem() > 0) {
					int wineIndex = mViewPager.getCurrentItem() -1;
					showWine(wineIndex);				
				}
				return true;
			case MENU_NEXT:
				if (mViewPager.getCurrentItem() < mAdapter.getCount() - 1) {
					int wineIndex = mViewPager.getCurrentItem() +1;
					showWine(wineIndex);
				}
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}

	}
	
	
	
	
	
	

}
