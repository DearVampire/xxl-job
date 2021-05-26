package com.github.nxw.jobhandler;

import com.github.nxw.util.ExecLinuxCmdUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auth：niuxiaowen
 * @Desc:
 * @Date: 2021/5/25
 */

@Component
public class SimpleJobHandler {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJobHandler.class);

    @Autowired
    ExecLinuxCmdUtils execLinuxCmdUtils;

    @XxlJob("execLinuxCmd")
    public ReturnT<String> taskJobHandler(String param) throws Exception {
        XxlJobHelper.log("XXL-JOB, taskJobHandler start---------------");
        String cmd = "python " + param;
        execLinuxCmdUtils.executeLinuxCmd(cmd);
        return ReturnT.SUCCESS;
    }

}
