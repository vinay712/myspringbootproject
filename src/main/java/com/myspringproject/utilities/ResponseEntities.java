package com.myspringproject.utilities;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.myspringproject.controllermodel.ResponseModel;

public class ResponseEntities {

	public static ResponseEntity<ResponseModel> generateResponseEntity(HttpServletRequest request, Object query) {
		ResponseModel responseModel = new ResponseModel();
		responseModel.setData(query);
		responseModel.setHttpStatus(CustomHttpStatus.OK);
		return ResponseEntities.generateResponseEntity(request, responseModel);
	}

	private static ResponseEntity<ResponseModel> generateResponseEntity(HttpServletRequest request,
			ResponseModel responseModel) {
		ResponseEntity<ResponseModel> response = null;
		responseModel.setStatusCode(responseModel.getHttpStatus().value());
		responseModel.setTimeStamp(System.currentTimeMillis());
		responseModel.setPath(request.getRequestURI());
		responseModel.getMetaData().setEncrypted(false);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Status", responseModel.getHttpStatus().name());
		headers.add("StatusCode", String.valueOf(responseModel.getStatusCode()));
		response = new ResponseEntity<>(responseModel, headers, HttpStatus.resolve(responseModel.getStatusCode()));
		return response;
	}
}
