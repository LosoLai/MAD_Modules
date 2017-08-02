package mad.topic2.lifecycle.test.fragment;

import mad.topic2.R;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class NextActivity extends FragmentActivity
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
      setContentView(R.layout.next_activity);
   }

   @Override
   protected void onDestroy()
   {
      Log.i(LOG_TAG, "onDestroy()");
      super.onDestroy();
   }

   @Override
   protected void onPause()
   {
      Log.i(LOG_TAG, "onPause()");
      super.onPause();
   }

   @Override
   protected void onRestart()
   {
      Log.i(LOG_TAG, "onRestart()");
      super.onRestart();
   }

   @Override
   protected void onResume()
   {
      Log.i(LOG_TAG, "onResume()");
      super.onResume();
   }

   @Override
   protected void onStart()
   {
      Log.i(LOG_TAG, "onStart()");
      super.onStart();
   }

   @Override
   protected void onStop()
   {
      Log.i(LOG_TAG, "onStop()");
      super.onStop();
   }
}
