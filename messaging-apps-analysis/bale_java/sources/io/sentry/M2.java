package io.sentry;

import android.gov.nist.core.Separators;
import io.sentry.exception.ExceptionMechanismException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class M2 {
    private final C3183r3 a;

    public M2(C3183r3 c3183r3) {
        this.a = (C3183r3) io.sentry.util.u.c(c3183r3, "The SentryStackTraceFactory is required.");
    }

    private io.sentry.protocol.q c(Throwable th, io.sentry.protocol.j jVar, Long l, List list, boolean z) {
        Package r0 = th.getClass().getPackage();
        String name = th.getClass().getName();
        io.sentry.protocol.q qVar = new io.sentry.protocol.q();
        String message = th.getMessage();
        if (r0 != null) {
            name = name.replace(r0.getName() + Separators.DOT, "");
        }
        String name2 = r0 != null ? r0.getName() : null;
        if (list != null && !list.isEmpty()) {
            io.sentry.protocol.A a = new io.sentry.protocol.A(list);
            if (z) {
                a.e(Boolean.TRUE);
            }
            qVar.n(a);
        }
        qVar.o(l);
        qVar.p(name);
        qVar.l(jVar);
        qVar.m(name2);
        qVar.r(message);
        return qVar;
    }

    private List e(Deque deque) {
        return new ArrayList(deque);
    }

    Deque a(Throwable th) {
        return b(th, new AtomicInteger(-1), new HashSet(), new ArrayDeque(), null);
    }

    Deque b(Throwable th, AtomicInteger atomicInteger, HashSet hashSet, Deque deque, String str) {
        io.sentry.protocol.j jVar;
        boolean zD;
        Throwable th2;
        Thread threadCurrentThread;
        String str2 = str;
        int i = atomicInteger.get();
        Throwable cause = th;
        while (cause != null && hashSet.add(cause)) {
            if (str2 == null) {
                str2 = "chained";
            }
            if (cause instanceof ExceptionMechanismException) {
                ExceptionMechanismException exceptionMechanismException = (ExceptionMechanismException) cause;
                jVar = exceptionMechanismException.a();
                Throwable thC = exceptionMechanismException.c();
                Thread threadB = exceptionMechanismException.b();
                zD = exceptionMechanismException.d();
                threadCurrentThread = threadB;
                th2 = thC;
            } else {
                jVar = new io.sentry.protocol.j();
                zD = false;
                th2 = cause;
                threadCurrentThread = Thread.currentThread();
            }
            deque.addFirst(c(th2, jVar, Long.valueOf(threadCurrentThread.getId()), this.a.a(th2.getStackTrace(), Boolean.FALSE.equals(jVar.l())), zD));
            if (jVar.k() == null) {
                jVar.p(str2);
            }
            if (atomicInteger.get() >= 0) {
                jVar.o(Integer.valueOf(i));
            }
            int iIncrementAndGet = atomicInteger.incrementAndGet();
            jVar.m(Integer.valueOf(iIncrementAndGet));
            Throwable[] suppressed = th2.getSuppressed();
            if (suppressed != null && suppressed.length > 0) {
                for (Throwable th3 : suppressed) {
                    b(th3, atomicInteger, hashSet, deque, "suppressed");
                }
            }
            cause = th2.getCause();
            str2 = null;
            i = iIncrementAndGet;
        }
        return deque;
    }

    public List d(Throwable th) {
        return e(a(th));
    }

    public List f(io.sentry.protocol.B b, io.sentry.protocol.j jVar, Throwable th) {
        io.sentry.protocol.A aN = b.n();
        if (aN == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(c(th, jVar, b.l(), aN.d(), true));
        return arrayList;
    }
}
