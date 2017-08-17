package mad.topic5.asynctask;

import android.os.AsyncTask;
import android.util.Log;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, Void>
{
   private final String LOG_TAG = this.getClass().getName();

   private SimpleActivity activity;

   public SimpleAsyncTask(SimpleActivity activity)
   {
      super();
      this.activity = activity;
   }

   @Override
   protected void onPreExecute()
   {
   }

   @Override
   // note the variable length parameter list (which we are not using here)
   protected Void doInBackground(Void... unused)
   {
      for (int i = 0; i < 10; i++)
      {
         // DON'T DO THIS: Called on worker thread
         //onProgressUpdate(i);

         // DO THIS: Called on the UI Thread
         publishProgress(i);

         try
         {
            Thread.sleep(1000);
         }
         catch (InterruptedException e)
         {
            Log.i(LOG_TAG, "interruptedException");
         }

         // help speed up cancel operation
         if (isCancelled())
         {
            Log.i(LOG_TAG, "isCancelled()");
            return null;
         }
      }

      return null;
   }

   @Override
   @SuppressWarnings("unused")
   protected void onProgressUpdate(Integer... progress)
   {
      // how to process variable length param list
      for (Integer i : progress)
         ;
      
      // note the variable length parameter list
      // we just use a single parameter in this case
      if (activity != null)
         activity.updateCounterTextView(progress[0]);
   }

   @Override
   protected void onPostExecute(Void result)
   {

   }

   // can override onPreExecute() and onPostExecute() if necessary

}