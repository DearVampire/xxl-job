/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.info;

/**
 * InterfaceName: JobInfoClient <br/>
 * Function: <br/>
 * Date: 2020年06月07日 18:32 <br/>
 *
 * @author lijinfeng
 */

public interface JobInfoClient {

    /**
     * 新建任务
     *
     * @param jobInfo 任务实体
     * @return int
     * @throws RuntimeException 运行时异常
     */
    int create(JobInfo jobInfo) throws RuntimeException;

    /**
     * 更新任务
     *
     * @param jobInfo 任务实体
     * @throws RuntimeException 运行时异常
     */
    void update(JobInfo jobInfo) throws RuntimeException;

    /**
     * 删除任务
     *
     * @param jobInfoId 任务ID
     * @throws RuntimeException 运行时异常
     */
    void delete(int jobInfoId) throws RuntimeException;

    /**
     * 停止任务
     *
     * @param jobInfoId 任务ID
     * @throws RuntimeException 运行时异常
     */
    void stop(int jobInfoId) throws RuntimeException;

    /**
     * 启动任务
     *
     * @param jobInfoId 任务ID
     * @throws RuntimeException 运行时异常
     */
    void start(int jobInfoId) throws RuntimeException;

    /**
     * 触发任务
     *
     * @param jobInfoId 任务ID
     * @param param 任务参数
     * @throws RuntimeException 运行时异常
     */
    void trigger(int jobInfoId, String param) throws RuntimeException;

}
