package com.believexin.baiduapi;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OcrService {
	
	 @Autowired
	 RestTemplate restTemplate;
	 @Autowired
	 AccessToken accessToken;
	/**
	 * <p>Title: getContentStrBybase64</p>
	 * <p>Description: 返回识别出来的文字（拼接到一起）</p>
	 * <p>Company: thunisoft </p> 
	 * @param img
	 * @return
	 * @throws IOException
	 * @author zhangxin
	 * @date 2018年6月9日 下午11:36:30
	 */
	public String getContentStrBybase64(String img) throws IOException {
		String data = getContextByBase64(img);
		ObjectMapper mapper = new ObjectMapper();
		OcrText ocrtext = mapper.readValue(data, OcrText.class);
		OcrLine[] ocrLines = ocrtext.getWordsResult();
		StringBuffer result = new StringBuffer();
		for (OcrLine ocrLine : ocrLines) {
			String word = ocrLine.getWords();
			result.append(word);
			result.append("\r\n");
		}
		return result.toString();
	}
	/**
	 * <p>Title: getContentStrBybase64</p>
	 * <p>Description: 返回识别出来的文字(分行返回)</p>
	 * <p>Company: thunisoft </p> 
	 * @param img
	 * @return
	 * @throws IOException
	 * @author zhangxin
	 * @date 2018年6月9日 下午11:36:59
	 */
	public List<String> getContentArrStrBybase64(String img) throws IOException {
		String data = getContextByBase64(img);
		ObjectMapper mapper = new ObjectMapper();
		OcrText ocrtext = mapper.readValue(data, OcrText.class);
		OcrLine[] ocrLines = ocrtext.getWordsResult();
		List<String> result = new ArrayList<>();
		for (OcrLine ocrLine : ocrLines) {
			String word = ocrLine.getWords();
			result.add(word);
		}
		return result;
	}
	public String getContextByBase64(String imgBase64) {
		try {
			String ocrUrl = "https://aip.baidubce.com/rest/2.0/ocr/v1/accurate_basic?access_token=" + accessToken.getAccess_token();
			String param = URLEncoder.encode("image","UTF-8") + "=" + URLEncoder.encode(imgBase64,"UTF-8");
			HttpHeaders headers = new HttpHeaders();
			MediaType type = MediaType.parseMediaType("application/x-www-form-urlencoded");
			headers.set("Accept-Charset", "utf-8");
			headers.setContentType(type);
			HttpEntity<String> formEntity = new HttpEntity<String>(param, headers);
			String result = restTemplate.postForObject(ocrUrl, formEntity, String.class);
			return new String(result.getBytes("ISO-8859-1"), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
