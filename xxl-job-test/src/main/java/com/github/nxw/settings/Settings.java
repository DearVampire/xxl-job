/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.settings;

import java.util.Map;
import java.util.Set;

/**
 * InterfaceName: Settings <br/>
 * Function: <br/>
 * Date: 2020年06月05日 16:17 <br/>
 *
 * @author lijinfeng
 */

public interface Settings {

    /**
     * 获取所有配置
     *
     *
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String, String> getSettings();

    /**
     * 获取指定配置的值
     *
     * @param name 参数名称
     * @return java.lang.String
     */
    String getSetting(String name);

    /**
     * 获取所有配置名称
     *
     *
     * @return java.util.Set<java.lang.String>
     */
    Set<String> getSettingNames();

}
