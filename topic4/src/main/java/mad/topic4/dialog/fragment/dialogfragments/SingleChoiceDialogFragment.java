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
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class SingleChoiceDialogFragment extends DialogFragment
{
   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);

      return new AlertDialog.Builder(getActivity())
            .setIcon(R.drawable.alert_dialog_icon)
            .setTitle(R.string.alert_dialog_single_choice)
            .setSingleChoiceItems(R.array.select_dialog_items2, 0,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {

                        /* User clicked on a radio button do some stuff */
                     }
                  })
            .setPositiveButton(R.string.alert_dialog_ok,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {

                        /* User clicked Yes so do some stuff */
                     }
                  })
            .setNegativeButton(R.string.alert_dialog_cancel,
                  new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int whichButton)
                     {

                        /* User clicked No so do some stuff */
                     }
                  }).create();
   }
}
