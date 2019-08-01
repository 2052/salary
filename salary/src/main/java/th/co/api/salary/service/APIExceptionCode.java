package th.co.api.salary.service;

import java.util.HashMap;
import java.util.Map;

public enum APIExceptionCode {
	
	STATUS_OK("200", "OK", "20000", "SUCCESS"),
	STATUS_UNAUTHORIZED("401","Unauthorized", "40001","Unauthorized"),
	STATUS_DATA_EXISTED("400", "Bad Request", "40003", "Data Existed"),
	STATUS_DATA_NOT_FOUND("404", "Not Found", "40401", "Data not found"),
	STATUS_INVALID("400", "Bad Request", "40002", "Invalid parameter"),
	STATUS_METHOD_NOT_ALLOWED("405", "Method Not Allowed", "40500", "Method Not Allowed"),
	STATUS_SYSTEM_ERROR("500", "Internal Server Error", "50000", "System Error"),
	;

	private final String httpCode;
	private final String httpStatusMsg;
	private final String resultCode;
	private final String resultDescription;	
	
	private APIExceptionCode(String httpCode, String httpStatusMsg,
			String resultCode, String resultDescription) {
		this.httpCode = httpCode;
		this.httpStatusMsg = httpStatusMsg;
		this.resultCode = resultCode;
		this.resultDescription = resultDescription;
	}
	
	private static Map<String, APIExceptionCode> httpMap = new HashMap<String, APIExceptionCode>();
	static {
		for (APIExceptionCode e : values()) {
			httpMap.put(e.httpCode, e);
		}
	}
	
	private static Map<String, APIExceptionCode> resultCodeMap = new HashMap<String, APIExceptionCode>();
	static {
		for (APIExceptionCode e : values()) {
			resultCodeMap.put(e.resultCode, e);
		}
	}
	
	public static final APIExceptionCode getHttpCode(String code) {
		return httpMap.get(code);
	}
	
	public static final APIExceptionCode getResultCode(String code) {
		return resultCodeMap.get(code);
	}

	public static Map<String, APIExceptionCode> gethttpMap() {
		return httpMap;
	}
	
	public static Map<String, APIExceptionCode> getResultCodeMap() {
		return resultCodeMap;
	}

	public static void setHttpMap(Map<String, APIExceptionCode> httpMap) {
		APIExceptionCode.httpMap = httpMap;
	}
	
	public static void setResultCodeMap(Map<String, APIExceptionCode> resultCodeMap) {
		APIExceptionCode.resultCodeMap = resultCodeMap;
	}

	public String getHttpCode() {
		return httpCode;
	}

	public String getHttpStatusMsg() {
		return httpStatusMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}
	


}
