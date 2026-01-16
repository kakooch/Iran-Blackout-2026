package ir.nasim;

import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public abstract class C76 {
    private static volatile InterfaceC16387lB2 a;
    private static volatile InterfaceC16387lB2 b;

    static Object a(InterfaceC16387lB2 interfaceC16387lB2, Object obj) {
        try {
            return interfaceC16387lB2.apply(obj);
        } catch (Throwable th) {
            throw AbstractC14250hc2.a(th);
        }
    }

    static AbstractC3967Dc6 b(InterfaceC16387lB2 interfaceC16387lB2, Callable callable) {
        AbstractC3967Dc6 abstractC3967Dc6 = (AbstractC3967Dc6) a(interfaceC16387lB2, callable);
        if (abstractC3967Dc6 != null) {
            return abstractC3967Dc6;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static AbstractC3967Dc6 c(Callable callable) {
        try {
            AbstractC3967Dc6 abstractC3967Dc6 = (AbstractC3967Dc6) callable.call();
            if (abstractC3967Dc6 != null) {
                return abstractC3967Dc6;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw AbstractC14250hc2.a(th);
        }
    }

    public static AbstractC3967Dc6 d(Callable callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC16387lB2 interfaceC16387lB2 = a;
        return interfaceC16387lB2 == null ? c(callable) : b(interfaceC16387lB2, callable);
    }

    public static AbstractC3967Dc6 e(AbstractC3967Dc6 abstractC3967Dc6) {
        if (abstractC3967Dc6 == null) {
            throw new NullPointerException("scheduler == null");
        }
        InterfaceC16387lB2 interfaceC16387lB2 = b;
        return interfaceC16387lB2 == null ? abstractC3967Dc6 : (AbstractC3967Dc6) a(interfaceC16387lB2, abstractC3967Dc6);
    }
}
