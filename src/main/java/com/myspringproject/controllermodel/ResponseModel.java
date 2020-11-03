package com.myspringproject.controllermodel;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.myspringproject.utilities.CustomHttpStatus;

@JsonInclude(Include.NON_EMPTY)
public class ResponseModel {

	@JsonProperty("TimeStamp")
	private Long timeStamp;

	@JsonProperty("Path")
	private String path;

	@JsonProperty("Status")
	private CustomHttpStatus httpStatus;

	@JsonProperty("StatusCode")
	private Integer statusCode;

	@JsonProperty("Message")
	private String message;

	@JsonProperty("MetaData")
	private MetaData metaData;

	@JsonProperty("Data")
	private Object data;

	public ResponseModel() {
		this.metaData = new MetaData();
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public CustomHttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(CustomHttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		setStatusCode(httpStatus.value());
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void clearMetaData() {
		this.metaData = null;
	}

	public static class MetaData {
		Map<String, Object> map;

		private boolean encrypted;

		public void setEncrypted(boolean encrypted) {
			this.encrypted = encrypted;
		}

		public Boolean isEncrypted() {
			return this.encrypted;
		}

		public void addData(String key, Object metaData) {
			if (map == null) {
				map = new HashMap<>();
			}
			map.put(key, metaData);
		}

		public Object getData(String key) {
			if (map == null) {
				return null;
			}
			return map.get(key);
		}
	}
}

