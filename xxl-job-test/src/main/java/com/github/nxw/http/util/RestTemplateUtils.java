/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.http.util;

import org.springframework.http.*;
import org.springframework.web.client.RestClientException;

/**
 * ClassName: RestTemplateUtils <br/>
 * Function: <br/>
 * Date: 2020年06月08日 10:57 <br/>
 *
 * @author lijinfeng
 */

public class RestTemplateUtils {

    public static <T> HttpEntity<T> buildDefaultHttpEntity(T request) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return new HttpEntity<>(request, httpHeaders);
    }

    public static <T> T getResponseObject(ResponseEntity<T> responseEntity) throws RestClientException {
        HttpStatus statusCode = responseEntity.getStatusCode();
        if(statusCode.is2xxSuccessful()) {
            return responseEntity.getBody();
        }
        throw new RestClientException("http status code error, status code is " + statusCode);
    }

}
