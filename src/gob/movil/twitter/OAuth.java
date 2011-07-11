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

import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import android.app.Activity;
import android.os.Bundle;

public class OAuth extends Activity {
	private String CALLBACK_URL = "callback://gm";
	private String REQUEST_TOKEN_URL = "http://api.twitter.com/oauth/request_token";
	private String ACCESS_TOKEN_URL = "http://api.twitter.com/oauth/access_token";
	private String AUTHORIZE_URL = "http://api.twitter.com/oauth/authorize";
	private OAuthProvider provider;
	private CommonsHttpOAuthConsumer consumer;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	// public void askOAuth() {
	// try {
	// consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
	// CONSUMER_SECRET);
	// provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL,
	// ACCESS_TOKEN_URL, AUTHORIZE_URL);
	// String authURL = provider.retrieveRequestToken(consumer,
	// CALLBACK_URL);
	// Toast.makeText(this, "Please authorize this app!",
	// Toast.LENGTH_LONG).show();
	// // setConsumerProvider();
	// startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(authURL)));
	// } catch (Exception e) {
	// Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
	// }
	// }
}