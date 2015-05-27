package com.wilckerson.native_ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.xml.sax.SAXException;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NativeUI {

    Fragment frag;
    Fragment frag2;
    LinearLayout fragContainer;
    Activity activity;
    FragmentManager fm;
    ArrayList<NativePage> pages;
    NativePage currentPage;

    public NativeUI(Activity activity) {

        this.activity = activity;
        fm = activity.getFragmentManager();

        // Initializing the list of pages
        pages = new ArrayList<NativePage>();
    }

    public void hide() {

        if (currentPage != null) {
            fm.beginTransaction().remove(currentPage.fragment).commit();
            currentPage = null;
        }
    }

    private NativePage getPage(String path) {

        for (NativePage page : pages) {
            if (page.path.equals(path)) {
                return page;
            }
        }

        return null;
    }


    public void loadPage(String path) {

        try {
            path = path.toLowerCase();

            // Verify if this page already exist
            NativePage page = getPage(path);

            if (page == null) { // If doesnt exist

                // Load the XML file
                InputStream stream = activity.getAssets().open("www/nativeui/" + path);

                //Instantiating the xml parser
                DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                Document xmlParser = builder.parse(stream);

                //Fragment that will receive the native controls parsed from the xml
                //The parser will run inside fragment method called onCreateView
                Fragment frag = new NativeUIFragment(xmlParser);

                // Create the page with generated fragment
                page = new NativePage();
                page.fragment = frag;
                page.path = path;
                page.activity = activity;

                // Store the page in ArrayList
                pages.add(page);
            }

            // Navigate to page
            navigateToPage(page);
        } catch (IOException e) {
            e.printStackTrace();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    private void navigateToPage(NativePage page) {


        // Nativage to the fragment of page
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(android.R.id.content, page.fragment);

        if (pages.size() > 1) {
            ft.addToBackStack(null);
        }

        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        ft.commit();

        currentPage = page;
    }


}
