package androidx.compose.foundation;

import ir.nasim.InterfaceC18507om4;

/* loaded from: classes.dex */
public abstract class k {
    public static final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, boolean z) {
        return eVar.i(z ? new HoverableElement(interfaceC18507om4) : androidx.compose.ui.e.a);
    }

    public static /* synthetic */ androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC18507om4 interfaceC18507om4, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return a(eVar, interfaceC18507om4, z);
    }
}
