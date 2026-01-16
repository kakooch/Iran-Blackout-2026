package ir.nasim;

import ir.nasim.C8963Xz3;
import ir.nasim.EH6;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class OJ implements C8963Xz3.a {
    public a e;
    EH6 a = null;
    float b = 0.0f;
    boolean c = false;
    ArrayList d = new ArrayList();
    boolean f = false;

    public interface a {
        EH6 a(int i);

        void b();

        void c(EH6 eh6, float f);

        void clear();

        int d();

        float e(EH6 eh6, boolean z);

        float f(int i);

        float g(EH6 eh6);

        float h(OJ oj, boolean z);

        boolean i(EH6 eh6);

        void j(EH6 eh6, float f, boolean z);

        void k(float f);
    }

    public OJ() {
    }

    private boolean u(EH6 eh6, C8963Xz3 c8963Xz3) {
        return eh6.m <= 1;
    }

    private EH6 w(boolean[] zArr, EH6 eh6) {
        EH6.a aVar;
        int iD = this.e.d();
        EH6 eh62 = null;
        float f = 0.0f;
        for (int i = 0; i < iD; i++) {
            float f2 = this.e.f(i);
            if (f2 < 0.0f) {
                EH6 eh6A = this.e.a(i);
                if ((zArr == null || !zArr[eh6A.c]) && eh6A != eh6 && (((aVar = eh6A.j) == EH6.a.SLACK || aVar == EH6.a.ERROR) && f2 < f)) {
                    f = f2;
                    eh62 = eh6A;
                }
            }
        }
        return eh62;
    }

    public void A(C8963Xz3 c8963Xz3, EH6 eh6, boolean z) {
        if (eh6 == null || !eh6.g) {
            return;
        }
        this.b += eh6.f * this.e.g(eh6);
        this.e.e(eh6, z);
        if (z) {
            eh6.j(this);
        }
        if (C8963Xz3.t && this.e.d() == 0) {
            this.f = true;
            c8963Xz3.a = true;
        }
    }

    public void B(C8963Xz3 c8963Xz3, OJ oj, boolean z) {
        this.b += oj.b * this.e.h(oj, z);
        if (z) {
            oj.a.j(this);
        }
        if (C8963Xz3.t && this.a != null && this.e.d() == 0) {
            this.f = true;
            c8963Xz3.a = true;
        }
    }

    public void C(C8963Xz3 c8963Xz3, EH6 eh6, boolean z) {
        if (eh6 == null || !eh6.n) {
            return;
        }
        float fG = this.e.g(eh6);
        this.b += eh6.p * fG;
        this.e.e(eh6, z);
        if (z) {
            eh6.j(this);
        }
        this.e.j(c8963Xz3.n.d[eh6.o], fG, z);
        if (C8963Xz3.t && this.e.d() == 0) {
            this.f = true;
            c8963Xz3.a = true;
        }
    }

    public void D(C8963Xz3 c8963Xz3) {
        if (c8963Xz3.g.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int iD = this.e.d();
            for (int i = 0; i < iD; i++) {
                EH6 eh6A = this.e.a(i);
                if (eh6A.d != -1 || eh6A.g || eh6A.n) {
                    this.d.add(eh6A);
                }
            }
            int size = this.d.size();
            if (size > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    EH6 eh6 = (EH6) this.d.get(i2);
                    if (eh6.g) {
                        A(c8963Xz3, eh6, true);
                    } else if (eh6.n) {
                        C(c8963Xz3, eh6, true);
                    } else {
                        B(c8963Xz3, c8963Xz3.g[eh6.d], true);
                    }
                }
                this.d.clear();
            } else {
                z = true;
            }
        }
        if (C8963Xz3.t && this.a != null && this.e.d() == 0) {
            this.f = true;
            c8963Xz3.a = true;
        }
    }

    @Override // ir.nasim.C8963Xz3.a
    public void a(C8963Xz3.a aVar) {
        if (aVar instanceof OJ) {
            OJ oj = (OJ) aVar;
            this.a = null;
            this.e.clear();
            for (int i = 0; i < oj.e.d(); i++) {
                this.e.j(oj.e.a(i), oj.e.f(i), true);
            }
        }
    }

    @Override // ir.nasim.C8963Xz3.a
    public EH6 b(C8963Xz3 c8963Xz3, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // ir.nasim.C8963Xz3.a
    public void c(EH6 eh6) {
        int i = eh6.e;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.e.c(eh6, f);
    }

    @Override // ir.nasim.C8963Xz3.a
    public void clear() {
        this.e.clear();
        this.a = null;
        this.b = 0.0f;
    }

    public OJ d(C8963Xz3 c8963Xz3, int i) {
        this.e.c(c8963Xz3.o(i, "ep"), 1.0f);
        this.e.c(c8963Xz3.o(i, "em"), -1.0f);
        return this;
    }

    OJ e(EH6 eh6, int i) {
        this.e.c(eh6, i);
        return this;
    }

    boolean f(C8963Xz3 c8963Xz3) {
        boolean z;
        EH6 eh6G = g(c8963Xz3);
        if (eh6G == null) {
            z = true;
        } else {
            x(eh6G);
            z = false;
        }
        if (this.e.d() == 0) {
            this.f = true;
        }
        return z;
    }

    EH6 g(C8963Xz3 c8963Xz3) {
        int iD = this.e.d();
        EH6 eh6 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        EH6 eh62 = null;
        for (int i = 0; i < iD; i++) {
            float f3 = this.e.f(i);
            EH6 eh6A = this.e.a(i);
            if (eh6A.j == EH6.a.UNRESTRICTED) {
                if (eh6 == null || f > f3) {
                    boolean zU = u(eh6A, c8963Xz3);
                    z = zU;
                    f = f3;
                    eh6 = eh6A;
                } else if (!z && u(eh6A, c8963Xz3)) {
                    f = f3;
                    eh6 = eh6A;
                    z = true;
                }
            } else if (eh6 == null && f3 < 0.0f) {
                if (eh62 == null || f2 > f3) {
                    boolean zU2 = u(eh6A, c8963Xz3);
                    z2 = zU2;
                    f2 = f3;
                    eh62 = eh6A;
                } else if (!z2 && u(eh6A, c8963Xz3)) {
                    f2 = f3;
                    eh62 = eh6A;
                    z2 = true;
                }
            }
        }
        return eh6 != null ? eh6 : eh62;
    }

    @Override // ir.nasim.C8963Xz3.a
    public EH6 getKey() {
        return this.a;
    }

    OJ h(EH6 eh6, EH6 eh62, int i, float f, EH6 eh63, EH6 eh64, int i2) {
        if (eh62 == eh63) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh64, 1.0f);
            this.e.c(eh62, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
            this.e.c(eh63, -1.0f);
            this.e.c(eh64, 1.0f);
            if (i > 0 || i2 > 0) {
                this.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.e.c(eh6, -1.0f);
            this.e.c(eh62, 1.0f);
            this.b = i;
        } else if (f >= 1.0f) {
            this.e.c(eh64, -1.0f);
            this.e.c(eh63, 1.0f);
            this.b = -i2;
        } else {
            float f2 = 1.0f - f;
            this.e.c(eh6, f2 * 1.0f);
            this.e.c(eh62, f2 * (-1.0f));
            this.e.c(eh63, (-1.0f) * f);
            this.e.c(eh64, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.b = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    OJ i(EH6 eh6, int i) {
        this.a = eh6;
        float f = i;
        eh6.f = f;
        this.b = f;
        this.f = true;
        return this;
    }

    @Override // ir.nasim.C8963Xz3.a
    public boolean isEmpty() {
        return this.a == null && this.b == 0.0f && this.e.d() == 0;
    }

    OJ j(EH6 eh6, EH6 eh62, float f) {
        this.e.c(eh6, -1.0f);
        this.e.c(eh62, f);
        return this;
    }

    public OJ k(EH6 eh6, EH6 eh62, EH6 eh63, EH6 eh64, float f) {
        this.e.c(eh6, -1.0f);
        this.e.c(eh62, 1.0f);
        this.e.c(eh63, f);
        this.e.c(eh64, -f);
        return this;
    }

    public OJ l(float f, float f2, float f3, EH6 eh6, EH6 eh62, EH6 eh63, EH6 eh64) {
        this.b = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
            this.e.c(eh64, 1.0f);
            this.e.c(eh63, -1.0f);
        } else if (f == 0.0f) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
        } else if (f3 == 0.0f) {
            this.e.c(eh63, 1.0f);
            this.e.c(eh64, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
            this.e.c(eh64, f4);
            this.e.c(eh63, -f4);
        }
        return this;
    }

    public OJ m(EH6 eh6, int i) {
        if (i < 0) {
            this.b = i * (-1);
            this.e.c(eh6, 1.0f);
        } else {
            this.b = i;
            this.e.c(eh6, -1.0f);
        }
        return this;
    }

    public OJ n(EH6 eh6, EH6 eh62, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
        } else {
            this.e.c(eh6, -1.0f);
            this.e.c(eh62, 1.0f);
        }
        return this;
    }

    public OJ o(EH6 eh6, EH6 eh62, EH6 eh63, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
            this.e.c(eh63, -1.0f);
        } else {
            this.e.c(eh6, -1.0f);
            this.e.c(eh62, 1.0f);
            this.e.c(eh63, 1.0f);
        }
        return this;
    }

    public OJ p(EH6 eh6, EH6 eh62, EH6 eh63, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.e.c(eh6, 1.0f);
            this.e.c(eh62, -1.0f);
            this.e.c(eh63, 1.0f);
        } else {
            this.e.c(eh6, -1.0f);
            this.e.c(eh62, 1.0f);
            this.e.c(eh63, -1.0f);
        }
        return this;
    }

    public OJ q(EH6 eh6, EH6 eh62, EH6 eh63, EH6 eh64, float f) {
        this.e.c(eh63, 0.5f);
        this.e.c(eh64, 0.5f);
        this.e.c(eh6, -0.5f);
        this.e.c(eh62, -0.5f);
        this.b = -f;
        return this;
    }

    void r() {
        float f = this.b;
        if (f < 0.0f) {
            this.b = f * (-1.0f);
            this.e.b();
        }
    }

    boolean s() {
        EH6 eh6 = this.a;
        return eh6 != null && (eh6.j == EH6.a.UNRESTRICTED || this.b >= 0.0f);
    }

    boolean t(EH6 eh6) {
        return this.e.i(eh6);
    }

    public String toString() {
        return z();
    }

    public EH6 v(EH6 eh6) {
        return w(null, eh6);
    }

    void x(EH6 eh6) {
        EH6 eh62 = this.a;
        if (eh62 != null) {
            this.e.c(eh62, -1.0f);
            this.a.d = -1;
            this.a = null;
        }
        float fE = this.e.e(eh6, true) * (-1.0f);
        this.a = eh6;
        if (fE == 1.0f) {
            return;
        }
        this.b /= fE;
        this.e.k(fE);
    }

    public void y() {
        this.a = null;
        this.e.clear();
        this.b = 0.0f;
        this.f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String z() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OJ.z():java.lang.String");
    }

    public OJ(C13196fp0 c13196fp0) {
        this.e = new EJ(this, c13196fp0);
    }
}
