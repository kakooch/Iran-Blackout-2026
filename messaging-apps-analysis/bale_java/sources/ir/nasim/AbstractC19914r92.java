package ir.nasim;

import java.util.Iterator;

/* renamed from: ir.nasim.r92, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19914r92 extends AbstractC11429cz6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC19914r92(D26 d26) {
        super(d26);
        AbstractC13042fc3.i(d26, "database");
    }

    protected abstract void i(InterfaceC15121j27 interfaceC15121j27, Object obj);

    public final int j(Object obj) {
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            i(interfaceC15121j27B, obj);
            return interfaceC15121j27B.V();
        } finally {
            h(interfaceC15121j27B);
        }
    }

    public final int k(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "entities");
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            Iterator it = iterable.iterator();
            int iV = 0;
            while (it.hasNext()) {
                i(interfaceC15121j27B, it.next());
                iV += interfaceC15121j27B.V();
            }
            return iV;
        } finally {
            h(interfaceC15121j27B);
        }
    }
}
