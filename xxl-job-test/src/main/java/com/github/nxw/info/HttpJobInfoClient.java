package com.github.nxw.info;

import com.github.nxw.http.util.RestTemplateUtils;
import com.github.nxw.util.ReturnUtils;
import com.xxl.job.core.biz.model.ReturnT;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: HttpJobInfoClient <br/>
 * Function: <br/>
 * Date: 2020年06月07日 17:36 <br/>
 *
 * @author lijinfeng
 */

public class HttpJobInfoClient implements JobInfoClient {

    /** xxl-job-admin项目中任务的URL模板 */
    private static final String JOB_INFO_URL = "%s/jobinfo/%s";
    /** 新建任务URL */
    private static final String ADD = "add";
    /** 更新任务URL */
    private static final String UPDATE = "update";
    /** 删除任务URL */
    private static final String DELETE = "remove";
    /** 停止任务URL */
    private static final String STOP = "stop";
    /** 启动任务URL */
    private static final String START = "start";
    /** 触发任务URL */
    private static final String TRIGGER = "trigger";
    /** 未知 */
    private static final String UNKNOWN = "unknown";
    /** 任务调度策略 */
    private static final String JOB_ROUTE_STRATEGY = "ROUND";
    /** 任务阻塞策略 */
    private static final String JOB_BLOCK_STRATEGY = "SERIAL_EXECUTION";
    /** 任务GLUE类型 */
    private static final String JOB_GLUE_TYPE = "BEAN";

    /** HTTP请求所用RestTemplate */
    private final RestTemplate restTemplate;
    /** xxl-job-admin的HTTP地址 */
    private final String address;



    public HttpJobInfoClient(RestTemplate restTemplate, String address) {
        this.restTemplate = restTemplate;
        this.address = address;
    }

    @Override
    public int create(JobInfo jobInfo) throws RuntimeException {
        /*参数校验*/
        if(null == jobInfo) {
            throw new IllegalArgumentException("job should not be null");
        }
        if(null != jobInfo.getId()) {
            throw new IllegalArgumentException("job id should be null");
        }
        /*新建任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, ADD), HttpMethod.POST,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfo)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            return Integer.parseInt(returnT.getContent());
        }else {
            throw new RuntimeException("create job " + jobInfo.getId() + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }

    }

    @Override
    public void update(JobInfo jobInfo) throws RuntimeException {
        /*参数校验*/
        if(null == jobInfo) {
            throw new IllegalArgumentException("job should not be null");
        }
        if(null == jobInfo.getId()) {
            throw new IllegalArgumentException("job id should not be null");
        }
        /*更新任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, UPDATE), HttpMethod.PUT,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfo)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            throw new RuntimeException("update job " + jobInfo.getId() + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }
    }

    @Override
    public void delete(int jobInfoId) throws RuntimeException {
        /*参数校验*/
        if(jobInfoId <= 0) {
            throw new IllegalArgumentException("job id should be greater than 0");
        }
        /*删除任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, DELETE), HttpMethod.DELETE,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfoId)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            throw new RuntimeException("delete job " + jobInfoId + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }
    }

    @Override
    public void stop(int jobInfoId) throws RuntimeException {
        /*参数校验*/
        if(jobInfoId <= 0) {
            throw new IllegalArgumentException("job id should be greater than 0");
        }
        /*停止任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, STOP), HttpMethod.PUT,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfoId)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            throw new RuntimeException("stop job " + jobInfoId + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }
    }

    @Override
    public void start(int jobInfoId) throws RuntimeException {
        /*参数校验*/
        if(jobInfoId <= 0) {
            throw new IllegalArgumentException("job id should be greater than 0");
        }
        /*启动任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, START), HttpMethod.PUT,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfoId)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            throw new RuntimeException("start job " + jobInfoId + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }
    }

    @Override
    public void trigger(int jobInfoId, String param) throws RuntimeException {
        /*参数校验*/
        if(jobInfoId <= 0) {
            throw new IllegalArgumentException("job id should be greater than 0");
        }
        /*触发任务*/
        ParameterizedTypeReference<ReturnT<String>> responseTypeRef =
                new ParameterizedTypeReference<ReturnT<String>>(){};
        ResponseEntity<ReturnT<String>> responseEntity =
                restTemplate.exchange(String.format(JOB_INFO_URL, address, TRIGGER), HttpMethod.PUT,
                        RestTemplateUtils.buildDefaultHttpEntity(buildRequest(jobInfoId, param)), responseTypeRef);
        ReturnT<String> returnT = RestTemplateUtils.getResponseObject(responseEntity);
        if(ReturnUtils.isSuccess(returnT)) {
            throw new RuntimeException("trigger job " + jobInfoId + " failed, msg is "
                    + ReturnUtils.getMsgOrDefault(returnT, UNKNOWN));
        }
    }

    private MultiValueMap<String, String> buildRequest(JobInfo jobInfo) {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        Integer id = jobInfo.getId();
        if(null != id) {
            request.add("id", String.valueOf(id));
        }
        request.add("jobGroup", String.valueOf(jobInfo.getGroup()));
        request.add("jobCron", jobInfo.getCron());
        request.add("jobDesc", jobInfo.getName());
        request.add("author", jobInfo.getAuthor());
        request.add("executorRouteStrategy", JOB_ROUTE_STRATEGY);
        request.add("executorHandler", jobInfo.getHandler());
        request.add("executorParam", jobInfo.getParam());
        request.add("executorBlockStrategy", JOB_BLOCK_STRATEGY);
        request.add("executorTimeout", String.valueOf(jobInfo.getTimeout()));
        request.add("executorFailRetryCount", String.valueOf(jobInfo.getRetryCount()));
        request.add("glueType", JOB_GLUE_TYPE);
        request.add("triggerStatus", String.valueOf(jobInfo.getTriggerStatus().value));
        return request;
    }

    private MultiValueMap<String, String> buildRequest(int jobInfoId) {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("id", String.valueOf(jobInfoId));
        return request;
    }

    private MultiValueMap<String, String> buildRequest(int jobInfoId, String param) {
        MultiValueMap<String, String> request = new LinkedMultiValueMap<>();
        request.add("id", String.valueOf(jobInfoId));
        request.add("executorParam", param);
        return request;
    }

}
