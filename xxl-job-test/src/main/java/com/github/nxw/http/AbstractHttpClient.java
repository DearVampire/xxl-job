/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.http;

import com.github.nxw.info.HttpJobInfoClient;
import com.github.nxw.info.JobInfoClient;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: AbstractHttpClient <br/>
 * Function: <br/>
 * Date: 2020年06月08日 09:46 <br/>
 *
 * @author lijinfeng
 */

public abstract class AbstractHttpClient implements XxlJobAdminClient {

    /** HTTP请求所用RestTemplate */
    protected RestTemplate restTemplate;
    /** xxl-job-admin的HTTP地址 */
    protected String address;



    @Override
    public JobInfoClient jobInfo() {
        return new HttpJobInfoClient(restTemplate, address);
    }

}
