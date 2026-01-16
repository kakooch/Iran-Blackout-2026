package ir.nasim;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import ir.nasim.AbstractC11911dl3;
import java.lang.ref.WeakReference;

/* renamed from: ir.nasim.Bp3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC3613Bp3 {
    private static C19409qI6 b;
    private static final Interpolator a = new LinearInterpolator();
    static AbstractC11911dl3.a c = AbstractC11911dl3.a.a("t", "s", "e", "o", "i", "h", "to", "ti");
    static AbstractC11911dl3.a d = AbstractC11911dl3.a.a("x", "y");

    private static WeakReference a(int i) {
        WeakReference weakReference;
        synchronized (AbstractC3613Bp3.class) {
            weakReference = (WeakReference) g().f(i);
        }
        return weakReference;
    }

    private static Interpolator b(PointF pointF, PointF pointF2) {
        Interpolator interpolatorA;
        pointF.x = AbstractC7323Rf4.b(pointF.x, -1.0f, 1.0f);
        pointF.y = AbstractC7323Rf4.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = AbstractC7323Rf4.b(pointF2.x, -1.0f, 1.0f);
        float fB = AbstractC7323Rf4.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        int i = AbstractC16500lN7.i(pointF.x, pointF.y, pointF2.x, fB);
        WeakReference weakReferenceA = AbstractC6219Mr3.e() ? null : a(i);
        Interpolator interpolator = weakReferenceA != null ? (Interpolator) weakReferenceA.get() : null;
        if (weakReferenceA == null || interpolator == null) {
            try {
                interpolatorA = AbstractC15109j15.a(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                interpolatorA = "The Path cannot loop back on itself.".equals(e.getMessage()) ? AbstractC15109j15.a(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
            }
            interpolator = interpolatorA;
            if (!AbstractC6219Mr3.e()) {
                try {
                    h(i, new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    static C24561yp3 c(AbstractC11911dl3 abstractC11911dl3, C23677xK3 c23677xK3, float f, BQ7 bq7, boolean z, boolean z2) {
        return (z && z2) ? e(c23677xK3, abstractC11911dl3, f, bq7) : z ? d(c23677xK3, abstractC11911dl3, f, bq7) : f(abstractC11911dl3, f, bq7);
    }

    private static C24561yp3 d(C23677xK3 c23677xK3, AbstractC11911dl3 abstractC11911dl3, float f, BQ7 bq7) {
        Interpolator interpolatorB;
        Object obj;
        abstractC11911dl3.B();
        PointF pointFE = null;
        Object objA = null;
        Object objA2 = null;
        PointF pointFE2 = null;
        PointF pointFE3 = null;
        float fF1 = 0.0f;
        boolean z = false;
        PointF pointFE4 = null;
        while (abstractC11911dl3.d()) {
            switch (abstractC11911dl3.l(c)) {
                case 0:
                    fF1 = (float) abstractC11911dl3.f1();
                    break;
                case 1:
                    objA2 = bq7.a(abstractC11911dl3, f);
                    break;
                case 2:
                    objA = bq7.a(abstractC11911dl3, f);
                    break;
                case 3:
                    pointFE = AbstractC20878sl3.e(abstractC11911dl3, 1.0f);
                    break;
                case 4:
                    pointFE4 = AbstractC20878sl3.e(abstractC11911dl3, 1.0f);
                    break;
                case 5:
                    if (abstractC11911dl3.r0() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                case 6:
                    pointFE2 = AbstractC20878sl3.e(abstractC11911dl3, f);
                    break;
                case 7:
                    pointFE3 = AbstractC20878sl3.e(abstractC11911dl3, f);
                    break;
                default:
                    abstractC11911dl3.R();
                    break;
            }
        }
        abstractC11911dl3.F();
        if (z) {
            interpolatorB = a;
            obj = objA2;
        } else {
            interpolatorB = (pointFE == null || pointFE4 == null) ? a : b(pointFE, pointFE4);
            obj = objA;
        }
        C24561yp3 c24561yp3 = new C24561yp3(c23677xK3, objA2, obj, interpolatorB, fF1, null);
        c24561yp3.o = pointFE2;
        c24561yp3.p = pointFE3;
        return c24561yp3;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static ir.nasim.C24561yp3 e(ir.nasim.C23677xK3 r21, ir.nasim.AbstractC11911dl3 r22, float r23, ir.nasim.BQ7 r24) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC3613Bp3.e(ir.nasim.xK3, ir.nasim.dl3, float, ir.nasim.BQ7):ir.nasim.yp3");
    }

    private static C24561yp3 f(AbstractC11911dl3 abstractC11911dl3, float f, BQ7 bq7) {
        return new C24561yp3(bq7.a(abstractC11911dl3, f));
    }

    private static C19409qI6 g() {
        if (b == null) {
            b = new C19409qI6();
        }
        return b;
    }

    private static void h(int i, WeakReference weakReference) {
        synchronized (AbstractC3613Bp3.class) {
            b.l(i, weakReference);
        }
    }
}
