package org.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Puntuaciones extends ListActivity {
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntuaciones);
        setListAdapter(new MiAdaptador(this,
                Asteroides.almacen.listaPuntuaciones(10)));
    }
    
	@Override protected void onListItemClick(ListView listView, 
	            View view, int position, long id) {
					super.onListItemClick(listView, view, position, id);
					Object o = getListAdapter().getItem(position);
					Toast.makeText(this, "Selecci—n: " + Integer.toString(position)
					+  " - " + o.toString(),Toast.LENGTH_LONG).show();
				}
}