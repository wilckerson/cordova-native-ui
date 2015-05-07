package com.wilckerson.native_ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Wilckerson on 06/05/2015.
 */
public class NativeUIManager {

    private NativePage nativePage;

    public NativeUIManager(NativePage nativePage){
        this.nativePage = nativePage;

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

    private void setValue(String controlName, final String propertyName, final String propertyValue) {

        if (nativePage != null) {

            // currentPage.fragment.getView().findViewById(stringToInteger(controlID));
            final View view = findControl(controlName, (ViewGroup)nativePage.fragment.getView());

            nativePage.activity.runOnUiThread(new Runnable() {
                public void run() {

                    if (view instanceof Button) {

                        Button button = (Button) view;
                        if (propertyName.equals("content")) {
                            button.setText(propertyValue);
                        }

                    }

                }

            });

        }

    }

    private void getValueAsync(String controlName, final String propertyName) {

        String value = null;

        if (nativePage != null) {

            // final View view =
            // currentPage.fragment.getView().findViewById(stringToInteger(controlID));
            final View view = nativePage.fragment.getView().findViewWithTag(controlName);

            // nativePage.activity.runOnUiThread(new Runnable() {
            // public void run() {

            if (view instanceof EditText) {

                EditText editText = (EditText) view;
                if (propertyName.equals("content")) {
                    value = editText.getText().toString();
                }

            }

            // }

            // });

        }

    }

}
