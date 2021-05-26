package com.github.nxw.service.impl;

import com.github.nxw.entity.ModelTask;
import com.github.nxw.info.JobInfo;
import com.github.nxw.job.AdminJobInfoBuilder;
import com.github.nxw.job.XxlJobAdminTemplate;
import com.github.nxw.service.TrainModelRunTasksService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Auth：niuxiaowen
 * @Desc:模型任务service
 * @Date: 2021/5/25
 */

@Slf4j
@Service
public class TrainModelRunTasksServiceImpl implements TrainModelRunTasksService {

    private static final Logger logger = LoggerFactory.getLogger(TrainModelRunTasksServiceImpl.class);

    @Autowired
    XxlJobAdminTemplate xxlJobAdminTemplate;

    @Override
    public int addRunTasks(ModelTask modelTask) {
        int add = xxlJobAdminTemplate.createJob(buildJobInfo(modelTask));
        return add;
    }

    private JobInfo buildJobInfo(ModelTask modelTask){
        return new AdminJobInfoBuilder().setHandler(modelTask.getHandler()).
                setCron(modelTask.getCron()).setName(modelTask.getName()).setRetryCount(1).
                setParam(modelTask.getParam()).build();
    }
}
