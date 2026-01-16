package ir.nasim;

import android.window.BackEvent;

/* renamed from: ir.nasim.sv, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C20974sv {
    public static final C20974sv a = new C20974sv();

    private C20974sv() {
    }

    public final BackEvent a(float f, float f2, float f3, int i) {
        return new BackEvent(f, f2, f3, i);
    }

    public final float b(BackEvent backEvent) {
        AbstractC13042fc3.i(backEvent, "backEvent");
        return backEvent.getProgress();
    }

    public final int c(BackEvent backEvent) {
        AbstractC13042fc3.i(backEvent, "backEvent");
        return backEvent.getSwipeEdge();
    }

    public final float d(BackEvent backEvent) {
        AbstractC13042fc3.i(backEvent, "backEvent");
        return backEvent.getTouchX();
    }

    public final float e(BackEvent backEvent) {
        AbstractC13042fc3.i(backEvent, "backEvent");
        return backEvent.getTouchY();
    }
}
