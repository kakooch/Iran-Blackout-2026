package ir.nasim;

/* renamed from: ir.nasim.ko1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16160ko1 {
    public static final void a(InterfaceC11938do1 interfaceC11938do1, Throwable th) {
        try {
            InterfaceC14371ho1 interfaceC14371ho1 = (InterfaceC14371ho1) interfaceC11938do1.a(InterfaceC14371ho1.h0);
            if (interfaceC14371ho1 != null) {
                interfaceC14371ho1.m(interfaceC11938do1, th);
            } else {
                AbstractC15569jo1.a(interfaceC11938do1, th);
            }
        } catch (Throwable th2) {
            AbstractC15569jo1.a(interfaceC11938do1, b(th, th2));
        }
    }

    public static final Throwable b(Throwable th, Throwable th2) {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC16632lc2.a(runtimeException, th);
        return runtimeException;
    }
}
