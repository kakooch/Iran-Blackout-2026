package ir.nasim;

import android.view.DisplayCutout;

/* renamed from: ir.nasim.pV1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18930pV1 {
    public static final C18930pV1 a = new C18930pV1();

    private C18930pV1() {
    }

    public final int a(DisplayCutout displayCutout) {
        AbstractC13042fc3.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        AbstractC13042fc3.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        AbstractC13042fc3.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        AbstractC13042fc3.i(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
