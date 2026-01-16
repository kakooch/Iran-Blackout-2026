package ir.nasim;

import java.util.Set;

/* renamed from: ir.nasim.i01, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14488i01 {
    public static final boolean a(C13895h01 c13895h01, InterfaceC21331tU0 interfaceC21331tU0) {
        AbstractC13042fc3.i(c13895h01, "<this>");
        AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
        if (OI1.x(interfaceC21331tU0)) {
            Set setB = c13895h01.b();
            C24948zU0 c24948zU0H = PI1.h(interfaceC21331tU0);
            if (AbstractC15401jX0.i0(setB, c24948zU0H == null ? null : c24948zU0H.g())) {
                return true;
            }
        }
        return false;
    }
}
