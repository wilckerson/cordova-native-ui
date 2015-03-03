package com.wilckerson.native_ui;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

public class NativeUITextBox extends NativeUIControl{

	@Override
	public View getNativeView(Element xmlElement, Context context) {
	
		//Parsing properties
		String placeholder = xmlElement.getAttribute("placeholder");
		String content = xmlElement.getAttribute("content");
		
		//Creating the native control
		EditText tbx = new EditText(context);
		
		if(placeholder != null && !placeholder.isEmpty()){
			tbx.setHint(placeholder);
		}
		
		if(content != null && !content.isEmpty()){
			tbx.setText(placeholder);
		}
		
		return tbx;
	}
}
