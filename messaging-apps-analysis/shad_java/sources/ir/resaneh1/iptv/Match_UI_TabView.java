package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class Match_UI_TabView {
    public TextView textView;

    public View createView(Activity activity, String str, int i) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.match_cell_tab, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(str);
            this.textView.setTextColor(i);
        }
        return viewInflate;
    }

    public View refreshView(View view, String str, int i) {
        if (view == null) {
            return null;
        }
        TextView textView = (TextView) view.findViewById(R.id.textView);
        this.textView = textView;
        if (textView != null) {
            textView.setText(str);
            this.textView.setTextColor(i);
        }
        return view;
    }
}
