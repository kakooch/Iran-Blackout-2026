package ir.nasim;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class wv8 extends Vh8 {
    private final Iq8 c;
    final Map d;

    public wv8(Iq8 iq8) {
        super("require");
        this.d = new HashMap();
        this.c = iq8;
    }

    @Override // ir.nasim.Vh8
    public final InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list) {
        InterfaceC22720vi8 interfaceC22720vi8;
        AbstractC9951ap8.h("require", 1, list);
        String strJ = c20322ro8.b((InterfaceC22720vi8) list.get(0)).j();
        if (this.d.containsKey(strJ)) {
            return (InterfaceC22720vi8) this.d.get(strJ);
        }
        Iq8 iq8 = this.c;
        if (iq8.a.containsKey(strJ)) {
            try {
                interfaceC22720vi8 = (InterfaceC22720vi8) ((Callable) iq8.a.get(strJ)).call();
            } catch (Exception unused) {
                throw new IllegalStateException("Failed to create API implementation: ".concat(String.valueOf(strJ)));
            }
        } else {
            interfaceC22720vi8 = InterfaceC22720vi8.r0;
        }
        if (interfaceC22720vi8 instanceof Vh8) {
            this.d.put(strJ, (Vh8) interfaceC22720vi8);
        }
        return interfaceC22720vi8;
    }
}
