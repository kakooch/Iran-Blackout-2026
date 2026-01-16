package ir.nasim;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.t92, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC21126t92 extends AbstractC11429cz6 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC21126t92(D26 d26) {
        super(d26);
        AbstractC13042fc3.i(d26, "database");
    }

    protected abstract void i(InterfaceC15121j27 interfaceC15121j27, Object obj);

    public final void j(Iterable iterable) {
        AbstractC13042fc3.i(iterable, "entities");
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                i(interfaceC15121j27B, it.next());
                interfaceC15121j27B.M0();
            }
        } finally {
            h(interfaceC15121j27B);
        }
    }

    public final void k(Object obj) {
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            i(interfaceC15121j27B, obj);
            interfaceC15121j27B.M0();
        } finally {
            h(interfaceC15121j27B);
        }
    }

    public final void l(Object[] objArr) {
        AbstractC13042fc3.i(objArr, "entities");
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            for (Object obj : objArr) {
                i(interfaceC15121j27B, obj);
                interfaceC15121j27B.M0();
            }
        } finally {
            h(interfaceC15121j27B);
        }
    }

    public final List m(Collection collection) {
        AbstractC13042fc3.i(collection, "entities");
        InterfaceC15121j27 interfaceC15121j27B = b();
        try {
            List listC = AbstractC9766aX0.c();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                i(interfaceC15121j27B, it.next());
                listC.add(Long.valueOf(interfaceC15121j27B.M0()));
            }
            List listA = AbstractC9766aX0.a(listC);
            h(interfaceC15121j27B);
            return listA;
        } catch (Throwable th) {
            h(interfaceC15121j27B);
            throw th;
        }
    }
}
