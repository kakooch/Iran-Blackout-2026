package ir.nasim;

/* loaded from: classes2.dex */
public final class LY0 {
    private static final C13920h26 A;
    private static final AbstractC9775aY0 B;
    private static final AbstractC9775aY0[] C;
    public static final LY0 a = new LY0();
    private static final float[] b;
    private static final float[] c;
    private static final float[] d;
    private static final C3662Bu7 e;
    private static final C3662Bu7 f;
    private static final C3662Bu7 g;
    private static final C3662Bu7 h;
    private static final C13920h26 i;
    private static final C13920h26 j;
    private static final C13920h26 k;
    private static final C13920h26 l;
    private static final C13920h26 m;
    private static final C13920h26 n;
    private static final C13920h26 o;
    private static final C13920h26 p;
    private static final C13920h26 q;
    private static final C13920h26 r;
    private static final C13920h26 s;
    private static final C13920h26 t;
    private static final C13920h26 u;
    private static final C13920h26 v;
    private static final AbstractC9775aY0 w;
    private static final AbstractC9775aY0 x;
    private static final C13920h26 y;
    private static final C13920h26 z;

    static {
        float[] fArr = {0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f};
        b = fArr;
        float[] fArr2 = {0.67f, 0.33f, 0.21f, 0.71f, 0.14f, 0.08f};
        c = fArr2;
        float[] fArr3 = {0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f};
        d = fArr3;
        C3662Bu7 c3662Bu7 = new C3662Bu7(2.4d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        e = c3662Bu7;
        C3662Bu7 c3662Bu72 = new C3662Bu7(2.2d, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 0.0d, 0.0d, 96, null);
        f = c3662Bu72;
        C3662Bu7 c3662Bu73 = new C3662Bu7(-3.0d, 2.0d, 2.0d, 5.591816309728916d, 0.28466892d, 0.55991073d, -0.685490157d);
        g = c3662Bu73;
        C3662Bu7 c3662Bu74 = new C3662Bu7(-2.0d, -1.555223d, 1.860454d, 0.012683313515655966d, 18.8515625d, -18.6875d, 6.277394636015326d);
        h = c3662Bu74;
        L03 l03 = L03.a;
        C13920h26 c13920h26 = new C13920h26("sRGB IEC61966-2.1", fArr, l03.e(), c3662Bu7, 0);
        i = c13920h26;
        C13920h26 c13920h262 = new C13920h26("sRGB IEC61966-2.1 (Linear)", fArr, l03.e(), 1.0d, 0.0f, 1.0f, 1);
        j = c13920h262;
        C13920h26 c13920h263 = new C13920h26("scRGB-nl IEC 61966-2-2:2003", fArr, l03.e(), null, new InterfaceC15993kX1() { // from class: ir.nasim.FY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.k(d2);
            }
        }, new InterfaceC15993kX1() { // from class: ir.nasim.GY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.l(d2);
            }
        }, -0.799f, 2.399f, c3662Bu7, 2);
        k = c13920h263;
        C13920h26 c13920h264 = new C13920h26("scRGB IEC 61966-2-2:2003", fArr, l03.e(), 1.0d, -0.5f, 7.499f, 3);
        l = c13920h264;
        C13920h26 c13920h265 = new C13920h26("Rec. ITU-R BT.709-5", new float[]{0.64f, 0.33f, 0.3f, 0.6f, 0.15f, 0.06f}, l03.e(), new C3662Bu7(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 4);
        m = c13920h265;
        C13920h26 c13920h266 = new C13920h26("Rec. ITU-R BT.2020-1", new float[]{0.708f, 0.292f, 0.17f, 0.797f, 0.131f, 0.046f}, l03.e(), new C3662Bu7(2.2222222222222223d, 0.9096697898662786d, 0.09033021013372146d, 0.2222222222222222d, 0.08145d, 0.0d, 0.0d, 96, null), 5);
        n = c13920h266;
        C13920h26 c13920h267 = new C13920h26("SMPTE RP 431-2-2007 DCI (P3)", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, new C10767c98(0.314f, 0.351f), 2.6d, 0.0f, 1.0f, 6);
        o = c13920h267;
        C13920h26 c13920h268 = new C13920h26("Display P3", new float[]{0.68f, 0.32f, 0.265f, 0.69f, 0.15f, 0.06f}, l03.e(), c3662Bu7, 7);
        p = c13920h268;
        C13920h26 c13920h269 = new C13920h26("NTSC (1953)", fArr2, l03.a(), new C3662Bu7(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 8);
        q = c13920h269;
        C13920h26 c13920h2610 = new C13920h26("SMPTE-C RGB", new float[]{0.63f, 0.34f, 0.31f, 0.595f, 0.155f, 0.07f}, l03.e(), new C3662Bu7(2.2222222222222223d, 0.9099181073703367d, 0.09008189262966333d, 0.2222222222222222d, 0.081d, 0.0d, 0.0d, 96, null), 9);
        r = c13920h2610;
        C13920h26 c13920h2611 = new C13920h26("Adobe RGB (1998)", new float[]{0.64f, 0.33f, 0.21f, 0.71f, 0.15f, 0.06f}, l03.e(), 2.2d, 0.0f, 1.0f, 10);
        s = c13920h2611;
        C13920h26 c13920h2612 = new C13920h26("ROMM RGB ISO 22028-2:2013", new float[]{0.7347f, 0.2653f, 0.1596f, 0.8404f, 0.0366f, 1.0E-4f}, l03.b(), new C3662Bu7(1.8d, 1.0d, 0.0d, 0.0625d, 0.031248d, 0.0d, 0.0d, 96, null), 11);
        t = c13920h2612;
        C13920h26 c13920h2613 = new C13920h26("SMPTE ST 2065-1:2012 ACES", new float[]{0.7347f, 0.2653f, 0.0f, 1.0f, 1.0E-4f, -0.077f}, l03.d(), 1.0d, -65504.0f, 65504.0f, 12);
        u = c13920h2613;
        C13920h26 c13920h2614 = new C13920h26("Academy S-2014-004 ACEScg", new float[]{0.713f, 0.293f, 0.165f, 0.83f, 0.128f, 0.044f}, l03.d(), 1.0d, -65504.0f, 65504.0f, 13);
        v = c13920h2614;
        C20793sc8 c20793sc8 = new C20793sc8("Generic XYZ", 14);
        w = c20793sc8;
        C4108Ds3 c4108Ds3 = new C4108Ds3("Generic L*a*b*", 15);
        x = c4108Ds3;
        C13920h26 c13920h2615 = new C13920h26("None", fArr, l03.e(), c3662Bu72, 16);
        y = c13920h2615;
        C13920h26 c13920h2616 = new C13920h26("Hybrid Log Gamma encoding", fArr3, l03.e(), null, new InterfaceC15993kX1() { // from class: ir.nasim.HY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.g(d2);
            }
        }, new InterfaceC15993kX1() { // from class: ir.nasim.IY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.h(d2);
            }
        }, 0.0f, 1.0f, c3662Bu73, 17);
        z = c13920h2616;
        C13920h26 c13920h2617 = new C13920h26("Perceptual Quantizer encoding", fArr3, l03.e(), null, new InterfaceC15993kX1() { // from class: ir.nasim.JY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.i(d2);
            }
        }, new InterfaceC15993kX1() { // from class: ir.nasim.KY0
            @Override // ir.nasim.InterfaceC15993kX1
            public final double a(double d2) {
                return LY0.j(d2);
            }
        }, 0.0f, 1.0f, c3662Bu74, 18);
        A = c13920h2617;
        C20598sH4 c20598sH4 = new C20598sH4("Oklab", 19);
        B = c20598sH4;
        C = new AbstractC9775aY0[]{c13920h26, c13920h262, c13920h263, c13920h264, c13920h265, c13920h266, c13920h267, c13920h268, c13920h269, c13920h2610, c13920h2611, c13920h2612, c13920h2613, c13920h2614, c20793sc8, c4108Ds3, c13920h2615, c13920h2616, c13920h2617, c20598sH4};
    }

    private LY0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double g(double d2) {
        return a.K(g, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double h(double d2) {
        return a.J(g, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double i(double d2) {
        return a.M(h, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double j(double d2) {
        return a.L(h, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double k(double d2) {
        return AbstractC10395bY0.a(d2, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final double l(double d2) {
        return AbstractC10395bY0.b(d2, 0.9478672985781991d, 0.05213270142180095d, 0.07739938080495357d, 0.04045d, 2.4d);
    }

    public final C13920h26 A() {
        return j;
    }

    public final C13920h26 B() {
        return q;
    }

    public final float[] C() {
        return c;
    }

    public final AbstractC9775aY0 D() {
        return B;
    }

    public final C13920h26 E() {
        return t;
    }

    public final C13920h26 F() {
        return r;
    }

    public final C13920h26 G() {
        return i;
    }

    public final float[] H() {
        return b;
    }

    public final C13920h26 I() {
        return y;
    }

    public final double J(C3662Bu7 c3662Bu7, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        double dA = c3662Bu7.a();
        double dB = c3662Bu7.b();
        double dC = c3662Bu7.c();
        double d5 = c3662Bu7.d();
        double dE = c3662Bu7.e();
        double d6 = dA * d4;
        return (c3662Bu7.f() + 1.0d) * d3 * (d6 <= 1.0d ? Math.pow(d6, dB) : Math.exp((d4 - dE) * dC) + d5);
    }

    public final double K(C3662Bu7 c3662Bu7, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double dA = 1.0d / c3662Bu7.a();
        double dB = 1.0d / c3662Bu7.b();
        double dC = 1.0d / c3662Bu7.c();
        double d4 = c3662Bu7.d();
        double dE = c3662Bu7.e();
        double dF = (d2 * d3) / (c3662Bu7.f() + 1.0d);
        return d3 * (dF <= 1.0d ? dA * Math.pow(dF, dB) : (dC * Math.log(dF - d4)) + dE);
    }

    public final double L(C3662Bu7 c3662Bu7, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        return d3 * Math.pow(AbstractC23053wG5.c(c3662Bu7.a() + (c3662Bu7.b() * Math.pow(d4, c3662Bu7.c())), 0.0d) / (c3662Bu7.d() + (c3662Bu7.e() * Math.pow(d4, c3662Bu7.c()))), c3662Bu7.f());
    }

    public final double M(C3662Bu7 c3662Bu7, double d2) {
        double d3 = d2 < 0.0d ? -1.0d : 1.0d;
        double d4 = d2 * d3;
        double d5 = -c3662Bu7.a();
        double d6 = c3662Bu7.d();
        double dF = 1.0d / c3662Bu7.f();
        return d3 * Math.pow(Math.max(d5 + (d6 * Math.pow(d4, dF)), 0.0d) / (c3662Bu7.b() + ((-c3662Bu7.e()) * Math.pow(d4, dF))), 1.0d / c3662Bu7.c());
    }

    public final C13920h26 m() {
        return u;
    }

    public final C13920h26 n() {
        return v;
    }

    public final C13920h26 o() {
        return s;
    }

    public final C13920h26 p() {
        return n;
    }

    public final C13920h26 q() {
        return z;
    }

    public final C13920h26 r() {
        return A;
    }

    public final C13920h26 s() {
        return m;
    }

    public final AbstractC9775aY0 t() {
        return x;
    }

    public final AbstractC9775aY0 u() {
        return w;
    }

    public final AbstractC9775aY0[] v() {
        return C;
    }

    public final C13920h26 w() {
        return o;
    }

    public final C13920h26 x() {
        return p;
    }

    public final C13920h26 y() {
        return k;
    }

    public final C13920h26 z() {
        return l;
    }
}
