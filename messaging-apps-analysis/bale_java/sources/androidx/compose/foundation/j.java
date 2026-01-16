package androidx.compose.foundation;

import ir.nasim.InterfaceC18507om4;

/* loaded from: classes.dex */
public abstract class j {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, boolean z, InterfaceC18507om4 interfaceC18507om4) {
        return eVar.i(z ? new FocusableElement(interfaceC18507om4) : androidx.compose.ui.e.a);
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, boolean z, InterfaceC18507om4 interfaceC18507om4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            interfaceC18507om4 = null;
        }
        return a(eVar, z, interfaceC18507om4);
    }
}
