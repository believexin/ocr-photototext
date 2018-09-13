package com.believexin.baiduapi;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("singleton")
public class AccessToken {
	public String access_token;
	public String session_key;
	public String scope;
	public String refresh_token;
	public String session_secret;
	public long expires_in;
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public String getSession_key() {
		return session_key;
	}
	public void setSession_key(String session_key) {
		this.session_key = session_key;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public String getSession_secret() {
		return session_secret;
	}
	public void setSession_secret(String session_secret) {
		this.session_secret = session_secret;
	}
	public long getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccessToken [access_token=");
		builder.append(access_token);
		builder.append(", session_key=");
		builder.append(session_key);
		builder.append(", scope=");
		builder.append(scope);
		builder.append(", refresh_token=");
		builder.append(refresh_token);
		builder.append(", session_secret=");
		builder.append(session_secret);
		builder.append(", expires_in=");
		builder.append(expires_in);
		builder.append("]");
		return builder.toString();
	}
}
