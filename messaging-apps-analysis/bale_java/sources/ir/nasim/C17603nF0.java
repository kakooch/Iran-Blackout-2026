package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;

/* renamed from: ir.nasim.nF0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C17603nF0 {
    public static final C17603nF0 a = new C17603nF0();

    private C17603nF0() {
    }

    public final boolean a(Canvas canvas, float f, float f2, float f3, float f4) {
        return canvas.quickReject(f, f2, f3, f4);
    }

    public final boolean b(Canvas canvas, Path path) {
        return canvas.quickReject(path);
    }

    public final boolean c(Canvas canvas, RectF rectF) {
        return canvas.quickReject(rectF);
    }
}
