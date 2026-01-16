package ir.nasim;

/* renamed from: ir.nasim.lj4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC16704lj4 {
    public static final InterfaceC15522jj4 a(InterfaceC11938do1 interfaceC11938do1) {
        InterfaceC15522jj4 interfaceC15522jj4 = (InterfaceC15522jj4) interfaceC11938do1.a(InterfaceC15522jj4.o0);
        if (interfaceC15522jj4 != null) {
            return interfaceC15522jj4;
        }
        throw new IllegalStateException("A MonotonicFrameClock is not available in this CoroutineContext. Callers should supply an appropriate MonotonicFrameClock using withContext.".toString());
    }

    public static final Object b(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return a(interfaceC20295rm1.getContext()).G(new C16113kj4(ua2), interfaceC20295rm1);
    }

    public static final Object c(UA2 ua2, InterfaceC20295rm1 interfaceC20295rm1) {
        return a(interfaceC20295rm1.getContext()).G(ua2, interfaceC20295rm1);
    }
}
