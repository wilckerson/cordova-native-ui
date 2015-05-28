package com.wilckerson.native_ui;

import com.wilckerson.native_ui.controls.NativeUIButton;
import com.wilckerson.native_ui.controls.NativeUIContainer;
import com.wilckerson.native_ui.controls.NativeUIPage;
import com.wilckerson.native_ui.controls.NativeUIText;
import com.wilckerson.native_ui.controls.NativeUITextBox;

public class NativeUIControlMapper {
	
	public static NativeUIControl getControlFor(String xmlNodeName){
		
		NativeUIControl control = null;
		
		if(xmlNodeName.equals("page")){ control = new NativeUIPage(); }
		else if(xmlNodeName.equals("container")){ control = new NativeUIContainer(); }
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