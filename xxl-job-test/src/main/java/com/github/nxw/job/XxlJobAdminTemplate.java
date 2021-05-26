package com.github.nxw.job;

import com.github.nxw.http.DefaultHttpClient;
import com.github.nxw.http.DefaultHttpSettings;
import com.github.nxw.http.XxlJobAdminClient;
import com.github.nxw.info.JobInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * ClassName: XxlJobAdminTemplate <br/>
 * Function: <br/>
 * Date: 2020年06月08日 21:08 <br/>
 *
 * @author lijinfeng
 */

@Component
public class XxlJobAdminTemplate {

    /** HTTP连接超时时间，单位为秒，-1表示不设置 */
    private static final int HTTP_CONNECT_TIMEOUT = -1;
    /** HTTP读取内容超时时间，单位为秒，-1表示不设置 */
    private static final int HTTP_READ_TIMEOUT = -1;

    /** xxl-job-admin的HTTP地址 */
    @Value("${xxl.job.admin.address}")
    private String xxlJobAdminAddress;
    /** xxl-job-admin客户端 */
    private XxlJobAdminClient xxlJobAdminClient;



    @PostConstruct
    public void init() {
        DefaultHttpSettings defaultHttpSettings = new DefaultHttpSettings.DefaultHttpSettingsBuilder()
                .setAddress(xxlJobAdminAddress)
                .setBufferRequestBody(true)
                .setConnectTimeout(HTTP_CONNECT_TIMEOUT)
                .setReadTimeout(HTTP_READ_TIMEOUT)
                .build();
        xxlJobAdminClient = new DefaultHttpClient(defaultHttpSettings);
    }

    public int createJob(JobInfo jobInfo) throws RuntimeException {
        return xxlJobAdminClient.jobInfo().create(jobInfo);
    }

    public void updateJob(JobInfo jobInfo) throws RuntimeException {
        xxlJobAdminClient.jobInfo().update(jobInfo);
    }

    public void deleteJob(int jobInfoId) throws RuntimeException {
        xxlJobAdminClient.jobInfo().delete(jobInfoId);
    }

    public void startJob(int jobInfoId) throws RuntimeException {
        xxlJobAdminClient.jobInfo().start(jobInfoId);
    }

    public void stopJob(int jobInfoId) throws RuntimeException {
        xxlJobAdminClient.jobInfo().stop(jobInfoId);
    }

    public void triggerJob(int jobInfoId, String jobInfoParam) throws RuntimeException {
        xxlJobAdminClient.jobInfo().trigger(jobInfoId, jobInfoParam);
    }

}
