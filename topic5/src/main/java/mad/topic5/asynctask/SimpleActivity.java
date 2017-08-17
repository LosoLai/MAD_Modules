
package mad.topic5.asynctask;

import mad.topic5.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

// sem 1, 2013 for MAD by Caspar Ryan
public class SimpleActivity extends Activity
{
   private TextView counterTextView;

   private SimpleAsyncTask asyncTask;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.simple);
      counterTextView = (TextView) findViewById(R.id.counterTextView);
   }

   public void updateCounterTextView(Integer progress)
   {
      counterTextView.setText(progress.toString());
   }

   // from the layout XML
   public void onClickStartAsyncTask(View v)
   {
      asyncTask = new SimpleAsyncTask(this);
      asyncTask.execute();
   }

   // from the layout XML
   public void onClickStopAsyncTask(View v)
   {
      asyncTask.cancel(true);
   }

}