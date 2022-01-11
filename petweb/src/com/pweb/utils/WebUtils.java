package com.pweb.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 操作Web层的工具类<br/>
 * 下方T利用泛型，省略类型转换
 * @author jhao Email:jh0612@icloud.com
 * @version v1.0
 * @create 2021-11-01  1:59
 * petweb
 */
public class WebUtils {
    public static <T> T copyParamToBean(Map value, T bean){
        try {
            System.out.println("注入前" + bean);
            BeanUtils.populate(bean,value);
            System.out.println("注入后" + bean);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            int i = Integer.parseInt(strInt);
            return i;
        } catch (NumberFormatException e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }
}
