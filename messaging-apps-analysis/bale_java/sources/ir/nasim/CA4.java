package ir.nasim;

import ir.nasim.InterfaceC15947kS0;
import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
final class CA4 implements InterfaceC15947kS0 {
    public static final CA4 a = new CA4();
    private static final String b = "should not have varargs or parameters with default values";

    private CA4() {
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public boolean a(AB2 ab2) {
        AbstractC13042fc3.i(ab2, "functionDescriptor");
        List listH = ab2.h();
        AbstractC13042fc3.h(listH, "functionDescriptor.valueParameters");
        List<InterfaceC24919zQ7> list = listH;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (InterfaceC24919zQ7 interfaceC24919zQ7 : list) {
            AbstractC13042fc3.h(interfaceC24919zQ7, "it");
            if (PI1.a(interfaceC24919zQ7) || interfaceC24919zQ7.u0() != null) {
                return false;
            }
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String b(AB2 ab2) {
        return InterfaceC15947kS0.a.a(this, ab2);
    }

    @Override // ir.nasim.InterfaceC15947kS0
    public String getDescription() {
        return b;
    }
}
