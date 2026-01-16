package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

/* renamed from: ir.nasim.il0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14948il0 extends V1 {
    public C14948il0() {
        super("BrushShape");
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void a(float f, float f2) {
        float fAbs = Math.abs(f - g());
        float fAbs2 = Math.abs(f2 - k());
        if (fAbs >= 4.0f || fAbs2 >= 4.0f) {
            float f3 = 2;
            h().quadTo(g(), k(), (g() + f) / f3, (k() + f2) / f3);
            n(f);
            q(f2);
        }
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void b(float f, float f2) {
        Log.d(j(), "startShape@ " + f + ',' + f2);
        h().moveTo(f, f2);
        n(f);
        q(f2);
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void c() {
        Log.d(j(), "stopShape");
    }

    @Override // ir.nasim.V1
    public void d(Canvas canvas, Paint paint) {
        AbstractC13042fc3.i(canvas, "canvas");
        AbstractC13042fc3.i(paint, "paint");
        canvas.drawPath(h(), paint);
    }
}
