package gob.movil.twitter;

import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import android.app.Activity;
import android.os.Bundle;

public class OAuth extends Activity {
	private String CALLBACK_URL = "callback://gm";
	private OAuthProvider provider;
	private CommonsHttpOAuthConsumer consumer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.oauth);
	}
}