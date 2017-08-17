package mad.topic4.actionbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.Locale;

import mad.topic4.R;
import mad.topic4.menu.MenuHelper;

// Simple navigation example using custom ToolBar for ActionBar
// written by Caspar sem 2, 2017
// can replace ActionBar.setNavigationMOde() deprecated at API 21
public class NavActionBarActivity extends AppCompatActivity
{
   //private String LOG_TAG = this.getClass().getName();

   // kept the options menu methods to test still working with custom ActionBar!
   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      super.onCreateOptionsMenu(menu);
      getMenuInflater().inflate(R.menu.options, menu);
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
      setContentView(R.layout.nav_activity);

      // get the custom toolbar and set it
      // NOTE: would have had to set min API 21 if we didn't use AppCompatActivity
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      //getSupportActionBar().setDisplayShowTitleEnabled(false);
      //toolbar.setLogo(R.drawable.XYZ);

      // create spinner and adapter (from array string resource)
      SpinnerAdapter spinnerAdapter = ArrayAdapter.createFromResource(
              getApplicationContext(), R.array.nav, R.layout.spinnertextview);
      // see API docs for getThemedContext()
      Spinner navigationSpinner = new Spinner(getSupportActionBar().getThemedContext());
      navigationSpinner.setAdapter(spinnerAdapter);
      // add spinner to toolbar
      toolbar.addView(navigationSpinner, 0);

      // test selection
      navigationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
      {
         @Override
         public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
         {
            Toast.makeText(NavActionBarActivity.this,
                    String.format(Locale.getDefault(), "Position: %d selected", position), Toast.LENGTH_SHORT).show();
         }

         @Override
         public void onNothingSelected(AdapterView<?> parent)
         {

         }
      });
   }
}
