/***  Copyright (c) 2008-2012 CommonsWare, LLC  Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not  use this file except in compliance with the License.
 * You may obtain   a copy  of the License at http://www.apache.org/licenses/LICENSE-2.0.
 * Unless required  by applicable law or agreed to in writing, 
 * software distributed under the  License is distributed on an "AS IS" BASIS,  
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either express or implied. 
 * See the License for the specific  language governing permissions and limitations under 
 * the License.
 * From _The Busy Coder's Guide to Android Development_    http://commonsware.com/Android*/

package mad.topic5.asynctask;

import mad.topic5.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class RotationAsyncActivity extends Activity
{
   private ProgressBar bar = null;
   private final String LOG_TAG = this.getClass().getName();
   
   // field added by Caspar
   private boolean done = false;

   private RotationAwareTask task = null;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.rotation);
      
      Log.i(LOG_TAG, "onCreate()");
      
      bar = (ProgressBar) findViewById(R.id.progress);
      task = (RotationAwareTask) getLastNonConfigurationInstance();
      if (task == null)
      {
         task = new RotationAwareTask(this);
         task.execute();
      }
      else
      {
         task.attach(this);
         updateProgress(task.getProgress());
         if (task.getProgress() >= 100)
         {
            markAsDone();
         }
      }
   }

   // method added by Caspar
   @Override
   protected void onResume()
   {
      // if the task is finished then restart on resume
      // this gives an easy way to restart without needing extra UI elements
      super.onResume();

      if (done == true)
      {
         done = false;
         task = new RotationAwareTask(this);
         task.execute();
      }
   }

   @Override
   // see API docs to see why this is a good place to detach the running task and save it for
   // when the activity gets recreated following the rotation
   public Object onRetainNonConfigurationInstance()
   {
      task.detach();
      return (task);
   }

   public void updateProgress(int progress)
   {
      bar.setProgress(progress);
   }

   public void markAsDone()
   {
      done = true; // added by Caspar
      findViewById(R.id.completed).setVisibility(View.VISIBLE);
   }

}