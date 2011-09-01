package gob.movil.twitter;

import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import twitter4j.Twitter;
import android.app.Application;

public class TwitterApplication extends Application {
	private Twitter twitter;
	private OAuthProvider provider;
	private CommonsHttpOAuthConsumer consumer;

	public Twitter getTwitter() {
		return twitter;
	}

	public void setTwitter(Twitter twitter) {
		this.twitter = twitter;
	}

	public OAuthProvider getProvider() {
		return provider;
	}

	public void setProvider(OAuthProvider provider) {
		this.provider = provider;
	}

	public CommonsHttpOAuthConsumer getConsumer() {
		return consumer;
	}

	public void setConsumer(CommonsHttpOAuthConsumer consumer) {
		this.consumer = consumer;
	}
}