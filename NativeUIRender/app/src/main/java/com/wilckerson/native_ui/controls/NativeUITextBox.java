package com.wilckerson.native_ui.controls;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.widget.EditText;

import com.wilckerson.native_ui.NativeUIControl;

public class NativeUITextBox extends NativeUIControl {

	EditText tbx;

	@Override
	public View getNativeView(Element xmlElement, Context context) {
	
		//Parsing properties
		String placeholder = xmlElement.getAttribute("placeholder");
		String content = xmlElement.getAttribute("content");
		
		//Creating the native control
		tbx = new EditText(context);
		
		if(placeholder != null && !placeholder.isEmpty()){
			tbx.setHint(placeholder);
		}
		
		if(content != null && !content.isEmpty()){
			tbx.setText(placeholder);
		}
		
		return tbx;
	}

	@Override
	public String getPropertyValue(String propertyName){
		String value = null;

		if(propertyName == "text"){
			value = tbx.getText().toString();
		}

		return value;
	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

		if(propertyName == "text"){
			tbx.setText(propertyValue);
		}
	}
}
