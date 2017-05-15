package com.ipartek.formacion.controller.pojo;

public enum MensajeType {
	/*
	 llamar al constructor private de la enum
	 (esto por debajo de java es un num, por eso se puede usar 
		en un switch
		
		*/
	MSG_TYPE_SUCCESS("alert alert-success"),
	MSG_TYPE_INFO("alert alert-info alert-dismissible"), 
    MSG_TYPE_WARNING("alert alert-warning alert-dismissible"), 
    MSG_TYPE_DANGER("alert alert-danger alert-dismissible");
    
	
	private String styles;

	private MensajeType(String s) {
		this.styles = s;
	}

	public String getStyles() {
		return styles;
	}

	public void setStyles(String s) {
		this.styles = s;
	}
	
	
	
}
