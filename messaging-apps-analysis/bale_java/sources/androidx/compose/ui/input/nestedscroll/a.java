package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.e;
import ir.nasim.C25166zq4;
import ir.nasim.InterfaceC24572yq4;

/* loaded from: classes2.dex */
public abstract class a {
    public static final e a(e eVar, InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4) {
        return eVar.i(new NestedScrollElement(interfaceC24572yq4, c25166zq4));
    }

    public static /* synthetic */ e b(e eVar, InterfaceC24572yq4 interfaceC24572yq4, C25166zq4 c25166zq4, int i, Object obj) {
        if ((i & 2) != 0) {
            c25166zq4 = null;
        }
        return a(eVar, interfaceC24572yq4, c25166zq4);
    }
}
