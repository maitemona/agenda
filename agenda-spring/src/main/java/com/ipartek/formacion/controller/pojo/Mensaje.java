 package com.ipartek.formacion.controller.pojo;

import java.io.Serializable;

public class Mensaje implements Serializable {

    String msg;
    MensajeType type;
    int code;

    public Mensaje(final String txt) {
        super();
        this.msg = txt;
        this.type = MensajeType.MSG_TYPE_SUCCESS;

    }

    public Mensaje(final MensajeType type) {
        super();
        this.type = type;
        this.msg = "";
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return super.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the type
     */
    public MensajeType getType() {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(MensajeType type) {
        this.type = type;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

}