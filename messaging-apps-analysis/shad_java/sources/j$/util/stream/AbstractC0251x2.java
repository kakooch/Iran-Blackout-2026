package j$.util.stream;

import org.rbmain.messenger.LiteMode;

/* renamed from: j$.util.stream.x2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC0251x2 {
    private static final A1 a = new Z1(null);
    private static final InterfaceC0245w1 b = new X1();
    private static final InterfaceC0255y1 c = new Y1();
    private static final InterfaceC0235u1 d = new W1();
    private static final int[] e = new int[0];
    private static final long[] f = new long[0];
    private static final double[] g = new double[0];

    static InterfaceC0225s1 d(long j, j$.util.function.m mVar) {
        return (j < 0 || j >= 2147483639) ? new C0231t2() : new C0125b2(j, mVar);
    }

    public static A1 e(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z, j$.util.function.m mVar) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 < 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            A1 a1 = (A1) new H1(abstractC0256y2, mVar, tVar).invoke();
            return z ? l(a1, mVar) : a1;
        }
        if (jR0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) mVar.apply((int) jR0);
        new C0220r2(tVar, abstractC0256y2, objArr).invoke();
        return new D1(objArr);
    }

    public static InterfaceC0235u1 f(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 < 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            InterfaceC0235u1 interfaceC0235u1 = (InterfaceC0235u1) new H1(abstractC0256y2, tVar, 0).invoke();
            return z ? m(interfaceC0235u1) : interfaceC0235u1;
        }
        if (jR0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jR0];
        new C0203o2(tVar, abstractC0256y2, dArr).invoke();
        return new T1(dArr);
    }

    public static InterfaceC0245w1 g(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 < 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            InterfaceC0245w1 interfaceC0245w1 = (InterfaceC0245w1) new H1(abstractC0256y2, tVar, 1).invoke();
            return z ? n(interfaceC0245w1) : interfaceC0245w1;
        }
        if (jR0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jR0];
        new C0209p2(tVar, abstractC0256y2, iArr).invoke();
        return new C0131c2(iArr);
    }

    public static InterfaceC0255y1 h(AbstractC0256y2 abstractC0256y2, j$.util.t tVar, boolean z) {
        long jR0 = abstractC0256y2.r0(tVar);
        if (jR0 < 0 || !tVar.hasCharacteristics(LiteMode.FLAG_ANIMATED_EMOJI_KEYBOARD_NOT_PREMIUM)) {
            InterfaceC0255y1 interfaceC0255y1 = (InterfaceC0255y1) new H1(abstractC0256y2, tVar, 2).invoke();
            return z ? o(interfaceC0255y1) : interfaceC0255y1;
        }
        if (jR0 >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jR0];
        new C0215q2(tVar, abstractC0256y2, jArr).invoke();
        return new C0185l2(jArr);
    }

    static A1 i(EnumC0151f4 enumC0151f4, A1 a1, A1 a12) {
        int i = B1.a[enumC0151f4.ordinal()];
        if (i == 1) {
            return new S1(a1, a12);
        }
        if (i == 2) {
            return new P1((InterfaceC0245w1) a1, (InterfaceC0245w1) a12);
        }
        if (i == 3) {
            return new Q1((InterfaceC0255y1) a1, (InterfaceC0255y1) a12);
        }
        if (i == 4) {
            return new O1((InterfaceC0235u1) a1, (InterfaceC0235u1) a12);
        }
        throw new IllegalStateException("Unknown shape " + enumC0151f4);
    }

    static InterfaceC0208p1 j(long j) {
        return (j < 0 || j >= 2147483639) ? new V1() : new U1(j);
    }

    static A1 k(EnumC0151f4 enumC0151f4) {
        int i = B1.a[enumC0151f4.ordinal()];
        if (i == 1) {
            return a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        if (i == 4) {
            return d;
        }
        throw new IllegalStateException("Unknown shape " + enumC0151f4);
    }

    public static A1 l(A1 a1, j$.util.function.m mVar) {
        if (a1.q() <= 0) {
            return a1;
        }
        long jCount = a1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) mVar.apply((int) jCount);
        new C0241v2(a1, objArr, 0, (B1) null).invoke();
        return new D1(objArr);
    }

    public static InterfaceC0235u1 m(InterfaceC0235u1 interfaceC0235u1) {
        if (interfaceC0235u1.q() <= 0) {
            return interfaceC0235u1;
        }
        long jCount = interfaceC0235u1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        double[] dArr = new double[(int) jCount];
        new C0236u2(interfaceC0235u1, dArr, 0).invoke();
        return new T1(dArr);
    }

    public static InterfaceC0245w1 n(InterfaceC0245w1 interfaceC0245w1) {
        if (interfaceC0245w1.q() <= 0) {
            return interfaceC0245w1;
        }
        long jCount = interfaceC0245w1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        int[] iArr = new int[(int) jCount];
        new C0236u2(interfaceC0245w1, iArr, 0).invoke();
        return new C0131c2(iArr);
    }

    public static InterfaceC0255y1 o(InterfaceC0255y1 interfaceC0255y1) {
        if (interfaceC0255y1.q() <= 0) {
            return interfaceC0255y1;
        }
        long jCount = interfaceC0255y1.count();
        if (jCount >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        long[] jArr = new long[(int) jCount];
        new C0236u2(interfaceC0255y1, jArr, 0).invoke();
        return new C0185l2(jArr);
    }

    static InterfaceC0214q1 p(long j) {
        return (j < 0 || j >= 2147483639) ? new C0143e2() : new C0137d2(j);
    }

    static InterfaceC0219r1 q(long j) {
        return (j < 0 || j >= 2147483639) ? new C0197n2() : new C0191m2(j);
    }
}
