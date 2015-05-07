package com.wilckerson.native_ui;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

public class NativeUIText extends NativeUIControl{

	@Override
	public View getNativeView(Element xmlElement, Context context) {
	
		//Parsing properties
		String content = xmlElement.getAttribute("content");
		
		//Creating the native control
		TextView tx = new TextView(context);
		
		if(content != null && !content.isEmpty()){
			tx.setText(content);
		}
		
		return tx;
	}

}
