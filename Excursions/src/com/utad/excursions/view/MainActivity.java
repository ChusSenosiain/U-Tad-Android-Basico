package com.utad.excursions.view;

import java.util.ArrayList;

import com.utad.excursions.Counter;
import com.utad.excursions.DownloadImageTask;
import com.utad.excursions.R;
import com.utad.excursions.R.id;
import com.utad.excursions.R.layout;
import com.utad.excursions.R.menu;
import com.utad.excursions.model.Company;
import com.utad.excursions.model.DepartmentType;
import com.utad.excursions.model.Employee;
import com.utad.excursions.model.Person;
import com.utad.excursions.model.Tour;
import com.utad.excursions.model.TourType;
import com.utad.excursions.model.Tourist;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
	
	private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Creo una excursion
        Tour mTour = new Tour(Counter.newTourID(), TourType.SPORT, 
        		"Casa rural 2014", "Viaje con los compañeros de trabajo", null);
        
        // Añado un empleado a la excursión
        Company mCompany = new Company(1, "Coca cola");
        Employee mEmployee = new Employee(Counter.newPersonID(), "Juanito", "Valderrama", 
        		56, "52881182L", "http://www.dummydo.com/images/pedro.jpg", DepartmentType.RRHH, mCompany);
        mTour.addTourTourist(new Tourist<Employee>(mEmployee));
        
        // Añado una persona a la excursión
        Person mPerson = new Person(2, "Manolito", "Gafotas", 12, "24242545L", null);
        mTour.addTourTourist(new Tourist<Person> (mPerson));
        
        String imageURL = null;
        
        // Se listan las personas y empleados que hay en la escursion
        for (Tourist t: mTour.getTourTourists()) {
        	
        	
        	if (t.getTourist().getClass() == Person.class) {
        		Log.d(TAG, "Persona: " + ((Person) t.getTourist()).getPersonName());
        	} else if (t.getTourist().getClass() == Employee.class) {
        		Log.d(TAG, "Empleado: " + ((Employee) t.getTourist()).getPersonName() + " del departamento " + 
        		((Employee) t.getTourist()).getEmployeeDepartmentType().getDepartmenyTypeDescription());
        	}
        	
        	
        	// Si la persona tiene foto, la bajo
        	imageURL = ((Person) t.getTourist()).getPersonImageURL();
        	
        	
        	new DownloadImageTask().getHTTPImage(imageURL, new DownloadImageTask.DownloadRequestListener() {
				
				@Override
				public void onDone(Bitmap image, Exception exception) {
					
					if (exception != null) {
						Log.d(TAG, "Se ha producido un error al descargar la imagen");
					} else {
						
						if (image == null) {
							Log.d(TAG, "Uy, no se ha producido un error pero no hay imagen");
						} else {
							
						}
					}
					
				}
			});
        	
        	
        	
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
