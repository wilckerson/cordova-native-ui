package com.wilckerson.native_ui.controls;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.wilckerson.native_ui.NativeUIControl;
import com.wilckerson.native_ui.NativeUIParser;

public class NativeUIContainer extends NativeUIControl {

	@Override
	public View getNativeView(Element xmlElement, Context context) {
		
		LinearLayout container = new LinearLayout(context);
		container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		String mode = xmlElement.getAttribute("mode");
		if(mode != null && !mode.isEmpty() && mode.equals("horizontal"))
		{
			container.setOrientation(LinearLayout.HORIZONTAL);
		}
		else
		{
			//Default value
			container.setOrientation(LinearLayout.VERTICAL);
		}

		//Parsing childs and putting on container
		View computedContainer = NativeUIParser.getViewFromXML(container,xmlElement.getChildNodes(), context);
		

		return computedContainer;
	}

	@Override
	public String getPropertyValue(String propertyName) {
		return null;
	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

	}

}
