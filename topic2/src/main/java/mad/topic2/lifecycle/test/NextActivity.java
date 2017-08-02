package mad.topic2.lifecycle.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import mad.topic2.R;

public class NextActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
      setContentView(R.layout.next);

      Button prevButton = (Button) findViewById(R.id.prev_activity_button);
      prevButton.setOnClickListener(new View.OnClickListener()
      {
         public void onClick(View v)
         {
            previousActivity(v);
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

   public void previousActivity(View view)
   {
      // only needed for startActivityForResult(...)
      this.setResult(RESULT_OK, null);

      // finish this activity and remove from back stack
      Log.i(LOG_TAG, "previousActivity() finish()");
      finish();

      // alternatively we can create a new instance of the previous activity
      // note that this will cause a different set of transitions
//       Intent myIntent = new Intent(this, LifecycleTestActivity.class);
//       startActivity(myIntent);

      // or if we want to start a completely different activity to test implicit
      // filters
      // this brings up google maps of RMIT location (using explicit lat and
      // long)
      // NOTE: Is buggy on the emulator so better to run on real device
//      String uri = String.format(Locale.getDefault(), "geo:%f,%f", -37.808111,
//            144.963784);
//      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//      this.startActivity(intent);
   }

}
