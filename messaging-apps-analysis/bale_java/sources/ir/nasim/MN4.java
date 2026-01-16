package ir.nasim;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;

/* loaded from: classes8.dex */
public final class MN4 extends V1 {
    private float h;
    private float i;

    public MN4() {
        super("OvalShape");
    }

    private final Path r() {
        RectF rectF = new RectF(g(), k(), i(), e());
        Path path = new Path();
        path.moveTo(g(), k());
        path.addOval(rectF, Path.Direction.CW);
        path.close();
        return path;
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void a(float f, float f2) {
        p(f);
        m(f2);
        float fAbs = Math.abs(f - this.h);
        float fAbs2 = Math.abs(f2 - this.i);
        if (fAbs >= 4.0f || fAbs2 >= 4.0f) {
            o(r());
            this.h = f;
            this.i = f2;
        }
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void b(float f, float f2) {
        Log.d(j(), "startShape@ " + f + ',' + f2);
        n(f);
        q(f2);
    }

    @Override // ir.nasim.InterfaceC9428Zw6
    public void c() {
        Log.d(j(), "stopShape");
    }
}
