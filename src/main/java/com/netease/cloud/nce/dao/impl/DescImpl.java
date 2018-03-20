package com.netease.cloud.nce.dao.impl;

import com.netease.cloud.nce.dto.DescDTO;
import com.netease.cloud.nce.utils.CommonData;
import com.netease.cloud.nce.utils.db.Pool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;



/**
 * Created by hzzhouxiang on 2018/2/28.
 */

@Component
public class DescImpl {

    private static final Logger logger = LoggerFactory.getLogger(DescImpl.class);

    public static long descCreateImpl(DescDTO descDTO,String uniqueId) throws ClassNotFoundException,SQLException {
        String sql = "INSERT INTO nce_web_desc (uniqueId, version, beginTest, endTest, smokeUrl, reviewUrl,executeUrl,costTime,qualityDesc,otherDetails) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?)"; ;
        PreparedStatement st = null;
        Connection con = null;
        long last_inserted_id = 0;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            con = DriverManager.getConnection(CommonData.dbHost+"/nce-report", CommonData.dbUsername, CommonData.dbPwd);
            st = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            st.setString(1,uniqueId);
            st.setString(2,descDTO.getVersion());
            st.setString(3,descDTO.getBeginTest());
            st.setString(4,descDTO.getEndTest());
            st.setString(5,descDTO.getSmokeUrl());
            st.setString(6,descDTO.getReviewUrl());
            st.setString(7,descDTO.getExecuteUrl());
            st.setString(8,descDTO.getCostTime());
            st.setString(9,descDTO.getQualityDesc());
            st.setString(10,descDTO.getOtherDetails());
            st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
            }
            //将不再使用的Connection对象放到连接池中，供以后使用
            Pool.putConnection(con);
        }catch (Exception e){
            e.printStackTrace();
        }
		return last_inserted_id;
    }


    public static DescDTO getDescByUuid(String id) throws ClassNotFoundException,SQLException {
        String sql = "Select * from nce_web_desc where id = ?"; ;
        PreparedStatement st = null;
        Connection con = null;
        ResultSet partitionRs = null;
        Class.forName("com.mysql.jdbc.Driver");

        try{
            con = DriverManager.getConnection(CommonData.dbHost+"/nce-report", CommonData.dbUsername, CommonData.dbPwd);
            st = con.prepareStatement(sql);

            st.setString(1,id);

            partitionRs = st.executeQuery();
            DescDTO descDTO = new DescDTO();
            while (partitionRs.next()) {
            	descDTO.setId(partitionRs.getLong("id"));
                descDTO.setUniqueId(partitionRs.getString("uniqueId"));
                descDTO.setVersion(partitionRs.getString("version"));
                descDTO.setBeginTest(partitionRs.getString("beginTest"));
                descDTO.setEndTest(partitionRs.getString("endTest"));
                descDTO.setSmokeUrl(partitionRs.getString("smokeUrl"));
                descDTO.setReviewUrl(partitionRs.getString("reviewUrl"));
                descDTO.setExecuteUrl(partitionRs.getString("executeUrl"));
                descDTO.setCostTime(partitionRs.getString("costTime"));
                descDTO.setQualityDesc(partitionRs.getString("qualityDesc"));
                descDTO.setOtherDetails(partitionRs.getString("otherDetails"));

            }


            //将不再使用的Connection对象放到连接池中，供以后使用
            Pool.putConnection(con);

            return descDTO;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
