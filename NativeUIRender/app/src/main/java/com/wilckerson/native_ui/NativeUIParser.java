package com.wilckerson.native_ui;

import android.app.Fragment;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NativeUIParser {

    public static Fragment getFragmentFromXML(final Document xmlParser) {

        Fragment frag = new NativeUIFragment(xmlParser);

        //Bundle b = new Bundle();
        //b.put
       //frag.setArguments(new Bundle().);
        return frag;
    }



    public static View getViewFromXML(ViewGroup container,NodeList childNodes, Context context) {

        //LinearLayout layout = new LinearLayout(context);


        for (int i = 0; i < childNodes.getLength(); i++) {

            Node node = childNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element xmlElement = (Element)node;
                String nodeName = xmlElement.getNodeName().toLowerCase();

                NativeUIControl control = NativeUIControlMapper.getControlFor(nodeName);
                if(control != null){
                    View nativeView = control.getNativeView(xmlElement, context);
                    if(nativeView != null){
                        container.addView(nativeView);
                    }
                }
            }
        }

        return container;

    }

}
