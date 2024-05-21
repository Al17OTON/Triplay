package com.triplay.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JSOUPUtil {
	public static Document getJsoupConnection(String url) throws Exception {
		return Jsoup.connect(url).get();
	}
}
