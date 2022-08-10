package com.epf.demo.util;

/**
 * 统一返回数据类
 *
 * @Author ZGD
 * @Date 2019/5/15
 */
public class ResponseUtil {
    public static final int CODE_SUCCESS = 200;
    public static final int CODE_ERROR = 500;
    public static final String MSG_SUCESS = "操作成功";
    public static final String MSG_ERROR = "操作失败";

    private int code;
    private String msg;
    private Object data;

    public ResponseUtil() {
    	
    }

    public ResponseUtil(int code) {
        this.code = code;
    }

    public ResponseUtil(int code, String message) {
        this.code = code;
        this.msg = message;
    }

    public ResponseUtil(int code, String message, Object data) {
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    /**
     * 请求成功 默认code是200，msg是'请求成功'
     *
     * @return
     */
    public static ResponseUtil success() {
        return new ResponseUtil(CODE_SUCCESS, MSG_SUCESS);
    }

    /**
     * 请求成功
     *
     * @param code
     * @return
     */
    public static ResponseUtil success(int code) {
        return new ResponseUtil(code, MSG_SUCESS);
    }

    /**
     * 请求成功 返回 消息 默认code是CODE_SUCCESS
     *
     * @param message
     * @return
     */
    public static ResponseUtil success(String message) {
        return new ResponseUtil(CODE_SUCCESS, message);
    }

    /**
     * 返回数据
     *
     * @param data
     * @return
     */
    public static ResponseUtil success(Object data) {
        return new ResponseUtil(CODE_SUCCESS, MSG_SUCESS, data);
    }

    /**
     * 请求成功 返回 编码 信息
     *
     * @param code    编码
     * @param message 消息
     * @return
     */
    public static ResponseUtil success(int code, String message) {
        return new ResponseUtil(code, message);
    }

    /**
     * 请求成功 返回 信息 和 数据 默认code是200
     *
     * @param message 信息
     * @param data    数据
     * @return
     */
    public static ResponseUtil success(String message, Object data) {
        return new ResponseUtil(CODE_SUCCESS, message, data);
    }

    /**
     * 请求成功 返回 code ,信息 和 数据
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResponseUtil success(int code, String message, Object data) {
        return new ResponseUtil(code, message, data);
    }

    /**
     * 请求失败
     *
     * @return
     */
    public static ResponseUtil error() {
        return new ResponseUtil(CODE_ERROR, MSG_ERROR);
    }

    /**
     * 请求失败
     *
     * @param msg 消息
     * @return
     */
    public static ResponseUtil error(String msg) {
        return new ResponseUtil(CODE_ERROR, msg);
    }

    /**
     * 请求错误 返回编码和信息
     *
     * @param code
     * @param message
     * @return
     */
    public static ResponseUtil error(int code, String message) {
        return new ResponseUtil(code, message);
    }

    /**
     * 请求错误 返回编码和信息和数据
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResponseUtil error(int code, String message, Object data) {
        return new ResponseUtil(code, message, data);
    }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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
    
}
