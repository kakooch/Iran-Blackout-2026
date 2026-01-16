package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UILinearLayoutScrollable {
    public LinearLayout linearLayout;
    public View view;

    public View createView(Activity activity, boolean z) {
        if (z) {
            this.view = activity.getLayoutInflater().inflate(R.layout.ui_linearlayout_scrollable_horizontally, (ViewGroup) null);
        } else {
            this.view = activity.getLayoutInflater().inflate(R.layout.ui_linearlayout_scrollable_vertically, (ViewGroup) null);
        }
        this.linearLayout = (LinearLayout) this.view.findViewById(R.id.linearLayout);
        this.view.setBackground(activity.getResources().getDrawable(R.drawable.transparent));
        this.linearLayout.setBackground(activity.getResources().getDrawable(R.drawable.transparent));
        return this.view;
    }
}
