package ir.nasim;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class Ni8 {
    final List a = new ArrayList();

    protected Ni8() {
    }

    public abstract InterfaceC22720vi8 a(String str, C20322ro8 c20322ro8, List list);

    final InterfaceC22720vi8 b(String str) {
        if (this.a.contains(AbstractC9951ap8.e(str))) {
            throw new UnsupportedOperationException("Command not implemented: ".concat(String.valueOf(str)));
        }
        throw new IllegalArgumentException("Command not supported");
    }
}
