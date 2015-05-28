package com.wilckerson.native_ui;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wilckerson on 06/05/2015.
 */
public class NativeUIManager {

    public static NativeUI nativeUI;

    static Map<String,ArrayList<NativeUIEvent>> events = new LinkedHashMap<String, ArrayList<NativeUIEvent>>();

    private static String getEventId(String controlId,String eventName){
        return String.format("%s_%s",controlId,eventName);
    }

    public static void addEventListener(String controlId, String eventName, NativeUIEvent delegate) {

        ArrayList<NativeUIEvent> eventDelegates = events.get(getEventId(controlId, eventName));
        if(eventDelegates == null){

            eventDelegates = new ArrayList<NativeUIEvent>();
            eventDelegates.add(delegate);

        }
        else
        {
            eventDelegates.add(delegate);
        }

        events.put(getEventId(controlId, eventName), eventDelegates);

    }

    public static void broadcastEvent(String controlId,String eventName){

        ArrayList<NativeUIEvent> eventDelegates = events.get(getEventId(controlId, eventName));

        if(eventDelegates != null) {
            for (int i = 0; i < eventDelegates.size(); i++) {
                NativeUIEvent delegate = eventDelegates.get(i);
                delegate.onExecute();
            }
        }
    }
    
    private View findControl(String query,ViewGroup viewGroup){

        View control = null;

        for (int i = 0; i < viewGroup.getChildCount(); i++) {

            View tmp = viewGroup.getChildAt(0);
            Object tag = tmp.getTag();
            if(tag != null && tag instanceof NativeUIControl){
                NativeUIControl ctrl = (NativeUIControl)tag;
                if(ctrl.controlId.equals(query))
                {
                    control = tmp;
                    break;
                }
            }
        }

        return control;

    }

    public static String getValue(String controlId, String propertyName) {

        String value = null;
//TODO: After change rotation the method fragment.getView returns null
        ViewGroup viewGroup = (ViewGroup)nativeUI.currentPage.fragment.getView();
        List<NativeUIControl> controls = findControlsById(viewGroup, controlId, true);

        if(controls != null && controls.size() > 0){
            value = controls.get(0).getPropertyValue(propertyName);
        }

        return value;
    }


    public static void setValue(String controlId, String propertyName, String propertyValue) {

        ViewGroup viewGroup = (ViewGroup)nativeUI.currentPage.fragment.getView();
        List<NativeUIControl> controls = findControlsById(viewGroup,controlId,true);

        if(controls != null && controls.size() > 0){
            controls.get(0).setPropertyValue(propertyName, propertyValue);
        }
    }

    public static List<NativeUIControl> findControlsById(ViewGroup root, String controlId,boolean onlyFirst){
        List<NativeUIControl> allControls = new ArrayList<NativeUIControl>();

        if(root != null) {
            int childCount = root.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = root.getChildAt(i);

                if (childView instanceof ViewGroup) {
                    allControls.addAll(findControlsById((ViewGroup) childView, controlId, onlyFirst));
                } else {
                    NativeUIControl control = (NativeUIControl) childView.getTag();
                    if (control != null && control.controlId.equals(controlId)) {
                        allControls.add(control);

                        if (onlyFirst) {
                            break;
                        }
                    }
                }
            }
        }

        return allControls;
    }


//    private void setValue(String controlName, final String propertyName, final String propertyValue) {
//
//        if (nativePage != null) {
//
//            // currentPage.fragment.getView().findViewById(stringToInteger(controlID));
//            final View view = findControl(controlName, (ViewGroup)nativePage.fragment.getView());
//
//            nativePage.activity.runOnUiThread(new Runnable() {
//                public void run() {
//
//                    if (view instanceof Button) {
//
//                        Button button = (Button) view;
//                        if (propertyName.equals("content")) {
//                            button.setText(propertyValue);
//                        }
//
//                    }
//
//                }
//
//            });
//
//        }
//
//    }
//
//    private void getValueAsync(String controlName, final String propertyName) {
//
//        String value = null;
//
//        if (nativePage != null) {
//
//            // final View view =
//            // currentPage.fragment.getView().findViewById(stringToInteger(controlID));
//            final View view = nativePage.fragment.getView().findViewWithTag(controlName);
//            //nativePage.fragment.getView().getvie
//            // nativePage.activity.runOnUiThread(new Runnable() {
//            // public void run() {
//
//            if (view instanceof EditText) {
//
//                EditText editText = (EditText) view;
//                if (propertyName.equals("content")) {
//                    value = editText.getText().toString();
//                }
//
//            }
//
//            // }
//
//            // });
//
//        }
//
//    }

}
