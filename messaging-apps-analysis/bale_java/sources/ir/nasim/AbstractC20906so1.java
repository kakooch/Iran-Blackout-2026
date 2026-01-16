package ir.nasim;

import java.util.concurrent.CancellationException;

/* renamed from: ir.nasim.so1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC20906so1 {
    public static final InterfaceC20315ro1 a(InterfaceC11938do1 interfaceC11938do1) {
        if (interfaceC11938do1.a(InterfaceC13730gj3.n0) == null) {
            interfaceC11938do1 = interfaceC11938do1.X(AbstractC20267rj3.b(null, 1, null));
        }
        return new C16140km1(interfaceC11938do1);
    }

    public static final InterfaceC20315ro1 b() {
        return new C16140km1(P17.b(null, 1, null).X(C12366eV1.c()));
    }

    public static final void c(InterfaceC20315ro1 interfaceC20315ro1, CancellationException cancellationException) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            interfaceC13730gj3.g(cancellationException);
            return;
        }
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + interfaceC20315ro1).toString());
    }

    public static /* synthetic */ void d(InterfaceC20315ro1 interfaceC20315ro1, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        c(interfaceC20315ro1, cancellationException);
    }

    public static final Object e(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC20295rm1 interfaceC20295rm1) {
        C18419od6 c18419od6 = new C18419od6(interfaceC20295rm1.getContext(), interfaceC20295rm1);
        Object objB = AbstractC13419gB7.b(c18419od6, c18419od6, interfaceC14603iB2);
        if (objB == AbstractC14862ic3.e()) {
            WA1.c(interfaceC20295rm1);
        }
        return objB;
    }

    public static final void f(InterfaceC20315ro1 interfaceC20315ro1) {
        AbstractC19067pj3.n(interfaceC20315ro1.getCoroutineContext());
    }

    public static final boolean g(InterfaceC20315ro1 interfaceC20315ro1) {
        InterfaceC13730gj3 interfaceC13730gj3 = (InterfaceC13730gj3) interfaceC20315ro1.getCoroutineContext().a(InterfaceC13730gj3.n0);
        if (interfaceC13730gj3 != null) {
            return interfaceC13730gj3.b();
        }
        return true;
    }

    public static final InterfaceC20315ro1 h(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC11938do1 interfaceC11938do1) {
        return new C16140km1(interfaceC20315ro1.getCoroutineContext().X(interfaceC11938do1));
    }
}
