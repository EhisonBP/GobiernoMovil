package gob.movil.twitter;

import android.app.Activity;
import android.os.Bundle;

public class OAuth extends Activity {
	private String CALLBACK_URL = "callback://gm";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.oauth);
	}
}