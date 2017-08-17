package mad.topic4.menu.refactored.actionbar;

import mad.topic4.R;
import mad.topic4.menu.MenuHelper;
import android.content.Intent;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;

public class CabCallback implements Callback
{
   private MenuActivity activity;

   public CabCallback(MenuActivity activity)
   {
      this.activity = activity;
   }

   @Override
   public boolean onCreateActionMode(ActionMode mode, Menu menu)
   {
      // this is the same as the original onCreateContextMenu()
      activity.getMenuInflater().inflate(R.menu.options, menu);
      // and intent to go back to previous Activity
      menu.findItem(R.id.backitem).setIntent(
            new Intent(activity, MenuTestActivity.class));
      return true;
   }

   @Override
   public boolean onPrepareActionMode(ActionMode mode, Menu menu)
   {
      // TODO Auto-generated method stub
      return false;
   }

   @Override
   public boolean onActionItemClicked(ActionMode mode, MenuItem item)
   {
      return MenuHelper.menuHelper(item);
   }

   @Override
   public void onDestroyActionMode(ActionMode mode)
   {
      // notify activity that action mode has finished
      activity.setActionMode(null);
   }
}
