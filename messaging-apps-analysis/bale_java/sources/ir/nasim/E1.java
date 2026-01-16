package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class E1 implements InterfaceFutureC15215jC3 {
    static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(E1.class.getName());
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile e b;
    volatile h c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(E1 e1, e eVar, e eVar2);

        abstract boolean b(E1 e1, Object obj, Object obj2);

        abstract boolean c(E1 e1, h hVar, h hVar2);

        abstract void d(h hVar, h hVar2);

        abstract void e(h hVar, Thread thread);
    }

    private static final class c {
        static final c c;
        static final c d;
        final boolean a;
        final Throwable b;

        static {
            if (E1.d) {
                d = null;
                c = null;
            } else {
                d = new c(false, null);
                c = new c(true, null);
            }
        }

        c(boolean z, Throwable th) {
            this.a = z;
            this.b = th;
        }
    }

    private static final class d {
        static final d b = new d(new a("Failure occurred while trying to finish a future."));
        final Throwable a;

        class a extends Throwable {
            a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th) {
            this.a = (Throwable) E1.d(th);
        }
    }

    private static final class e {
        static final e d = new e(null, null);
        final Runnable a;
        final Executor b;
        e c;

        e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }
    }

    private static final class f extends b {
        final AtomicReferenceFieldUpdater a;
        final AtomicReferenceFieldUpdater b;
        final AtomicReferenceFieldUpdater c;
        final AtomicReferenceFieldUpdater d;
        final AtomicReferenceFieldUpdater e;

        f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.a = atomicReferenceFieldUpdater;
            this.b = atomicReferenceFieldUpdater2;
            this.c = atomicReferenceFieldUpdater3;
            this.d = atomicReferenceFieldUpdater4;
            this.e = atomicReferenceFieldUpdater5;
        }

        @Override // ir.nasim.E1.b
        boolean a(E1 e1, e eVar, e eVar2) {
            return F1.a(this.d, e1, eVar, eVar2);
        }

        @Override // ir.nasim.E1.b
        boolean b(E1 e1, Object obj, Object obj2) {
            return F1.a(this.e, e1, obj, obj2);
        }

        @Override // ir.nasim.E1.b
        boolean c(E1 e1, h hVar, h hVar2) {
            return F1.a(this.c, e1, hVar, hVar2);
        }

        @Override // ir.nasim.E1.b
        void d(h hVar, h hVar2) {
            this.b.lazySet(hVar, hVar2);
        }

        @Override // ir.nasim.E1.b
        void e(h hVar, Thread thread) {
            this.a.lazySet(hVar, thread);
        }
    }

    private static final class g extends b {
        g() {
            super();
        }

        @Override // ir.nasim.E1.b
        boolean a(E1 e1, e eVar, e eVar2) {
            synchronized (e1) {
                try {
                    if (e1.b != eVar) {
                        return false;
                    }
                    e1.b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.E1.b
        boolean b(E1 e1, Object obj, Object obj2) {
            synchronized (e1) {
                try {
                    if (e1.a != obj) {
                        return false;
                    }
                    e1.a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.E1.b
        boolean c(E1 e1, h hVar, h hVar2) {
            synchronized (e1) {
                try {
                    if (e1.c != hVar) {
                        return false;
                    }
                    e1.c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.E1.b
        void d(h hVar, h hVar2) {
            hVar.b = hVar2;
        }

        @Override // ir.nasim.E1.b
        void e(h hVar, Thread thread) {
            hVar.a = thread;
        }
    }

    private static final class h {
        static final h c = new h(false);
        volatile Thread a;
        volatile h b;

        h(boolean z) {
        }

        void a(h hVar) {
            E1.f.d(this, hVar);
        }

        void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        h() {
            E1.f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(E1.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(E1.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(E1.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f = gVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    protected E1() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objI = i(this);
            sb.append("SUCCESS, result=[");
            sb.append(q(objI));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append("]");
        }
    }

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    private e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.b;
        } while (!f.a(this, eVar2, e.d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.c;
            eVar4.c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    static void f(E1 e1) {
        e1.m();
        e1.b();
        e eVarE = e1.e(null);
        while (eVarE != null) {
            e eVar = eVarE.c;
            g(eVarE.a, eVarE.b);
            eVarE = eVar;
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    private Object h(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        }
        if (obj == g) {
            return null;
        }
        return obj;
    }

    static Object i(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void m() {
        h hVar;
        do {
            hVar = this.c;
        } while (!f.c(this, hVar, h.c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.b;
        }
    }

    private void n(h hVar) {
        hVar.a = null;
        while (true) {
            h hVar2 = this.c;
            if (hVar2 == h.c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.b;
                if (hVar2.a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.b = hVar4;
                    if (hVar3.a == null) {
                        break;
                    }
                } else if (!f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    private String q(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (obj == null) {
            if (f.b(this, obj, d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d)) {
                if (z) {
                    k();
                }
                f(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && true) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.c;
            if (hVar != h.c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && true) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(hVar2);
                    } else {
                        hVar = this.c;
                    }
                } while (hVar != h.c);
            }
            return h(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && true) {
                return h(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j + Separators.SP + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + Separators.SP + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + Separators.SP;
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (this.a != null) & true;
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public final void j(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        e eVar = this.b;
        if (eVar != e.d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.c = eVar;
                if (f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.b;
                }
            } while (eVar != e.d);
        }
        g(runnable, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String l() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean o(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean p(Throwable th) {
        if (!f.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public String toString() {
        String strL;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strL = l();
            } catch (RuntimeException e2) {
                strL = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strL != null && !strL.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strL);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    protected void b() {
    }

    protected void k() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) & true) {
                return h(obj2);
            }
            h hVar = this.c;
            if (hVar != h.c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                n(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & true));
                        return h(obj);
                    }
                    hVar = this.c;
                } while (hVar != h.c);
            }
            return h(this.a);
        }
        throw new InterruptedException();
    }
}
