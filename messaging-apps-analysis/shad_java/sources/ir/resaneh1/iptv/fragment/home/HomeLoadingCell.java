package ir.resaneh1.iptv.fragment.home;

import android.content.Context;
import android.widget.FrameLayout;
import org.rbmain.messenger.AndroidUtilities;
import org.rbmain.ui.Components.LayoutHelper;
import org.rbmain.ui.Components.RadialProgressView;

/* loaded from: classes3.dex */
public class HomeLoadingCell extends FrameLayout {
    private RadialProgressView progressBar;

    public HomeLoadingCell(Context context, int i) {
        super(context);
        RadialProgressView radialProgressView = new RadialProgressView(context);
        this.progressBar = radialProgressView;
        radialProgressView.setSize(AndroidUtilities.dp(i));
        addView(this.progressBar, LayoutHelper.createFrame(-2, -2, 17));
        setLayoutParams(LayoutHelper.createFrame(56, -1.0f));
    }

    public void setProgressBarColor(int i) {
        this.progressBar.setProgressColor(i);
    }
}
