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

		//Creating the native control
		tbx = new EditText(context);

		return tbx;
	}

	@Override
	public String getPropertyValue(String propertyName){
		String value = null;

		if(propertyName.equals("content")){
			value = tbx.getText().toString();
		}
		else if(propertyName.equals("placeholder")){
			value = tbx.getHint().toString();
		}

		return value;
	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

		if(propertyName.equals("content")){
			tbx.setText(propertyValue);
		}
		else if(propertyName.equals("placeholder")){
			tbx.setHint(propertyValue);
		}
	}
}
