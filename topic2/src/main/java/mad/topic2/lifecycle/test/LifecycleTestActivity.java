package mad.topic2.lifecycle.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

import mad.topic2.R;

public class LifecycleTestActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   /**
    * Called when the activity is first created.
    */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
      setContentView(R.layout.life_cycle_test);

      View button = findViewById(R.id.next_activity_button);
      button.setOnClickListener(new OnClickListener()
      {
         public void onClick(View v)
         {
//            Test implicit activity
//            Intent intentToDial = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:99252000"));
//            startActivity(intentToDial);

            nextActivity(v);
         }
      });
   }

   @Override
   protected void onRestart()
   {
      Log.i(LOG_TAG, "onRestart()");
      super.onRestart();
   }

   @Override
   protected void onStart()
   {
      Log.i(LOG_TAG, "onStart()");
      super.onStart();
   }

   @Override
   protected void onResume()
   {
      Log.i(LOG_TAG, "onResume()");
      super.onResume();
   }

   @Override
   protected void onPause()
   {
      Log.i(LOG_TAG, "onPause()");
      super.onPause();
   }

   @Override
   protected void onStop()
   {
      Log.i(LOG_TAG, "onStop()");
      super.onStop();
   }

   @Override
   protected void onDestroy()
   {
      Log.i(LOG_TAG, "onDestroy()");
      super.onDestroy();
   }

   public void nextActivity(View view)
   {
      Log.i(LOG_TAG, "nextActivity()");

      Intent myIntent = new Intent(this, NextActivity.class);
      //startActivity(myIntent);
      this.startActivityForResult(myIntent, 1);
   }

   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data)
   {
      Log.i(LOG_TAG, "onActivityResult(): " + resultCode);

      super.onActivityResult(requestCode, resultCode, data);
   }
}