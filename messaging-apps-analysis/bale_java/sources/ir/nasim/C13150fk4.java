package ir.nasim;

import android.view.MotionEvent;

/* renamed from: ir.nasim.fk4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C13150fk4 {
    public static final C13150fk4 a = new C13150fk4();

    private C13150fk4() {
    }

    public final long a(MotionEvent motionEvent, int i) {
        float rawX = motionEvent.getRawX(i);
        float rawY = motionEvent.getRawY(i);
        return ZG4.e((Float.floatToRawIntBits(rawY) & 4294967295L) | (Float.floatToRawIntBits(rawX) << 32));
    }
}
