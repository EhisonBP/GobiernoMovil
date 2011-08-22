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

import static gob.movil.info.Constants.CONSUMER_KEY;
import static gob.movil.info.Constants.CONSUMER_SECRET;
import gob.movil.R;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class OAuthTwitter extends Activity {
	private String CALLBACK_URL = "callback://gm";
	private String REQUEST_TOKEN_URL = "http://api.twitter.com/oauth/request_token";
	private String ACCESS_TOKEN_URL = "http://api.twitter.com/oauth/access_token";
	private String AUTHORIZE_URL = "http://api.twitter.com/oauth/authorize";
	private Twitter twitter;
	private CommonsHttpOAuthConsumer consumer;
	private OAuthProvider provider;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		System.setProperty("http.keepAlive", "false");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oauth);
		Button authentication = (Button) findViewById(R.id.authenticate);
		authentication.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getOAuth();
			}
		});
	}

	private void getOAuth() {
		try {
			consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
					CONSUMER_SECRET);
			provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL,
					ACCESS_TOKEN_URL, AUTHORIZE_URL);
			String url = provider.retrieveRequestToken(consumer, CALLBACK_URL);
			Toast.makeText(getApplicationContext(), "Please, authorize!",
					Toast.LENGTH_SHORT);
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Authentication error!",
					Toast.LENGTH_SHORT);
		}
	}
}