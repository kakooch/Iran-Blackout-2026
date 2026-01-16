package ir.nasim;

import java.util.Collection;
import java.util.ServiceLoader;

/* renamed from: ir.nasim.io1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC14979io1 {
    private static final Collection a = AbstractC11342cq6.K(AbstractC9962aq6.c(ServiceLoader.load(InterfaceC14371ho1.class, InterfaceC14371ho1.class.getClassLoader()).iterator()));

    public static final Collection a() {
        return a;
    }

    public static final void b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
