package androidx.compose.foundation.lazy.layout;

import ir.nasim.C15060iw3;
import ir.nasim.EnumC24286yM4;
import ir.nasim.InterfaceC16242kw3;

/* loaded from: classes.dex */
public abstract class b {
    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, InterfaceC16242kw3 interfaceC16242kw3, C15060iw3 c15060iw3, boolean z, EnumC24286yM4 enumC24286yM4) {
        return eVar.i(new LazyLayoutBeyondBoundsModifierElement(interfaceC16242kw3, c15060iw3, z, enumC24286yM4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void c() {
        throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
    }
}
