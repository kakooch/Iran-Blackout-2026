package ir.nasim;

import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;

/* renamed from: ir.nasim.pf5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C19029pf5 extends AbstractC16893m26 {
    public /* synthetic */ C19029pf5(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, ED1 ed1) {
        this(z, f, interfaceC9664aL6);
    }

    @Override // ir.nasim.AbstractC16893m26
    public androidx.compose.material.ripple.d c(InterfaceC23241wb3 interfaceC23241wb3, boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(331259447);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(331259447, i, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:84)");
        }
        ViewGroup viewGroupE = A26.e((View) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.k()));
        boolean zV = ((((i & 14) ^ 6) > 4 && interfaceC22053ub1.V(interfaceC23241wb3)) || (i & 6) == 4) | ((((458752 & i) ^ 196608) > 131072 && interfaceC22053ub1.V(this)) || (i & 196608) == 131072) | interfaceC22053ub1.V(viewGroupE);
        Object objB = interfaceC22053ub1.B();
        if (zV || objB == InterfaceC22053ub1.a.a()) {
            objB = new androidx.compose.material.ripple.a(z, f, interfaceC9664aL6, interfaceC9664aL62, viewGroupE, null);
            interfaceC22053ub1.s(objB);
        }
        androidx.compose.material.ripple.a aVar = (androidx.compose.material.ripple.a) objB;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        interfaceC22053ub1.Q();
        return aVar;
    }

    private C19029pf5(boolean z, float f, InterfaceC9664aL6 interfaceC9664aL6) {
        super(z, f, interfaceC9664aL6, null);
    }
}
