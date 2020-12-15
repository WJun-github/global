package com.wj.mongo.entitty;

import com.wj.mongo.entitty.enums.CommonEnum;
import lombok.Data;

/**
 * @author wj
 * @version 1.0
 * @date 2020/12/14 0014
 * @description
 */
@Data
public class JsonResult {

    private Integer code;
    private String message;
    private Object data;

    public JsonResult(){}

    public static JsonResult success(Object data){
        JsonResult result=new JsonResult();
        result.setCode(CommonEnum.SUCCESS.getCode());
        result.setMessage(CommonEnum.SUCCESS.getMessage());
        result.setData(data);
        return result;
    }

    public static JsonResult success(){
        return success(null);
    }

    public static JsonResult failure(){
        JsonResult result=new JsonResult();
        result.setCode(CommonEnum.FAILURE.getCode());
        result.setMessage(CommonEnum.FAILURE.getMessage());
        return result;
    }

    public static JsonResult failure(Integer code,String message){
        JsonResult result=new JsonResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }



}
