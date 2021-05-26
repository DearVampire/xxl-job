/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.util;

import com.xxl.job.core.biz.model.ReturnT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * ClassName: ReturnUtils <br/>
 * Function: <br/>
 * Date: 2020年06月15日 14:21 <br/>
 *
 * @author lijinfeng
 */
@Slf4j
@Component
public class ReturnUtils {

    public static <T> boolean isSuccess(ReturnT<T> returnT) {
        return Optional.ofNullable(returnT)
                .map(ReturnT::getCode)
                .map(code -> code == ReturnT.SUCCESS_CODE)
                .orElse(false);
    }

    public static <T> String getMsgOrDefault(ReturnT<T> returnT, String defaultMsg) {
        return Optional.ofNullable(returnT)
                .map(ReturnT::getMsg)
                .orElse(defaultMsg);
    }

}
