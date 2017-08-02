package mad.topic2.lifecycle.test.fragment;

import mad.topic2.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class NextFragment extends Fragment
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
   }

   public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreateView()");
      View view = inflater.inflate(R.layout.next_fragment, container, false);

      View button = view.findViewById(R.id.prev_activity_button);
      button.setOnClickListener(new OnClickListener() {

         public void onClick(View v)
         {
            previousActivity(v);
         }
      });

      return view;
   }

   @Override
   public void onDestroy()
   {
      Log.i(LOG_TAG, "onDestroy()");
      super.onDestroy();
   }

   @Override
   public void onPause()
   {
      Log.i(LOG_TAG, "onPause()");
      super.onPause();
   }

   @Override
   public void onResume()
   {
      Log.i(LOG_TAG, "onResume()");
      super.onResume();
   }

   @Override
   public void onStart()
   {
      Log.i(LOG_TAG, "onStart()");
      super.onStart();
   }

   @Override
   public void onStop()
   {
      Log.i(LOG_TAG, "onStop()");
      super.onStop();
   }

   @Override
   public void onActivityCreated(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onActivityCreated()");
      super.onActivityCreated(savedInstanceState);
   }

   @Override
   public void onDestroyView()
   {
      Log.i(LOG_TAG, "onDestroyView()");
      super.onDestroyView();
   }

   @Override
   public void onDetach()
   {
      Log.i(LOG_TAG, "onDetach()");
      super.onDetach();
   }

   public void previousActivity(View view)
   {
      Log.i(LOG_TAG, "previousActivity() finish()");

      // finish this activity and remove from back stack
      getActivity().finish();

      // alternatively we can create a new instance of the previous activity
      // note that this will cause a different set of transitions
      // Intent myIntent = new Intent(this, LifecycleTestActivity.class);
      // startActivity(myIntent);

      // or if we want to start a completely different activity to test implicit
      // filters
      // this brings up google maps of RMIT location (using explicit lat and
      // long)
      // NOTE: Requires emulator with Google APIs
      // String uri = String.format(Locale.getDefault(), "geo:%f,%f",
      // -37.808111,
      // 144.963784);
      // Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
      // this.startActivity(intent);
   }

}
