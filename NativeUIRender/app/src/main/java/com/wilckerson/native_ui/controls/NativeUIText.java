package com.wilckerson.native_ui.controls;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.wilckerson.native_ui.NativeUIControl;

public class NativeUIText extends NativeUIControl {

	TextView tx;

	@Override
	public View getNativeView(Element xmlElement, Context context) {

		//Creating the native control
		 tx = new TextView(context);

		
		return tx;
	}

	@Override
	public String getPropertyValue(String propertyName) {

		String value = null;
		if(propertyName.equals("content")) {
			value = tx.getText().toString();
		}

		return value;

	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

		if(propertyName.equals("content")){
			tx.setText(propertyValue);
		}
	}

}
