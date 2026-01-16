package ir.resaneh1.iptv.toolbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import ir.medu.shad.R;

/* loaded from: classes4.dex */
public class ToolbarProgressBar {
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.toolbar_progress, (ViewGroup) null);
        this.view = viewInflate;
        return this.view;
    }
}
