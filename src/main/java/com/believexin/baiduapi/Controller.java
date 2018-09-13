package com.believexin.baiduapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private OcrService ocrService;
	
	@RequestMapping(value = "/api/context",method = RequestMethod.POST)
	public String getImgBase64(String imgBase64) {
		try {
			return ocrService.getContentStrBybase64(imgBase64);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "/api/contextArr",method = RequestMethod.POST)
	public List<String> getImgContextArrBase64(String imgBase64) {
		try {
			return ocrService.getContentArrStrBybase64(imgBase64);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
