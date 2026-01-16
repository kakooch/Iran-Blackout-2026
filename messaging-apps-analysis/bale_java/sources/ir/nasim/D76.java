package ir.nasim;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import io.reactivex.rxjava3.exceptions.UndeliverableException;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class D76 {
    static volatile InterfaceC23859xe1 a;
    static volatile InterfaceC16387lB2 b;
    static volatile InterfaceC16387lB2 c;

    static Object a(InterfaceC16387lB2 interfaceC16387lB2, Object obj) {
        try {
            return interfaceC16387lB2.apply(obj);
        } catch (Throwable th) {
            throw AbstractC8226Vb2.d(th);
        }
    }

    static boolean b(Throwable th) {
        return (th instanceof OnErrorNotImplementedException) || (th instanceof MissingBackpressureException) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof CompositeException);
    }

    public static IG4 c(IG4 ig4) {
        InterfaceC16387lB2 interfaceC16387lB2 = c;
        return interfaceC16387lB2 != null ? (IG4) a(interfaceC16387lB2, ig4) : ig4;
    }

    public static void d(Throwable th) {
        InterfaceC23859xe1 interfaceC23859xe1 = a;
        if (th == null) {
            th = AbstractC8226Vb2.a("onError called with a null Throwable.");
        } else if (!b(th)) {
            th = new UndeliverableException(th);
        }
        if (interfaceC23859xe1 != null) {
            try {
                interfaceC23859xe1.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                g(th2);
            }
        }
        th.printStackTrace();
        g(th);
    }

    public static Runnable e(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        InterfaceC16387lB2 interfaceC16387lB2 = b;
        return interfaceC16387lB2 == null ? runnable : (Runnable) a(interfaceC16387lB2, runnable);
    }

    static void g(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }

    public static PG4 f(IG4 ig4, PG4 pg4) {
        return pg4;
    }
}
