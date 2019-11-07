package com.yz.supermarket.utils;

/**
* @ClassName: ResponseBody  
* @Description: ajax 数据返回
* @author yangzeng
* @date 2019年11月7日  
 */
public class ResponseBody {
	private Integer code;	//状态：0为正常，其他根据实际情况定义
	private String msg;		//消息提示
	private Object data;	//返回结果
	
	public ResponseBody(Integer code,String msg,Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseBody [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
