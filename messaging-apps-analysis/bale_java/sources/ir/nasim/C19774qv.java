package ir.nasim;

import android.view.accessibility.AccessibilityManager;

/* renamed from: ir.nasim.qv, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C19774qv {
    public static final C19774qv a = new C19774qv();

    private C19774qv() {
    }

    public final int a(AccessibilityManager accessibilityManager, int i, int i2) {
        return accessibilityManager.getRecommendedTimeoutMillis(i, i2);
    }
}
