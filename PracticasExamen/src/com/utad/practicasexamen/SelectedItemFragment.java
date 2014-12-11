package com.utad.practicasexamen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SelectedItemFragment extends Fragment {
	
	
	TextView mTextoMostrar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		
		View root = inflater.inflate(R.layout.fragment_selected_item, container, false);
		
		mTextoMostrar = (TextView) root.findViewById(R.id.item_seleccionado);
		
				
		return root;
				
	}
	
	
	public void cambiarTexto(String texto) {
		mTextoMostrar.setText(texto);
	}
	
	

}
