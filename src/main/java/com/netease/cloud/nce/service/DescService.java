package com.netease.cloud.nce.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.netease.cloud.nce.dao.impl.DescImpl;
import com.netease.cloud.nce.dto.DescDTO;

/**
 * Created by hzzhouxiang on 2018/2/28.
 */

@Service
public class DescService {

    @Autowired(required = false)
	private static DescImpl descImpl;
	
    public static long createDesc(DescDTO descDTO,String uuid) {
 
        try{
           	long id = DescImpl.descCreateImpl(descDTO,uuid);
           	if(id!=0){
           		return id;
           	}else{
           		throw new Exception("Server Internal error");
           	}
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    public static DescDTO getDescByUuid( String id) {

        try{
            DescDTO descDTO = DescImpl.getDescByUuid(id);
            return descDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
