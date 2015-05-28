package com.wilckerson.native_ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NativeUIParser {


    static int baseId = 1618;


    public static View getViewFromXML(ViewGroup container, NodeList childNodes, Context context) {

        View result = null;

        for (int i = 0; i < childNodes.getLength(); i++) {

            Node node = childNodes.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element xmlElement = (Element) node;

                String nodeName = xmlElement.getNodeName().toLowerCase();

                View nativeView = getViewFromControlName(nodeName, xmlElement,context);

                if (nativeView != null && container != null) {
                    container.addView(nativeView);
                    result = container;
                } else if (nativeView != null && container == null) {
                    result = nativeView;
                }
            }
        }

        return result;

    }

    public static View getViewFromControlName(String controlName, Element xmlElement, Context context) {
        View nativeView = null;

        NativeUIControl control = NativeUIControlMapper.getControlFor(controlName);
        //control.context = context;

        if (control != null) {
            nativeView = control.getNativeView(xmlElement, context);

            //Parsing simple attributes
            ParsingSimpleAttributes(xmlElement, control);

            nativeView.setId(++baseId);

            String xmlId = "#".concat(xmlElement.getAttribute("id"));
            control.controlId = xmlId;
            //String controlId = String.format("%s_#%s",nodeName,xmlId);
            nativeView.setTag(control);

        }
        return nativeView;
    }

    private static void ParsingSimpleAttributes(Element xmlElement, NativeUIControl control) {

        NamedNodeMap attributes = xmlElement.getAttributes();
        for (int j = 0; j < attributes.getLength(); j++) {
            Node attribute = attributes.item(j);
            String name = attribute.getNodeName();
            String value = attribute.getNodeValue();

            if (name != null && value != null) {
                control.setPropertyValue(name, value);
            }
        }
    }

    public static Element findChildAttribute(Element xmlRootElement,String childAttributeName) {
        Element childAttribute = null;

        NodeList childs = xmlRootElement.getChildNodes();
        for (int j = 0; j < childs.getLength(); j++) {
            Node node = childs.item(j);

            if (node.getNodeType() == Node.ELEMENT_NODE) {

                Element childElement = (Element) node;
                String childName = childElement.getNodeName().toLowerCase();

                if (childName.equals(childAttributeName)) {

                   childAttribute = childElement;
                    break;
                }
            }
        }

        return childAttribute;
    }

}
