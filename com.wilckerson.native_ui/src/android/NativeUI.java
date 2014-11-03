package com.wilckerson.native_ui;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentManager.OnBackStackChangedListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

public class NativeUI extends CordovaPlugin {
    
     @Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
            if (action.equals("initView")) {
                //String message = args.getString(0);
                this.initView(callbackContext);
                return true;
            }
            return false;
        }

        private void initView(CallbackContext callbackContext) {
            
        	//new AlertDialog.Builder(this.cordova.getActivity()).setTitle("Native Alert").show();
        	Activity activity = this.cordova.getActivity();
        	
        	final FragmentManager fm = activity.getFragmentManager();
//        	fm.addOnBackStackChangedListener(new OnBackStackChangedListener(){
//
//				@Override
//				public void onBackStackChanged() {
//					
//					fm.popBackStack();
//					
//				}
//        	});
        	
             
        	
            final ViewGroup rootElement = (ViewGroup)activity.getWindow().getDecorView().findViewById(android.R.id.content);
            if(rootElement != null)
            {
            	Fragment frag = new Fragment(){
            		@Override
            		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            			
            			Button btn = new Button(container.getContext());
                        btn.setText("Botao Nativo");
                        btn.setLayoutParams(new LayoutParams(
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
                        
                        btn.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								
								Fragment frag2 = new Fragment(){
				            		@Override
				            		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
				            			
				            			Button btn = new Button(container.getContext());
				                        btn.setText("Botao Nativo Fragment 2");
				                        btn.setLayoutParams(new LayoutParams(
				                            ViewGroup.LayoutParams.WRAP_CONTENT,
				                                ViewGroup.LayoutParams.WRAP_CONTENT));
				                        
				                        container.addView(btn);
				            			
				            			return super.onCreateView(inflater, container, savedInstanceState);
				            		}
				            	};
				            	
				            	//FragmentManager fm = activity.getFragmentManager();
				                FragmentTransaction ft = fm.beginTransaction();
				                 
				                ft.replace(rootElement.getId(),frag2);
				                ft.addToBackStack(null);
				                //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
				                ft.commit();
							}
						});
                        
                        container.addView(btn);
            			
            			return super.onCreateView(inflater, container, savedInstanceState);
            		}
            	};
            	
            	
            	FragmentTransaction ft = fm.beginTransaction();
                ft.add(rootElement.getId(),frag);
                //ft.addToBackStack(null);
                //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                
                
                
                
   
            }
            
                callbackContext.success();
           
                //callbackContext.error("Expected one non-empty string argument.");
            
        }
    
}