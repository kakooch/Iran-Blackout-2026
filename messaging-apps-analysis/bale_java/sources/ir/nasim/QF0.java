package ir.nasim;

import android.util.Size;
import android.view.Surface;
import androidx.camera.core.e;
import androidx.camera.core.impl.DeferrableSurface;
import ir.nasim.C11982ds5;
import ir.nasim.C17889nj7;
import ir.nasim.O23;
import java.util.Objects;

/* loaded from: classes.dex */
class QF0 {
    AbstractC12595es5 a;
    androidx.camera.core.i b;
    androidx.camera.core.i c;
    private C11982ds5.a d;
    private c e;
    private HA4 f = null;

    class a extends JB0 {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            AbstractC12595es5 abstractC12595es5 = QF0.this.a;
        }

        @Override // ir.nasim.JB0
        public void d(int i) {
            AbstractC20567sE0.c().execute(new Runnable() { // from class: ir.nasim.PF0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.f();
                }
            });
        }
    }

    static abstract class c {
        private DeferrableSurface b;
        private JB0 a = new a();
        private DeferrableSurface c = null;

        class a extends JB0 {
            a() {
            }
        }

        c() {
        }

        static c l(Size size, int i, int i2, boolean z, P23 p23, Size size2, int i3) {
            return new WS(size, i, i2, z, p23, size2, i3, new X22(), new X22());
        }

        abstract X22 a();

        abstract P23 b();

        abstract int c();

        abstract int d();

        abstract int e();

        abstract Size f();

        DeferrableSurface g() {
            return this.c;
        }

        abstract X22 h();

        abstract Size i();

        DeferrableSurface j() {
            DeferrableSurface deferrableSurface = this.b;
            Objects.requireNonNull(deferrableSurface);
            return deferrableSurface;
        }

        abstract boolean k();

        void m(JB0 jb0) {
            this.a = jb0;
        }

        void n(Surface surface, Size size, int i) {
            this.c = new W33(surface, size, i);
        }

        void o(Surface surface) {
            AbstractC4980Hj5.j(this.b == null, "The surface is already set.");
            this.b = new W33(surface, i(), c());
        }
    }

    QF0() {
    }

    private static O23 g(P23 p23, int i, int i2, int i3) {
        return p23 != null ? p23.a(i, i2, i3, 4, 0L) : androidx.camera.core.g.a(i, i2, i3, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(androidx.camera.core.i iVar) {
        if (iVar != null) {
            iVar.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(AbstractC12595es5 abstractC12595es5) {
        p(abstractC12595es5);
        this.f.h(abstractC12595es5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(O23 o23) {
        try {
            androidx.camera.core.f fVarB = o23.b();
            if (fVarB != null) {
                o(fVarB);
            }
        } catch (IllegalStateException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(O23 o23) {
        try {
            androidx.camera.core.f fVarB = o23.b();
            if (fVarB != null) {
                q(fVarB);
            }
        } catch (IllegalStateException e) {
            PI3.d("CaptureNode", "Failed to acquire latest image of postview", e);
        }
    }

    private void n(androidx.camera.core.f fVar) {
        AbstractC17949np7.a();
        C11982ds5.a aVar = this.d;
        Objects.requireNonNull(aVar);
        aVar.a().accept(C11982ds5.b.c(this.a, fVar));
        this.a.p();
    }

    private void q(androidx.camera.core.f fVar) {
        PI3.l("CaptureNode", "Postview image is closed due to request completed or aborted");
        fVar.close();
    }

    private void s(c cVar, final androidx.camera.core.i iVar, final androidx.camera.core.i iVar2) {
        cVar.j().d();
        cVar.j().k().j(new Runnable() { // from class: ir.nasim.NF0
            @Override // java.lang.Runnable
            public final void run() {
                iVar.l();
            }
        }, AbstractC20567sE0.c());
        if (cVar.g() != null) {
            cVar.g().d();
            cVar.g().k().j(new Runnable() { // from class: ir.nasim.OF0
                @Override // java.lang.Runnable
                public final void run() {
                    QF0.j(iVar2);
                }
            }, AbstractC20567sE0.c());
        }
    }

    public int h() {
        AbstractC17949np7.a();
        AbstractC4980Hj5.j(this.b != null, "The ImageReader is not initialized.");
        return this.b.i();
    }

    void o(androidx.camera.core.f fVar) {
        AbstractC17949np7.a();
        PI3.l("CaptureNode", "Discarding ImageProxy which was inadvertently acquired: " + fVar);
        fVar.close();
    }

    void p(AbstractC12595es5 abstractC12595es5) {
        AbstractC17949np7.a();
        AbstractC4980Hj5.j(abstractC12595es5.h().size() == 1, "only one capture stage is supported.");
        AbstractC4980Hj5.j(h() > 0, "Too many acquire images. Close image to be able to process next.");
        WB2.g(abstractC12595es5.a(), new b(abstractC12595es5), AbstractC20567sE0.a());
    }

    public void r() {
        AbstractC17949np7.a();
        c cVar = this.e;
        Objects.requireNonNull(cVar);
        androidx.camera.core.i iVar = this.b;
        Objects.requireNonNull(iVar);
        s(cVar, iVar, this.c);
    }

    void t(C17889nj7.a aVar) {
        AbstractC17949np7.a();
    }

    public void u(e.a aVar) {
        AbstractC17949np7.a();
        AbstractC4980Hj5.j(this.b != null, "The ImageReader is not initialized.");
        this.b.m(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C11982ds5.a v(c cVar) {
        InterfaceC25043ze1 interfaceC25043ze1;
        HA4 ha4;
        AbstractC4980Hj5.j(this.e == null && this.b == null, "CaptureNode does not support recreation yet.");
        this.e = cVar;
        Size sizeI = cVar.i();
        int iC = cVar.c();
        boolean z = !cVar.k();
        JB0 aVar = new a();
        if (z) {
            cVar.b();
            androidx.camera.core.h hVar = new androidx.camera.core.h(sizeI.getWidth(), sizeI.getHeight(), iC, 4);
            aVar = KB0.b(aVar, hVar.m());
            interfaceC25043ze1 = new InterfaceC25043ze1() { // from class: ir.nasim.IF0
                @Override // ir.nasim.InterfaceC25043ze1
                public final void accept(Object obj) {
                    this.a.p((AbstractC12595es5) obj);
                }
            };
            ha4 = hVar;
        } else {
            cVar.b();
            HA4 ha42 = new HA4(g(null, sizeI.getWidth(), sizeI.getHeight(), iC));
            this.f = ha42;
            interfaceC25043ze1 = new InterfaceC25043ze1() { // from class: ir.nasim.JF0
                @Override // ir.nasim.InterfaceC25043ze1
                public final void accept(Object obj) {
                    this.a.k((AbstractC12595es5) obj);
                }
            };
            ha4 = ha42;
        }
        cVar.m(aVar);
        Surface surface = ha4.getSurface();
        Objects.requireNonNull(surface);
        cVar.o(surface);
        this.b = new androidx.camera.core.i(ha4);
        ha4.f(new O23.a() { // from class: ir.nasim.KF0
            @Override // ir.nasim.O23.a
            public final void a(O23 o23) {
                this.a.l(o23);
            }
        }, AbstractC20567sE0.c());
        if (cVar.f() != null) {
            cVar.b();
            O23 o23G = g(null, cVar.f().getWidth(), cVar.f().getHeight(), cVar.e());
            o23G.f(new O23.a() { // from class: ir.nasim.LF0
                @Override // ir.nasim.O23.a
                public final void a(O23 o23) {
                    this.a.m(o23);
                }
            }, AbstractC20567sE0.c());
            this.c = new androidx.camera.core.i(o23G);
            cVar.n(o23G.getSurface(), cVar.f(), cVar.e());
        }
        cVar.h().a(interfaceC25043ze1);
        cVar.a().a(new InterfaceC25043ze1() { // from class: ir.nasim.MF0
            @Override // ir.nasim.InterfaceC25043ze1
            public final void accept(Object obj) {
                this.a.t((C17889nj7.a) obj);
            }
        });
        C11982ds5.a aVarE = C11982ds5.a.e(cVar.c(), cVar.d());
        this.d = aVarE;
        return aVarE;
    }

    class b implements MB2 {
        final /* synthetic */ AbstractC12595es5 a;

        b(AbstractC12595es5 abstractC12595es5) {
        }

        @Override // ir.nasim.MB2
        public void onFailure(Throwable th) {
            AbstractC17949np7.a();
            if (this.a == QF0.this.a) {
                PI3.l("CaptureNode", "request aborted, id=" + QF0.this.a.e());
                if (QF0.this.f != null) {
                    QF0.this.f.i();
                }
                QF0.this.a = null;
            }
        }

        @Override // ir.nasim.MB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Void r1) {
        }
    }
}
