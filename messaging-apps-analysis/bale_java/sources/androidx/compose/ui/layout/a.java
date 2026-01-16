package androidx.compose.ui.layout;

import ir.nasim.InterfaceC15631ju3;
import ir.nasim.ZV3;

/* loaded from: classes2.dex */
public abstract class a {
    public static final Object a(ZV3 zv3) {
        Object objH = zv3.h();
        InterfaceC15631ju3 interfaceC15631ju3 = objH instanceof InterfaceC15631ju3 ? (InterfaceC15631ju3) objH : null;
        if (interfaceC15631ju3 != null) {
            return interfaceC15631ju3.Y0();
        }
        return null;
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, Object obj) {
        return eVar.i(new LayoutIdElement(obj));
    }
}
