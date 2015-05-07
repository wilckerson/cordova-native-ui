package com.wilckerson.native_ui;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class NativeUIContainer extends NativeUIControl{

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
		
		View childView = NativeUIParser.getViewFromXML(container,xmlElement.getChildNodes(), context);
		
		return container;
	}

}
