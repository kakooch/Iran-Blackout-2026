package ir.nasim;

import androidx.compose.ui.input.pointer.PointerHoverIconModifierElement;
import androidx.compose.ui.input.pointer.StylusHoverIconModifierElement;

/* renamed from: ir.nasim.Jg5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC5421Jg5 {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC4953Hg5 interfaceC4953Hg5, boolean z) {
        return eVar.i(new PointerHoverIconModifierElement(interfaceC4953Hg5, z));
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return a(eVar, interfaceC4953Hg5, z);
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, InterfaceC4953Hg5 interfaceC4953Hg5, boolean z, C20757sZ1 c20757sZ1) {
        return eVar.i(new StylusHoverIconModifierElement(interfaceC4953Hg5, z, c20757sZ1));
    }
}
