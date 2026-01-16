package ir.nasim;

import ir.nasim.C8243Vd1;
import ir.nasim.UK6;
import java.util.HashMap;

/* renamed from: ir.nasim.fe1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13060fe1 implements InterfaceC14709iL5 {
    private Object a;
    private float a0;
    final UK6 b;
    private float b0;
    ET1 d0;
    ET1 e0;
    private Object f0;
    private C16651le1 g0;
    private HashMap h0;
    private HashMap i0;
    String c = null;
    InterfaceC17844nf2 d = null;
    int e = 0;
    int f = 0;
    float g = -1.0f;
    float h = -1.0f;
    float i = 0.5f;
    float j = 0.5f;
    protected int k = 0;
    protected int l = 0;
    protected int m = 0;
    protected int n = 0;
    protected int o = 0;
    protected int p = 0;
    protected int q = 0;
    protected int r = 0;
    protected int s = 0;
    protected int t = 0;
    protected int u = 0;
    protected int v = 0;
    int w = 0;
    int x = 0;
    float y = Float.NaN;
    float z = Float.NaN;
    float A = Float.NaN;
    float B = Float.NaN;
    float C = Float.NaN;
    float D = Float.NaN;
    float E = Float.NaN;
    float F = Float.NaN;
    float G = Float.NaN;
    float H = Float.NaN;
    float I = Float.NaN;
    int J = 0;
    protected Object K = null;
    protected Object L = null;
    protected Object M = null;
    protected Object N = null;
    protected Object O = null;
    protected Object P = null;
    protected Object Q = null;
    protected Object R = null;
    protected Object S = null;
    protected Object T = null;
    protected Object U = null;
    protected Object V = null;
    Object W = null;
    Object X = null;
    Object Y = null;
    Object Z = null;
    UK6.c c0 = null;

    /* renamed from: ir.nasim.fe1$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[UK6.c.values().length];
            a = iArr;
            try {
                iArr[UK6.c.LEFT_TO_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UK6.c.LEFT_TO_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[UK6.c.RIGHT_TO_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[UK6.c.RIGHT_TO_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[UK6.c.START_TO_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[UK6.c.START_TO_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[UK6.c.END_TO_START.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[UK6.c.END_TO_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[UK6.c.TOP_TO_TOP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[UK6.c.TOP_TO_BOTTOM.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[UK6.c.BOTTOM_TO_TOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[UK6.c.BOTTOM_TO_BOTTOM.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[UK6.c.BASELINE_TO_BOTTOM.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[UK6.c.BASELINE_TO_TOP.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[UK6.c.BASELINE_TO_BASELINE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[UK6.c.CIRCULAR_CONSTRAINT.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[UK6.c.CENTER_HORIZONTALLY.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[UK6.c.CENTER_VERTICALLY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    public C13060fe1(UK6 uk6) {
        Object obj = ET1.j;
        this.d0 = ET1.b(obj);
        this.e0 = ET1.b(obj);
        this.h0 = new HashMap();
        this.i0 = new HashMap();
        this.b = uk6;
    }

    private void e(C16651le1 c16651le1, Object obj, UK6.c cVar) {
        C16651le1 c16651le1U = u(obj);
        if (c16651le1U == null) {
        }
        int[] iArr = a.a;
        int i = iArr[cVar.ordinal()];
        switch (iArr[cVar.ordinal()]) {
            case 1:
                C8243Vd1.b bVar = C8243Vd1.b.LEFT;
                c16651le1.q(bVar).b(c16651le1U.q(bVar), this.k, this.q, false);
                break;
            case 2:
                c16651le1.q(C8243Vd1.b.LEFT).b(c16651le1U.q(C8243Vd1.b.RIGHT), this.k, this.q, false);
                break;
            case 3:
                c16651le1.q(C8243Vd1.b.RIGHT).b(c16651le1U.q(C8243Vd1.b.LEFT), this.l, this.r, false);
                break;
            case 4:
                C8243Vd1.b bVar2 = C8243Vd1.b.RIGHT;
                c16651le1.q(bVar2).b(c16651le1U.q(bVar2), this.l, this.r, false);
                break;
            case 5:
                C8243Vd1.b bVar3 = C8243Vd1.b.LEFT;
                c16651le1.q(bVar3).b(c16651le1U.q(bVar3), this.m, this.s, false);
                break;
            case 6:
                c16651le1.q(C8243Vd1.b.LEFT).b(c16651le1U.q(C8243Vd1.b.RIGHT), this.m, this.s, false);
                break;
            case 7:
                c16651le1.q(C8243Vd1.b.RIGHT).b(c16651le1U.q(C8243Vd1.b.LEFT), this.n, this.t, false);
                break;
            case 8:
                C8243Vd1.b bVar4 = C8243Vd1.b.RIGHT;
                c16651le1.q(bVar4).b(c16651le1U.q(bVar4), this.n, this.t, false);
                break;
            case 9:
                C8243Vd1.b bVar5 = C8243Vd1.b.TOP;
                c16651le1.q(bVar5).b(c16651le1U.q(bVar5), this.o, this.u, false);
                break;
            case 10:
                c16651le1.q(C8243Vd1.b.TOP).b(c16651le1U.q(C8243Vd1.b.BOTTOM), this.o, this.u, false);
                break;
            case 11:
                c16651le1.q(C8243Vd1.b.BOTTOM).b(c16651le1U.q(C8243Vd1.b.TOP), this.p, this.v, false);
                break;
            case 12:
                C8243Vd1.b bVar6 = C8243Vd1.b.BOTTOM;
                c16651le1.q(bVar6).b(c16651le1U.q(bVar6), this.p, this.v, false);
                break;
            case 13:
                c16651le1.f0(C8243Vd1.b.BASELINE, c16651le1U, C8243Vd1.b.BOTTOM, this.w, this.x);
                break;
            case 14:
                c16651le1.f0(C8243Vd1.b.BASELINE, c16651le1U, C8243Vd1.b.TOP, this.w, this.x);
                break;
            case 15:
                C8243Vd1.b bVar7 = C8243Vd1.b.BASELINE;
                c16651le1.f0(bVar7, c16651le1U, bVar7, this.w, this.x);
                break;
            case 16:
                c16651le1.m(c16651le1U, this.a0, (int) this.b0);
                break;
        }
    }

    private void o() {
        this.K = s(this.K);
        this.L = s(this.L);
        this.M = s(this.M);
        this.N = s(this.N);
        this.O = s(this.O);
        this.P = s(this.P);
        this.Q = s(this.Q);
        this.R = s(this.R);
        this.S = s(this.S);
        this.T = s(this.T);
        this.U = s(this.U);
        this.V = s(this.V);
        this.W = s(this.W);
        this.X = s(this.X);
        this.Y = s(this.Y);
    }

    private Object s(Object obj) {
        if (obj == null) {
            return null;
        }
        return !(obj instanceof C13060fe1) ? this.b.j(obj) : obj;
    }

    private C16651le1 u(Object obj) {
        if (obj instanceof InterfaceC14709iL5) {
            return ((InterfaceC14709iL5) obj).a();
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C13060fe1 A(int i) {
        UK6.c cVar = this.c0;
        if (cVar != null) {
            switch (a.a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.k = i;
                    break;
                case 3:
                case 4:
                    this.l = i;
                    break;
                case 5:
                case 6:
                    this.m = i;
                    break;
                case 7:
                case 8:
                    this.n = i;
                    break;
                case 9:
                case 10:
                    this.o = i;
                    break;
                case 11:
                case 12:
                    this.p = i;
                    break;
                case 13:
                case 14:
                case 15:
                    this.w = i;
                    break;
                case 16:
                    this.b0 = i;
                    break;
            }
        } else {
            this.k = i;
            this.l = i;
            this.m = i;
            this.n = i;
            this.o = i;
            this.p = i;
        }
        return this;
    }

    public C13060fe1 B(Object obj) {
        return A(this.b.d(obj));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C13060fe1 C(int i) {
        UK6.c cVar = this.c0;
        if (cVar != null) {
            switch (a.a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.q = i;
                    break;
                case 3:
                case 4:
                    this.r = i;
                    break;
                case 5:
                case 6:
                    this.s = i;
                    break;
                case 7:
                case 8:
                    this.t = i;
                    break;
                case 9:
                case 10:
                    this.u = i;
                    break;
                case 11:
                case 12:
                    this.v = i;
                    break;
                case 13:
                case 14:
                case 15:
                    this.x = i;
                    break;
            }
        } else {
            this.q = i;
            this.r = i;
            this.s = i;
            this.t = i;
            this.u = i;
            this.v = i;
        }
        return this;
    }

    public C13060fe1 D(Object obj) {
        return C(this.b.d(obj));
    }

    public C13060fe1 E() {
        if (this.M != null) {
            this.c0 = UK6.c.RIGHT_TO_LEFT;
        } else {
            this.c0 = UK6.c.RIGHT_TO_RIGHT;
        }
        return this;
    }

    public C13060fe1 F(Object obj) {
        this.c0 = UK6.c.RIGHT_TO_LEFT;
        this.M = obj;
        return this;
    }

    public C13060fe1 G(Object obj) {
        this.c0 = UK6.c.RIGHT_TO_RIGHT;
        this.N = obj;
        return this;
    }

    public void H(InterfaceC17844nf2 interfaceC17844nf2) {
        this.d = interfaceC17844nf2;
        if (interfaceC17844nf2 != null) {
            b(interfaceC17844nf2.a());
        }
    }

    public C13060fe1 I(ET1 et1) {
        this.e0 = et1;
        return this;
    }

    public void J(int i) {
        this.e = i;
    }

    public void K(String str) {
        this.c = str;
    }

    public void L(int i) {
        this.f = i;
    }

    public void M(Object obj) {
        this.f0 = obj;
        C16651le1 c16651le1 = this.g0;
        if (c16651le1 != null) {
            c16651le1.A0(obj);
        }
    }

    public C13060fe1 N(ET1 et1) {
        this.d0 = et1;
        return this;
    }

    public C13060fe1 O() {
        if (this.O != null) {
            this.c0 = UK6.c.START_TO_START;
        } else {
            this.c0 = UK6.c.START_TO_END;
        }
        return this;
    }

    public C13060fe1 P(Object obj) {
        this.c0 = UK6.c.START_TO_END;
        this.P = obj;
        return this;
    }

    public C13060fe1 Q(Object obj) {
        this.c0 = UK6.c.START_TO_START;
        this.O = obj;
        return this;
    }

    public C13060fe1 R() {
        if (this.S != null) {
            this.c0 = UK6.c.TOP_TO_TOP;
        } else {
            this.c0 = UK6.c.TOP_TO_BOTTOM;
        }
        return this;
    }

    public C13060fe1 S(Object obj) {
        this.c0 = UK6.c.TOP_TO_BOTTOM;
        this.T = obj;
        return this;
    }

    public C13060fe1 T(Object obj) {
        this.c0 = UK6.c.TOP_TO_TOP;
        this.S = obj;
        return this;
    }

    public C13060fe1 U(float f) {
        this.j = f;
        return this;
    }

    public C13060fe1 V(ET1 et1) {
        return N(et1);
    }

    @Override // ir.nasim.InterfaceC14709iL5
    public C16651le1 a() {
        if (this.g0 == null) {
            C16651le1 c16651le1N = n();
            this.g0 = c16651le1N;
            c16651le1N.A0(this.f0);
        }
        return this.g0;
    }

    @Override // ir.nasim.InterfaceC14709iL5, ir.nasim.InterfaceC17844nf2
    public void apply() {
        if (this.g0 == null) {
            return;
        }
        InterfaceC17844nf2 interfaceC17844nf2 = this.d;
        if (interfaceC17844nf2 != null) {
            interfaceC17844nf2.apply();
        }
        this.d0.e(this.b, this.g0, 0);
        this.e0.e(this.b, this.g0, 1);
        o();
        e(this.g0, this.K, UK6.c.LEFT_TO_LEFT);
        e(this.g0, this.L, UK6.c.LEFT_TO_RIGHT);
        e(this.g0, this.M, UK6.c.RIGHT_TO_LEFT);
        e(this.g0, this.N, UK6.c.RIGHT_TO_RIGHT);
        e(this.g0, this.O, UK6.c.START_TO_START);
        e(this.g0, this.P, UK6.c.START_TO_END);
        e(this.g0, this.Q, UK6.c.END_TO_START);
        e(this.g0, this.R, UK6.c.END_TO_END);
        e(this.g0, this.S, UK6.c.TOP_TO_TOP);
        e(this.g0, this.T, UK6.c.TOP_TO_BOTTOM);
        e(this.g0, this.U, UK6.c.BOTTOM_TO_TOP);
        e(this.g0, this.V, UK6.c.BOTTOM_TO_BOTTOM);
        e(this.g0, this.W, UK6.c.BASELINE_TO_BASELINE);
        e(this.g0, this.X, UK6.c.BASELINE_TO_TOP);
        e(this.g0, this.Y, UK6.c.BASELINE_TO_BOTTOM);
        e(this.g0, this.Z, UK6.c.CIRCULAR_CONSTRAINT);
        int i = this.e;
        if (i != 0) {
            this.g0.M0(i);
        }
        int i2 = this.f;
        if (i2 != 0) {
            this.g0.d1(i2);
        }
        float f = this.g;
        if (f != -1.0f) {
            this.g0.Q0(f);
        }
        float f2 = this.h;
        if (f2 != -1.0f) {
            this.g0.h1(f2);
        }
        this.g0.L0(this.i);
        this.g0.c1(this.j);
        C16651le1 c16651le1 = this.g0;
        C13992h98 c13992h98 = c16651le1.n;
        c13992h98.f = this.y;
        c13992h98.g = this.z;
        c13992h98.h = this.A;
        c13992h98.i = this.B;
        c13992h98.j = this.C;
        c13992h98.k = this.D;
        c13992h98.l = this.E;
        c13992h98.m = this.F;
        c13992h98.n = this.H;
        c13992h98.o = this.I;
        c13992h98.p = this.G;
        int i3 = this.J;
        c13992h98.r = i3;
        c16651le1.i1(i3);
        HashMap map = this.h0;
        if (map != null) {
            for (String str : map.keySet()) {
                this.g0.n.g(str, 902, ((Integer) this.h0.get(str)).intValue());
            }
        }
        HashMap map2 = this.i0;
        if (map2 != null) {
            for (String str2 : map2.keySet()) {
                this.g0.n.f(str2, 901, ((Float) this.i0.get(str2)).floatValue());
            }
        }
    }

    @Override // ir.nasim.InterfaceC14709iL5
    public void b(C16651le1 c16651le1) {
        if (c16651le1 == null) {
            return;
        }
        this.g0 = c16651le1;
        c16651le1.A0(this.f0);
    }

    @Override // ir.nasim.InterfaceC14709iL5
    public void c(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.InterfaceC14709iL5
    public InterfaceC17844nf2 d() {
        return this.d;
    }

    public C13060fe1 f() {
        this.c0 = UK6.c.BASELINE_TO_BASELINE;
        return this;
    }

    public C13060fe1 g(Object obj) {
        this.c0 = UK6.c.BASELINE_TO_BASELINE;
        this.W = obj;
        return this;
    }

    @Override // ir.nasim.InterfaceC14709iL5
    public Object getKey() {
        return this.a;
    }

    public C13060fe1 h() {
        if (this.U != null) {
            this.c0 = UK6.c.BOTTOM_TO_TOP;
        } else {
            this.c0 = UK6.c.BOTTOM_TO_BOTTOM;
        }
        return this;
    }

    public C13060fe1 i(Object obj) {
        this.c0 = UK6.c.BOTTOM_TO_BOTTOM;
        this.V = obj;
        return this;
    }

    public C13060fe1 j(Object obj) {
        this.c0 = UK6.c.BOTTOM_TO_TOP;
        this.U = obj;
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public C13060fe1 k() {
        UK6.c cVar = this.c0;
        if (cVar != null) {
            switch (a.a[cVar.ordinal()]) {
                case 1:
                case 2:
                    this.K = null;
                    this.L = null;
                    this.k = 0;
                    this.q = 0;
                    break;
                case 3:
                case 4:
                    this.M = null;
                    this.N = null;
                    this.l = 0;
                    this.r = 0;
                    break;
                case 5:
                case 6:
                    this.O = null;
                    this.P = null;
                    this.m = 0;
                    this.s = 0;
                    break;
                case 7:
                case 8:
                    this.Q = null;
                    this.R = null;
                    this.n = 0;
                    this.t = 0;
                    break;
                case 9:
                case 10:
                    this.S = null;
                    this.T = null;
                    this.o = 0;
                    this.u = 0;
                    break;
                case 11:
                case 12:
                    this.U = null;
                    this.V = null;
                    this.p = 0;
                    this.v = 0;
                    break;
                case 15:
                    this.W = null;
                    break;
                case 16:
                    this.Z = null;
                    break;
            }
        } else {
            this.K = null;
            this.L = null;
            this.k = 0;
            this.M = null;
            this.N = null;
            this.l = 0;
            this.O = null;
            this.P = null;
            this.m = 0;
            this.Q = null;
            this.R = null;
            this.n = 0;
            this.S = null;
            this.T = null;
            this.o = 0;
            this.U = null;
            this.V = null;
            this.p = 0;
            this.W = null;
            this.Z = null;
            this.i = 0.5f;
            this.j = 0.5f;
            this.q = 0;
            this.r = 0;
            this.s = 0;
            this.t = 0;
            this.u = 0;
            this.v = 0;
        }
        return this;
    }

    public C13060fe1 l() {
        O().k();
        p().k();
        x().k();
        E().k();
        return this;
    }

    public C13060fe1 m() {
        R().k();
        f().k();
        h().k();
        return this;
    }

    public C16651le1 n() {
        return new C16651le1(v().h(), t().h());
    }

    public C13060fe1 p() {
        if (this.Q != null) {
            this.c0 = UK6.c.END_TO_START;
        } else {
            this.c0 = UK6.c.END_TO_END;
        }
        return this;
    }

    public C13060fe1 q(Object obj) {
        this.c0 = UK6.c.END_TO_END;
        this.R = obj;
        return this;
    }

    public C13060fe1 r(Object obj) {
        this.c0 = UK6.c.END_TO_START;
        this.Q = obj;
        return this;
    }

    public ET1 t() {
        return this.e0;
    }

    public ET1 v() {
        return this.d0;
    }

    public C13060fe1 w(float f) {
        this.i = f;
        return this;
    }

    public C13060fe1 x() {
        if (this.K != null) {
            this.c0 = UK6.c.LEFT_TO_LEFT;
        } else {
            this.c0 = UK6.c.LEFT_TO_RIGHT;
        }
        return this;
    }

    public C13060fe1 y(Object obj) {
        this.c0 = UK6.c.LEFT_TO_LEFT;
        this.K = obj;
        return this;
    }

    public C13060fe1 z(Object obj) {
        this.c0 = UK6.c.LEFT_TO_RIGHT;
        this.L = obj;
        return this;
    }
}
