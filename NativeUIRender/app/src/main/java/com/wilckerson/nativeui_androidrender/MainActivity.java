package com.wilckerson.nativeui_androidrender;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wilckerson.native_ui.NativeUI;
import com.wilckerson.native_ui.NativeUIEvent;
import com.wilckerson.native_ui.NativeUIFragment;
import com.wilckerson.native_ui.NativeUIManager;


public class MainActivity extends ActionBarActivity {

    NativeUI nui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            nui = new NativeUI(this);

            nui.loadPage("whoareyou.xml");
            //nui.loadPage("welcome.xml");

            NativeUIManager.addEventListener("#btnSubmit", "click", new NativeUIEvent() {
                @Override
                public void onExecute() {

                    String name = NativeUIManager.getValue("#tbxName","content");

                    if(name == null || name.isEmpty()){
                        Toast toast = Toast.makeText(nui.activity, "Please, enter your name", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }

                    nui.loadPage("welcome.xml");
                    NativeUIManager.setValue("#txUserName","content",name);

                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
