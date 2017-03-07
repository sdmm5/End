package com.ptteng.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by maweijiang on 2017/3/6.
 */
public class MyCharacterEncodingRequest extends HttpServletRequestWrapper {
    private HttpServletRequest request;
    public MyCharacterEncodingRequest(HttpServletRequest request) {
        super(request);
        this.request=request;
    }

    public String getParameter(String name){
        try{
            String value = this.request.getParameter(name);
            if(value == null){
                return null;
            }
            //如果不是以get方式提交数据,直接返回获取的值
            if(this.request.getMethod().equalsIgnoreCase("get")){
                return value;
            }else{
                value = new String(value.getBytes("ISO8859-1"),this.request.getCharacterEncoding());
                return value;
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
