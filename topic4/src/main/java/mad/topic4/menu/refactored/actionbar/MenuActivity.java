package mad.topic4.menu.refactored.actionbar;

import mad.topic4.R;
import mad.topic4.menu.MenuHelper;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

// Menu example using the ActionBar 
// this is a refactored version from package mad.topic4.menu
// written by Caspar sem 1, 2013
public class MenuActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   private ActionMode mActionMode;

   // options menu code is the same only the manifest and options.xml change
   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      super.onCreateOptionsMenu(menu);
      getMenuInflater().inflate(R.menu.options, menu);
      // an intent to go back to previous Activity
      // NOTE: this is for demo purposes of using an intent
      // take note of effect on back stack i.e. we have multiple activities in
      // the stack!
      menu.findItem(R.id.backitem).setIntent(
            new Intent(this, MenuTestActivity.class));
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      // use helper class and method to remove code duplication
      boolean handled = MenuHelper.menuHelper(item);

      // if this hasn't been handled then pass it to the parent
      return handled ? handled : super.onOptionsItemSelected(item);
   }

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.menuactivityrefactored);

      Log.i(LOG_TAG, "onCreate()");

      // individual TextView for list item
      String[] listItems = new String[] { "one", "two", "three" };
      ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
            R.layout.listtextview, listItems);

      // Alternative approach: textView embedded in layout
      // ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
      // R.layout.textlayout, R.id.nestedTextview, listItems);

      String[] spinnerItems = new String[] { "four", "five", "six" };
      ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
            R.layout.spinnertextview, spinnerItems);

      ListView listview1 = (ListView) findViewById(R.id.listView1);
      Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
      listview1.setAdapter(listAdapter);
      spinner1.setAdapter(spinnerAdapter);

      listview1.setOnItemClickListener(new OnItemClickListener() {

         public void onItemClick(AdapterView<?> parent, View view,
               int position, long id)
         {
            if (mActionMode == null)
               Log.i(LOG_TAG, "List item " + position + " clicked");
            else
               Log.i(LOG_TAG, "List item " + position + " clicked in CAB mode");
         }

      });

      spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
         public void onItemSelected(AdapterView<?> parent, View view,
               int position, long id)
         {
            Log.i(LOG_TAG, "Spinner item " + position + " selected");
         }

         public void onNothingSelected(AdapterView<?> parent)
         {
         }

      });

      // set up contextual actionbar on long click (CAB)
      // this is not as simple as adding a floating context menu
      listview1
            .setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

               public boolean onItemLongClick(AdapterView<?> parent, View view,
                     int position, long id)
               {
                  // but is easier to find which item was long clicked
                  // compared to floating context menu
                  Log.i(LOG_TAG, "List item " + position + " long clicked");

                  // done for efficiency to save recreating if unnecessary
                  if (mActionMode != null)
                  {
                     // allows default list selection behaviour
                     return false;
                  }

                  // Start the CAB
                  mActionMode = startActionMode(new CabCallback(
                        MenuActivity.this));

                  return false;
               }

            });

   }

   public void setActionMode(ActionMode actionMode)
   {
      this.mActionMode = actionMode;
   }

}
