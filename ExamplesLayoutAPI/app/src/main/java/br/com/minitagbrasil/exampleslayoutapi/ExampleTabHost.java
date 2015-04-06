package br.com.minitagbrasil.exampleslayoutapi;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import br.com.minitagbrasil.exampleslayoutapi.tabs.TabOne;

/**
 * Created by ggarcia on 05/04/15.
 */
public class ExampleTabHost extends TabActivity implements TabHost.OnTabChangeListener, TabHost.TabContentFactory {

    private static final String CATEGORY = "Book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getTabHost from superclass TabActivity
        TabHost tabHost = getTabHost();
        tabHost.setOnTabChangedListener(this);

        //Tab 1: opened from Intent (Activity TabOne.class)
        TabHost.TabSpec tabOne = tabHost.newTabSpec("Tab 1");

        //defines the name, the image of the tab and the Intent that will fill the tab space
        tabOne.setIndicator("Tab 1", getResources().getDrawable(R.drawable.smile_glasses_32x32));
        tabOne.setContent(new Intent(this, TabOne.class));

        //add the tabOne to tabHost
        tabHost.addTab(tabOne);

        //Tab 2: uses the TabContentFactory.createTabContent(String) method to create the tab
        TabHost.TabSpec tabTwo = tabHost.newTabSpec("Tab 2");

        tabTwo.setIndicator("Tab 2", getResources().getDrawable(R.drawable.smile_crazy_32x32));
        tabTwo.setContent(this); //TabContentFactory.createTabContent(tag) implemented (bellow)

        //add the tabTwo to tabHost
        tabHost.addTab(tabTwo);

        //TODO fail
        //Tab 3: created from layout file in resources
//        TabHost.TabSpec tabTree = tabHost.newTabSpec("Tab 3");

//        tabTree.setIndicator("Tab 3", getResources().getDrawable(R.drawable.smile_happy_32x32));
//        tabTree.setContent(R.layout.tabtree);

        //add the tabTree to tabHost
//        tabHost.addTab(tabTree);

    }

    @Override
    public View createTabContent(String tag) {
        TextView tv = new TextView(this);
        tv.setText("Using a factory to create the tab "+ tag);
        return tv;
    }

    @Override
    public void onTabChanged(String tabId) {
        Log.i(CATEGORY, "Tab changed to "+tabId);
    }
}
