package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIMatchPointRow {
    public TextView textView2;
    public TextView textView3;
    public TextView textview1;
    public View view;

    public View createView(Activity activity, String str, String str2, String str3) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_match_point_row, (ViewGroup) null);
        this.textview1 = (TextView) viewInflate.findViewById(R.id.textViewRight);
        this.textView2 = (TextView) viewInflate.findViewById(R.id.textViewCenter);
        this.textView3 = (TextView) viewInflate.findViewById(R.id.textViewLeft);
        this.textview1.setText(str);
        this.textView2.setText(str2);
        this.textView3.setText(str3);
        this.view = viewInflate;
        return viewInflate;
    }
}
