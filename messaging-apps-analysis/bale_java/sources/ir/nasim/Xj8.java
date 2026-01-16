package ir.nasim;

import java.util.List;

/* loaded from: classes3.dex */
public final class Xj8 extends Ni8 {
    @Override // ir.nasim.Ni8
    public final InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list) {
        if (str == null || str.isEmpty() || !c20322ro8.h(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        InterfaceC22720vi8 interfaceC22720vi8D = c20322ro8.d(str);
        if (interfaceC22720vi8D instanceof Vh8) {
            return ((Vh8) interfaceC22720vi8D).a(c20322ro8, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", str));
    }
}
