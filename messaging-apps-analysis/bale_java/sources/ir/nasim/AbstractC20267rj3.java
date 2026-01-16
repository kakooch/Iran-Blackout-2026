package ir.nasim;

import ir.nasim.InterfaceC13730gj3;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: ir.nasim.rj3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract /* synthetic */ class AbstractC20267rj3 {
    public static final InterfaceC24075y01 a(InterfaceC13730gj3 interfaceC13730gj3) {
        return new C15521jj3(interfaceC13730gj3);
    }

    public static /* synthetic */ InterfaceC24075y01 b(InterfaceC13730gj3 interfaceC13730gj3, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC13730gj3 = null;
        }
        return AbstractC19067pj3.a(interfaceC13730gj3);
    }

    public static final void c(InterfaceC11938do1 interfaceC11938do1, CancellationException cancellationException) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(cancellationException);
        }
    }

    public static final void d(InterfaceC13730gj3 interfaceC13730gj3, String str, Throwable th) {
        interfaceC13730gj3.g(AbstractC15450jc2.a(str, th));
    }

    public static /* synthetic */ void e(InterfaceC11938do1 interfaceC11938do1, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        AbstractC19067pj3.c(interfaceC11938do1, cancellationException);
    }

    public static /* synthetic */ void f(InterfaceC13730gj3 interfaceC13730gj3, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        AbstractC19067pj3.d(interfaceC13730gj3, str, th);
    }

    public static final Object g(InterfaceC13730gj3 interfaceC13730gj3, InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC13730gj3.a.a(interfaceC13730gj3, null, 1, null);
        Object objK0 = interfaceC13730gj3.k0(interfaceC20295rm1);
        return objK0 == AbstractC14862ic3.e() ? objK0 : C19938rB7.a;
    }

    public static final void h(InterfaceC11938do1 interfaceC11938do1, CancellationException cancellationException) {
        InterfaceC23384wp6 interfaceC23384wp6D;
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 == null || (interfaceC23384wp6D = interfaceC13730gj3.d()) == null) {
            return;
        }
        Iterator it = interfaceC23384wp6D.iterator();
        while (it.hasNext()) {
            ((InterfaceC13730gj3) it.next()).g(cancellationException);
        }
    }

    public static final void i(InterfaceC13730gj3 interfaceC13730gj3, CancellationException cancellationException) {
        Iterator it = interfaceC13730gj3.d().iterator();
        while (it.hasNext()) {
            ((InterfaceC13730gj3) it.next()).g(cancellationException);
        }
    }

    public static /* synthetic */ void j(InterfaceC11938do1 interfaceC11938do1, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        AbstractC19067pj3.h(interfaceC11938do1, cancellationException);
    }

    public static /* synthetic */ void k(InterfaceC13730gj3 interfaceC13730gj3, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        AbstractC19067pj3.i(interfaceC13730gj3, cancellationException);
    }

    public static final NV1 l(InterfaceC13730gj3 interfaceC13730gj3, NV1 nv1) {
        return interfaceC13730gj3.s(new TV1(nv1));
    }

    public static final void m(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            AbstractC19067pj3.o(interfaceC13730gj3);
        }
    }

    public static final void n(InterfaceC13730gj3 interfaceC13730gj3) {
        if (!interfaceC13730gj3.b()) {
            throw interfaceC13730gj3.q();
        }
    }

    public static final InterfaceC13730gj3 o(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            return interfaceC13730gj3;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + interfaceC11938do1).toString());
    }

    public static final boolean p(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC11938do1.a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            return interfaceC13730gj3.b();
        }
        return true;
    }
}
