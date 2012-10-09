package gob.movil.app;

import gob.movil.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class Splash extends Activity {
	
	private static final long SPLASH_DISPLAY_LENGTH = 4000;
	ImageView imagen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	//	setContentView(R.layout.splash);
	//	imagen = (ImageView)findViewById (R.id.corazon);
		Animation transparente = AnimationUtils.loadAnimation(this, R.anim.animacion);
		imagen.startAnimation(transparente);
		Handler handler = new Handler();
		handler.postDelayed(getRunnableStartApp(), SPLASH_DISPLAY_LENGTH);
	}

	private Runnable getRunnableStartApp() {
		Runnable runnable = new Runnable(){
			public void run(){
			
			Intent intent = new Intent(Splash.this, Main.class);
			startActivity(intent);
			finish();
			}
			};
			return runnable;
	}

}
