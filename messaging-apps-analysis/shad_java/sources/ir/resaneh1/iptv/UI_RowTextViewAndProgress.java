package ir.resaneh1.iptv;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.medu.shad.R;
import org.rbmain.messenger.ApplicationLoader;

/* loaded from: classes3.dex */
public class UI_RowTextViewAndProgress {
    public View progressBar;
    public TextView textView;
    public View view;

    public View createView(Activity activity) {
        View viewInflate = activity.getLayoutInflater().inflate(R.layout.row_text_view_and_progressbar, (ViewGroup) null);
        this.view = viewInflate;
        this.textView = (TextView) viewInflate.findViewById(R.id.textView);
        this.progressBar = this.view.findViewById(R.id.progressBarContainer);
        UIProgressBarNewStyle.addToFrame(ApplicationLoader.applicationActivity, (FrameLayout) this.progressBar, 24);
        return this.view;
    }
}
