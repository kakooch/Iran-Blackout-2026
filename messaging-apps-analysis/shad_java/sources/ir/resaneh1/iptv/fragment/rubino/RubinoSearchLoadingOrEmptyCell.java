package ir.resaneh1.iptv.fragment.rubino;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;
import ir.resaneh1.iptv.fragment.rubino.RubinoLoadingCell;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.ActionBar.Theme;
import org.rbmain.ui.Components.LayoutHelper;

/* loaded from: classes3.dex */
public class RubinoSearchLoadingOrEmptyCell extends FrameLayout {
    public boolean isEmptyView;
    public FrameLayout loadingView;
    public Context mContext;
    public TextView textView;

    public RubinoSearchLoadingOrEmptyCell(Context context, boolean z) {
        int i;
        super(context);
        this.mContext = context;
        this.isEmptyView = z;
        this.textView = new TextView(context);
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        this.loadingView = frameLayout;
        addView(frameLayout, LayoutHelper.createFrame(20, 20.0f, 21, 16.0f, 30.0f, 24.0f, 30.0f));
        RubinoLoadingCell.ProgressView progressView = new RubinoLoadingCell.ProgressView(this.mContext);
        progressView.setSize(AndroidUtilities.dp(20.0f));
        this.loadingView.addView(progressView);
        if (z) {
            i = 0;
            this.loadingView.setVisibility(8);
            this.textView.setTextSize(2, 15.0f);
            this.textView.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        } else {
            i = 60;
            this.textView.setTextSize(2, 14.0f);
            this.textView.setTextColor(Theme.getColor(Theme.key_rubinoGrayColor));
        }
        this.textView.setTypeface(Theme.getRubinoTypeFaceBold());
        this.textView.setPadding(AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f), AndroidUtilities.dp(8.0f));
        addView(this.textView, LayoutHelper.createFrame(-1, -2.0f, 21, 8.0f, 8.0f, i + 8, 8.0f));
    }

    public void setText(String str) {
        this.textView.setText(str);
        if (this.isEmptyView) {
            this.loadingView.setVisibility(8);
        } else if (str.isEmpty()) {
            this.loadingView.setVisibility(8);
        } else {
            this.loadingView.setVisibility(0);
        }
    }
}
