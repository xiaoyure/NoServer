package com.cont.utils;
             
public class ServiceException  extends RuntimeException {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -1721995397154188162L;
	private String errorCode ;  //异常对应的返回码
    private String message;  //异常对应的描述信息
     
    public ServiceException() {
        super();
    }
 
    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
 
    public ServiceException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
    public ServiceException(Throwable cause) {
		super(cause.getMessage(), cause);
	}
    public String getErrorCode() {
        return errorCode;
    }
 
    public String getmessage() {
        return message;
    }
}
