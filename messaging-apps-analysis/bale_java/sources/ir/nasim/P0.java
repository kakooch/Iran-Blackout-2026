package ir.nasim;

import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
public abstract class P0 {
    private final C3988Df0 a;
    private final FE2 b;

    P0(C3988Df0 c3988Df0) {
        this.a = c3988Df0;
        this.b = new FE2(c3988Df0);
    }

    public static P0 a(C3988Df0 c3988Df0) {
        if (c3988Df0.i(1)) {
            return new D(c3988Df0);
        }
        if (!c3988Df0.i(2)) {
            return new C15637jv(c3988Df0);
        }
        int iG = FE2.g(c3988Df0, 1, 4);
        if (iG == 4) {
            return new C23482x(c3988Df0);
        }
        if (iG == 5) {
            return new C24072y(c3988Df0);
        }
        int iG2 = FE2.g(c3988Df0, 1, 5);
        if (iG2 == 12) {
            return new C24662z(c3988Df0);
        }
        if (iG2 == 13) {
            return new A(c3988Df0);
        }
        switch (FE2.g(c3988Df0, 1, 7)) {
            case Type.NINFO /* 56 */:
                return new B(c3988Df0, "310", "11");
            case 57:
                return new B(c3988Df0, "320", "11");
            case 58:
                return new B(c3988Df0, "310", "13");
            case 59:
                return new B(c3988Df0, "320", "13");
            case 60:
                return new B(c3988Df0, "310", "15");
            case 61:
                return new B(c3988Df0, "320", "15");
            case 62:
                return new B(c3988Df0, "310", "17");
            case 63:
                return new B(c3988Df0, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(c3988Df0)));
        }
    }

    protected final FE2 b() {
        return this.b;
    }

    protected final C3988Df0 c() {
        return this.a;
    }

    public abstract String d();
}
