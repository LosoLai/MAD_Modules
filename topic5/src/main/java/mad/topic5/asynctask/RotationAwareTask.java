package mad.topic5.asynctask;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

public class RotationAwareTask extends AsyncTask<Void, Void, Void>
{
   private final String LOG_TAG = this.getClass().getName();

   RotationAsyncActivity activity = null;

   int progress = 0;

   public RotationAwareTask(RotationAsyncActivity activity)
   {
      attach(activity);
   }

   @Override
   protected Void doInBackground(Void... unused)
   {
      for (int i = 0; i < 20; i++)
      {
         SystemClock.sleep(1000);
         publishProgress();
      }
      return null;
   }

   @Override
   protected void onProgressUpdate(Void... unused)
   {
      if (activity == null)
      {
         Log.w(LOG_TAG, "onProgressUpdate() skipped -- no activity");
      }
      else
      {
         progress += 5;
         Log.i(LOG_TAG, "Task progress=" + progress + "%");
         activity.updateProgress(progress);
      }
   }

   @Override
   protected void onPostExecute(Void unused)
   {
      if (activity == null)
      {
         Log.w("RotationAsync", "onPostExecute() skipped -- no activity");
      }
      else
      {
         activity.markAsDone();
      }
   }

   public void detach()
   {
      activity = null;
   }

   public void attach(RotationAsyncActivity activity)
   {
      this.activity = activity;
   }

   public int getProgress()
   {
      return (progress);
   }
}