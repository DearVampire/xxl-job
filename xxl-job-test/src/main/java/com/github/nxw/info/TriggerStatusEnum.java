/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.info;


/**
 * EnumName: JobInfoStatusEnum <br/>
 * Function: <br/>
 * Date: 2020年06月08日 10:10 <br/>
 *
 * @author lijinfeng
 */

public enum TriggerStatusEnum {

    /** 停止 */
    STOP(0),
    /** 运行 */
    RUN(1);

    public final int value;

    TriggerStatusEnum(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TriggerStatusEnum{" +
                "value=" + value +
                '}';
    }

}
