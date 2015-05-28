package com.wilckerson.native_ui.controls;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import com.wilckerson.native_ui.NativeUIControl;
import com.wilckerson.native_ui.NativeUIParser;

public class NativeUIContainer extends NativeUIControl {

	LinearLayout container;

	@Override
	public View getNativeView(Element xmlElement, Context context) {
		
		container = new LinearLayout(context);

		//Parsing childs and putting on container
		container = (LinearLayout)NativeUIParser.getViewFromXML(container,xmlElement.getChildNodes(), context);

		container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		return container;
	}

	@Override
	public String getPropertyValue(String propertyName) {
		return null;
	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

		if(propertyName.equals("mode")){

			if(propertyValue.equals("horizontal"))
			{
				container.setOrientation(LinearLayout.HORIZONTAL);
			}
			else
			{
				//Default value
				container.setOrientation(LinearLayout.VERTICAL);
			}
		}

	}

}
