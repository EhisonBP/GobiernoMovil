/*
 * Licencia GPL v3
 * "Gobierno Móvil" es un producto de "Gobierno en Línea".
 * Copyright (C) 2011 Richard Ricciardelli. Centro Nacional de Tecnologías de Información. All Rights Reserved.
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses
 */

package gob.movil.twitter;

import gob.movil.R;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class OAuthTwitter extends Activity {
	private String CALLBACK_URL = "callback://gm";
	private String REQUEST_TOKEN_URL = "http://api.twitter.com/oauth/request_token";
	private String ACCESS_TOKEN_URL = "http://api.twitter.com/oauth/access_token";
	private String AUTHORIZE_URL = "http://api.twitter.com/oauth/authorize";
	private Twitter twitter;
	private OAuthProvider provider;
	private CommonsHttpOAuthConsumer consumer;

	// HttpClient client = new DefaultHttpClient();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		System.setProperty("http.keepAlive", "false");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oauth);
		
		Button authentication = (Button) findViewById(R.id.authenticate);
		authentication.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

			}
		});
	}
}