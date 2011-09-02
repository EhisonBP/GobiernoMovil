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
import static gob.movil.info.Constants.TWITTER_PREFERENCES;
import gob.movil.R;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.http.AccessToken;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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
		checkCredentials();
		getConsumerProvider();
		Button authentication = (Button) findViewById(R.id.authenticate);
		authentication.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getOAuth();
			}
		});
	}

	private void checkCredentials() {
		AccessToken access = getAccessToken();
		if (access == null)
			return;
		twitter = new TwitterFactory().getInstance();
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		twitter.setOAuthAccessToken(access);
		((TwitterApplication) getApplication()).setTwitter(twitter);
		Intent i = new Intent(this, TwitterActivity.class);
		startActivity(i);
		finish();
	}

	private AccessToken getAccessToken() {
		SharedPreferences preferences = getSharedPreferences(
				TWITTER_PREFERENCES, MODE_PRIVATE);
		String token = preferences.getString("token", "");
		String secret = preferences.getString("secret", "");
		if (token != null && secret != null && !"".equals(secret)
				&& !"".equals(token)) {
			return new AccessToken(token, secret);
		}
		return null;
	}

	private void getConsumerProvider() {
		OAuthProvider p = ((TwitterApplication) getApplication()).getProvider();
		CommonsHttpOAuthConsumer c = ((TwitterApplication) getApplication())
				.getConsumer();
		if (p != null)
			provider = p;
		if (c != null)
			consumer = c;
	}

	private void getOAuth() {
		try {
			consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY,
					CONSUMER_SECRET);
			provider = new DefaultOAuthProvider(REQUEST_TOKEN_URL,
					ACCESS_TOKEN_URL, AUTHORIZE_URL);
			String url = provider.retrieveRequestToken(consumer, CALLBACK_URL);
			Toast.makeText(getApplicationContext(),
					getString(R.string.authorize), Toast.LENGTH_SHORT).show();
			setConsumerProvider();
			startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(),
					getString(R.string.authentication_error),
					Toast.LENGTH_SHORT).show();
		}
	}

	private void setConsumerProvider() {
		if (provider != null)
			((TwitterApplication) getApplication()).setProvider(provider);
		if (consumer != null)
			((TwitterApplication) getApplication()).setConsumer(consumer);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (this.getIntent() != null && this.getIntent().getData() != null) {
			Uri uri = this.getIntent().getData();
			if (uri != null && uri.toString().startsWith(CALLBACK_URL)) {
				String verifier = uri
						.getQueryParameter(oauth.signpost.OAuth.OAUTH_VERIFIER);
				try {
					provider.retrieveAccessToken(consumer, verifier);
					AccessToken a = new AccessToken(consumer.getToken(),
							consumer.getTokenSecret());
					storeAccessToken(a);
					twitter = new TwitterFactory().getInstance();
					twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
					twitter.setOAuthAccessToken(a);
					((TwitterApplication) getApplication()).setTwitter(twitter);
					Intent i = new Intent(this, TwitterActivity.class);
					startActivity(i);
					finish();
				} catch (Exception e) {
					e.printStackTrace();
					Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG)
							.show();
				}
			}

		}
	}

	private void storeAccessToken(AccessToken access) {
		SharedPreferences preferences = getSharedPreferences(
				TWITTER_PREFERENCES, MODE_PRIVATE);
		SharedPreferences.Editor editor = preferences.edit();
		editor.putString("access", access.getToken());
		editor.putString("secret", access.getTokenSecret());
		editor.commit();
	}
}