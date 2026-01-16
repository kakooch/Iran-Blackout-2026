package ir.nasim;

import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.LayoutWeightElement;
import ir.nasim.InterfaceC12529em;

/* renamed from: ir.nasim.aZ0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9784aZ0 implements ZY0 {
    public static final C9784aZ0 a = new C9784aZ0();

    private C9784aZ0() {
    }

    @Override // ir.nasim.ZY0
    public androidx.compose.ui.e a(androidx.compose.ui.e eVar, float f, boolean z) {
        if (!(((double) f) > 0.0d)) {
            K73.a("invalid weight; must be greater than zero");
        }
        return eVar.i(new LayoutWeightElement(AbstractC23053wG5.h(f, Float.MAX_VALUE), z));
    }

    @Override // ir.nasim.ZY0
    public androidx.compose.ui.e c(androidx.compose.ui.e eVar, InterfaceC12529em.b bVar) {
        return eVar.i(new HorizontalAlignElement(bVar));
    }
}
