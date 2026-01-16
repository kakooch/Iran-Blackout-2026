package androidx.compose.material.ripple;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.A26;
import ir.nasim.AbstractC10434bc1;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.AbstractC16278l02;
import ir.nasim.AbstractC20723sV3;
import ir.nasim.AbstractC7624Sn;
import ir.nasim.AbstractC8614Ws3;
import ir.nasim.C17484n26;
import ir.nasim.C19938rB7;
import ir.nasim.ED1;
import ir.nasim.InterfaceC17460n02;
import ir.nasim.InterfaceC21734u26;
import ir.nasim.InterfaceC23241wb3;
import ir.nasim.InterfaceC6693Oo5;
import ir.nasim.SA2;
import ir.nasim.UE0;
import ir.nasim.VX0;

/* loaded from: classes.dex */
public final class b extends RippleNode implements InterfaceC21734u26 {
    private RippleContainer y;
    private RippleHostView z;

    static final class a extends AbstractC8614Ws3 implements SA2 {
        a() {
            super(0);
        }

        public final void a() {
            AbstractC16278l02.a(b.this);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    public /* synthetic */ b(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2, ED1 ed1) {
        this(interfaceC23241wb3, z, f, vx0, sa2);
    }

    private final RippleContainer K2() {
        RippleContainer rippleContainer = this.y;
        if (rippleContainer != null) {
            AbstractC13042fc3.f(rippleContainer);
            return rippleContainer;
        }
        RippleContainer rippleContainerC = A26.c(A26.e((View) AbstractC10434bc1.a(this, AndroidCompositionLocals_androidKt.k())));
        this.y = rippleContainerC;
        AbstractC13042fc3.f(rippleContainerC);
        return rippleContainerC;
    }

    private final void L2(RippleHostView rippleHostView) {
        this.z = rippleHostView;
        AbstractC16278l02.a(this);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void A2(InterfaceC6693Oo5.b bVar, long j, float f) {
        RippleHostView rippleHostViewB = K2().b(this);
        rippleHostViewB.b(bVar, getBounded(), j, AbstractC20723sV3.d(f), E2(), ((C17484n26) getRippleAlpha().invoke()).d(), new a());
        L2(rippleHostViewB);
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void B2(InterfaceC17460n02 interfaceC17460n02) {
        UE0 ue0E = interfaceC17460n02.z1().e();
        RippleHostView rippleHostView = this.z;
        if (rippleHostView != null) {
            rippleHostView.m0setRipplePropertiesbiQXAtU(getRippleSize(), AbstractC20723sV3.d(getTargetRadius()), E2(), ((C17484n26) getRippleAlpha().invoke()).d());
            rippleHostView.draw(AbstractC7624Sn.d(ue0E));
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void I2(InterfaceC6693Oo5.b bVar) {
        RippleHostView rippleHostView = this.z;
        if (rippleHostView != null) {
            rippleHostView.e();
        }
    }

    @Override // androidx.compose.ui.e.c
    public void f2() {
        RippleContainer rippleContainer = this.y;
        if (rippleContainer != null) {
            rippleContainer.a(this);
        }
    }

    @Override // ir.nasim.InterfaceC21734u26
    public void j1() {
        L2(null);
    }

    private b(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, VX0 vx0, SA2 sa2) {
        super(interfaceC23241wb3, z, f, vx0, sa2, null);
    }
}
