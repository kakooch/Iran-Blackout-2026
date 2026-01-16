package ir.resaneh1.iptv.UIView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UILinearLayout {
    public LinearLayout linearLayout;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.ui_linearlayout, (ViewGroup) null);
        this.view = viewInflate;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linearLayout);
        this.linearLayout = linearLayout;
        linearLayout.setBackground(activity.getResources().getDrawable(R.drawable.transparent));
        this.view.setBackground(activity.getResources().getDrawable(R.drawable.transparent));
        return this.view;
    }
}
