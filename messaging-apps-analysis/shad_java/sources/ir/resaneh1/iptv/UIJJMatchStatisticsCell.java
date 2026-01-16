package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import ir.resaneh1.iptv.helper.NumberUtils;

/* loaded from: classes3.dex */
public class UIJJMatchStatisticsCell {
    public FrameLayout frameLayout1;
    public FrameLayout frameLayout2;
    public TextView textView1;
    public TextView textView2;
    public View view;

    public View createView(Activity activity, String str, float f) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.jj_match_statistics_cell, (ViewGroup) null);
        this.textView1 = (TextView) viewInflate.findViewById(R.id.textView1);
        this.textView2 = (TextView) viewInflate.findViewById(R.id.textView2);
        this.frameLayout1 = (FrameLayout) viewInflate.findViewById(R.id.frameLayout1);
        this.frameLayout2 = (FrameLayout) viewInflate.findViewById(R.id.frameLayout2);
        this.textView2.setText(str);
        this.textView1.setText(NumberUtils.toPersian(f + "%"));
        ((LinearLayout.LayoutParams) this.frameLayout1.getLayoutParams()).weight = 100.0f - f;
        ((LinearLayout.LayoutParams) this.frameLayout2.getLayoutParams()).weight = f;
        this.view = viewInflate;
        return viewInflate;
    }
}
