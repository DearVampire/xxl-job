package com.github.nxw.entity;

import com.github.nxw.info.TriggerStatusEnum;
import lombok.Data;

/**
 * @Auth：niuxiaowen
 * @Desc:模型任务表
 * @Date: 2021/5/26
 */
@Data
public class ModelTask {
    /**
     * 主键
     * */
    private int id;

    /**
     * cron表达式
     * */
    private String cron;

    /**
     * name
     * */
    private String name;

    /**
     * handler,固定为execLinuxCmd
     * */
    private String handler = "execLinuxCmd";

    /**
     * 任务参数
     * */
    private String param;

    /**
     * timeout,默认120s
     * */
    private int timeout=120;

    /**
     * 重试次数
     * */
    private int retryCount;

    /**
     * TriggerStatusEnum
     * */
    private TriggerStatusEnum triggerStatusEnum;
}
