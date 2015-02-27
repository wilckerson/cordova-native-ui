package com.wilckerson.native_ui;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;

public class NativeUIPage implements NativeUIControl{

	@Override
	public View getNativeView(Element xmlElement, Context context) {
		
		View childView = NativeUI.parseXML(xmlElement.getChildNodes(), context);
		
		return childView;
		
	}

}
