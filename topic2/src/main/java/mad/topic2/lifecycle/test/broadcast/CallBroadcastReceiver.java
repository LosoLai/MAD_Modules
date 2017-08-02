package mad.topic2.lifecycle.test.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallBroadcastReceiver extends BroadcastReceiver
{
   @Override
   // requires android.permission.READ_PHONE_STATE in manifest
   // requires IntentFilter constant "android.intent.action.PHONE_STATE" in
   // manifest
   public void onReceive(Context context, final Intent intent)
   {
      final String LOG_TAG = getClass().getName();

      // updated sem2 2017 By Caspar
      // Uses BroadcastReceiver.goAsync() to keep receiver alive during asynchronous operation
      // See https://developer.android.com/guide/components/broadcasts.html
      // alternative is to use a Service for asynchronous processing
      // NOTE: Thread only required for operations long enough to cause a UI frame skip (~16ms)
      final PendingResult pendingResult = goAsync();
      new Thread()
      {
         // see call to pendingResult.finish() at end of thread
         public void run()
         {
            // wait for debugger to attach so we can set breakpoints in this receiver
            //android.os.Debug.waitForDebugger();
            Log.i(LOG_TAG, "onReceive()");
            Bundle extras = intent.getExtras();
            if (extras != null)
            {
               String state = extras.getString(TelephonyManager.EXTRA_STATE);
               Log.i(LOG_TAG, state);
               if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))
               {
                  String phoneNumber = extras
                          .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                  // need this check for hidden caller ID else get a NullPointerException in Log call
                  Log.i(LOG_TAG, phoneNumber == null ? "phoneNumber==null" : phoneNumber);
               }
            }
            // signal processing finished so BroadcastReceiver can be recycled
            pendingResult.finish();
         }
      }.start();
   }
}
