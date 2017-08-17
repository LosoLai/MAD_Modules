package mad.topic4.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import mad.topic4.R;

// Gesture Logging Activity by Caspar s2, 2017
public class GestureActivity extends Activity
{
   private String LOG_TAG = this.getClass().getName();
   private GestureDetector detector;
   private ScaleGestureDetector scaleDetector;

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
      setContentView(R.layout.gesture);

      // single class to implement all our gestures for logging
      LoggingGestureListener gestureListener = new LoggingGestureListener();
      // two gesture detectors (pinch is handled by a ScaleDetector)
      scaleDetector = new ScaleGestureDetector(this, gestureListener);
      detector = new GestureDetector(this, gestureListener);
      // DoubleTapListener is implemented by the same class
      detector.setOnDoubleTapListener(gestureListener);
   }

   // forwarding all touch events to our gesture/scale detectirs which pass on to listener
   @Override
   public boolean onTouchEvent(MotionEvent event)
   {
      detector.onTouchEvent(event);
      scaleDetector.onTouchEvent(event);
      return super.onTouchEvent(event);
   }
}