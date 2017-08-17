package mad.topic4.menu;

import android.util.Log;
import android.view.MenuItem;

import java.util.Locale;

import mad.topic4.R;

public class MenuHelper
{
   private static String LOG_TAG = MenuHelper.class.getName();

   public static boolean menuHelper(MenuItem item)
   {
      switch (item.getItemId())
      {
      case R.id.backitem:
         Log.i(LOG_TAG, "Back menuitem selected");
         // return false so intent is fired
         return false;
      case R.id.prefitem:
         Log.i(LOG_TAG, "Preferences menuitem selected");
         return true; // true=consume i.e. no further menu activity
      case R.id.pref1:
      case R.id.pref2:
         // NOTE: have to programmatically handle the "check" state
         if (item.isChecked())
            item.setChecked(false);
         else
            item.setChecked(true);
         Log.i(LOG_TAG, String.format(Locale.getDefault(), "Preferences submenuitem %d selected", item.getItemId()));
         return true;
      default:
         return false;
      }

   }
}
