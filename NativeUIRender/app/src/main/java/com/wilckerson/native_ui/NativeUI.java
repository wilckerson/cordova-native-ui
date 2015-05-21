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

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NativeUI{

	Fragment frag;
	Fragment frag2;
	LinearLayout fragContainer;
	Activity activity;
	FragmentManager fm;
	ArrayList<NativePage> pages;
	NativePage currentPage;

	public NativeUI(Activity activity){

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
				Document xmlParser = loadXML(path,activity);

				// Parse the XML to generate native controls inside Fragment
				Fragment frag = new NativeUIFragment();//NativeUIParser.getFragmentFromXML(xmlParser);

				Bundle b = new Bundle();
 				b.putString("currentPage",path);
		        frag.setArguments(b);

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

	public static Document loadXML(String path,Context context) throws IOException, ParserConfigurationException, SAXException {
		InputStream stream = null;

		stream = context.getAssets().open("www/nativeui/" + path);


		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(stream);
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
