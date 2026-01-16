package ir.nasim;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.AbstractC16967mA0;
import ir.nasim.G27;
import ir.nasim.Z27;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class C27 {
    private final int a;
    private final Matrix b;
    private final boolean c;
    private final Rect d;
    private final boolean e;
    private final int f;
    private final androidx.camera.core.impl.w g;
    private int h;
    private int i;
    private Z27 k;
    private a l;
    private boolean j = false;
    private final Set m = new HashSet();
    private boolean n = false;
    private final List o = new ArrayList();

    static class a extends DeferrableSurface {
        final InterfaceFutureC15215jC3 o;
        AbstractC16967mA0.a p;
        private DeferrableSurface q;
        private J27 r;

        a(Size size, int i) {
            super(size, i);
            this.o = AbstractC16967mA0.a(new AbstractC16967mA0.c() { // from class: ir.nasim.A27
                @Override // ir.nasim.AbstractC16967mA0.c
                public final Object a(AbstractC16967mA0.a aVar) {
                    return this.a.n(aVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object n(AbstractC16967mA0.a aVar) {
            this.p = aVar;
            return "SettableFuture hashCode: " + hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w() {
            J27 j27 = this.r;
            if (j27 != null) {
                j27.k();
            }
            if (this.q == null) {
                this.p.d();
            }
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        public void d() {
            super.d();
            AbstractC17949np7.d(new Runnable() { // from class: ir.nasim.z27
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.w();
                }
            });
        }

        @Override // androidx.camera.core.impl.DeferrableSurface
        protected InterfaceFutureC15215jC3 r() {
            return this.o;
        }

        boolean v() {
            AbstractC17949np7.a();
            return this.q == null && !m();
        }

        public void x(J27 j27) {
            AbstractC4980Hj5.j(this.r == null, "Consumer can only be linked once.");
            this.r = j27;
        }

        public boolean y(final DeferrableSurface deferrableSurface, Runnable runnable) {
            AbstractC17949np7.a();
            AbstractC4980Hj5.g(deferrableSurface);
            DeferrableSurface deferrableSurface2 = this.q;
            if (deferrableSurface2 == deferrableSurface) {
                return false;
            }
            AbstractC4980Hj5.j(deferrableSurface2 == null, "A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider");
            AbstractC4980Hj5.b(h().equals(deferrableSurface.h()), String.format("The provider's size(%s) must match the parent(%s)", h(), deferrableSurface.h()));
            AbstractC4980Hj5.b(i() == deferrableSurface.i(), String.format("The provider's format(%s) must match the parent(%s)", Integer.valueOf(i()), Integer.valueOf(deferrableSurface.i())));
            AbstractC4980Hj5.j(!m(), "The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.");
            this.q = deferrableSurface;
            WB2.u(deferrableSurface.j(), this.p);
            deferrableSurface.l();
            k().j(new Runnable() { // from class: ir.nasim.B27
                @Override // java.lang.Runnable
                public final void run() {
                    deferrableSurface.e();
                }
            }, AbstractC20567sE0.a());
            deferrableSurface.f().j(runnable, AbstractC20567sE0.c());
            return true;
        }
    }

    public C27(int i, int i2, androidx.camera.core.impl.w wVar, Matrix matrix, boolean z, Rect rect, int i3, int i4, boolean z2) {
        this.f = i;
        this.a = i2;
        this.g = wVar;
        this.b = matrix;
        this.c = z;
        this.d = rect;
        this.i = i3;
        this.h = i4;
        this.e = z2;
        this.l = new a(wVar.e(), i2);
    }

    private void A() {
        AbstractC17949np7.a();
        Z27.h hVarG = Z27.h.g(this.d, this.i, this.h, t(), this.b, this.e);
        Z27 z27 = this.k;
        if (z27 != null) {
            z27.D(hVarG);
        }
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            ((InterfaceC25043ze1) it.next()).accept(hVarG);
        }
    }

    private void g() {
        AbstractC4980Hj5.j(!this.j, "Consumer can only be linked once.");
        this.j = true;
    }

    private void h() {
        AbstractC4980Hj5.j(!this.n, "Edge is already closed.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ InterfaceFutureC15215jC3 w(final a aVar, int i, G27.a aVar2, G27.a aVar3, Surface surface) {
        AbstractC4980Hj5.g(surface);
        try {
            aVar.l();
            J27 j27 = new J27(surface, s(), i, this.g.e(), aVar2, aVar3, this.b);
            j27.e().j(new Runnable() { // from class: ir.nasim.y27
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.e();
                }
            }, AbstractC20567sE0.a());
            aVar.x(j27);
            return WB2.l(j27);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            return WB2.j(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        if (this.n) {
            return;
        }
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y() {
        AbstractC20567sE0.c().execute(new Runnable() { // from class: ir.nasim.x27
            @Override // java.lang.Runnable
            public final void run() {
                this.a.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i, int i2) {
        boolean z;
        boolean z2 = true;
        if (this.i != i) {
            this.i = i;
            z = true;
        } else {
            z = false;
        }
        if (this.h != i2) {
            this.h = i2;
        } else {
            z2 = z;
        }
        if (z2) {
            A();
        }
    }

    public void B(DeferrableSurface deferrableSurface) {
        AbstractC17949np7.a();
        h();
        a aVar = this.l;
        Objects.requireNonNull(aVar);
        aVar.y(deferrableSurface, new RunnableC21061t27(aVar));
    }

    public void C(final int i, final int i2) {
        AbstractC17949np7.d(new Runnable() { // from class: ir.nasim.v27
            @Override // java.lang.Runnable
            public final void run() {
                this.a.z(i, i2);
            }
        });
    }

    public void e(Runnable runnable) {
        AbstractC17949np7.a();
        h();
        this.m.add(runnable);
    }

    public void f(InterfaceC25043ze1 interfaceC25043ze1) {
        AbstractC4980Hj5.g(interfaceC25043ze1);
        this.o.add(interfaceC25043ze1);
    }

    public final void i() {
        AbstractC17949np7.a();
        this.l.d();
        this.n = true;
    }

    public InterfaceFutureC15215jC3 j(final int i, final G27.a aVar, final G27.a aVar2) {
        AbstractC17949np7.a();
        h();
        g();
        final a aVar3 = this.l;
        return WB2.z(aVar3.j(), new FK() { // from class: ir.nasim.w27
            @Override // ir.nasim.FK
            public final InterfaceFutureC15215jC3 apply(Object obj) {
                return this.a.w(aVar3, i, aVar, aVar2, (Surface) obj);
            }
        }, AbstractC20567sE0.c());
    }

    public Z27 k(InterfaceC15221jD0 interfaceC15221jD0) {
        return l(interfaceC15221jD0, true);
    }

    public Z27 l(InterfaceC15221jD0 interfaceC15221jD0, boolean z) {
        AbstractC17949np7.a();
        h();
        Z27 z27 = new Z27(this.g.e(), interfaceC15221jD0, z, this.g.b(), this.g.c(), new Runnable() { // from class: ir.nasim.s27
            @Override // java.lang.Runnable
            public final void run() {
                this.a.y();
            }
        });
        try {
            final DeferrableSurface deferrableSurfaceM = z27.m();
            a aVar = this.l;
            Objects.requireNonNull(aVar);
            if (aVar.y(deferrableSurfaceM, new RunnableC21061t27(aVar))) {
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3K = aVar.k();
                Objects.requireNonNull(deferrableSurfaceM);
                interfaceFutureC15215jC3K.j(new Runnable() { // from class: ir.nasim.u27
                    @Override // java.lang.Runnable
                    public final void run() {
                        deferrableSurfaceM.d();
                    }
                }, AbstractC20567sE0.a());
            }
            this.k = z27;
            A();
            return z27;
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new AssertionError("Surface is somehow already closed", e);
        } catch (RuntimeException e2) {
            z27.E();
            throw e2;
        }
    }

    public final void m() {
        AbstractC17949np7.a();
        h();
        this.l.d();
    }

    public Rect n() {
        return this.d;
    }

    public DeferrableSurface o() {
        AbstractC17949np7.a();
        h();
        g();
        return this.l;
    }

    public int p() {
        return this.i;
    }

    public Matrix q() {
        return this.b;
    }

    public androidx.camera.core.impl.w r() {
        return this.g;
    }

    public int s() {
        return this.f;
    }

    public boolean t() {
        return this.c;
    }

    public void u() {
        AbstractC17949np7.a();
        h();
        if (this.l.v()) {
            return;
        }
        this.j = false;
        this.l.d();
        this.l = new a(this.g.e(), this.a);
        Iterator it = this.m.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    public boolean v() {
        return this.e;
    }
}
