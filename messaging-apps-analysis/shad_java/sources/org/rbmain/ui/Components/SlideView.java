package org.rbmain.ui.Components;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import io.github.inflationx.calligraphy3.BuildConfig;

/* loaded from: classes5.dex */
public class SlideView extends LinearLayout {
    public String getHeaderName() {
        return BuildConfig.FLAVOR;
    }

    public boolean needBackButton() {
        return false;
    }

    public boolean onBackPressed(boolean z) {
        return true;
    }

    public void onCancelPressed() {
    }

    public void onDestroyActivity() {
    }

    public void onNextPressed() {
    }

    public void onShow() {
    }

    public void restoreStateParams(Bundle bundle) {
    }

    public void saveStateParams(Bundle bundle) {
    }

    public void setParams(Bundle bundle, boolean z) {
    }

    public SlideView(Context context) {
        super(context);
    }
}
