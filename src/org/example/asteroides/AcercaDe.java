package org.example.asteroides;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class AcercaDe extends Activity {
	/** Called when the activity is first created. */

    @Override public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.acercade);

    }
    
    @Override
	protected void onResume() {
		Asteroides.mp.start(); 
		super.onDestroy();
	}
}
