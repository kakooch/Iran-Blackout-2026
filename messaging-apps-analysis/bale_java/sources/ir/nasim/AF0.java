package ir.nasim;

import android.graphics.Canvas;

/* loaded from: classes2.dex */
final class AF0 {
    public static final AF0 a = new AF0();

    private AF0() {
    }

    public final void a(Canvas canvas, boolean z) {
        if (z) {
            canvas.enableZ();
        } else {
            canvas.disableZ();
        }
    }
}
