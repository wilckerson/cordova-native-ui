package com.wilckerson.native_ui;

public class NativeUIMapper{
	
	public static NativeUIControl getControlFor(String xmlNodeName){
		
		NativeUIControl control = null;
		
		if(xmlNodeName.equals("page")){ control = new NativeUIPage(); }
		else if(xmlNodeName.equals("button")){ control = new NativeUIButton(); }
		else if(xmlNodeName.equals("text")){ control = new NativeUIText(); }
		else if(xmlNodeName.equals("textbox")){ control = new NativeUITextBox(); }

//		else if(xmlNodeName == "yourcontrol"){
//			
//			 control = new NativeUIYourControl();
//		}
		
		return control;
	}
}