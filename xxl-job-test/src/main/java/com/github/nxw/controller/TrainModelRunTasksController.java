package com.github.nxw.controller;

import com.github.halosee.dto.common.R;
import com.github.nxw.entity.ModelTask;
import com.github.nxw.entity.TrainModel;
import com.github.nxw.service.TrainModelRunTasksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**TrainModel
 * @Auth：niuxiaowen
 * @Desc:xxl-job任务调度接口
 * @Date: 2021/5/25
 */
@Slf4j
@RestController
@RequestMapping("/xxlJob")
public class TrainModelRunTasksController {
    @Autowired
    TrainModelRunTasksService trainModelRunTasksService;

    /**
     * 新增运行任务
     * */
    @RequestMapping("/addRunTasks")
    public R addRunTasks(@RequestBody ModelTask modelTask){
        int add = trainModelRunTasksService.addRunTasks(modelTask);
        return R.success(add);
    }
}
