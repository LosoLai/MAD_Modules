package mad.topic4.menu.refactored.actionbar;

import mad.topic4.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MenuTestActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   /** Called when the activity is first created. */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.menutest);

      Log.i(LOG_TAG, "onCreate()");
   }

   public void nextActivity(View view)
   {
      Log.i(LOG_TAG, "nextActivity()");
      Intent myIntent = new Intent(this, MenuActivity.class);
      startActivity(myIntent);
   }

   @Override
   protected void onDestroy()
   {
      super.onDestroy();

      Log.i(LOG_TAG, "onDestroy()");
   }

   @Override
   protected void onPause()
   {
      super.onPause();

      Log.i(LOG_TAG, "onPause()");
   }

   @Override
   protected void onRestart()
   {
      super.onRestart();

      Log.i(LOG_TAG, "onRestart()");
   }

   @Override
   protected void onResume()
   {
      super.onResume();

      Log.i(LOG_TAG, "onResume()");
   }

   @Override
   protected void onStart()
   {
      super.onStart();

      Log.i(LOG_TAG, "onStart()");
   }

   @Override
   protected void onStop()
   {
      super.onStop();

      Log.i(LOG_TAG, "onStop()");
   }
}