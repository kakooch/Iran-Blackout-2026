package ir.nasim;

import android.graphics.Matrix;
import android.view.inputmethod.CursorAnchorInfo;

/* renamed from: ir.nasim.Ew1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4376Ew1 {
    private final FV3 a;
    private final InterfaceC19324q93 b;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private C23945xm7 j;
    private C13774gn7 k;
    private InterfaceC11600dH4 l;
    private CK5 n;
    private CK5 o;
    private final Object c = new Object();
    private UA2 m = b.e;
    private final CursorAnchorInfo.Builder p = new CursorAnchorInfo.Builder();
    private final float[] q = AV3.c(null, 1, null);
    private final Matrix r = new Matrix();

    public C4376Ew1(FV3 fv3, InterfaceC19324q93 interfaceC19324q93) {
        this.a = fv3;
        this.b = interfaceC19324q93;
    }

    private final void c() {
        if (this.b.b()) {
            this.m.invoke(AV3.a(this.q));
            this.a.g(this.q);
            AbstractC5964Lp.a(this.r, this.q);
            InterfaceC19324q93 interfaceC19324q93 = this.b;
            CursorAnchorInfo.Builder builder = this.p;
            C23945xm7 c23945xm7 = this.j;
            AbstractC13042fc3.f(c23945xm7);
            InterfaceC11600dH4 interfaceC11600dH4 = this.l;
            AbstractC13042fc3.f(interfaceC11600dH4);
            C13774gn7 c13774gn7 = this.k;
            AbstractC13042fc3.f(c13774gn7);
            Matrix matrix = this.r;
            CK5 ck5 = this.n;
            AbstractC13042fc3.f(ck5);
            CK5 ck52 = this.o;
            AbstractC13042fc3.f(ck52);
            interfaceC19324q93.e(AbstractC4142Dw1.b(builder, c23945xm7, interfaceC11600dH4, c13774gn7, matrix, ck5, ck52, this.f, this.g, this.h, this.i));
            this.e = false;
        }
    }

    public final void a() {
        synchronized (this.c) {
            this.j = null;
            this.l = null;
            this.k = null;
            this.m = a.e;
            this.n = null;
            this.o = null;
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

    public final void d(C23945xm7 c23945xm7, InterfaceC11600dH4 interfaceC11600dH4, C13774gn7 c13774gn7, UA2 ua2, CK5 ck5, CK5 ck52) {
        synchronized (this.c) {
            try {
                this.j = c23945xm7;
                this.l = interfaceC11600dH4;
                this.k = c13774gn7;
                this.m = ua2;
                this.n = ck5;
                this.o = ck52;
                if (this.e || this.d) {
                    c();
                }
                C19938rB7 c19938rB7 = C19938rB7.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: ir.nasim.Ew1$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((AV3) obj).p());
            return C19938rB7.a;
        }

        public final void a(float[] fArr) {
        }
    }

    /* renamed from: ir.nasim.Ew1$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((AV3) obj).p());
            return C19938rB7.a;
        }

        public final void a(float[] fArr) {
        }
    }
}
