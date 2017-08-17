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

package mad.topic4.dialog.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import mad.topic4.R;
import mad.topic4.dialog.fragment.dialogfragments.DialogListDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.MultipleChoiceCursorDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.MultipleChoiceDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.ProgressDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.SingleChoiceDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.TextEntryDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.YesNoLongMessageDialogFragment;
import mad.topic4.dialog.fragment.dialogfragments.YesNoMessageDialogFragment;

//Refactored version of API AlertDialogSamples
//uses individual DialogFragments for each AlertDialog
//By Caspar Ryan
public class AlertDialogSamplesFragment extends Fragment
{
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState)
   {
      View view = inflater.inflate(R.layout.alert_dialog, container, false);

      /*
       * Display a text message with yes/no buttons and handle each message as
       * well as the cancel action
       */
      Button twoButtonsTitle = (Button) view.findViewById(R.id.two_buttons);
      twoButtonsTitle.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new YesNoMessageDialogFragment().show(getFragmentManager(), "yn");
         }
      });

      /*
       * Display a long text message with yes/no buttons and handle each message
       * as well as the cancel action
       */
      Button twoButtons2Title = (Button) view.findViewById(R.id.two_buttons2);
      twoButtons2Title.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new YesNoLongMessageDialogFragment().show(getFragmentManager(),
                  "ynl");
         }
      });

      /* Display a list of items */
      Button selectButton = (Button) view.findViewById(R.id.select_button);
      selectButton.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new DialogListDialogFragment().show(getFragmentManager(), "dl");
         }
      });

      /* Display a custom progress bar */
      Button progressButton = (Button) view.findViewById(R.id.progress_button);
      progressButton.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new ProgressDialogFragment().show(getFragmentManager(), "progress");
         }
      });

      /* Display a radio button group */
      Button radioButton = (Button) view.findViewById(R.id.radio_button);
      radioButton.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new SingleChoiceDialogFragment().show(getFragmentManager(), "sc");
         }
      });

      /* Display a list of checkboxes */
      Button checkBox = (Button) view.findViewById(R.id.checkbox_button);
      checkBox.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new MultipleChoiceDialogFragment().show(getFragmentManager(), "mc");
         }
      });

      /* Display a list of checkboxes, backed by a cursor */
      Button checkBox2 = (Button) view.findViewById(R.id.checkbox_button2);
      checkBox2.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new MultipleChoiceCursorDialogFragment().show(getFragmentManager(),
                  "mcc");
         }
      });

      /* Display a text entry dialog */
      Button textEntry = (Button) view.findViewById(R.id.text_entry_button);
      textEntry.setOnClickListener(new OnClickListener() {
         public void onClick(View v)
         {
            new TextEntryDialogFragment().show(getFragmentManager(), "te");
         }
      });

      return view;
   }
}
