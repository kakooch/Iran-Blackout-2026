package androidx.compose.ui.draw;

import ir.nasim.C14988ip0;
import ir.nasim.InterfaceC14380hp0;
import ir.nasim.UA2;

/* loaded from: classes2.dex */
public abstract class b {
    public static final InterfaceC14380hp0 a(UA2 ua2) {
        return new a(new C14988ip0(), ua2);
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new DrawBehindElement(ua2));
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new DrawWithCacheElement(ua2));
    }

    public static final androidx.compose.ui.e d(androidx.compose.ui.e eVar, UA2 ua2) {
        return eVar.i(new DrawWithContentElement(ua2));
    }
}
