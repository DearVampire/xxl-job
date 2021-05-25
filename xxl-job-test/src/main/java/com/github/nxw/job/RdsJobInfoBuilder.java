/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.job;

import com.github.nxw.info.JobInfo;
import com.github.nxw.info.TriggerStatusEnum;

/**
 * ClassName: JobInfoBuilder <br/>
 * Function: <br/>
 * Date: 2020年06月10日 11:54 <br/>
 *
 * @author lijinfeng
 */

public class RdsJobInfoBuilder {

    /** 执行器所在分组的ID */
    private static final int GROUP = 1;
    /** 负责人 */
    private static final String AUTHOR = "rds";

    /** 任务ID */
    private Integer id;
    /** 任务执行CRON表达式 */
    private String cron;
    /** 任务名称 */
    private String name;
    /** 任务Handler名称 */
    private String handler;
    /** 任务参数 */
    private String param;
    /** 任务执行超时时间，单位为秒，默认120s */
    private Integer timeout;
    /** 任务失败重试次数，默认1次 */
    private Integer retryCount;
    /** 任务状态 */
    private TriggerStatusEnum triggerStatus;



    public JobInfo build() {
        return new JobInfo.JobInfoBuilder()
                .setId(id)
                .setGroup(GROUP)
                .setCron(cron)
                .setName(name)
                .setAuthor(AUTHOR)
                .setHandler(handler)
                .setParam(param)
                .setTimeout(timeout)
                .setRetryCount(retryCount)
                .setTriggerStatus(triggerStatus)
                .build();
    }

    public RdsJobInfoBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public RdsJobInfoBuilder setCron(String cron) {
        this.cron = cron;
        return this;
    }

    public RdsJobInfoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RdsJobInfoBuilder setHandler(String handler) {
        this.handler = handler;
        return this;
    }

    public RdsJobInfoBuilder setParam(String param) {
        this.param = param;
        return this;
    }

    public RdsJobInfoBuilder setTimeout(Integer timeout) {
        this.timeout = timeout;
        return this;
    }

    public RdsJobInfoBuilder setRetryCount(Integer retryCount) {
        this.retryCount = retryCount;
        return this;
    }

    public RdsJobInfoBuilder setTriggerStatus(TriggerStatusEnum triggerStatus) {
        this.triggerStatus = triggerStatus;
        return this;
    }

}
