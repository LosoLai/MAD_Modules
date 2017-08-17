/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mad.topic4.dialog.fragment.dialogfragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import mad.topic4.R;

public class YesNoLongMessageDialogFragment extends DialogFragment
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);

      return new AlertDialog.Builder(getActivity())
            .setIcon(R.drawable.alert_dialog_icon)
            .setTitle(R.string.alert_dialog_two_buttons_msg)
            .setMessage(R.string.alert_dialog_two_buttons2_msg)
            .setPositiveButton(R.string.alert_dialog_ok,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {
                        Log.i(LOG_TAG, "OK selected (Fragment)");
                     }
                  })
            .setNeutralButton(R.string.alert_dialog_something,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {
                        Log.i(LOG_TAG, "Something selected (Fragment)");
                     }
                  })
            .setNegativeButton(R.string.alert_dialog_cancel,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {
                        Log.i(LOG_TAG, "Cancel selected (Fragment)");
                     }
                  }).create();
   }
}
