package mad.topic3.tab.fragment;

// based on Android API example

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;

import mad.topic3.R;

public class FragmentTabWidgetActivity extends FragmentActivity
{
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.fragment_tab);

      FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
      tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

      tabHost.addTab(
            tabHost.newTabSpec("artists").setIndicator("Artists",
                    ContextCompat.getDrawable(this, R.drawable.ic_tab_artists)),
            ArtistsFragment.class, null);

      tabHost.addTab(
            tabHost.newTabSpec("albums").setIndicator("Albums",
                    ContextCompat.getDrawable(this, R.drawable.ic_tab_albums)),
            AlbumsFragment.class, null);

      tabHost.addTab(
            tabHost.newTabSpec("songs").setIndicator("Songs",
                    ContextCompat.getDrawable(this, R.drawable.ic_tab_songs)),
            SongsFragment.class, null);

      tabHost.setCurrentTab(0);
   }
}