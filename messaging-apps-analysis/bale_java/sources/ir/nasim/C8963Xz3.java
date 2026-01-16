package ir.nasim;

import ir.nasim.C8243Vd1;
import ir.nasim.EH6;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: ir.nasim.Xz3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C8963Xz3 {
    public static boolean r = false;
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = false;
    private static int w = 1000;
    public static long x;
    public static long y;
    private a d;
    OJ[] g;
    final C13196fp0 n;
    private a q;
    public boolean a = false;
    int b = 0;
    private HashMap c = null;
    private int e = 32;
    private int f = 32;
    public boolean h = false;
    public boolean i = false;
    private boolean[] j = new boolean[32];
    int k = 1;
    int l = 0;
    private int m = 32;
    private EH6[] o = new EH6[w];
    private int p = 0;

    /* renamed from: ir.nasim.Xz3$a */
    interface a {
        void a(a aVar);

        EH6 b(C8963Xz3 c8963Xz3, boolean[] zArr);

        void c(EH6 eh6);

        void clear();

        EH6 getKey();

        boolean isEmpty();
    }

    /* renamed from: ir.nasim.Xz3$b */
    class b extends OJ {
        public b(C13196fp0 c13196fp0) {
            this.e = new FH6(this, c13196fp0);
        }
    }

    public C8963Xz3() {
        this.g = null;
        this.g = new OJ[32];
        C();
        C13196fp0 c13196fp0 = new C13196fp0();
        this.n = c13196fp0;
        this.d = new C6462Nq5(c13196fp0);
        if (v) {
            this.q = new b(c13196fp0);
        } else {
            this.q = new OJ(c13196fp0);
        }
    }

    private final int B(a aVar, boolean z) {
        for (int i = 0; i < this.k; i++) {
            this.j[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2++;
            if (i2 >= this.k * 2) {
                return i2;
            }
            if (aVar.getKey() != null) {
                this.j[aVar.getKey().c] = true;
            }
            EH6 eh6B = aVar.b(this, this.j);
            if (eh6B != null) {
                boolean[] zArr = this.j;
                int i3 = eh6B.c;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (eh6B != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.l; i5++) {
                    OJ oj = this.g[i5];
                    if (oj.a.j != EH6.a.UNRESTRICTED && !oj.f && oj.t(eh6B)) {
                        float fG = oj.e.g(eh6B);
                        if (fG < 0.0f) {
                            float f2 = (-oj.b) / fG;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    OJ oj2 = this.g[i4];
                    oj2.a.d = -1;
                    oj2.x(eh6B);
                    EH6 eh6 = oj2.a;
                    eh6.d = i4;
                    eh6.r(this, oj2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    private void C() {
        int i = 0;
        if (v) {
            while (i < this.l) {
                OJ oj = this.g[i];
                if (oj != null) {
                    this.n.a.a(oj);
                }
                this.g[i] = null;
                i++;
            }
            return;
        }
        while (i < this.l) {
            OJ oj2 = this.g[i];
            if (oj2 != null) {
                this.n.b.a(oj2);
            }
            this.g[i] = null;
            i++;
        }
    }

    private EH6 a(EH6.a aVar, String str) {
        EH6 eh6 = (EH6) this.n.c.b();
        if (eh6 == null) {
            eh6 = new EH6(aVar, str);
            eh6.q(aVar, str);
        } else {
            eh6.o();
            eh6.q(aVar, str);
        }
        int i = this.p;
        int i2 = w;
        if (i >= i2) {
            int i3 = i2 * 2;
            w = i3;
            this.o = (EH6[]) Arrays.copyOf(this.o, i3);
        }
        EH6[] eh6Arr = this.o;
        int i4 = this.p;
        this.p = i4 + 1;
        eh6Arr[i4] = eh6;
        return eh6;
    }

    private final void l(OJ oj) {
        int i;
        if (t && oj.f) {
            oj.a.p(this, oj.b);
        } else {
            OJ[] ojArr = this.g;
            int i2 = this.l;
            ojArr[i2] = oj;
            EH6 eh6 = oj.a;
            eh6.d = i2;
            this.l = i2 + 1;
            eh6.r(this, oj);
        }
        if (t && this.a) {
            int i3 = 0;
            while (i3 < this.l) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                OJ oj2 = this.g[i3];
                if (oj2 != null && oj2.f) {
                    oj2.a.p(this, oj2.b);
                    if (v) {
                        this.n.a.a(oj2);
                    } else {
                        this.n.b.a(oj2);
                    }
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.l;
                        if (i4 >= i) {
                            break;
                        }
                        OJ[] ojArr2 = this.g;
                        int i6 = i4 - 1;
                        OJ oj3 = ojArr2[i4];
                        ojArr2[i6] = oj3;
                        EH6 eh62 = oj3.a;
                        if (eh62.d == i4) {
                            eh62.d = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.l = i - 1;
                    i3--;
                }
                i3++;
            }
            this.a = false;
        }
    }

    private void n() {
        for (int i = 0; i < this.l; i++) {
            OJ oj = this.g[i];
            oj.a.f = oj.b;
        }
    }

    public static OJ s(C8963Xz3 c8963Xz3, EH6 eh6, EH6 eh62, float f) {
        return c8963Xz3.r().j(eh6, eh62, f);
    }

    private int u(a aVar) {
        for (int i = 0; i < this.l; i++) {
            OJ oj = this.g[i];
            if (oj.a.j != EH6.a.UNRESTRICTED && oj.b < 0.0f) {
                boolean z = false;
                int i2 = 0;
                while (!z) {
                    i2++;
                    float f = Float.MAX_VALUE;
                    int i3 = 0;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = 0;
                    while (true) {
                        if (i3 >= this.l) {
                            break;
                        }
                        OJ oj2 = this.g[i3];
                        if (oj2.a.j != EH6.a.UNRESTRICTED && !oj2.f && oj2.b < 0.0f) {
                            int i7 = 9;
                            if (u) {
                                int iD = oj2.e.d();
                                int i8 = 0;
                                while (i8 < iD) {
                                    EH6 eh6A = oj2.e.a(i8);
                                    float fG = oj2.e.g(eh6A);
                                    if (fG > 0.0f) {
                                        int i9 = 0;
                                        while (i9 < i7) {
                                            float f2 = eh6A.h[i9] / fG;
                                            if ((f2 < f && i9 == i6) || i9 > i6) {
                                                i6 = i9;
                                                i5 = eh6A.c;
                                                i4 = i3;
                                                f = f2;
                                            }
                                            i9++;
                                            i7 = 9;
                                        }
                                    }
                                    i8++;
                                    i7 = 9;
                                }
                            } else {
                                for (int i10 = 1; i10 < this.k; i10++) {
                                    EH6 eh6 = this.n.d[i10];
                                    float fG2 = oj2.e.g(eh6);
                                    if (fG2 > 0.0f) {
                                        for (int i11 = 0; i11 < 9; i11++) {
                                            float f3 = eh6.h[i11] / fG2;
                                            if ((f3 < f && i11 == i6) || i11 > i6) {
                                                i4 = i3;
                                                i5 = i10;
                                                i6 = i11;
                                                f = f3;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        i3++;
                    }
                    if (i4 != -1) {
                        OJ oj3 = this.g[i4];
                        oj3.a.d = -1;
                        oj3.x(this.n.d[i5]);
                        EH6 eh62 = oj3.a;
                        eh62.d = i4;
                        eh62.r(this, oj3);
                    } else {
                        z = true;
                    }
                    if (i2 > this.k / 2) {
                        z = true;
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    public static AbstractC7080Qe4 w() {
        return null;
    }

    private void y() {
        int i = this.e * 2;
        this.e = i;
        this.g = (OJ[]) Arrays.copyOf(this.g, i);
        C13196fp0 c13196fp0 = this.n;
        c13196fp0.d = (EH6[]) Arrays.copyOf(c13196fp0.d, this.e);
        int i2 = this.e;
        this.j = new boolean[i2];
        this.f = i2;
        this.m = i2;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        C13196fp0 c13196fp0;
        int i = 0;
        while (true) {
            c13196fp0 = this.n;
            EH6[] eh6Arr = c13196fp0.d;
            if (i >= eh6Arr.length) {
                break;
            }
            EH6 eh6 = eh6Arr[i];
            if (eh6 != null) {
                eh6.o();
            }
            i++;
        }
        c13196fp0.c.c(this.o, this.p);
        this.p = 0;
        Arrays.fill(this.n.d, (Object) null);
        HashMap map = this.c;
        if (map != null) {
            map.clear();
        }
        this.b = 0;
        this.d.clear();
        this.k = 1;
        for (int i2 = 0; i2 < this.l; i2++) {
            OJ oj = this.g[i2];
            if (oj != null) {
                oj.c = false;
            }
        }
        C();
        this.l = 0;
        if (v) {
            this.q = new b(this.n);
        } else {
            this.q = new OJ(this.n);
        }
    }

    public void b(C16651le1 c16651le1, C16651le1 c16651le12, float f, int i) {
        C8243Vd1.b bVar = C8243Vd1.b.LEFT;
        EH6 eh6Q = q(c16651le1.q(bVar));
        C8243Vd1.b bVar2 = C8243Vd1.b.TOP;
        EH6 eh6Q2 = q(c16651le1.q(bVar2));
        C8243Vd1.b bVar3 = C8243Vd1.b.RIGHT;
        EH6 eh6Q3 = q(c16651le1.q(bVar3));
        C8243Vd1.b bVar4 = C8243Vd1.b.BOTTOM;
        EH6 eh6Q4 = q(c16651le1.q(bVar4));
        EH6 eh6Q5 = q(c16651le12.q(bVar));
        EH6 eh6Q6 = q(c16651le12.q(bVar2));
        EH6 eh6Q7 = q(c16651le12.q(bVar3));
        EH6 eh6Q8 = q(c16651le12.q(bVar4));
        OJ ojR = r();
        double d = f;
        double d2 = i;
        ojR.q(eh6Q2, eh6Q4, eh6Q6, eh6Q8, (float) (Math.sin(d) * d2));
        d(ojR);
        OJ ojR2 = r();
        ojR2.q(eh6Q, eh6Q3, eh6Q5, eh6Q7, (float) (Math.cos(d) * d2));
        d(ojR2);
    }

    public void c(EH6 eh6, EH6 eh62, int i, float f, EH6 eh63, EH6 eh64, int i2, int i3) {
        OJ ojR = r();
        ojR.h(eh6, eh62, i, f, eh63, eh64, i2);
        if (i3 != 8) {
            ojR.d(this, i3);
        }
        d(ojR);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(ir.nasim.OJ r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L3
            return
        L3:
            int r0 = r5.l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.m
            if (r0 >= r2) goto L12
            int r0 = r5.k
            int r0 = r0 + r1
            int r2 = r5.f
            if (r0 < r2) goto L15
        L12:
            r5.y()
        L15:
            boolean r0 = r6.f
            r2 = 0
            if (r0 != 0) goto L84
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L24
            return
        L24:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L7b
            ir.nasim.EH6 r0 = r5.p()
            r6.a = r0
            int r3 = r5.l
            r5.l(r6)
            int r4 = r5.l
            int r3 = r3 + r1
            if (r4 != r3) goto L7b
            ir.nasim.Xz3$a r2 = r5.q
            r2.a(r6)
            ir.nasim.Xz3$a r2 = r5.q
            r5.B(r2, r1)
            int r2 = r0.d
            r3 = -1
            if (r2 != r3) goto L7c
            ir.nasim.EH6 r2 = r6.a
            if (r2 != r0) goto L59
            ir.nasim.EH6 r0 = r6.v(r0)
            if (r0 == 0) goto L59
            r6.x(r0)
        L59:
            boolean r0 = r6.f
            if (r0 != 0) goto L62
            ir.nasim.EH6 r0 = r6.a
            r0.r(r5, r6)
        L62:
            boolean r0 = ir.nasim.C8963Xz3.v
            if (r0 == 0) goto L6e
            ir.nasim.fp0 r0 = r5.n
            ir.nasim.ti5 r0 = r0.a
            r0.a(r6)
            goto L75
        L6e:
            ir.nasim.fp0 r0 = r5.n
            ir.nasim.ti5 r0 = r0.b
            r0.a(r6)
        L75:
            int r0 = r5.l
            int r0 = r0 - r1
            r5.l = r0
            goto L7c
        L7b:
            r1 = r2
        L7c:
            boolean r0 = r6.s()
            if (r0 != 0) goto L83
            return
        L83:
            r2 = r1
        L84:
            if (r2 != 0) goto L89
            r5.l(r6)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C8963Xz3.d(ir.nasim.OJ):void");
    }

    public OJ e(EH6 eh6, EH6 eh62, int i, int i2) {
        if (s && i2 == 8 && eh62.g && eh6.d == -1) {
            eh6.p(this, eh62.f + i);
            return null;
        }
        OJ ojR = r();
        ojR.n(eh6, eh62, i);
        if (i2 != 8) {
            ojR.d(this, i2);
        }
        d(ojR);
        return ojR;
    }

    public void f(EH6 eh6, int i) {
        if (s && eh6.d == -1) {
            float f = i;
            eh6.p(this, f);
            for (int i2 = 0; i2 < this.b + 1; i2++) {
                EH6 eh62 = this.n.d[i2];
                if (eh62 != null && eh62.n && eh62.o == eh6.c) {
                    eh62.p(this, eh62.p + f);
                }
            }
            return;
        }
        int i3 = eh6.d;
        if (i3 == -1) {
            OJ ojR = r();
            ojR.i(eh6, i);
            d(ojR);
            return;
        }
        OJ oj = this.g[i3];
        if (oj.f) {
            oj.b = i;
            return;
        }
        if (oj.e.d() == 0) {
            oj.f = true;
            oj.b = i;
        } else {
            OJ ojR2 = r();
            ojR2.m(eh6, i);
            d(ojR2);
        }
    }

    public void g(EH6 eh6, EH6 eh62, int i, boolean z) {
        OJ ojR = r();
        EH6 eh6T = t();
        eh6T.e = 0;
        ojR.o(eh6, eh62, eh6T, i);
        d(ojR);
    }

    public void h(EH6 eh6, EH6 eh62, int i, int i2) {
        OJ ojR = r();
        EH6 eh6T = t();
        eh6T.e = 0;
        ojR.o(eh6, eh62, eh6T, i);
        if (i2 != 8) {
            m(ojR, (int) (ojR.e.g(eh6T) * (-1.0f)), i2);
        }
        d(ojR);
    }

    public void i(EH6 eh6, EH6 eh62, int i, boolean z) {
        OJ ojR = r();
        EH6 eh6T = t();
        eh6T.e = 0;
        ojR.p(eh6, eh62, eh6T, i);
        d(ojR);
    }

    public void j(EH6 eh6, EH6 eh62, int i, int i2) {
        OJ ojR = r();
        EH6 eh6T = t();
        eh6T.e = 0;
        ojR.p(eh6, eh62, eh6T, i);
        if (i2 != 8) {
            m(ojR, (int) (ojR.e.g(eh6T) * (-1.0f)), i2);
        }
        d(ojR);
    }

    public void k(EH6 eh6, EH6 eh62, EH6 eh63, EH6 eh64, float f, int i) {
        OJ ojR = r();
        ojR.k(eh6, eh62, eh63, eh64, f);
        if (i != 8) {
            ojR.d(this, i);
        }
        d(ojR);
    }

    void m(OJ oj, int i, int i2) {
        oj.e(o(i2, null), i);
    }

    public EH6 o(int i, String str) {
        if (this.k + 1 >= this.f) {
            y();
        }
        EH6 eh6A = a(EH6.a.ERROR, str);
        int i2 = this.b + 1;
        this.b = i2;
        this.k++;
        eh6A.c = i2;
        eh6A.e = i;
        this.n.d[i2] = eh6A;
        this.d.c(eh6A);
        return eh6A;
    }

    public EH6 p() {
        if (this.k + 1 >= this.f) {
            y();
        }
        EH6 eh6A = a(EH6.a.SLACK, null);
        int i = this.b + 1;
        this.b = i;
        this.k++;
        eh6A.c = i;
        this.n.d[i] = eh6A;
        return eh6A;
    }

    public EH6 q(Object obj) {
        EH6 eh6I = null;
        if (obj == null) {
            return null;
        }
        if (this.k + 1 >= this.f) {
            y();
        }
        if (obj instanceof C8243Vd1) {
            C8243Vd1 c8243Vd1 = (C8243Vd1) obj;
            eh6I = c8243Vd1.i();
            if (eh6I == null) {
                c8243Vd1.s(this.n);
                eh6I = c8243Vd1.i();
            }
            int i = eh6I.c;
            if (i == -1 || i > this.b || this.n.d[i] == null) {
                if (i != -1) {
                    eh6I.o();
                }
                int i2 = this.b + 1;
                this.b = i2;
                this.k++;
                eh6I.c = i2;
                eh6I.j = EH6.a.UNRESTRICTED;
                this.n.d[i2] = eh6I;
            }
        }
        return eh6I;
    }

    public OJ r() {
        OJ oj;
        if (v) {
            oj = (OJ) this.n.a.b();
            if (oj == null) {
                oj = new b(this.n);
                y++;
            } else {
                oj.y();
            }
        } else {
            oj = (OJ) this.n.b.b();
            if (oj == null) {
                oj = new OJ(this.n);
                x++;
            } else {
                oj.y();
            }
        }
        EH6.i();
        return oj;
    }

    public EH6 t() {
        if (this.k + 1 >= this.f) {
            y();
        }
        EH6 eh6A = a(EH6.a.SLACK, null);
        int i = this.b + 1;
        this.b = i;
        this.k++;
        eh6A.c = i;
        this.n.d[i] = eh6A;
        return eh6A;
    }

    public C13196fp0 v() {
        return this.n;
    }

    public int x(Object obj) {
        EH6 eh6I = ((C8243Vd1) obj).i();
        if (eh6I != null) {
            return (int) (eh6I.f + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.d.isEmpty()) {
            n();
            return;
        }
        if (!this.h && !this.i) {
            A(this.d);
            return;
        }
        for (int i = 0; i < this.l; i++) {
            if (!this.g[i].f) {
                A(this.d);
                return;
            }
        }
        n();
    }
}
