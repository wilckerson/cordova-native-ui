package com.wilckerson.native_ui;

public class NativeUIMapper{
	
	public static NativeUIControl getControlFor(String xmlNodeName){
		
		NativeUIControl control = null;
		
		if(xmlNodeName.equals("button")){ control = new NativeUIButton(); }
//		else if(xmlNodeName == "yourcontrol"){
//			
//			 control = new NativeUIYourControl();
//		}
		
		return control;
	}
}