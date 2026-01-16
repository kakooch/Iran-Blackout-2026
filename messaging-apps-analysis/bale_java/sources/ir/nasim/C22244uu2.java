package ir.nasim;

/* renamed from: ir.nasim.uu2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22244uu2 {
    public static final C22244uu2 a;
    private static final float[] b;
    private static volatile C19409qI6 c;
    private static final Object[] d;
    public static final int e;

    static {
        C22244uu2 c22244uu2 = new C22244uu2();
        a = c22244uu2;
        b = new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f};
        c = new C19409qI6(0, 1, null);
        Object[] objArr = new Object[0];
        d = objArr;
        synchronized (objArr) {
            c22244uu2.h(c, 1.15f, new C22840vu2(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{9.2f, 11.5f, 13.8f, 16.4f, 19.8f, 21.8f, 25.2f, 30.0f, 100.0f}));
            c22244uu2.h(c, 1.3f, new C22840vu2(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{10.4f, 13.0f, 15.6f, 18.8f, 21.6f, 23.6f, 26.4f, 30.0f, 100.0f}));
            c22244uu2.h(c, 1.5f, new C22840vu2(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{12.0f, 15.0f, 18.0f, 22.0f, 24.0f, 26.0f, 28.0f, 30.0f, 100.0f}));
            c22244uu2.h(c, 1.8f, new C22840vu2(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{14.4f, 18.0f, 21.6f, 24.4f, 27.6f, 30.8f, 32.8f, 34.8f, 100.0f}));
            c22244uu2.h(c, 2.0f, new C22840vu2(new float[]{8.0f, 10.0f, 12.0f, 14.0f, 18.0f, 20.0f, 24.0f, 30.0f, 100.0f}, new float[]{16.0f, 20.0f, 24.0f, 26.0f, 30.0f, 34.0f, 36.0f, 38.0f, 100.0f}));
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
        if (!(c22244uu2.e(c.k(0)) - 0.01f > 1.03f)) {
            O73.b("You should only apply non-linear scaling to font scales > 1");
        }
        e = 8;
    }

    private C22244uu2() {
    }

    private final InterfaceC21654tu2 a(InterfaceC21654tu2 interfaceC21654tu2, InterfaceC21654tu2 interfaceC21654tu22, float f) {
        float[] fArr = b;
        float[] fArr2 = new float[fArr.length];
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            float f2 = b[i];
            fArr2[i] = C24960zV3.a.b(interfaceC21654tu2.b(f2), interfaceC21654tu22.b(f2), f);
        }
        return new C22840vu2(b, fArr2);
    }

    private final InterfaceC21654tu2 c(float f) {
        return (InterfaceC21654tu2) c.f(d(f));
    }

    private final int d(float f) {
        return (int) (f * 100.0f);
    }

    private final float e(int i) {
        return i / 100.0f;
    }

    private final void g(float f, InterfaceC21654tu2 interfaceC21654tu2) {
        synchronized (d) {
            C19409qI6 c19409qI6Clone = c.clone();
            a.h(c19409qI6Clone, f, interfaceC21654tu2);
            c = c19409qI6Clone;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    private final void h(C19409qI6 c19409qI6, float f, InterfaceC21654tu2 interfaceC21654tu2) {
        c19409qI6.l(d(f), interfaceC21654tu2);
    }

    public final InterfaceC21654tu2 b(float f) {
        InterfaceC21654tu2 c22840vu2;
        if (!f(f)) {
            return null;
        }
        InterfaceC21654tu2 interfaceC21654tu2C = a.c(f);
        if (interfaceC21654tu2C != null) {
            return interfaceC21654tu2C;
        }
        int iH = c.h(d(f));
        if (iH >= 0) {
            return (InterfaceC21654tu2) c.p(iH);
        }
        int i = -(iH + 1);
        int i2 = i - 1;
        float fE = 1.0f;
        if (i >= c.o()) {
            C22840vu2 c22840vu22 = new C22840vu2(new float[]{1.0f}, new float[]{f});
            g(f, c22840vu22);
            return c22840vu22;
        }
        if (i2 < 0) {
            float[] fArr = b;
            c22840vu2 = new C22840vu2(fArr, fArr);
        } else {
            fE = e(c.k(i2));
            c22840vu2 = (InterfaceC21654tu2) c.p(i2);
        }
        InterfaceC21654tu2 interfaceC21654tu2A = a(c22840vu2, (InterfaceC21654tu2) c.p(i), C24960zV3.a.a(0.0f, 1.0f, fE, e(c.k(i)), f));
        g(f, interfaceC21654tu2A);
        return interfaceC21654tu2A;
    }

    public final boolean f(float f) {
        return f >= 1.03f;
    }
}
