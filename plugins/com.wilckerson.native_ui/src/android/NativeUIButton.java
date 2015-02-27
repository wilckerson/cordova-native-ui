package com.wilckerson.native_ui;

class NativeUIButton implements NativeUIControl, OnClickListener{

	@Override
	public View getNativeView(String xmlNodeInfo,Context context) {
		
		Button btn = new Button(context);
		btn.setTag("btn");
		// btn.setId(stringToInteger("btn"));
		btn.setText("NativeBtn");
		btn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		btn.setOnClickListener(this);
		
		return btn;
		
	}

	@Override
	public void onClick(View arg0) {
		
		String controlName = arg0.getTag().toString();
		String eventName = "click";

		NativeUI.broadcastEvent(controlName, eventName);
		
	}

}