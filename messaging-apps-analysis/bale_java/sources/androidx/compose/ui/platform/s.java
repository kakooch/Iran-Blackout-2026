package androidx.compose.ui.platform;

import android.view.MotionEvent;

/* loaded from: classes2.dex */
final class s {
    public static final s a = new s();

    private s() {
    }

    public final boolean a(MotionEvent motionEvent, int i) {
        return (Float.floatToRawIntBits(motionEvent.getRawX(i)) & Integer.MAX_VALUE) < 2139095040 && (Float.floatToRawIntBits(motionEvent.getRawY(i)) & Integer.MAX_VALUE) < 2139095040;
    }
}
