package com.utad.simplechesstable;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	
	private static final String TAG = "SimpleChessTable";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        // Crear un tablero de ajedrez y mostrarlo en el log con un solo comando log
        StringBuilder mChessTable = new StringBuilder();
        String mCellValue;
        
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		if ((i + j) % 2 == 0) {
        			mCellValue = "X";
        		} else {
        			mCellValue = "_";
        		}
        		mChessTable.append(mCellValue);
        	}
        	mChessTable.append("\n");
        }
        
        Log.d(TAG, mChessTable.toString());
        
        // Mío. Crear el tablero en una matriz
        String [][] mChessTableMat = new String[8][8];
        
        for (int i = 0; i < 8; i++) {
        	for (int j = 0; j < 8; j++) {
        		if ((i + j) % 2 == 0) {
        			mCellValue = "X";
        		} else {
        			mCellValue = "_";
        		}
        		mChessTableMat[i][j] = mCellValue;
        	}
        }
        
        
        
        
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
