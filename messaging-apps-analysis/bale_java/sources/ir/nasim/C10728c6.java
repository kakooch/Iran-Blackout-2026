package ir.nasim;

import android.app.Activity;
import android.graphics.Rect;

/* renamed from: ir.nasim.c6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C10728c6 {
    public static final C10728c6 a = new C10728c6();

    private C10728c6() {
    }

    public final Rect a(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        Rect bounds = activity.getWindowManager().getCurrentWindowMetrics().getBounds();
        AbstractC13042fc3.h(bounds, "activity.windowManager.currentWindowMetrics.bounds");
        return bounds;
    }
}
