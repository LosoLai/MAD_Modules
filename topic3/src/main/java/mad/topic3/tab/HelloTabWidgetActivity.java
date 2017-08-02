package mad.topic3.tab;

// based on Android API example

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.TabHost;

import mad.topic3.R;

public class HelloTabWidgetActivity extends TabActivity
{
   /**
    * Called when the activity is first created.
    */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.tab);

      TabHost tabHost = getTabHost(); // The activity TabHost
      TabHost.TabSpec spec; // Reusable TabSpec for each tab
      Intent intent; // Reusable Intent for each tab

      // Create an Intent to launch an Activity for the tab (to be reused)
      intent = new Intent().setClass(this, ArtistsActivity.class);
      // Initialize a TabSpec for each tab and add it to the TabHost
      spec = tabHost
              .newTabSpec("artists")
              .setIndicator("Artists", ContextCompat.getDrawable(this, R.drawable.ic_tab_artists))
              .setContent(intent);
      tabHost.addTab(spec);
      // Do the same for the other tabs
      intent = new Intent().setClass(this, AlbumsActivity.class);
      spec = tabHost.newTabSpec("albums")
              .setIndicator("Albums", ContextCompat.getDrawable(this, R.drawable.ic_tab_albums))
              .setContent(intent);
      tabHost.addTab(spec);
      intent = new Intent().setClass(this, SongsActivity.class);
      spec = tabHost.newTabSpec("songs")
              .setIndicator("Songs", ContextCompat.getDrawable(this, R.drawable.ic_tab_songs))
              .setContent(intent);
      tabHost.addTab(spec);
      tabHost.setCurrentTab(1);
   }
}