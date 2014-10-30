package com.wilckerson.native_ui;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;

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
            
        	new AlertDialog.Builder(this.cordova.getActivity()).setTitle("Native Alert").show();
        	
                callbackContext.success();
           
                //callbackContext.error("Expected one non-empty string argument.");
            
        }
    
}