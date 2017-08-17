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

import mad.topic4.R;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class ProgressDialogFragment extends DialogFragment
{
   private static final int MAX_PROGRESS = 100;

   private ProgressDialog progressDialog;

   private ProgressHandler progressHandler;

   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);

      progressHandler = new ProgressHandler(this);

      progressDialog = new ProgressDialog(this.getActivity());
      progressDialog.setIcon(R.drawable.alert_dialog_icon);
      progressDialog.setTitle(R.string.select_dialog);
      progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
      progressDialog.setMax(MAX_PROGRESS);

      progressDialog.setButton(DialogInterface.BUTTON_POSITIVE,
            getText(R.string.alert_dialog_hide),
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int whichButton)
               {

               }
            });
      progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE,
            getText(R.string.alert_dialog_cancel),
            new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int whichButton)
               {

               }
            });

      // start progress handler by sending an empty message
      progressHandler.sendEmptyMessage(0);

      return progressDialog;
   }

   private static class ProgressHandler extends Handler
   {
      private int mProgress = 0;

      private ProgressDialogFragment parent;

      public ProgressHandler(ProgressDialogFragment parent)
      {
         this.parent = parent;
      }

      @Override
      public void handleMessage(Message msg)
      {
         super.handleMessage(msg);
         if (mProgress >= MAX_PROGRESS)
         {
            parent.dismiss();
         }
         else if (parent != null)
         {
            mProgress++;
            // safe to cast since we created it in onCreateDialog() above
            ProgressDialog parentDialog = (ProgressDialog) this.parent
                  .getDialog();
            if (parentDialog != null)
            {
               parentDialog.incrementProgressBy(1);
               sendEmptyMessageDelayed(0, 100);
            }
         }
      }
   }
}
