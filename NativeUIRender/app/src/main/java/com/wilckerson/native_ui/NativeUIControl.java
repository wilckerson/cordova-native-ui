package com.wilckerson.native_ui;

import android.content.Context;
import android.view.View;

import org.w3c.dom.Element;

/**
 * Created by Wilckerson on 06/05/2015.
 */
abstract class NativeUIControl {

	String controlId;
	String controlClass;

	public void parseCommonAttributes(View control,Element xmlElement){

		controlId = "#".concat(xmlElement.getAttribute("id"));

		control.setTag(this);
	}

	View getNativeView(Element xmlElement, Context context){return null;}
}
