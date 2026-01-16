package ir.nasim;

import android.graphics.Path;
import android.graphics.PathMeasure;

/* renamed from: ir.nasim.rq, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20333rq implements InterfaceC18064o15 {
    private final PathMeasure a;

    public C20333rq(PathMeasure pathMeasure) {
        this.a = pathMeasure;
    }

    @Override // ir.nasim.InterfaceC18064o15
    public boolean a(float f, float f2, V05 v05, boolean z) {
        PathMeasure pathMeasure = this.a;
        if (v05 instanceof C19724qq) {
            return pathMeasure.getSegment(f, f2, ((C19724qq) v05).u(), z);
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // ir.nasim.InterfaceC18064o15
    public void b(V05 v05, boolean z) {
        Path pathU;
        PathMeasure pathMeasure = this.a;
        if (v05 == null) {
            pathU = null;
        } else {
            if (!(v05 instanceof C19724qq)) {
                throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
            }
            pathU = ((C19724qq) v05).u();
        }
        pathMeasure.setPath(pathU, z);
    }

    @Override // ir.nasim.InterfaceC18064o15
    public float getLength() {
        return this.a.getLength();
    }
}
