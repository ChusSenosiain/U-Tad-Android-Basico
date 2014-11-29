package com.utad.bacuus.controller.adapter;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.utad.bacuus.controller.fragment.WineFragment;
import com.utad.bacuus.model.Wine;
import com.utad.bacuus.model.WineHouse;

public class WineFragmentAdapter extends FragmentPagerAdapter {
	
	private WineHouse mWines = null;

	public WineFragmentAdapter(FragmentManager fm) {
		super(fm);
		mWines = WineHouse.getInstance();
	}

	@Override
	public Fragment getItem(int position) {
		
		WineFragment fragment = new WineFragment();
		Bundle arguments = new Bundle();
		arguments.putSerializable(WineFragment.ARG_WINE, mWines.getWine(position));
		fragment.setArguments(arguments);
		
		return fragment;
	}

	@Override
	public int getCount() {
		return mWines.getWinesSize();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		super.getPageTitle(position);
		return mWines.getWine(position).getName();
	}
	
	public int getResourceImage(int position) {
		return mWines.getWine(position).getImage();
	}
	
	public int getWinePosition(Wine wine) {
		
		int pos = 0;
		
		for (pos = 0; pos < mWines.getWinesSize(); pos++) {
			if (mWines.getWine(pos).equals(wine)) {
				break;
			}
		}
		
		return pos;
	}
	
	

}
