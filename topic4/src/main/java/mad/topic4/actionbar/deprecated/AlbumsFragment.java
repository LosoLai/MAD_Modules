package mad.topic4.actionbar.deprecated;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AlbumsFragment extends Fragment
{
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
         Bundle savedInstanceState)
   {
      TextView textview = new TextView(this.getActivity());
      textview.setText("This is the default tab");
      return textview;
   }
}
