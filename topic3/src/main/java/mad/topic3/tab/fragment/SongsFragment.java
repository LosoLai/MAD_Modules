package mad.topic3.tab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SongsFragment extends Fragment
{
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState)
   {
      TextView textview = new TextView(this.getActivity());
      textview.setText("This is the Songs tab");
      return textview;
   }
}
