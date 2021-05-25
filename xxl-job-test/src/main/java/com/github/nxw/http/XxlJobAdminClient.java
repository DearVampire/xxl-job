/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.http;


import com.github.nxw.info.JobInfoClient;

/**
 * InterfaceName: XxlJobAdminClient <br/>
 * Function: <br/>
 * Date: 2020年06月05日 12:02 <br/>
 *
 * @author lijinfeng
 */

public interface XxlJobAdminClient {

    /**
     * 获取操作JobInfo的客户端
     *
     *
     * @return com.bonc.bcloud.rds.job.client.job.info.JobInfoClient
     */
    JobInfoClient jobInfo();

}
