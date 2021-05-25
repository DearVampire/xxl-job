/*
 * Copyright (c) 1993, 2020, the original author or authors. All rights reserved.
 */

package com.github.nxw.http;

import com.github.nxw.settings.Settings;
import com.github.nxw.settings.SettingsBuilder;
import org.springframework.util.StringUtils;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: DefaultHttpSettings <br/>
 * Function: <br/>
 * Date: 2020年06月05日 16:34 <br/>
 *
 * @author lijinfeng
 */

public class DefaultHttpSettings implements Settings {

    /** xxl-job-admin的HTTP地址 */
    private final String address;
    /** 请求是否使用缓存流的形式 */
    private final boolean bufferRequestBody;
    /** 请求每次传输字节长度，bufferRequestBody为true时不可设置 */
    private final int chunkSize;
    /** 连接超时时间，单位为毫秒，-1表示不设置 */
    private final int connectTimeout;
    /** 读取内容超时时间，单位为毫秒，-1表示不设置 */
    private final int readTimeout;
    /** 设置项集合 */
    private final Map<String, String> settings = new HashMap<String, String>(4);



    private DefaultHttpSettings(DefaultHttpSettingsBuilder builder) {
        this.address = builder.address;
        this.bufferRequestBody = builder.bufferRequestBody;
        this.chunkSize = builder.chunkSize;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        settings.put("address", address);
        settings.put("bufferRequestBody", String.valueOf(this.bufferRequestBody));
        settings.put("chunkSize", String.valueOf(this.chunkSize));
        settings.put("connectTimeout", String.valueOf(this.connectTimeout));
        settings.put("readTimeout", String.valueOf(this.readTimeout));
    }

    @Override
    public Map<String, String> getSettings() {
        return settings;
    }

    @Override
    public String getSetting(String name) {
        return settings.get(name);
    }

    @Override
    public Set<String> getSettingNames() {
        return settings.keySet();
    }

    public String getAddress() {
        return address;
    }

    public boolean isBufferRequestBody() {
        return bufferRequestBody;
    }

    public int getChunkSize() {
        return chunkSize;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }



    public static class DefaultHttpSettingsBuilder implements SettingsBuilder {

        /** 默认连接超时时间，单位为毫秒，-1表示不设置 */
        public static final int DEFAULT_CONNECT_TIMEOUT = -1;
        /** 默认读取内容超时时间，单位为毫秒，-1表示不设置 */
        public static final int DEFAULT_READ_TIMEOUT = -1;

        /** xxl-job-admin的HTTP地址 */
        private String address;
        /** 请求是否使用缓存流的形式 */
        private boolean bufferRequestBody = true;
        /** 请求每次传输字节长度，bufferRequestBody为true时不可设置 */
        private int chunkSize;
        /** 连接超时时间，单位为毫秒，-1表示不设置 */
        private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;
        /** 读取内容超时时间，单位为毫秒，-1表示不设置 */
        private int readTimeout = DEFAULT_READ_TIMEOUT;



        @Override
        public DefaultHttpSettings build() {
            if(StringUtils.isEmpty(address)) {
                throw new IllegalArgumentException("address should not be empty");
            }
            if(bufferRequestBody) {
                if(chunkSize != 0) {
                    throw new IllegalArgumentException("chunkSize should not be set when bufferRequestBody is true");
                }
            }else {
                if(chunkSize == 0) {
                    throw new IllegalArgumentException("chunkSize should be set when bufferRequestBody is false");
                }
            }
            return new DefaultHttpSettings(this);
        }

        public DefaultHttpSettingsBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public DefaultHttpSettingsBuilder setBufferRequestBody(boolean bufferRequestBody) {
            this.bufferRequestBody = bufferRequestBody;
            return this;
        }

        public DefaultHttpSettingsBuilder setChunkSize(int chunkSize) {
            if(chunkSize <= 0) {
                throw new IllegalArgumentException("chunkSize should be greater than 0");
            }
            this.chunkSize = chunkSize;
            return this;
        }

        public DefaultHttpSettingsBuilder setConnectTimeout(int connectTimeout) {
            if(connectTimeout == 0) {
                throw new IllegalArgumentException("connectTimeout should not be 0");
            }else if(connectTimeout < -1) {
                throw new IllegalArgumentException("connectTimeout should not be less than -1");
            }
            this.connectTimeout = connectTimeout;
            return this;
        }

        public DefaultHttpSettingsBuilder setReadTimeout(int readTimeout) {
            if(readTimeout == 0) {
                throw new IllegalArgumentException("readTimeout should not be 0");
            }else if(readTimeout < -1) {
                throw new IllegalArgumentException("readTimeout should not be less than -1");
            }
            this.readTimeout = readTimeout;
            return this;
        }

    }

}
