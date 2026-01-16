package ir.nasim;

/* loaded from: classes.dex */
public abstract class N46 {
    private static final M46 a = b(50);

    public static final M46 a(float f) {
        return c(AbstractC10554bo1.a(f));
    }

    public static final M46 b(int i) {
        return c(AbstractC10554bo1.b(i));
    }

    public static final M46 c(InterfaceC9934ao1 interfaceC9934ao1) {
        return new M46(interfaceC9934ao1, interfaceC9934ao1, interfaceC9934ao1, interfaceC9934ao1);
    }

    public static final M46 d(float f) {
        return c(AbstractC10554bo1.c(f));
    }

    public static final M46 e(float f, float f2, float f3, float f4) {
        return new M46(AbstractC10554bo1.c(f), AbstractC10554bo1.c(f2), AbstractC10554bo1.c(f3), AbstractC10554bo1.c(f4));
    }

    public static /* synthetic */ M46 f(float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = C17784nZ1.q(0);
        }
        if ((i & 2) != 0) {
            f2 = C17784nZ1.q(0);
        }
        if ((i & 4) != 0) {
            f3 = C17784nZ1.q(0);
        }
        if ((i & 8) != 0) {
            f4 = C17784nZ1.q(0);
        }
        return e(f, f2, f3, f4);
    }

    public static final M46 g() {
        return a;
    }
}
