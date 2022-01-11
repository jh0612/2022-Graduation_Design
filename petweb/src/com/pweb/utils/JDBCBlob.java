package com.pweb.utils;

import com.pweb.pojo.Pets;

import java.io.*;
import java.sql.*;

/**
 * 本次毕设不与使用，使用String的url
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-10-26  11:54
 * petweb
 */
public abstract class JDBCBlob {
    /**
    * 获取，下载
    * @param sql sql
    * @param idload 可变形参
    * @author jh
    * @Date:  2021/10/26  12:00
    */
    public static void imgblobdonload(String sql,Integer idload){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fops = null;
        //向数据表customers中插入blob类型的字段
        try {
            conn = JDBCUtils.getConnectionDruid();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idload);//在这里进行对那张图片的下载，即id属性
            rs = ps.executeQuery();
            //填充占位符
            if (rs.next()){
                int id = rs.getInt("id");
                String petsname = rs.getString("petsname");
                String species = rs.getString("species");
                int amount = rs.getInt("amount");
                String instruction = rs.getString("instruction");
                String picture1 = rs.getString("picture");
                Pets pet = new Pets(id,petsname,species,amount,instruction,picture1);
                System.out.println(pet);

                Blob picture = rs.getBlob("picture");
                is = picture.getBinaryStream();
                fops = new FileOutputStream("download.jpg");//文件默认到工程文件夹下
                //将Blob类型的字段下载下来，以文件的形式保存在本地
                //文件到了JavaSenior文件夹下
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1){
                    fops.write(buffer,0,len);
                }
            }
            //当设置Blob类型(也就是文件)全部都是以流的形式进行的inputstream
            //这里用了绝对路径成功了相对路径却不行
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fops != null) {
                    fops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.close(conn, ps, rs);
        }
    }

}
