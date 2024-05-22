package com.triplay.web.controller;

import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.util.JSOUPUtil;
import com.triplay.util.RestUtil;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/place") 
public class WebController {
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<String, Object>> getPlace(@PathVariable("id") String id) throws Exception{
		Document doc = JSOUPUtil.getJsoupConnection("https://place.map.kakao.com/" + id);
		String title = null;
		String address = null;
		
		Elements metaTags = doc.getElementsByTag("meta");
		for(Element meta : metaTags) {
			if(meta.attr("property").equals("og:title")) {
				title = meta.attr("content");
			}else if(meta.attr("property").equals("og:description")) {
				address = meta.attr("content");
			}
			
			if(title != null && address != null) break;
		}
		if(title == null || address == null) {
			System.out.println(title + " " + address);
			return RestUtil.makeErrorResponseEntity();
		}
		
		System.out.println(title + " " + address);
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("조회성공");
		RestUtil.setResponseData(res, "title", title);
		RestUtil.setResponseData(res, "address", address);
		
		return RestUtil.makeResponseEntity(res);
	}
	
}
