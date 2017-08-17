// Threading example with High Concurrency using Handler by Caspar Ryan
// for MAD Topic 5 sem 1, 2013
package mad.topic5.thread.startstop;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import mad.topic5.R;

public class ThreadTestStartStopActivity extends Activity
{
   // maintain a queue of running threads (FIFO)
   // LinkedBlockingQueue is thread safe (standard LinkedList is not)
   private Queue<Thread> threadQueue = new LinkedBlockingQueue<Thread>();

   private Handler uiHandler;

   private TextView textView1;

   private static final String LOG_TAG = ThreadTestStartStopActivity.class.getName();

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.worker_thread);
      textView1 = (TextView) findViewById(R.id.textView1);

      // get a Handler for the UI thread
      uiHandler = new Handler();
   }

   // use Threads tab in DDMS to check status of created and interrupted threads
   public void onClickStartThread(View v)
   {
      // uncomment if you want to trigger application not responding (ANR)!
      //blockFor(10);

      // check if thread at head of queue is finished (for debug purposes
      // only)
      Thread firstThread = threadQueue.peek();
      if (firstThread != null)
         Log.d(LOG_TAG, "firstThread.isAlive()=="
               + firstThread.isAlive());
      else
         Log.d(LOG_TAG, "firstThread==null");

      // create the Thread from a Runnable (WorkerTask)
      Thread newThread = new Thread(new WorkerRunnable(this, textView1, uiHandler));
      // add new thread to queue
      threadQueue.add(newThread);

      // make sure thread will be killed if app is unexpectedly killed
      newThread.setDaemon(true);
      newThread.start();
   }

   public void onClickInterruptThread(View v)
   {
      // if we have a thread in the queue then interrupt it and remove from
      // queue
      Thread front = threadQueue.peek();
      if (front != null)
      {
         front.interrupt();
         threadQueue.remove();
      }
   }
   
   // handle onPause and onResume if you want to start/stop threads
   // but may want to let them complete e.g. if downloading data that will be
   // stored locally

   private void blockFor(int secs)
   {
      long start=System.currentTimeMillis();

      // very inefficient, perfect for blocking ;)
      while(System.currentTimeMillis()-start < secs * 1000)
         ;
   }
}