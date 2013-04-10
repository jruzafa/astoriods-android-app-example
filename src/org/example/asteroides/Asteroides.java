package org.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Asteroides extends Activity {
	
	private Button bAcercaDe;
	public static AlmacenPuntuaciones almacen = new AlmacenPuntuacionesArray();
	public static MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		bAcercaDe = (Button) findViewById(R.id.button3);
		bAcercaDe.setOnClickListener(new OnClickListener() {
			public void onClick(View view) {
				lanzarAcercaDe(null);
			}
		});
		
		Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
		mp = MediaPlayer.create(this, R.raw.audio);
		mp.start();
	}
	
	@Override
	protected void onSaveInstanceState (Bundle estado){
		super.onSaveInstanceState(estado);
		 if (mp != null) {
			int mpPos = mp.getCurrentPosition();
				
			estado.putInt("position", mpPos);
		 }
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle estado){
		super.onRestoreInstanceState(estado);
		
		if(estado != null && mp != null){
			int mPosRestart = estado.getInt("position");
			
			mp.seekTo(mPosRestart);
		}
	}
	
	public void finishApp(View view){
		finish();
	}
	
	public void lanzarAcercaDe(View view){
		Intent i = new Intent(this, AcercaDe.class);
		
		startActivity(i);
		mp.pause();
	}
	
	public void lanzarPuntuaciones(View view){
		Intent i = new Intent(this, Puntuaciones.class);
		
		startActivity(i);
	}
	
	public void lanzarPreferencias(View view){
		Intent i = new Intent(this, Preferencias.class);
		
		startActivity(i);
	}
	
	public void lanzarJuego(View view){
		Intent i = new Intent(this, Juego.class);
		
		startActivity(i);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		super.onCreateOptionsMenu(menu);
		
		MenuInflater inflater = getMenuInflater();
		
		inflater.inflate(R.menu.menu, menu);
		return true; /** true -> el menœ ya est‡ visible */
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.acercaDe:
				lanzarAcercaDe(null);
				break;
			case R.id.config:
                lanzarPreferencias(null);
                break;
		}
		
		return true; /** true -> consumimos el item, no se propaga*/
	}
	
	
	// LIFE CYCLE
	
	@Override
	protected void onStart() {
		super.onStart();
		mp.start();
		Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		
		Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
		mp.pause();
		super.onPause();
	}

	@Override
	protected void onStop() {
		Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
		mp.pause();
		super.onStop();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}

}
