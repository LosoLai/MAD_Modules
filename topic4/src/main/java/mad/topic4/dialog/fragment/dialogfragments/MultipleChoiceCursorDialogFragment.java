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
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.Toast;

public class MultipleChoiceCursorDialogFragment extends DialogFragment
{
   @Override
   public Dialog onCreateDialog(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);

      String[] projection = new String[] { ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.SEND_TO_VOICEMAIL };
      
      // CursorLoader introduced in API 11
      Cursor cursor = new CursorLoader(getActivity(),
            ContactsContract.Contacts.CONTENT_URI, projection, null, null, null)
            .loadInBackground();

      return new AlertDialog.Builder(getActivity())
            .setIcon(R.drawable.ic_popup_reminder)
            .setTitle(R.string.alert_dialog_multi_choice_cursor)
            .setMultiChoiceItems(cursor,
                  ContactsContract.Contacts.SEND_TO_VOICEMAIL,
                  ContactsContract.Contacts.DISPLAY_NAME,
                  new DialogInterface.OnMultiChoiceClickListener() {
                     public void onClick(DialogInterface dialog,
                           int whichButton, boolean isChecked)
                     {
                        Toast.makeText(getActivity(),
                              "Readonly Demo Only - Data will not be updated",
                              Toast.LENGTH_SHORT).show();
                     }
                  }).create();
   }

}
