package mad.topic4.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.Locale;

import mad.topic4.R;

// Simple Menu example by Caspar
public class MenuActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      super.onCreateOptionsMenu(menu);
      getMenuInflater().inflate(R.menu.options, menu);
      // an intent to go back to previous Activity
      menu.findItem(R.id.backitem).setIntent(
            new Intent(this, MenuTestActivity.class));
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      super.onOptionsItemSelected(item);
      
      // use helper class/method since context and options behaviour is the same
      // here
      return MenuHelper.menuHelper(item);
   }

   @Override
   public void onCreateContextMenu(ContextMenu menu, View v,
         ContextMenuInfo menuInfo)
   {
      super.onCreateContextMenu(menu, v, menuInfo);
      getMenuInflater().inflate(R.menu.options, menu);
      // and intent to go back to previous Activity
      // NOTE: this is for demo purposes of using an intent
      // take note of effect on back stack i.e. we have multiple activities in
      // the stack!
      menu.findItem(R.id.backitem).setIntent(
            new Intent(this, MenuTestActivity.class));
   }

   @Override
   public boolean onContextItemSelected(MenuItem item)
   {
      super.onContextItemSelected(item);
      // find which list item context menu applies to
      AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
      if (info != null)
         Log.i(LOG_TAG, String.format(Locale.getDefault(), "Context menu id: %d, position: %d",
                 item.getItemId(), info.position));
      boolean retVal = MenuHelper.menuHelper(item);

      // if not handled then send to super (which returns false by default)
      return retVal ? retVal : super.onOptionsItemSelected(item);
   }

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.menuactivity);

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
            Log.i(LOG_TAG, String.format(Locale.getDefault(), "List item %d clicked", position ));
         }

      });

      spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
         public void onItemSelected(AdapterView<?> parent, View view,
               int position, long id)
         {
            Log.i(LOG_TAG, String.format(Locale.getDefault(), "Spinner item %d clicked", position));
         }

         public void onNothingSelected(AdapterView<?> parent)
         {
         }

      });

      registerForContextMenu(listview1);
   }
}
