package com.utad.practicasexamen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ListFragment extends Fragment {
	
	private ActionBar mActionBar;
	private ListView mListView;
	public static final String ARG_SELECTED_ITEM = "SELECTED_ITEM";
	private String[] mList;
	private static final String MI_LISTA = "MI_LISTA";

	private int mSelectedItem = 0;
	private OnItemSelected mListener;
	
	public interface OnItemSelected {
		public void onItemSelected(int item);
	}
	
	public void setListener(OnItemSelected listener) {
		mListener = listener;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
		if (getArguments() != null) {
			mSelectedItem = getArguments().getInt(ARG_SELECTED_ITEM, 0);
		}
		
		
		
		
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View root = inflater.inflate(R.layout.fragment_list, container, false);
		
		if (savedInstanceState != null) {
			mList = savedInstanceState.getStringArray(MI_LISTA);
		} else {
			mList = new String[3];
			mList[0] = "uno";
			mList[1] = "dos";
			mList[2] = "tres";
		}
		
		// Obtener actionBar 
		mActionBar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		mActionBar.setDisplayHomeAsUpEnabled(true);
		
		mListView = (ListView) root.findViewById(R.id.listview);
		
	
		ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mList); 
	
		mListView.setAdapter(itemsAdapter);
		
		mListView.setSelection(mSelectedItem);

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				if (mListener != null) {
					mListener.onItemSelected(position);
				}
			}
		});
		
		return root;
		
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == android.R.id.home) {
			getActivity().finish();
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putStringArray(MI_LISTA, mList);
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
