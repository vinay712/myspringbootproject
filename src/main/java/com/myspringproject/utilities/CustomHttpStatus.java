package com.myspringproject.utilities;

import org.springframework.http.HttpStatus.Series;
import org.springframework.lang.Nullable;

public enum CustomHttpStatus {
	OK(200, "OK"), CREATED(201, "Created"), BAD_REQUEST(400, "Bad Request"), UNAUTHORIZED(401, "Unauthorized"),
	FORBIDDEN(403, "Forbidden"), NOT_FOUND(404, "Not Found"), NO_RESPONSE(412, "No Response"),
	INTERNAL_SERVER_ERROR(500, "Internal Server Error"), GATEWAY_TIMEOUT(504, "Gateway Timeout");

	private final int value;

	private final String reasonPhrase;

	private CustomHttpStatus(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public int value() {
		return this.value;
	}

	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

	public boolean is1xxInformational() {
		return Series.INFORMATIONAL.equals(series());
	}

	public boolean is2xxSuccessful() {
		return Series.SUCCESSFUL.equals(series());
	}

	public boolean is3xxRedirection() {
		return Series.REDIRECTION.equals(series());
	}

	public boolean is4xxClientError() {
		return Series.CLIENT_ERROR.equals(series());
	}

	public boolean is5xxServerError() {
		return Series.SERVER_ERROR.equals(series());
	}

	public boolean isError() {
		return is4xxClientError() || is5xxServerError();
	}

	public Series series() {
		return Series.valueOf(this.value());
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}

	@Nullable
	public static CustomHttpStatus valueOf(int statusCode) {
		for (CustomHttpStatus status : values()) {
			if (status.value == statusCode) {
				return status;
			}
		}
		return null;

	}
	/*
	 * public static CustomHttpStatus resolve(int statusCode) { CustomHttpStatus
	 * status = valueOf(statusCode); /*if (status == null) { throw new
	 * IllegalArgumentException("No matching constant for [" + statusCode + "]"); }
	 * return status; }
	 */
}
