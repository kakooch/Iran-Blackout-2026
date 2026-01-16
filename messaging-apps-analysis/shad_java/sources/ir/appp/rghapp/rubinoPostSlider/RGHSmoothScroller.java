package ir.appp.rghapp.rubinoPostSlider;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;
import org.rbmain.messenger.AndroidUtilities;

/* loaded from: classes3.dex */
public class RGHSmoothScroller extends LinearSmoothScroller {
    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected int getVerticalSnapPreference() {
        return -1;
    }

    public RGHSmoothScroller(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 66.0f / displayMetrics.densityDpi;
    }

    public long estimateAnimationDuration() {
        DisplayMetrics displayMetrics = AndroidUtilities.displayMetrics;
        return (long) ((displayMetrics.widthPixels * (66.0f / displayMetrics.densityDpi)) + 300.0f);
    }
}
