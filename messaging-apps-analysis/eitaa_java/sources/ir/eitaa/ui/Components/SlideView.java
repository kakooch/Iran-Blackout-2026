package ir.eitaa.ui.Components;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

/* loaded from: classes3.dex */
public class SlideView extends LinearLayout {
    public String getHeaderName() {
        return "";
    }

    public boolean needBackButton() {
        return false;
    }

    public boolean onBackPressed(boolean force) {
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

    public void setParams(Bundle params, boolean restore) {
    }

    public SlideView(Context context) {
        super(context);
    }
}
