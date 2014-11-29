package com.utad.bacuus.controller.fragment;

import java.util.LinkedList;
import java.util.List;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.activity.WineHouseActivity;
import com.utad.bacuus.model.Wine;
import com.utad.bacuus.model.WineHouse;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class WineListFragment extends Fragment{
	
	private OnWineSelectedListener mListener = null;
	
	public interface OnWineSelectedListener {
		public void onWineSelected(int index);
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_wine_list, container, false);
		
		final ListView wineList = (ListView) root.findViewById(R.id.wine_list);
		
		new AsyncTask<Void, Void, List<Wine>>() {
			
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
			protected void onPostExecute(List<Wine> result) {
				super.onPostExecute(result);
				pDialog.dismiss();
				wineList.setAdapter(new ArrayAdapter<Wine>(getActivity(),
						android.R.layout.simple_spinner_dropdown_item,
						result));
				
			}

			@Override
			protected List<Wine> doInBackground(Void... params) {
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				WineHouse wineHouse = WineHouse.getInstance();
				return wineHouse.cloneWineList();
			}
			
			
		}.execute();
		
		
		wineList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (mListener != null) {
					mListener.onWineSelected(position);
				}
								
			}
		});
		
		return root;
		
	}


	public OnWineSelectedListener getListener() {
		return mListener;
	}


	public void setListener(OnWineSelectedListener listener) {
		mListener = listener;
	}
	
	
	
	
	

}
