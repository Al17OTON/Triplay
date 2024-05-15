package com.triplay.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

/**
 * REST 개발 시 반복되는 코드를 단순화하기 위한 class
 */
public class RestUtil {
	
	/**
	 * 주어진 데이터를 담은 Response Entity를 생성한다.
	 * 
	 * @param data
	 * 		전달할 전체 데이터	
	 */
	public static ResponseEntity<Map<String, Object>> makeResponseEntity(Map<String, Object> data) {
		return new ResponseEntity<Map<String,Object>>(data, HttpStatus.OK);
	}
	
	/**
	 * 오류 응답 생성
	 * @param msg
	 * 		Error 메세지
	 * @return
	 * 		HTTP Status BAD_REQUEST를 가진 사용자 정의 응답 반환
	 */
	public static ResponseEntity<Map<String, Object>> makeErrorResponseEntity(String msg) {
		return makeResponseEntity(msg, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 오류 응답 생성
	 * @return
	 * 		HttpStatus.BAD_REQUEST를 가진 응답을 반환
	 */
	public static ResponseEntity<Map<String, Object>> makeErrorResponseEntity() {
		return makeErrorResponseEntity("Error");
	}
	
	/**
	 * 사용자 정의 응답 생성
	 * @param msg
	 * 		보낼 메세지
	 * @param status
	 * 		Http 상태 코드
	 * @return
	 * 		사용자 정의 응답을 생성하여 반환
	 */
	public static ResponseEntity<Map<String,Object>> makeResponseEntity(String msg, HttpStatusCode status) {
		return new ResponseEntity<Map<String,Object>>(makeResponseTemplete(msg), status);
	}
	
	/**
	 * 메세지는 사용자가 정의하고 HTTP Status OK를 가진 응답을 생성 
	 * @param msg
	 * 		보낼 메세지
	 * @return
	 * 		HTTP Status OK를 가진 응답 생성
	 */
	public static ResponseEntity<Map<String, Object>> makeResponseEntity(String msg) {
		return makeResponseEntity(msg, HttpStatus.OK);
	}
	
	/**
	 * 기본 메세지 "조회완료"를 담은 Map을 생성하여 리턴한다.
	 * @return
	 * 		msg에 "조회완료"가 붙은 Map 객체 반환
	 */
	public static Map<String, Object> makeResponseTemplete() {
		return makeResponseTemplete("조회완료");
	}
	
	/**
	 * 주어진 msg를 담은 Map 객체를 생성한다.
	 * @param msg
	 * 		msg에 추가할 내용
	 * @return
	 * 		msg에 주어진 내용을 담고 Map 반환
	 */
	public static Map<String, Object> makeResponseTemplete(String msg) {
		Map<String, Object> res = new HashMap<>();
		res.put("msg", msg);
		return res;
	}
	
	/**
	 * 기본 응답 데이터를 "resdata"에 넣어준다
	 * @param res
	 * 		데이터를 담을 map
	 * @param resData
	 * 		담을 데이터
	 * @return
	 * 		"resdata" 키에 데이터를 삽입 후 반환
	 */
	public static Map<String, Object> setResponseData(Map<String, Object> res, Object resData) {
		res.put("resdata", resData);
		return res;
	}
	

}
