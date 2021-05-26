package com.github.nxw.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TrainModel implements Serializable {

    /**
     * 主键
     * */
    private int id;

    /**
     *  模型名称
     * */
    private String modelName;

    /**
     *  模型版本
     * */
    private String modelVersion;

    /**
     * 功能描述
     * */
    private String modelDescription;

    /**
     * 适用范围
     * */
    private String scopeApplication;

    /**
     * 模型状态，1.新建  2.测试中	3.测试成功  4.测试失败	 5.上线	6.使用  7.下线
     * */
    private int modelStatus;

    /**
     * 修改时间
     * */
    private Date modificationTime;

    /**
     *  系统信息表ID
     * */
    private int systemId;

    /**
     * 模型类型
     * */
    private String modelType;

    /**
     * 操作员
     * */
    private String operator;

    /**
     * 人员单位
     * */
    private String personnelUnit;

    /**
     * 模型文件url
     * */
    private String modelScript;

    /**
     * 运行时长
     * */
    private Date useOftenTime;

    /**
     * 异常处理次数
     * */
    private int abnormalTimes;

    /**
     * 编译语言
     * */
    private String compileLanguage;

    /**
     * cpu占用
     * */
    private String cpuOccupancy;

    /**
     * 内存占用
     * */
    private String memoryOccupancy;

    /**
     * 数据吞吐量
     * */
    private String dataThroughput;

    /**
     * 数据效费比
     * */
    private String dataCostRatio;

    /**
     * 适用环境
     * */
    private String applicableEnv;

    /**
     * 平台
     * */
    private String platform;

    /**
     * 车型
     * */
    private String trainType;

    /**
     * 批次
     * */
    private String trainBatch;

    /**
     * 协议
     * */
    private String agreement;

    /**
     * 建模对象
     * */
    private String modelingObject;

    /**
     * 模型细分类
     * */
    private String modelDetailType;

}
