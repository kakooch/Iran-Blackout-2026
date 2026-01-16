package androidx.compose.material.ripple;

import android.view.ViewGroup;
import ir.nasim.A26;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC13472gH6;
import ir.nasim.AbstractC18075o26;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC7624Sn;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17484n26;
import ir.nasim.C19938rB7;
import ir.nasim.C24381yX0;
import ir.nasim.ED1;
import ir.nasim.InterfaceC20315ro1;
import ir.nasim.InterfaceC21734u26;
import ir.nasim.InterfaceC23919xk1;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.InterfaceC9102Ym4;
import ir.nasim.InterfaceC9664aL6;
import ir.nasim.OD6;
import ir.nasim.SA2;
import ir.nasim.UE0;
import ir.nasim.YM5;

/* loaded from: classes.dex */
public final class a extends d implements YM5, InterfaceC21734u26 {
    private final boolean c;
    private final float d;
    private final InterfaceC9664aL6 e;
    private final InterfaceC9664aL6 f;
    private final ViewGroup g;
    private RippleContainer h;
    private final InterfaceC9102Ym4 i;
    private final InterfaceC9102Ym4 j;
    private long k;
    private int l;
    private final SA2 m;

    /* renamed from: androidx.compose.material.ripple.a$a, reason: collision with other inner class name */
    static final class C0053a extends AbstractC8614Ws3 implements SA2 {
        C0053a() {
            super(0);
        }

        public final void a() {
            a.this.o(!r0.l());
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ a(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, ViewGroup viewGroup, ED1 ed1) {
        this(z, f, interfaceC9664aL6, interfaceC9664aL62, viewGroup);
    }

    private final void k() {
        RippleContainer rippleContainer = this.h;
        if (rippleContainer != null) {
            rippleContainer.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l() {
        return ((Boolean) this.j.getValue()).booleanValue();
    }

    private final RippleContainer m() {
        RippleContainer rippleContainer = this.h;
        if (rippleContainer != null) {
            AbstractC13042fc3.f(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = A26.c(this.g);
        this.h = rippleContainerC;
        AbstractC13042fc3.f(rippleContainerC);
        return rippleContainerC;
    }

    private final RippleHostView n() {
        return (RippleHostView) this.i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
    }

    private final void p(RippleHostView rippleHostView) {
        this.i.setValue(rippleHostView);
    }

    @Override // ir.nasim.InterfaceC16930m63
    public void a(InterfaceC23919xk1 interfaceC23919xk1) throws Throwable {
        this.k = interfaceC23919xk1.d();
        this.l = Float.isNaN(this.d) ? AbstractC20723sV3.d(AbstractC18075o26.a(interfaceC23919xk1, this.c, interfaceC23919xk1.d())) : interfaceC23919xk1.B0(this.d);
        long jY = ((C24381yX0) this.e.getValue()).y();
        float fD = ((C17484n26) this.f.getValue()).d();
        interfaceC23919xk1.N1();
        f(interfaceC23919xk1, this.d, jY);
        UE0 ue0E = interfaceC23919xk1.z1().e();
        l();
        RippleHostView rippleHostViewN = n();
        if (rippleHostViewN != null) {
            rippleHostViewN.m0setRipplePropertiesbiQXAtU(interfaceC23919xk1.d(), this.l, jY, fD);
            rippleHostViewN.draw(AbstractC7624Sn.d(ue0E));
        }
    }

    @Override // ir.nasim.YM5
    public void b() {
    }

    @Override // androidx.compose.material.ripple.d
    public void c(InterfaceC6693Oo5.b bVar, InterfaceC20315ro1 interfaceC20315ro1) {
        RippleHostView rippleHostViewB = m().b(this);
        rippleHostViewB.b(bVar, this.c, this.k, this.l, ((C24381yX0) this.e.getValue()).y(), ((C17484n26) this.f.getValue()).d(), this.m);
        p(rippleHostViewB);
    }

    @Override // ir.nasim.YM5
    public void d() {
        k();
    }

    @Override // ir.nasim.YM5
    public void e() {
        k();
    }

    @Override // androidx.compose.material.ripple.d
    public void g(InterfaceC6693Oo5.b bVar) {
        RippleHostView rippleHostViewN = n();
        if (rippleHostViewN != null) {
            rippleHostViewN.e();
        }
    }

    @Override // ir.nasim.InterfaceC21734u26
    public void j1() {
        p(null);
    }

    private a(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, ViewGroup viewGroup) {
        super(z, interfaceC9664aL62);
        this.c = z;
        this.d = f;
        this.e = interfaceC9664aL6;
        this.f = interfaceC9664aL62;
        this.g = viewGroup;
        this.i = AbstractC13472gH6.d(null, null, 2, null);
        this.j = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
        this.k = OD6.b.b();
        this.l = -1;
        this.m = new C0053a();
    }
}
