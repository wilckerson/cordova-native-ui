package com.wilckerson.native_ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Wilckerson on 06/05/2015.
 */

public class NativeUIFragment extends Fragment {

   // private Document xmlParser;

    //public NativeUIFragment(){}

//    public NativeUIFragment(Document xmlParser){
//        this.xmlParser = xmlParser;
//    }

    //public void setContent(Document xmlParser){
        //this.xmlParser = xmlParser;
    //}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        LinearLayout layout = new LinearLayout(container.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        //here is your arguments
        Bundle bundle=getArguments();

        if(bundle != null){
           String path = bundle.getString("currentPage");
            try {
                Document xmlParser = NativeUI.loadXML(path, container.getContext());


                View result = NativeUIParser.getViewFromXML(layout, xmlParser.getChildNodes(), container.getContext());

                return result;


            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }

return layout;

        //EditText tx = new EditText(container.getContext());
        //tx.setHint("Digite...");
        //tx.setId(1680);

        //return tx;

    }
}
