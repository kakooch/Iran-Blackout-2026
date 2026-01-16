package ir.nasim;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.ci8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC11264ci8 {
    public static InterfaceC22720vi8 a(InterfaceC14926ii8 interfaceC14926ii8, InterfaceC22720vi8 interfaceC22720vi8, C20322ro8 c20322ro8, List list) {
        if (interfaceC14926ii8.f(interfaceC22720vi8.j())) {
            InterfaceC22720vi8 interfaceC22720vi8H = interfaceC14926ii8.h(interfaceC22720vi8.j());
            if (interfaceC22720vi8H instanceof Vh8) {
                return ((Vh8) interfaceC22720vi8H).a(c20322ro8, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", interfaceC22720vi8.j()));
        }
        if (!"hasOwnProperty".equals(interfaceC22720vi8.j())) {
            throw new IllegalArgumentException(String.format("Object has no function %s", interfaceC22720vi8.j()));
        }
        AbstractC9951ap8.h("hasOwnProperty", 1, list);
        return interfaceC14926ii8.f(c20322ro8.b((InterfaceC22720vi8) list.get(0)).j()) ? InterfaceC22720vi8.w0 : InterfaceC22720vi8.x0;
    }

    public static Iterator b(Map map) {
        return new C13134fi8(map.keySet().iterator());
    }
}
