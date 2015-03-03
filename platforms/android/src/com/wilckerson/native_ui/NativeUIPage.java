package com.wilckerson.native_ui;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.view.View;

public class NativeUIPage extends NativeUIControl{

	@Override
	public View getNativeView(Element xmlElement, Context context) {
		
		View containerView = null;
		
		NodeList childNodes = xmlElement.getChildNodes();
		
		for (int i = 0; i < childNodes.getLength(); i++) {

			Node node = childNodes.item(i);

			if (node.getNodeType() == Node.ELEMENT_NODE) {

				Element childElement = (Element)node;
				String nodeName = childElement.getNodeName().toLowerCase();
				
				//Parsing the container
				if(nodeName.equals("page.container")){
					NativeUIContainer container = new NativeUIContainer();
					containerView = container.getNativeView(childElement, context);
				}
			}
		}
		
		return containerView;
		
	}

}
