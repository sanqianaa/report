package com.netease.cloud.nce.utils.db;

import com.netease.cloud.nce.utils.CommonData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by hzzhouxiang on 2018/1/24.
 */
public class Pool {

    private static Vector<Connection> pool = new Vector<Connection>();

    private static int MAX_CONNECTION =100;

    private static String DRIVER="com.mysql.jdbc.Driver";
    private static String URL = CommonData.dbHost+"/nce_report";
    private static String USERNAME = CommonData.dbUsername;
    private static String PASSWROD = CommonData.dbPwd;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将一个Connection对象放置到连接池中
     */
    public static  void putConnection(Connection connection){

        synchronized(pool)
        {
            if(pool.size()<MAX_CONNECTION)
            {
                pool.add(connection);
            }
        }
    }


    /**
     * 返回一个Connection对象，如果连接池内有元素，则pop出第一个元素；
     * 如果连接池Pool中没有元素，则创建一个connection对象，然后添加到pool中
     * @return Connection
     */
    public static Connection getConnection(){
        Connection connection = null;
        synchronized(pool)
        {
            if(pool.size()>0)
            {
                connection = pool.get(0);
                pool.remove(0);
            }
            else
            {
                connection = createConnection();
                pool.add(connection);
            }
        }
        return connection;
    }

    /**
     * 创建一个新的Connection对象
     */
    private static Connection createConnection()
    {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWROD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
