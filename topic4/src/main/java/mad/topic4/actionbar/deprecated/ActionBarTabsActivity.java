package mad.topic4.actionbar.deprecated;

// based on Android API example
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import mad.topic4.R;

// Caspar NOTE: addTab is deprecated now so better to use FragmentTabHost (see topic 3 examples)
public class ActionBarTabsActivity extends Activity
{
   private static final String LOG_TAG = ActionBarTabsActivity.class.getName();
   
   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.actionbar_tab);

      ActionBar bar = getActionBar();

      // add a Tab with listener to handle selection
      bar.addTab(bar.newTab().setText("Artists")
            .setTabListener(new MusicTabListener(new ArtistsFragment(), "Artists")));

      bar.addTab(bar.newTab().setText("Albums")
            .setTabListener(new MusicTabListener(new AlbumsFragment(), "Albums")));
      
      bar.addTab(bar.newTab().setText("Songs")
            .setTabListener(new MusicTabListener(new SongsFragment(), "Songs")));
      
      bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
      bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);
   }
   
   public class MusicTabListener implements ActionBar.TabListener
   {
      private Fragment tabFragment;

      private String tabName;

      public MusicTabListener(Fragment tabFragment, String tabName)
      {
         super();
         this.tabFragment = tabFragment;
         this.tabName = tabName;
      }

      public void onTabReselected(Tab tab, FragmentTransaction ft)
      {
      }

      public void onTabSelected(Tab tab, FragmentTransaction ft)
      {
         Log.i(LOG_TAG, "Tab selected: " + tabName);
         
         ft.add(R.id.realtabcontent, tabFragment, tabName);
      }

      public void onTabUnselected(Tab tab, FragmentTransaction ft)
      {
         ft.remove(tabFragment);
      }
   }
}