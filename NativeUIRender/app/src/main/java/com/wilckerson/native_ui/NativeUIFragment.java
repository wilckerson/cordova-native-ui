package com.wilckerson.native_ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * Created by Wilckerson on 06/05/2015.
 */

public class NativeUIFragment extends Fragment {

    private Document xmlParser;

    public NativeUIFragment(){}

    @SuppressLint("ValidFragment")
    public NativeUIFragment(Document xmlParser){
        this.xmlParser = xmlParser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = new LinearLayout(container.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        Document xmlParser = null;


        View result = NativeUIParser.getViewFromXML(layout, xmlParser.getChildNodes(), container.getContext());

        return result;

    }
}
