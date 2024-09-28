package com.example.demo.utils;

import com.example.demo.entity.constant.PublicConstant;
import com.example.demo.entity.result.ResultMessage;



public class ResultUtil {

    /**
     * 返回成功 并返回前端数据
     * @param object
     * @return
     */
    public static  ResultMessage success(Object object,String ... message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setState(PublicConstant.STATE_SUCCESS);
        resultMessage.setData(object);
        if(message != null && message.length==1){
            resultMessage.setMessage(message[0]);
        }else {
            resultMessage.setMessage(PublicConstant.MESSAGE_SUCCESS);
        }
        return resultMessage;
    }

    /**
     * 返回成功 不带数据
     * @return
     */
    public static ResultMessage success(String ... message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setState(PublicConstant.STATE_SUCCESS);
        if(message != null && message.length==1){
            resultMessage.setMessage(message[0]);
        }else {
            resultMessage.setMessage(PublicConstant.MESSAGE_SUCCESS);
        }
        return resultMessage;
    }

    /**
     * 返回失败
     * @param message
     * @return
     */
    public static  ResultMessage error(String ... message) {
        ResultMessage resultMessage = new ResultMessage();
        resultMessage.setState(PublicConstant.STATE_ERROR);
        if(message != null && message.length==1){
            resultMessage.setMessage(message[0]);
        }else {
            resultMessage.setMessage(PublicConstant.ERROR_SUCCESS);
        }
        return resultMessage;
    }
}
