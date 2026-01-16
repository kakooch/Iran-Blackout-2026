package ir.nasim;

import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.VerticalAlignElement;
import ir.nasim.InterfaceC12529em;

/* loaded from: classes.dex */
public final class M66 implements L66 {
    public static final M66 a = new M66();

    private M66() {
    }

    @Override // ir.nasim.L66
    public androidx.compose.ui.e a(androidx.compose.ui.e eVar, float f, boolean z) {
        if (!(((double) f) > 0.0d)) {
            K73.a("invalid weight; must be greater than zero");
        }
        return eVar.i(new LayoutWeightElement(AbstractC23053wG5.h(f, Float.MAX_VALUE), z));
    }

    @Override // ir.nasim.L66
    public androidx.compose.ui.e c(androidx.compose.ui.e eVar, InterfaceC12529em.c cVar) {
        return eVar.i(new VerticalAlignElement(cVar));
    }
}
