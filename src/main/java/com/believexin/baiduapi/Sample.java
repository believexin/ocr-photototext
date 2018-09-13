package com.believexin.baiduapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class Sample implements ApplicationRunner{
	
    //设置APPID/AK/SK
    public static final String TOKEN_HOST = "http://aip.baidubce.com/oauth/2.0/token?";
    public static final String API_KEY = "e3PdO88mTtMBSOIGPQouqEU6";
    public static final String SECRET_KEY = "dbrAHKjbLhWTIiGojLbSLOaLcgUkCroT";
    public static final String GRANT_TYPE = "client_credentials";
    
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    AccessToken accessToken;
    
    public AccessToken getAccessToken()  throws Exception {
    	String url = TOKEN_HOST + "&client_id=" + API_KEY + "&client_secret=" + SECRET_KEY + "&grant_type=" + GRANT_TYPE; 
    	ResponseEntity<AccessToken> result = restTemplate.getForEntity(url, AccessToken.class);
    	if(result.getBody() == null) {
    		throw new Exception("获取access_token失败！");
    	}
    	accessToken.setAccess_token(result.getBody().getAccess_token());
    	accessToken.setExpires_in(result.getBody().getExpires_in());
    	return accessToken;
    }

	@Override
	public void run(ApplicationArguments args) throws Exception {
		getAccessToken();
		taskRun(accessToken.getExpires_in());
	}
	public void taskRun(long lastTime) {
		try {
			Thread.sleep(lastTime);
			getAccessToken();
			taskRun(accessToken.getExpires_in());
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}

