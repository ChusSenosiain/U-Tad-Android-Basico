package com.utad.bacuus.controller.fragment;

import java.util.LinkedList;
import java.util.List;

import com.utad.bacuus.R;
import com.utad.bacuus.controller.activity.WineHouseActivity;
import com.utad.bacuus.model.Wine;
import com.utad.bacuus.model.WineHouse;

import android.content.Intent;
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

public class WineListFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View root = inflater.inflate(R.layout.fragment_wine_list, container, false);
		
		ListView wineList = (ListView) root.findViewById(R.id.wine_list);
		
		
		wineList.setAdapter(new ArrayAdapter<Wine>(getActivity(),
				android.R.layout.simple_spinner_dropdown_item,
				WineHouse.getInstance().cloneWineList()));
		
		
		wineList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// TODO ir a la ventana de winehouse con el vino seleccionado
				//Toast.makeText(getActivity(), "Vino " + position, Toast.LENGTH_LONG).show();
				
				parent.getItemAtPosition(position);
				
				Intent wineHouseActivity = new Intent(getActivity(), WineHouseActivity.class);
				wineHouseActivity.putExtra(WineHouseActivity.EXTRA_WINE, (Wine) parent.getItemAtPosition(position));
				getActivity().startActivity(wineHouseActivity);
				
			
			}
			
		});
		
		return root;
		
	}
	
	

}
