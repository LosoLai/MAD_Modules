package mad.topic3.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import mad.topic3.R;

public class LayoutTestActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();

   /**
    * Called when the activity is first created.
    */
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      // change this to test other layouts in res/layout (e.g. linear etc.)
      this.setContentView(R.layout.frame);

      Log.i(LOG_TAG, "onCreate()");

      // for echo.xml layout only
//      View okButton = findViewById(R.id.ok);
//      final EditText echoEntry = (EditText) findViewById(R.id.entry);
//      final TextView echoLabel = (TextView) findViewById(R.id.echoLabel);
//      okButton.setOnClickListener(new View.OnClickListener()
//      {
//         public void onClick(View v)
//         {
//            echoLabel.setText(echoEntry.getText());
//         }
//      });
   }
}