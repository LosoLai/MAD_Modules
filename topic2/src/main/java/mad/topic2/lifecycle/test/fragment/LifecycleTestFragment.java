package mad.topic2.lifecycle.test.fragment;

import mad.topic2.R;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class LifecycleTestFragment extends Fragment
{
   private String LOG_TAG = this.getClass().getName();

   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreate()");
      super.onCreate(savedInstanceState);
   }

   /** Called when the fragment is first created. */
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState)
   {
      Log.i(LOG_TAG, "onCreateView()");
      View view = inflater.inflate(R.layout.life_cycle_test_fragment,
            container, false);

      View button = view.findViewById(R.id.next_activity_button);
      button.setOnClickListener(new OnClickListener() {

         public void onClick(View v)
         {
            nextActivity(v);
         }
      });

      return view;
   }

   public void nextActivity(View view)
   {
      Log.i(LOG_TAG, "nextActivity()");
      Intent myIntent = new Intent(getActivity(), NextActivity.class);
      startActivity(myIntent);
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
}