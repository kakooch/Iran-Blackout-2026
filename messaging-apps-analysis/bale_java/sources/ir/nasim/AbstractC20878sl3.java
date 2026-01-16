package ir.nasim;

import android.graphics.Color;
import android.graphics.PointF;
import ir.nasim.AbstractC11911dl3;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.sl3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC20878sl3 {
    private static final AbstractC11911dl3.a a = AbstractC11911dl3.a.a("x", "y");

    /* renamed from: ir.nasim.sl3$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[AbstractC11911dl3.b.values().length];
            a = iArr;
            try {
                iArr[AbstractC11911dl3.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[AbstractC11911dl3.b.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[AbstractC11911dl3.b.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(AbstractC11911dl3 abstractC11911dl3, float f) {
        abstractC11911dl3.b();
        float fF1 = (float) abstractC11911dl3.f1();
        float fF12 = (float) abstractC11911dl3.f1();
        while (abstractC11911dl3.j() != AbstractC11911dl3.b.END_ARRAY) {
            abstractC11911dl3.R();
        }
        abstractC11911dl3.c();
        return new PointF(fF1 * f, fF12 * f);
    }

    private static PointF b(AbstractC11911dl3 abstractC11911dl3, float f) {
        float fF1 = (float) abstractC11911dl3.f1();
        float fF12 = (float) abstractC11911dl3.f1();
        while (abstractC11911dl3.d()) {
            abstractC11911dl3.R();
        }
        return new PointF(fF1 * f, fF12 * f);
    }

    private static PointF c(AbstractC11911dl3 abstractC11911dl3, float f) {
        abstractC11911dl3.B();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (abstractC11911dl3.d()) {
            int iL = abstractC11911dl3.l(a);
            if (iL == 0) {
                fG = g(abstractC11911dl3);
            } else if (iL != 1) {
                abstractC11911dl3.m();
                abstractC11911dl3.R();
            } else {
                fG2 = g(abstractC11911dl3);
            }
        }
        abstractC11911dl3.F();
        return new PointF(fG * f, fG2 * f);
    }

    static int d(AbstractC11911dl3 abstractC11911dl3) {
        abstractC11911dl3.b();
        int iF1 = (int) (abstractC11911dl3.f1() * 255.0d);
        int iF12 = (int) (abstractC11911dl3.f1() * 255.0d);
        int iF13 = (int) (abstractC11911dl3.f1() * 255.0d);
        while (abstractC11911dl3.d()) {
            abstractC11911dl3.R();
        }
        abstractC11911dl3.c();
        return Color.argb(255, iF1, iF12, iF13);
    }

    static PointF e(AbstractC11911dl3 abstractC11911dl3, float f) {
        int i = a.a[abstractC11911dl3.j().ordinal()];
        if (i == 1) {
            return b(abstractC11911dl3, f);
        }
        if (i == 2) {
            return a(abstractC11911dl3, f);
        }
        if (i == 3) {
            return c(abstractC11911dl3, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + abstractC11911dl3.j());
    }

    static List f(AbstractC11911dl3 abstractC11911dl3, float f) {
        ArrayList arrayList = new ArrayList();
        abstractC11911dl3.b();
        while (abstractC11911dl3.j() == AbstractC11911dl3.b.BEGIN_ARRAY) {
            abstractC11911dl3.b();
            arrayList.add(e(abstractC11911dl3, f));
            abstractC11911dl3.c();
        }
        abstractC11911dl3.c();
        return arrayList;
    }

    static float g(AbstractC11911dl3 abstractC11911dl3) {
        AbstractC11911dl3.b bVarJ = abstractC11911dl3.j();
        int i = a.a[bVarJ.ordinal()];
        if (i == 1) {
            return (float) abstractC11911dl3.f1();
        }
        if (i != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + bVarJ);
        }
        abstractC11911dl3.b();
        float fF1 = (float) abstractC11911dl3.f1();
        while (abstractC11911dl3.d()) {
            abstractC11911dl3.R();
        }
        abstractC11911dl3.c();
        return fF1;
    }
}
