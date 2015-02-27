package com.wilckerson.native_ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParserException;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
//import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.XmlResourceParser;
//import android.app.FragmentManager.OnBackStackChangedListener;
//import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;

public class NativeUI extends CordovaPlugin {

	Fragment frag;
	Fragment frag2;
	LinearLayout fragContainer;
	Activity activity;
	FragmentManager fm;
	ArrayList<NativePage> pages;
	NativePage currentPage;

	static CallbackContext eventsCallbackContext;

	// HashMap<String,Integer> idControls;

	@Override
	public void initialize(org.apache.cordova.CordovaInterface cordova, org.apache.cordova.CordovaWebView webView) {

		// Getting the fragment manager from this activity
		activity = this.cordova.getActivity();
		fm = activity.getFragmentManager();

		// Initializing the list of pages
		pages = new ArrayList<NativePage>();

	};

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("initView")) {
			// String message = args.getString(0);
			this.initView(callbackContext);
			return true;
		} else if (action.equals("loadPage")) {
			String path = args.getString(0);
			this.loadPage(path, callbackContext);
			return true;
		} else if (action.equals("hide")) {
			// String message = args.getString(0);
			this.hide(callbackContext);
			return true;

		} else if (action.equals("setValueAsync")) {
			String controlName = args.getString(0);
			String propertyName = args.getString(1);
			String propertyValue = args.getString(2);
			this.setValueAsync(controlName, propertyName, propertyValue, callbackContext);
			return true;

		} else if (action.equals("getValueAsync")) {
			String controlName = args.getString(0);
			String propertyName = args.getString(1);
			this.getValueAsync(controlName, propertyName, callbackContext);
			return true;
		} else if (action.equals("broadcastEvent")) {

			eventsCallbackContext = callbackContext;
			return true;
		}
		return false;
	}

	public static void broadcastEvent(String controlName, String eventName) {

		try {
			if (eventsCallbackContext != null) {

				JSONObject json = new JSONObject();
				json.put("controlName", controlName);
				json.put("eventName", eventName);

				PluginResult dataResult = new PluginResult(PluginResult.Status.OK, json);
				dataResult.setKeepCallback(true);
				eventsCallbackContext.sendPluginResult(dataResult);
			}
		} catch (Exception e) {
			// TODO: What is the best way to catch this code?
		}

	}

	private void setValueAsync(String controlName, final String propertyName, final String propertyValue, CallbackContext callbackContext) {
		try {

			if (currentPage != null) {

				// final View view =
				// currentPage.fragment.getView().findViewById(stringToInteger(controlID));
				final View view = currentPage.fragment.getView().findViewWithTag(controlName);

				cordova.getActivity().runOnUiThread(new Runnable() {
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

			callbackContext.success();

		} catch (Exception ex) {
			String msg = String.format("Error on setValueAsync to control: %s with property: %s and value: %s. JavaException: %s", controlName, propertyName, propertyValue, ex.getMessage());

			callbackContext.error(msg);
		}
	}

	private void getValueAsync(String controlName, final String propertyName, CallbackContext callbackContext) {
		try {

			String value = null;

			if (currentPage != null) {

				// final View view =
				// currentPage.fragment.getView().findViewById(stringToInteger(controlID));
				final View view = currentPage.fragment.getView().findViewWithTag(controlName);

				// cordova.getActivity().runOnUiThread(new Runnable() {
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

			callbackContext.success(value);

		} catch (Exception ex) {
			String msg = String.format("Error on getValueAsync on property: %s of control: %s . JavaException: %s", propertyName, controlName, ex.getMessage());

			callbackContext.error(msg);
		}
	}

	private void hide(CallbackContext callbackContext) {
		try {

			if (currentPage != null) {
				fm.beginTransaction().remove(currentPage.fragment).commit();
				currentPage = null;
			}

			callbackContext.success();

		} catch (Exception ex) {
			String msg = String.format("Error on hide native page. JavaException: %s", ex.getMessage());
			callbackContext.error(msg);
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

	@SuppressLint("DefaultLocale")
	private void loadPage(String path, CallbackContext callbackContext) {

		try {
			path = path.toLowerCase();

			// Verify if this page already exist
			NativePage page = getPage(path);

			if (page == null) { // If doesnt exist

				// Load the XML file
				InputStream stream = cordova.getActivity().getAssets().open("www/nativeui/" + path);

				DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document xmlParser = builder.parse(stream);

				// Parse the XML to generate native controls inside Fragment
				Fragment frag = renderFragment(xmlParser);

				// Create the page with generated fragment
				page = new NativePage();
				page.fragment = frag;
				page.path = path;

				// Store the page in ArrayList
				pages.add(page);
			}

			// Navigate to page
			navigateToPage(page, callbackContext);

		} catch (Exception ex) {
			String msg = String.format("Error on loadPage %s. JavaException: %s", path, ex.getMessage());
			callbackContext.error(msg);
		}
	}

	private int stringToInteger(String str) {
		return (new java.math.BigInteger(str.getBytes())).intValue();
	}

	private View parseXML(Document xml, Context context) {

		LinearLayout layout = new LinearLayout(context);

		NodeList childNodes = xml.getChildNodes();

		for (int i = 0; i < childNodes.getLength(); i++) {

			Element xmlElement = (Element) childNodes.item(i);

			if (xmlElement.getNodeType() == Node.ELEMENT_NODE) {

				String nodeName = xmlElement.getNodeName();

				NativeUIControl control = NativeUIMapper.getControlFor(nodeName);
				View nativeView = control.getNativeView(xmlElement, context);
				layout.addView(nativeView);
			}
		}

		return layout;

	}

	private Fragment renderFragment(final Document xmlParser) {

		Fragment frag = new Fragment() {
			@Override
			public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

				return parseXML(xmlParser, container.getContext());

				// LinearLayout layout = new LinearLayout(activity);

				// EditText txt = new EditText(container.getContext());
				// txt.setTag("txt");
				// //txt.setId(stringToInteger("txt"));
				// txt.setHint("Native textBox");
				// txt.setLayoutParams(new
				// LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				// ViewGroup.LayoutParams.WRAP_CONTENT));
				// layout.addView(txt);

				// Button btn2 = new Button(container.getContext());
				// btn2.setTag("btn2");,
				// // btn.setId(stringToInteger("btn"));
				// btn2.setText("NativeBtn2");
				// btn2.setLayoutParams(new
				// LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
				// ViewGroup.LayoutParams.WRAP_CONTENT));
				// layout.addView(btn2);
				//
				// btn2.setOnClickListener(eventsOnClickListener);

				// return layout;
			}
		};

		return frag;
	}

	private void navigateToPage(NativePage page, CallbackContext callbackContext) {

		try {
			// Nativage to the fragment of page
			FragmentTransaction ft = fm.beginTransaction();

			ft.replace(android.R.id.content, page.fragment);

			if (pages.size() > 1) {
				ft.addToBackStack(null);
			}

			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

			ft.commit();

			currentPage = page;

			callbackContext.success();
		} catch (Exception ex) {
			String msg = String.format("Error on navigateToPage %s. JavaException: %s", page.path, ex.getMessage());
			callbackContext.error(msg);
		}

	}

	private void initView(CallbackContext callbackContext) {

		// new
		// AlertDialog.Builder(this.cordova.getActivity()).setTitle("Native Alert").show();
		final Activity activity = this.cordova.getActivity();

		fm = activity.getFragmentManager();
		// fm.addOnBackStackChangedListener(new OnBackStackChangedListener(){
		//
		// @Override
		// public void onBackStackChanged() {
		//
		// fm.popBackStack();
		//
		// }
		// });

		// final ViewGroup rootElement =
		// (ViewGroup)activity.getWindow().getDecorView().findViewById(android.R.id.content);

		// if(rootElement != null)
		{

			// fragContainer = new LinearLayout(activity);
			// fragContainer.setId(999999);
			// rootElement.addView(fragContainer);

			// Button btn = new Button(activity);
			// btn.setText("Botao Nativo");
			// fragContainer.addView(btn);
			//
			// Button btn2 = new Button(activity);
			// btn2.setText("Botao Nativo 2");
			// fragContainer.addView(btn2);

			frag = new Fragment() {
				@Override
				public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

					// if(frag2 != null){
					// activity.getFragmentManager().beginTransaction().remove(frag2).commit();
					// }

					RelativeLayout fragView = new RelativeLayout(activity);

					Button btn = new Button(container.getContext());
					btn.setText("Botao Nativo");
					btn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

					fragView.addView(btn);

					btn.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							frag2 = new Fragment() {
								@Override
								public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

									RelativeLayout fragView2 = new RelativeLayout(activity);

									Button btn = new Button(container.getContext());
									btn.setText("Botao Nativo Fragment 2");
									btn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

									fragView2.addView(btn);

									return fragView2;
								}
							};

							// FragmentManager fm =
							// activity.getFragmentManager();
							FragmentTransaction ft = fm.beginTransaction();

							ft.replace(android.R.id.content, frag2);

							// ft.remove(frag);//.add(fragContainer)
							ft.addToBackStack(null);
							ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
							ft.commit();
						}
					});

					return fragView;
				}
			};

			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(android.R.id.content, frag);
			// ft.addToBackStack(null);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();

		}

		callbackContext.success();

		// callbackContext.error("Expected one non-empty string argument.");

	}

}

class NativePage {

	Fragment fragment;
	String path;
}

interface NativeUIControl {

	View getNativeView(Element xmlElement, Context context);
}
