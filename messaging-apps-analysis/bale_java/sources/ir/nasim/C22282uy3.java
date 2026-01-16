package ir.nasim;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;

/* renamed from: ir.nasim.uy3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22282uy3 {
    private final UA2 a;
    private final InterfaceC19915r93 b;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private C23945xm7 j;
    private C13774gn7 k;
    private InterfaceC11600dH4 l;
    private CK5 m;
    private CK5 n;
    private final Object c = new Object();
    private final CursorAnchorInfo.Builder o = new CursorAnchorInfo.Builder();
    private final float[] p = AV3.c(null, 1, null);
    private final Matrix q = new Matrix();

    public C22282uy3(UA2 ua2, InterfaceC19915r93 interfaceC19915r93) {
        this.a = ua2;
        this.b = interfaceC19915r93;
    }

    private final void c() {
        if (!this.b.b() || this.j == null || this.l == null || this.k == null || this.m == null || this.n == null) {
            return;
        }
        AV3.h(this.p);
        this.a.invoke(AV3.a(this.p));
        float[] fArr = this.p;
        CK5 ck5 = this.n;
        AbstractC13042fc3.f(ck5);
        float f = -ck5.i();
        CK5 ck52 = this.n;
        AbstractC13042fc3.f(ck52);
        AV3.n(fArr, f, -ck52.l(), 0.0f);
        AbstractC5964Lp.a(this.q, this.p);
        InterfaceC19915r93 interfaceC19915r93 = this.b;
        CursorAnchorInfo.Builder builder = this.o;
        C23945xm7 c23945xm7 = this.j;
        AbstractC13042fc3.f(c23945xm7);
        InterfaceC11600dH4 interfaceC11600dH4 = this.l;
        AbstractC13042fc3.f(interfaceC11600dH4);
        C13774gn7 c13774gn7 = this.k;
        AbstractC13042fc3.f(c13774gn7);
        Matrix matrix = this.q;
        CK5 ck53 = this.m;
        AbstractC13042fc3.f(ck53);
        CK5 ck54 = this.n;
        AbstractC13042fc3.f(ck54);
        interfaceC19915r93.e(AbstractC21692ty3.b(builder, c23945xm7, interfaceC11600dH4, c13774gn7, matrix, ck53, ck54, this.f, this.g, this.h, this.i));
        this.e = false;
    }

    public final void a() {
        synchronized (this.c) {
            this.j = null;
            this.l = null;
            this.k = null;
            this.m = null;
            this.n = null;
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }

    public final void b(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        synchronized (this.c) {
            try {
                this.f = z3;
                this.g = z4;
                this.h = z5;
                this.i = z6;
                if (z) {
                    this.e = true;
                    if (this.j != null) {
                        c();
                    }
                }
                this.d = z2;
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, CK5 ck5, CK5 ck52) {
        synchronized (this.c) {
            try {
                this.j = c23945xm7;
                this.l = interfaceC11600dH4;
                this.k = c13774gn7;
                this.m = ck5;
                this.n = ck52;
                if (this.e || this.d) {
                    c();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
