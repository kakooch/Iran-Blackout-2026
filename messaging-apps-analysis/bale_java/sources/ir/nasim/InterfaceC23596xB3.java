package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.xB3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public interface InterfaceC23596xB3 extends InterfaceC5194Ih3 {

    /* renamed from: ir.nasim.xB3$a */
    public static final class a {
        public static InterfaceC4009Dh3 a(InterfaceC23596xB3 interfaceC23596xB3, C9424Zw2 c9424Zw2) {
            Object obj;
            AbstractC13042fc3.i(interfaceC23596xB3, "this");
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            Iterator it = interfaceC23596xB3.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                C24948zU0 c24948zU0F = ((InterfaceC4009Dh3) next).f();
                if (AbstractC13042fc3.d(c24948zU0F != null ? c24948zU0F.b() : null, c9424Zw2)) {
                    obj = next;
                    break;
                }
            }
            return (InterfaceC4009Dh3) obj;
        }
    }
}
