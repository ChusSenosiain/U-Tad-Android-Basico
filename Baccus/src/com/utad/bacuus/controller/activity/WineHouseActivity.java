package com.utad.bacuus.controller.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.adapter.WineFragmentAdapter;
import com.utad.bacuus.model.Wine;


public class WineHouseActivity extends ActionBarActivity {
	
	public static final String EXTRA_WINE = "WINE_SELECTED";
	
	private WineFragmentAdapter mAdapter;
	private android.support.v7.app.ActionBar mActionBar;
	
	private final int MENU_PREV = 0;
	private final int MENU_NEXT = 1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wine_house);
		
		
		Wine wine = (Wine) getIntent().getSerializableExtra(EXTRA_WINE);
		
		mAdapter = new WineFragmentAdapter(getSupportFragmentManager());
		mActionBar = getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		mActionBar.setNavigationMode(getSupportActionBar().NAVIGATION_MODE_TABS);
		
		final ViewPager pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(mAdapter);
		
		for (int i = 0; i < mAdapter.getCount(); i++) {
			Tab tab = mActionBar.newTab();
			tab.setText(mAdapter.getPageTitle(i));
			
			tab.setTabListener(new TabListener() {
				
				@Override
				public void onTabUnselected(Tab arg0, FragmentTransaction trx) {
					
				}
				
				@Override
				public void onTabSelected(Tab tab, FragmentTransaction trx) {
					pager.setCurrentItem(tab.getPosition());
				}
				
				@Override
				public void onTabReselected(Tab arg0, FragmentTransaction trx) {
					
				}
			});
			mActionBar.addTab(tab);
		}
		
		
		updateActionBar(mAdapter.getWinePosition(wine));
		
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int position) {
				updateActionBar(position);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
		
	}
	
	
	private void updateActionBar(int position) {
		mActionBar.setSubtitle(mAdapter.getPageTitle(position));
		mActionBar.setIcon(mAdapter.getResourceImage(position));
		mActionBar.setSelectedNavigationItem(position);
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		//getMenuInflater().inflate(R.menu.wine_house_menu, menu);
		
		MenuItem prev = menu.add(Menu.NONE, MENU_PREV, 0, R.string.action_prev);
		MenuItem next = menu.add(Menu.NONE, MENU_NEXT, 0, R.string.action_next);
		
		MenuItemCompat.setShowAsAction(prev, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);
		MenuItemCompat.setShowAsAction(next, MenuItemCompat.SHOW_AS_ACTION_ALWAYS);

		
		int index = mActionBar.getSelectedNavigationIndex();
		next.setEnabled(index < mAdapter.getCount() -1);
		prev.setEnabled(index > 0);
		
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case MENU_PREV:
				if (mActionBar.getSelectedNavigationIndex() > 0) {
					updateActionBar(mActionBar.getSelectedNavigationIndex() - 1);
				}
				return true;
			case MENU_NEXT:
				if (mActionBar.getSelectedNavigationIndex() < mAdapter.getCount() - 1) {
					updateActionBar(mActionBar.getSelectedNavigationIndex() + 1);
				}
				return true;
			case android.R.id.home:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
		
	}
	
	
	
	
}
