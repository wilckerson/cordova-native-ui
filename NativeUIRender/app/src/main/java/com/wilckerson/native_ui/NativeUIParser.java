package com.wilckerson.native_ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NativeUIParser {

    public static Fragment getFragmentFromXML(final Document xmlParser) {

        NativeUIFragment frag = new NativeUIFragment();
        //frag.setContent(xmlParser);

//        Bundle b = new Bundle();
//        b.put
//       frag.setArguments(new Bundle().);
        return frag;
    }



    public static View getViewFromXML(ViewGroup container,NodeList childNodes, Context context) {

        //LinearLayout layout = new LinearLayout(context);

int baseId = 1680;
        for (int i = 0; i < childNodes.getLength(); i++) {

            Node node = childNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element xmlElement = (Element)node;
                String nodeName = xmlElement.getNodeName().toLowerCase();

                NativeUIControl control = NativeUIMapper.getControlFor(nodeName);
                if(control != null){
                    View nativeView = control.getNativeView(xmlElement, context);
                    nativeView.setId(baseId + i);

                    if(nativeView != null){
                        container.addView(nativeView);
                    }
                }
            }
        }

        return container;

    }

}
