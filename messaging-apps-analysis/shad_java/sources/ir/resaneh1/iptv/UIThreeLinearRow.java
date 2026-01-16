package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIThreeLinearRow {
    public LinearLayout linearLayout1;
    public LinearLayout linearLayout2;
    public LinearLayout linearLayout3;
    public View view;

    public View createView(Activity activity, View view, View view2, View view3) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.three_linear_row, (ViewGroup) null);
        this.linearLayout1 = (LinearLayout) viewInflate.findViewById(R.id.linearLayout1);
        this.linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.linearLayout2);
        this.linearLayout3 = (LinearLayout) viewInflate.findViewById(R.id.linearLayout3);
        if (view != null) {
            this.linearLayout1.addView(view);
        }
        if (view2 != null) {
            this.linearLayout2.addView(view2);
        }
        if (view3 != null) {
            this.linearLayout3.addView(view3);
        }
        this.view = viewInflate;
        return viewInflate;
    }
}
