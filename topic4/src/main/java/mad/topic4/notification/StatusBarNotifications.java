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

package mad.topic4.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import mad.topic4.R;

/**
 * Demonstrates adding notifications to the status bar
 */

// refactored by Caspar to use NotificationBuilder to remove deprecated calls
public class StatusBarNotifications extends Activity
{
   private NotificationManager mNotificationManager;
   // flags for notification sounds/vibration
   private int defaults;
   // Use our layout id for a unique identifier
   private static int MOOD_NOTIFICATIONS = R.layout.status_bar_notifications;

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.status_bar_notifications);

      // Get the notification manager service.
      mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

      Button button = (Button) findViewById(R.id.happy);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_happy,
                    R.string.status_bar_notifications_happy_message, false);
         }
      });

      button = (Button) findViewById(R.id.neutral);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_neutral,
                    R.string.status_bar_notifications_ok_message, false);
         }
      });

      button = (Button) findViewById(R.id.sad);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_sad,
                    R.string.status_bar_notifications_sad_message, false);
         }
      });

      button = (Button) findViewById(R.id.happyMarquee);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_happy,
                    R.string.status_bar_notifications_happy_message, true);
         }
      });

      button = (Button) findViewById(R.id.neutralMarquee);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_neutral,
                    R.string.status_bar_notifications_ok_message, true);
         }
      });

      button = (Button) findViewById(R.id.sadMarquee);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMood(R.drawable.stat_sad,
                    R.string.status_bar_notifications_sad_message, true);
         }
      });

      button = (Button) findViewById(R.id.happyViews);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMoodView(R.drawable.stat_happy,
                    R.string.status_bar_notifications_happy_message);
         }
      });

      button = (Button) findViewById(R.id.neutralViews);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMoodView(R.drawable.stat_neutral,
                    R.string.status_bar_notifications_ok_message);
         }
      });

      button = (Button) findViewById(R.id.sadViews);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setMoodView(R.drawable.stat_sad,
                    R.string.status_bar_notifications_sad_message);
         }
      });

      button = (Button) findViewById(R.id.defaultSound);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setDefault(NotificationCompat.DEFAULT_SOUND);
         }
      });

      button = (Button) findViewById(R.id.defaultVibrate);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setDefault(NotificationCompat.DEFAULT_VIBRATE);
         }
      });

      button = (Button) findViewById(R.id.defaultAll);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            setDefault(NotificationCompat.DEFAULT_ALL);
         }
      });

      button = (Button) findViewById(R.id.clear);
      button.setOnClickListener(new Button.OnClickListener()
      {
         public void onClick(View v)
         {
            mNotificationManager.cancel(R.layout.status_bar_notifications);
         }
      });
   }

   // Added by Caspar to demonstrate Toast notification
   @Override
   protected void onResume()
   {
      super.onResume();
      Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
   }

   private PendingIntent makeMoodIntent(int moodId)
   {
      // The PendingIntent to launch our activity if the user selects this
      // NotificationCompat. Note the use of FLAG_UPDATE_CURRENT so that if there
      // is already an active matching pending intent, we will update its
      // extras to be the ones passed in here.
      PendingIntent contentIntent = PendingIntent.getActivity(
              this,
              0,
              new Intent(this, NotificationDisplay.class).setFlags(
                      Intent.FLAG_ACTIVITY_NEW_TASK).putExtra("moodimg", moodId),
              PendingIntent.FLAG_UPDATE_CURRENT);
      return contentIntent;
   }

   private void setMood(int moodId, int textId, boolean showTicker)
   {
      // In this sample, we'll use the same text for the ticker and the expanded
      // notification
      CharSequence text = getText(textId);

      // choose the ticker text
      String tickerText = showTicker ? getString(textId) : null;

      // modified by Caspar to use non deprecated APIs
      Notification notification = new NotificationCompat.Builder(this)
              .setContentTitle(getText(R.string.status_bar_notifications_mood_title))
              .setContentText(text)
              .setTicker(tickerText)
              .setSmallIcon(moodId)
              .setWhen(System.currentTimeMillis())
              .setContentIntent(makeMoodIntent(moodId))
              .setDefaults(defaults)
              .setPriority(NotificationCompat.PRIORITY_DEFAULT)
              // couldn't get set lights to work!
              .setLights(Color.WHITE, 500, 500)
              .build();

      // Send the NotificationCompat.
      // We use a layout id because it is a unique number. We use it later to cancel.
      mNotificationManager.notify(MOOD_NOTIFICATIONS, notification);
   }

   // added by Caspar from https://stackoverflow.com/questions/5699810/how-to-change-bitmap-image-color-in-android
   private static Bitmap changeBitmapColor(Bitmap sourceBitmap, int color)
   {
      Bitmap resultBitmap = sourceBitmap.copy(sourceBitmap.getConfig(), true);
      Paint paint = new Paint();
      ColorFilter filter = new LightingColorFilter(color, 1);
      paint.setColorFilter(filter);
      Canvas canvas = new Canvas(resultBitmap);
      canvas.drawBitmap(resultBitmap, 0, 0, paint);
      return resultBitmap;
   }

   private void setMoodView(int moodId, int textId)
   {
      // In this sample, we'll use the same text for the ticker and the expanded
      // notification
      CharSequence text = getText(textId);
      // our custom view
      RemoteViews contentView = new RemoteViews(getPackageName(),
              R.layout.status_bar_balloon);
      contentView.setTextViewText(R.id.text, text);
      // Caspar: this is an old example so we have to do some hackery to change the colors to display o white background for API 23!
      contentView.setImageViewBitmap(R.id.icon, changeBitmapColor(BitmapFactory.decodeResource(getResources(), moodId), Color.BLACK));
      contentView.setTextColor(R.id.text, ResourcesCompat.getColor(getResources(), android.R.color.black, null));

      // modified by Caspar to use newer APIs
      final Notification notification = new NotificationCompat.Builder(this)
              .setContentTitle(getText(R.string.status_bar_notifications_mood_title))
              .setContentText(text)
              .setTicker(getText(textId))
              .setSmallIcon(moodId)
              .setWhen(System.currentTimeMillis())
              .setCustomContentView(contentView)
              .setContentIntent(makeMoodIntent(moodId))
              .setDefaults(defaults)
              .setPriority(NotificationCompat.PRIORITY_DEFAULT)
              // couldn't get set lights to work!
              .setLights(Color.WHITE, 500, 500)
              .build();

      // added by Caspar to optionally delay notification (trying to get lights to work :P)
      new Handler().postDelayed(new Runnable() {
         public void run() {
            // we use a string id because is a unique number. we use it later to
            // cancel the notification
            mNotificationManager.notify(MOOD_NOTIFICATIONS, notification);
         }
      }, 0);
   }

   // modified by Caspar to work with Builder and better toggle behaviour
   private void setDefault(int flag)
   {
      // NOTE: using XOR for toggle effect
      // ALL is set independently to the individual options
      if(flag==NotificationCompat.DEFAULT_ALL)
         defaults=(defaults==NotificationCompat.DEFAULT_ALL) ? 0 : NotificationCompat.DEFAULT_ALL;
      else
         defaults ^= flag|NotificationCompat.DEFAULT_LIGHTS;
   }
}
