package ir.nasim;

import ir.nasim.C9475a16;

/* loaded from: classes8.dex */
public abstract class NE0 {
    private static final void a(InterfaceC20295rm1 interfaceC20295rm1, Throwable th) throws Throwable {
        C9475a16.a aVar = C9475a16.b;
        interfaceC20295rm1.resumeWith(C9475a16.b(AbstractC10685c16.a(th)));
        throw th;
    }

    public static final void b(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC20295rm1 interfaceC20295rm12) throws Throwable {
        try {
            InterfaceC20295rm1 interfaceC20295rm1C = AbstractC14251hc3.c(interfaceC20295rm1);
            C9475a16.a aVar = C9475a16.b;
            UU1.c(interfaceC20295rm1C, C9475a16.b(C19938rB7.a), null, 2, null);
        } catch (Throwable th) {
            a(interfaceC20295rm12, th);
        }
    }

    public static final void c(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1, UA2 ua2) throws Throwable {
        try {
            InterfaceC20295rm1 interfaceC20295rm1C = AbstractC14251hc3.c(AbstractC14251hc3.a(interfaceC14603iB2, obj, interfaceC20295rm1));
            C9475a16.a aVar = C9475a16.b;
            UU1.b(interfaceC20295rm1C, C9475a16.b(C19938rB7.a), ua2);
        } catch (Throwable th) {
            a(interfaceC20295rm1, th);
        }
    }

    public static /* synthetic */ void d(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1, UA2 ua2, int i, Object obj2) throws Throwable {
        if ((i & 4) != 0) {
            ua2 = null;
        }
        c(interfaceC14603iB2, obj, interfaceC20295rm1, ua2);
    }
}
