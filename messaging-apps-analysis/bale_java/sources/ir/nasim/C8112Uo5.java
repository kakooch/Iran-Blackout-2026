package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.impl.C;
import androidx.camera.core.impl.D;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.v;
import ir.nasim.C22601vW5;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* renamed from: ir.nasim.Uo5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8112Uo5 extends AbstractC15273jI7 {
    public static final b x = new b();
    private static final Executor y = AbstractC20567sE0.c();
    private c p;
    private Executor q;
    v.b r;
    private DeferrableSurface s;
    private C27 t;
    Z27 u;
    private P27 v;
    private v.c w;

    /* renamed from: ir.nasim.Uo5$a */
    public static final class a implements C.a {
        private final androidx.camera.core.impl.q a;

        public a() {
            this(androidx.camera.core.impl.q.Z());
        }

        static a d(androidx.camera.core.impl.j jVar) {
            return new a(androidx.camera.core.impl.q.a0(jVar));
        }

        @Override // ir.nasim.InterfaceC3513Be2
        public androidx.camera.core.impl.p a() {
            return this.a;
        }

        public C8112Uo5 c() {
            androidx.camera.core.impl.s sVarB = b();
            androidx.camera.core.impl.o.u(sVarB);
            return new C8112Uo5(sVarB);
        }

        @Override // androidx.camera.core.impl.C.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public androidx.camera.core.impl.s b() {
            return new androidx.camera.core.impl.s(androidx.camera.core.impl.r.X(this.a));
        }

        public a f(D.b bVar) {
            a().p(androidx.camera.core.impl.C.B, bVar);
            return this;
        }

        public a g(C15116j22 c15116j22) {
            a().p(androidx.camera.core.impl.n.i, c15116j22);
            return this;
        }

        public a h(C22601vW5 c22601vW5) {
            a().p(androidx.camera.core.impl.o.r, c22601vW5);
            return this;
        }

        public a i(int i) {
            a().p(androidx.camera.core.impl.C.x, Integer.valueOf(i));
            return this;
        }

        public a j(int i) {
            if (i == -1) {
                i = 0;
            }
            a().p(androidx.camera.core.impl.o.j, Integer.valueOf(i));
            return this;
        }

        public a k(Class cls) {
            a().p(InterfaceC24505yj7.G, cls);
            if (a().g(InterfaceC24505yj7.F, null) == null) {
                l(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public a l(String str) {
            a().p(InterfaceC24505yj7.F, str);
            return this;
        }

        private a(androidx.camera.core.impl.q qVar) {
            this.a = qVar;
            Class cls = (Class) qVar.g(InterfaceC24505yj7.G, null);
            if (cls != null && !cls.equals(C8112Uo5.class)) {
                throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
            }
            f(D.b.PREVIEW);
            k(C8112Uo5.class);
            j.a aVar = androidx.camera.core.impl.o.m;
            if (((Integer) qVar.g(aVar, -1)).intValue() == -1) {
                qVar.p(aVar, 2);
            }
        }
    }

    /* renamed from: ir.nasim.Uo5$b */
    public static final class b {
        private static final C22601vW5 a;
        private static final androidx.camera.core.impl.s b;
        private static final C15116j22 c;

        static {
            C22601vW5 c22601vW5A = new C22601vW5.a().d(C18829pK.c).e(C23787xW5.c).a();
            a = c22601vW5A;
            C15116j22 c15116j22 = C15116j22.c;
            c = c15116j22;
            b = new a().i(2).j(0).h(c22601vW5A).g(c15116j22).b();
        }

        public androidx.camera.core.impl.s a() {
            return b;
        }
    }

    /* renamed from: ir.nasim.Uo5$c */
    public interface c {
        void a(Z27 z27);
    }

    C8112Uo5(androidx.camera.core.impl.s sVar) {
        super(sVar);
        this.q = y;
    }

    private void Z(v.b bVar, androidx.camera.core.impl.w wVar) {
        if (this.p != null) {
            bVar.m(this.s, wVar.b(), o(), m());
        }
        v.c cVar = this.w;
        if (cVar != null) {
            cVar.b();
        }
        v.c cVar2 = new v.c(new v.d() { // from class: ir.nasim.To5
            @Override // androidx.camera.core.impl.v.d
            public final void a(androidx.camera.core.impl.v vVar, v.g gVar) {
                this.a.d0(vVar, gVar);
            }
        });
        this.w = cVar2;
        bVar.q(cVar2);
    }

    private void a0() {
        v.c cVar = this.w;
        if (cVar != null) {
            cVar.b();
            this.w = null;
        }
        DeferrableSurface deferrableSurface = this.s;
        if (deferrableSurface != null) {
            deferrableSurface.d();
            this.s = null;
        }
        P27 p27 = this.v;
        if (p27 != null) {
            p27.h();
            this.v = null;
        }
        C27 c27 = this.t;
        if (c27 != null) {
            c27.i();
            this.t = null;
        }
        this.u = null;
    }

    private v.b b0(androidx.camera.core.impl.s sVar, androidx.camera.core.impl.w wVar) {
        AbstractC17949np7.a();
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        Objects.requireNonNull(interfaceC15221jD0F);
        InterfaceC15221jD0 interfaceC15221jD0 = interfaceC15221jD0F;
        a0();
        AbstractC4980Hj5.i(this.t == null);
        Matrix matrixU = u();
        boolean zP = interfaceC15221jD0.p();
        Rect rectC0 = c0(wVar.e());
        Objects.requireNonNull(rectC0);
        this.t = new C27(1, 34, wVar, matrixU, zP, rectC0, q(interfaceC15221jD0, B(interfaceC15221jD0)), c(), j0(interfaceC15221jD0));
        k();
        this.t.e(new Runnable() { // from class: ir.nasim.Ro5
            @Override // java.lang.Runnable
            public final void run() {
                this.a.F();
            }
        });
        Z27 z27K = this.t.k(interfaceC15221jD0);
        this.u = z27K;
        this.s = z27K.m();
        if (this.p != null) {
            f0();
        }
        v.b bVarP = v.b.p(sVar, wVar.e());
        bVarP.r(wVar.c());
        bVarP.v(sVar.B());
        if (wVar.d() != null) {
            bVarP.g(wVar.d());
        }
        Z(bVarP, wVar);
        return bVarP;
    }

    private Rect c0(Size size) {
        if (z() != null) {
            return z();
        }
        if (size != null) {
            return new Rect(0, 0, size.getWidth(), size.getHeight());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0(androidx.camera.core.impl.v vVar, v.g gVar) {
        if (f() == null) {
            return;
        }
        k0((androidx.camera.core.impl.s) i(), d());
        F();
    }

    private void f0() {
        g0();
        final c cVar = (c) AbstractC4980Hj5.g(this.p);
        final Z27 z27 = (Z27) AbstractC4980Hj5.g(this.u);
        this.q.execute(new Runnable() { // from class: ir.nasim.So5
            @Override // java.lang.Runnable
            public final void run() {
                cVar.a(z27);
            }
        });
    }

    private void g0() {
        InterfaceC15221jD0 interfaceC15221jD0F = f();
        C27 c27 = this.t;
        if (interfaceC15221jD0F == null || c27 == null) {
            return;
        }
        c27.C(q(interfaceC15221jD0F, B(interfaceC15221jD0F)), c());
    }

    private boolean j0(InterfaceC15221jD0 interfaceC15221jD0) {
        return interfaceC15221jD0.p() && B(interfaceC15221jD0);
    }

    private void k0(androidx.camera.core.impl.s sVar, androidx.camera.core.impl.w wVar) {
        v.b bVarB0 = b0(sVar, wVar);
        this.r = bVarB0;
        U(AbstractC22311v13.a(new Object[]{bVarB0.o()}));
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.C J(InterfaceC14623iD0 interfaceC14623iD0, C.a aVar) {
        aVar.a().p(androidx.camera.core.impl.n.h, 34);
        return aVar.b();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w M(androidx.camera.core.impl.j jVar) {
        this.r.g(jVar);
        U(AbstractC22311v13.a(new Object[]{this.r.o()}));
        return d().g().d(jVar).a();
    }

    @Override // ir.nasim.AbstractC15273jI7
    protected androidx.camera.core.impl.w N(androidx.camera.core.impl.w wVar, androidx.camera.core.impl.w wVar2) {
        k0((androidx.camera.core.impl.s) i(), wVar);
        return wVar;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void O() {
        a0();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public void S(Rect rect) {
        super.S(rect);
        g0();
    }

    public void h0(c cVar) {
        i0(y, cVar);
    }

    public void i0(Executor executor, c cVar) {
        AbstractC17949np7.a();
        if (cVar == null) {
            this.p = null;
            E();
            return;
        }
        this.p = cVar;
        this.q = executor;
        if (e() != null) {
            k0((androidx.camera.core.impl.s) i(), d());
            F();
        }
        D();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public androidx.camera.core.impl.C j(boolean z, androidx.camera.core.impl.D d) {
        b bVar = x;
        androidx.camera.core.impl.j jVarA = d.a(bVar.a().N(), 1);
        if (z) {
            jVarA = androidx.camera.core.impl.j.O(jVarA, bVar.a());
        }
        if (jVarA == null) {
            return null;
        }
        return y(jVarA).b();
    }

    public String toString() {
        return "Preview:" + n();
    }

    @Override // ir.nasim.AbstractC15273jI7
    public Set w() {
        HashSet hashSet = new HashSet();
        hashSet.add(1);
        return hashSet;
    }

    @Override // ir.nasim.AbstractC15273jI7
    public C.a y(androidx.camera.core.impl.j jVar) {
        return a.d(jVar);
    }
}
