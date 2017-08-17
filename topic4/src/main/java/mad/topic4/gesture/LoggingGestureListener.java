package mad.topic4.gesture;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import java.util.Locale;

// Gesture Logging Listener by Caspar s2, 2017
public class LoggingGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener
{
   private final String LOG_TAG = this.getClass().getName();

   @Override
   public boolean onDown(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onDown: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);

      return false;
   }

   @Override
   public void onShowPress(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onShowPress: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
   }

   @Override
   public boolean onSingleTapUp(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onSingleTapUp: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
   {
      String s = String.format(Locale.getDefault(), "onScroll: x1=%.0f, y1=%.0f, x2=%.0f, y2=%.0f, distanceX=%.2f, distanceY=%.2f"
              , e1.getX(), e1.getY(), e2.getX(), e2.getY(), distanceX, distanceY);
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public void onLongPress(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onLongPress: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
   }

   @Override
   public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
   {
      String s = String.format(Locale.getDefault(), "onFling: x1=%.0f, y1=%.0f, x2=%.0f, y2=%.0f, velocityX=%.2f, velocityY=%.2f"
              , e1.getX(), e1.getY(), e2.getX(), e2.getY(), velocityX, velocityY);
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onSingleTapConfirmed(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onSingleTapConfirmed: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onDoubleTap(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onDoubleTap: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onDoubleTapEvent(MotionEvent e)
   {
      String s = String.format(Locale.getDefault(), "onDoubleTapEvent: x=%.0f, y=%.0f"
              , e.getX(), e.getY());
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onScale(ScaleGestureDetector detector)
   {
      String s = String.format(Locale.getDefault(), "onScale: scaleFactor=%.2f"
              , detector.getScaleFactor());
      Log.d(LOG_TAG, s);
      return false;
   }

   @Override
   public boolean onScaleBegin(ScaleGestureDetector detector)
   {
      String s = String.format(Locale.getDefault(), "onScaleBegin: scaleFactor=%.2f"
              , detector.getScaleFactor());
      Log.d(LOG_TAG, s);
      return true;
   }

   @Override
   public void onScaleEnd(ScaleGestureDetector detector)
   {
      String s = String.format(Locale.getDefault(), "onScaleEnd: scaleFactor=%.2f"
              , detector.getScaleFactor());
      Log.d(LOG_TAG, s);
   }
}
