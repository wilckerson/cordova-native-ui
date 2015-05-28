package com.wilckerson.native_ui;

import android.content.Context;
import android.view.View;

import org.w3c.dom.Element;

/**
 * Created by Wilckerson on 06/05/2015.
 */
public abstract class NativeUIControl {

	public String controlId;
	String controlClass;

//	public void parseCommonAttributes(View control,Element xmlElement){
//
//		controlId = "#".concat(xmlElement.getAttribute("id"));
//
//		control.setTag(this);
//	}

	public abstract View getNativeView(Element xmlElement, Context context);
	public abstract String getPropertyValue(String propertyName);
	public abstract void setPropertyValue(String propertyName, String propertyValue);
}
