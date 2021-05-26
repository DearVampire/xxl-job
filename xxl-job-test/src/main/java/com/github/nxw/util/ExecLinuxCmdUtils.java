package com.github.nxw.util;

import com.github.nxw.service.impl.TrainModelRunTasksServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Auth：niuxiaowen
 * @Desc:执行Linux命令工具类
 * @Date: 2021/5/25
 */

@Slf4j
@Component
public class ExecLinuxCmdUtils {

    private static final Logger logger = LoggerFactory.getLogger(ExecLinuxCmdUtils.class);

    /**
     * 命令执行
     * */
    public String executeLinuxCmd(String cmd){
        logger.info("get cmd job:" + cmd);

        Runtime run = Runtime.getRuntime();

        try {
            Process process = run.exec(cmd);
            InputStream in = process.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuffer out = new StringBuffer();
            byte[] b = new byte[8192];
            for (int n; (n = in.read(b)) != -1;) {
                out.append(new String(b, 0, n));
            }
            logger.info("job result [" + out.toString() + "]");
            in.close();
            process.waitFor();
            process.destroy();

            return out.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
