/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.info;

import org.springframework.util.StringUtils;

/**
 * ClassName: JobInfo <br/>
 * Function: <br/>
 * Date: 2020年06月05日 15:56 <br/>
 *
 * @author lijinfeng
 */

public class JobInfo {

    /** 任务ID */
    private final Integer id;
    /** 执行器所在分组的ID */
    private final Integer group;
    /** 任务执行CRON表达式 */
    private final String cron;
    /** 任务名称 */
    private final String name;
    /** 负责人 */
    private final String author;
    /** 任务Handler名称 */
    private final String handler;
    /** 任务参数 */
    private final String param;
    /** 任务执行超时时间，单位为秒 */
    private final Integer timeout;
    /** 任务失败重试次数 */
    private final Integer retryCount;
    /** 任务状态 */
    private final TriggerStatusEnum triggerStatus;



    private JobInfo(JobInfoBuilder jobInfoBuilder) {
        this.id = jobInfoBuilder.id;
        this.group = jobInfoBuilder.group;
        this.cron = jobInfoBuilder.cron;
        this.name = jobInfoBuilder.name;
        this.author = jobInfoBuilder.author;
        this.handler = jobInfoBuilder.handler;
        this.param = jobInfoBuilder.param;
        this.timeout = jobInfoBuilder.timeout;
        this.retryCount = jobInfoBuilder.retryCount;
        this.triggerStatus = jobInfoBuilder.triggerStatus;
    }

    public Integer getId() {
        return id;
    }

    public Integer getGroup() {
        return group;
    }

    public String getCron() {
        return cron;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getHandler() {
        return handler;
    }

    public String getParam() {
        return param;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public Integer getRetryCount() {
        return retryCount;
    }

    public TriggerStatusEnum getTriggerStatus() {
        return triggerStatus;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "id=" + id +
                ", group=" + group +
                ", cron='" + cron + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", handler='" + handler + '\'' +
                ", param='" + param + '\'' +
                ", timeout=" + timeout +
                ", retryCount=" + retryCount +
                ", triggerStatus=" + triggerStatus +
                '}';
    }



    public static class JobInfoBuilder {

        /** 默认超时时间，单位为秒 */
        private static final int DEFAULT_TIMEOUT = 120;
        /** 默认失败重试次数 */
        private static final int DEFAULT_RETRY_COUNT = 1;
        /** 默认任务状态 */
        private static final TriggerStatusEnum DEFAULT_TRIGGER_STATUS = TriggerStatusEnum.RUN;

        /** 任务ID */
        private Integer id;
        /** 执行器所在分组的ID */
        private Integer group;
        /** 任务执行CRON表达式 */
        private String cron;
        /** 任务名称 */
        private String name;
        /** 负责人 */
        private String author;
        /** 任务Handler名称 */
        private String handler;
        /** 任务参数 */
        private String param;
        /** 任务执行超时时间，单位为秒 */
        private Integer timeout;
        /** 任务失败重试次数 */
        private Integer retryCount;
        /** 任务状态 */
        private TriggerStatusEnum triggerStatus;

        public JobInfo build() throws IllegalArgumentException{
            if(null == group) {
                throw new IllegalArgumentException("job group should not be null");
            }
            if(null == cron) {
                throw new IllegalArgumentException("job cron should not be null");
            }
            if(null == name) {
                throw new IllegalArgumentException("job name should not be null");
            }
            if(null == author) {
                throw new IllegalArgumentException("job author should not be null");
            }
            if(null == handler) {
                throw new IllegalArgumentException("job handler should not be null");
            }
            if(null == timeout) {
                this.timeout = DEFAULT_TIMEOUT;
            }
            if(null == retryCount) {
                this.retryCount = DEFAULT_RETRY_COUNT;
            }
            if(null == triggerStatus) {
                this.triggerStatus = DEFAULT_TRIGGER_STATUS;
            }
            return new JobInfo(this);
        }

        public JobInfoBuilder setId(Integer id) {
            if(null != id && id <= 0) {
                throw new IllegalArgumentException("job id should be greater than 0");
            }
            this.id = id;
            return this;
        }

        public JobInfoBuilder setGroup(Integer group) {
            if(null != group && group <= 0) {
                throw new IllegalArgumentException("job group id should be greater than 0");
            }
            this.group = group;
            return this;
        }

        public JobInfoBuilder setCron(String cron) {
            if(StringUtils.isEmpty(cron)) {
                throw new IllegalArgumentException("job cron should not be empty");
            }
            this.cron = cron;
            return this;
        }

        public JobInfoBuilder setName(String name) {
            if(StringUtils.isEmpty(name)) {
                throw new IllegalArgumentException("job name should not be empty");
            }
            this.name = name;
            return this;
        }

        public JobInfoBuilder setAuthor(String author) {
            if(StringUtils.isEmpty(author)) {
                throw new IllegalArgumentException("job author should not be empty");
            }
            this.author = author;
            return this;
        }

        public JobInfoBuilder setHandler(String handler) {
            if(StringUtils.isEmpty(handler)) {
                throw new IllegalArgumentException("job handler should not be empty");
            }
            this.handler = handler;
            return this;
        }

        public JobInfoBuilder setParam(String param) {
            this.param = param;
            return this;
        }

        public JobInfoBuilder setTimeout(Integer timeout) {
            if(null != timeout && timeout <= 0) {
                throw new IllegalArgumentException("job timeout should be greater than 0");
            }
            this.timeout = timeout;
            return this;
        }

        public JobInfoBuilder setRetryCount(Integer retryCount) {
            if(null != retryCount && retryCount < 0) {
                throw new IllegalArgumentException("job retryCount should not be less than 0");
            }
            this.retryCount = retryCount;
            return this;
        }

        public JobInfoBuilder setTriggerStatus(TriggerStatusEnum triggerStatus) {
            this.triggerStatus = triggerStatus;
            return this;
        }

    }

}
