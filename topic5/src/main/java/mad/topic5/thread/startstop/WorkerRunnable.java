package mad.topic5.thread.startstop;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class WorkerRunnable implements Runnable
{
   private static final String LOG_TAG = WorkerRunnable.class.getName();

   private TextView textView1;

   private Handler uiHandler;

   private Activity activity;

   public WorkerRunnable(Activity activity, TextView textView1, Handler uiHandler)
   {
      this.textView1 = textView1;
      this.uiHandler = uiHandler;
      this.activity = activity; 
   }

   @Override
   public void run()
   {
      int i=0;
      
      try
      {
         // this thread runs until it is interrupted externally with a call
         // to interrupt()
         while (true)
         {
            Thread thisThread = Thread.currentThread();

            // check to quit if we have called interrupted on this Thread
            if (thisThread != null && thisThread.isInterrupted())
            {
               // do tidy up first if necessary
               Log.i(LOG_TAG, "isInterrupted()==true");
               return;
            }

            long start = System.nanoTime();
            // simulate complex calculation
            for (long l = 0; l < 1000000; l++)
               ;
            long stop = System.nanoTime();

            // needs to be final to be visible to Runnable inner class below
            final String msg = "Calculation took: " + (stop - start)
                  / 1000000.0 + "ms";

            // the method as a Runnable that will update the UI
            Runnable uiUpdateRunnable = new Runnable() {
               public void run()
               {
                  textView1.setText(msg);
               }

            };

            // three different approaches to do the same thing!
            // in all cases only the UI thread updates the TextView so there is
            // no
            // need for concurrency management using volatile or synchronized
            if ((++i % 3) == 0)
            {
               // post to the original (UI) thread using a Handler
               uiHandler.post(uiUpdateRunnable);
            }
            else if ((i % 2) == 0)
            {
               // else run on UI thread using Activity
               activity.runOnUiThread(uiUpdateRunnable);
            }
            else
            {
               // else post directly to View
               textView1.post(uiUpdateRunnable);
            }

            start = System.nanoTime();
            Thread.sleep(100);
            stop = System.nanoTime();
            Log.i(LOG_TAG, "Slept: " + (stop - start) / 1000000.0 + "ms");
         }
      }
      // exit if we are interrupted
      catch (InterruptedException ie)
      {
         // do tidy up first if necessary
         Log.i(LOG_TAG, "caught InterruptedException");
         return;
      }
   }
}
