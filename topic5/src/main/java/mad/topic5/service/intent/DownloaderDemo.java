/***
  Copyright (c) 2008-2012 CommonsWare, LLC
  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain	a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0. Unless required
  by applicable law or agreed to in writing, software distributed under the
  License is distributed on an "AS IS" BASIS,	WITHOUT	WARRANTIES OR CONDITIONS
  OF ANY KIND, either express or implied. See the License for the specific
  language governing permissions and limitations under the License.
	
  From _The Busy Coder's Guide to Android Development_
    http://commonsware.com/Android
 */

package mad.topic5.service.intent;

import java.lang.ref.WeakReference;

import mad.topic5.R;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DownloaderDemo extends Activity
{
   private static class DownloadHandler extends Handler
   {
      // By Caspar
      // see Lint warning for the non-fixed inner class Handler
      // to see why we need WeakReference
      private WeakReference<Activity> activity;

      public DownloadHandler(Activity activity)
      {
         this.activity = new WeakReference<Activity>(activity);
      }

      @Override
      public void handleMessage(Message msg)
      {
         Button b = (Button) activity.get().findViewById(R.id.button);
         b.setEnabled(true);

         Toast.makeText(activity.get(), "Download complete!", Toast.LENGTH_LONG)
               .show();
      }
   };

   private Handler handler = new DownloadHandler(this);

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.downloader);

   }

   // XML onClick
   public void doTheDownload(View v)
   {
      Button b = (Button) findViewById(R.id.button);
      b.setEnabled(false);

      Intent i = new Intent(this, DownloaderService.class);

      i.setData(Uri.parse("http://commonsware.com/Android/excerpt.pdf"));
      i.putExtra(DownloaderService.EXTRA_MESSENGER, new Messenger(handler));

      startService(i);
   }
}
