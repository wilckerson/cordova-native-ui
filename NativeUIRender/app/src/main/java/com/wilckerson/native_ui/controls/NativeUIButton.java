package com.wilckerson.native_ui.controls;

import org.w3c.dom.Element;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

import com.wilckerson.native_ui.NativeUIControl;
import com.wilckerson.native_ui.NativeUIManager;

public class NativeUIButton extends NativeUIControl implements OnClickListener {

	Button btn;

	@Override
	public View getNativeView(Element xmlElement, Context context) {

		btn = new Button(context);

		btn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		btn.setOnClickListener(this);

		return btn;

	}

	@Override
	public String getPropertyValue(String propertyName) {

		String value = null;
		if(propertyName.equals("content")) {
			value = btn.getText().toString();
		}

		return value;
	}

	@Override
	public void setPropertyValue(String propertyName, String propertyValue) {

		if(propertyName.equals("content")){
			btn.setText(propertyValue);
		}
	}

	@Override
	public void onClick(View arg0) {

		String eventName = "click";
		//String controlId = arg0.getTag().toString();

		NativeUIManager.broadcastEvent(super.controlId, eventName);

	}

}