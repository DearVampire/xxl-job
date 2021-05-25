/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.http;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: DefaultHttpClient <br/>
 * Function: <br/>
 * Date: 2020年06月05日 16:14 <br/>
 *
 * @author lijinfeng
 */

public class DefaultHttpClient extends AbstractHttpClient {

    public DefaultHttpClient(DefaultHttpSettings defaultHttpSettings) {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setBufferRequestBody(defaultHttpSettings.isBufferRequestBody());
        simpleClientHttpRequestFactory.setChunkSize(defaultHttpSettings.getChunkSize());
        simpleClientHttpRequestFactory.setConnectTimeout(defaultHttpSettings.getConnectTimeout());
        simpleClientHttpRequestFactory.setReadTimeout(defaultHttpSettings.getReadTimeout());
        this.restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
        this.address = defaultHttpSettings.getAddress();
    }

}
