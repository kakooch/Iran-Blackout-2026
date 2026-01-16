package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import ir.medu.shad.R;

/* loaded from: classes3.dex */
public class UIRowCardView {
    public LinearLayout linearLayout;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.row_card_view, (ViewGroup) null);
        this.view = viewInflate;
        this.linearLayout = (LinearLayout) viewInflate.findViewById(R.id.linearLayout);
        return this.view;
    }
}
