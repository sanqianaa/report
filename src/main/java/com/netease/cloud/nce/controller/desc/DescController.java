package com.netease.cloud.nce.controller.desc;


import com.alibaba.fastjson.JSON;
import com.netease.cloud.nce.controller.AbstractController;
import com.netease.cloud.nce.dto.DescDTO;
import com.netease.cloud.nce.service.DescService;
import com.netease.cloud.nce.utils.CommonData;
import com.netease.cloud.nce.utils.log.LogTraceUUIDHolder;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Created by hzzhouxiang on 2018/1/24.
 */
@RestController
@RequestMapping("/api/v1/imageinfo")
public class DescController extends AbstractController {
    private static final Logger logger = LoggerFactory.getLogger(DescController.class);

//    @Autowired(required = false)
//    private DescService descService;


    /**
     * 记录测试评价
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public Object recordeDesc(@RequestBody String requestBody, HttpServletRequest request) {
        String uniqueId = LogTraceUUIDHolder.getUUIDId();
        logger.info("RecordeDesc param: {}", requestBody);
        DescDTO descDTO;
        descDTO = JSON.parseObject(requestBody, DescDTO.class);
        long id = DescService.createDesc(descDTO,uniqueId);
        if (id!=0) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
            return apiReturn(SUCCESS, params);
        } else {
            return apiReturn(FAIL, "create repo fail");
        }

//        String uniqueId = LogTraceUUIDHolder.getUUIDId();
//        String descId = DescService.createDesc(descDTO, uniqueId);
//        return null;
    }

    /**
     * 根据结果ID获取容器评价信息
     *
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getDesc(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        logger.info("id: {}", id);
        DescDTO descDTO = DescService.getDescByUuid(id);
        if(descDTO==null){
            return apiReturn(NOTFOUND,"The containerDesc is not exist");
        }
        {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("image", descDTO);
            return apiReturn(SUCCESS, params);
        }
    }
}
