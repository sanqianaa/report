package com.netease.cloud.nce.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.netease.cloud.nce.utils.log.LogTraceUUIDHolder;
import com.netease.libs.holder.WebContextHolder;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hzzhouxiang on 2018/1/25.
 */
public class AbstractController {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    protected int SUCCESS = 200;
    protected int FAIL = 400;
    protected int NOTFOUND = 404;
    protected int SERVER_FAIL = 500;


    public String apiReturn(int statusCode, String code, String message, Map<String, Object> params) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("RequestId", LogTraceUUIDHolder.getUUIDId());

        if (StringUtils.isNotBlank(code)) {
            body.put("Code", code);
        }
        if (StringUtils.isNotBlank(message)) {
            body.put("Message", message);
        }
        if (params != null && !params.isEmpty()) {
            body.putAll(params);
        }
        HttpServletResponse response = WebContextHolder.getResponse();
        response.setCharacterEncoding(Charsets.UTF_8.name());
        response.setContentType(MappingJackson2JsonView.DEFAULT_CONTENT_TYPE);
        response.setStatus(statusCode);
        try {
            response.getWriter().write(JSON.toJSONString(body));
        } catch (IOException e) {
            logger.warn("io exception.", e);
        }
        return null;
    }


    public String apiReturn(int code, String msg, Object params) {
        Gson gson = new Gson();
        HttpServletRequest request = WebContextHolder.getRequest();
        HttpServletResponse response = WebContextHolder.getResponse();
        response.setCharacterEncoding(Charsets.UTF_8.name());
        response.setContentType(MappingJackson2JsonView.DEFAULT_CONTENT_TYPE);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Code", code);
        map.put("Message", msg);
        if (params != null) {
            map.put("Params", params);
        }
        response.setStatus(SUCCESS);
        try {
            String ja = gson.toJson(map);
            response.getWriter().write(ja);
        } catch (Exception e) {
            logger.warn("io exception.");
        }
        return null;
    }

    public String apiReturn(int code, Map<String, Object> params) {
        return apiReturn(code, params, null);
    }

    public String apiReturn(int code, String msg) {  return apiReturn(code, msg, null); }

    public String apiReturn(int code, Map<String, Object> params, String contentType) {
        Gson gson = new Gson();
        HttpServletRequest request = WebContextHolder.getRequest();
        HttpServletResponse response = WebContextHolder.getResponse();
        response.setCharacterEncoding(Charsets.UTF_8.name());
        response.setContentType(MappingJackson2JsonView.DEFAULT_CONTENT_TYPE);
        if (StringUtils.isNotBlank(contentType)) {
            response.setContentType(contentType);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Code", code);
        map.put("Message", params.get("Message"));
        if (params != null) {
            map.put("Params", params);
        }

        response.setStatus(SUCCESS);

        try {
            response.getWriter().write(gson.toJson(map));
        } catch (Exception e) {
            logger.warn("io exception.");
        }
        return null;
    }







}
