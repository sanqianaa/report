package com.netease.cloud.nce.utils.log;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by hzzhouxiang on 2018/1/25.
 */
public class LogTraceUUIDHolder {
    private static final Logger logger = LoggerFactory.getLogger(LogTraceUUIDHolder.class);

    public static String getUUIDId() {
        return UUID.randomUUID().toString();
    }

}
