package androidx.compose.foundation.lazy.layout;

import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import ir.nasim.AbstractC5138Ib1;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.InterfaceC6030Lw3;
import ir.nasim.SA2;

/* loaded from: classes.dex */
public abstract class f {
    public static final float a(int i, int i2, boolean z) {
        return z ? b(i, i2) + 100 : b(i, i2);
    }

    public static final float b(int i, int i2) {
        return i2 + (i * SIPTransactionStack.BASE_TIMER_INTERVAL);
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, SA2 sa2, InterfaceC6030Lw3 interfaceC6030Lw3, EnumC24286yM4 enumC24286yM4, boolean z, boolean z2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1070136913, i, -1, "androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:48)");
        }
        androidx.compose.ui.e eVarI = eVar.i(new LazyLayoutSemanticsModifier(sa2, interfaceC6030Lw3, enumC24286yM4, z, z2));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return eVarI;
    }
}
