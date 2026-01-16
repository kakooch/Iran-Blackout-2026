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
public abstract class S0 implements InterfaceFutureC15215jC3 {
    static final boolean d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger e = Logger.getLogger(S0.class.getName());
    static final b f;
    private static final Object g;
    volatile Object a;
    volatile e b;
    volatile i c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(S0 s0, e eVar, e eVar2);

        abstract boolean b(S0 s0, Object obj, Object obj2);

        abstract boolean c(S0 s0, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    private static final class c {
        static final c c;
        static final c d;
        final boolean a;
        final Throwable b;

        static {
            if (S0.d) {
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
            this.a = (Throwable) S0.d(th);
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

        @Override // ir.nasim.S0.b
        boolean a(S0 s0, e eVar, e eVar2) {
            return F1.a(this.d, s0, eVar, eVar2);
        }

        @Override // ir.nasim.S0.b
        boolean b(S0 s0, Object obj, Object obj2) {
            return F1.a(this.e, s0, obj, obj2);
        }

        @Override // ir.nasim.S0.b
        boolean c(S0 s0, i iVar, i iVar2) {
            return F1.a(this.c, s0, iVar, iVar2);
        }

        @Override // ir.nasim.S0.b
        void d(i iVar, i iVar2) {
            this.b.lazySet(iVar, iVar2);
        }

        @Override // ir.nasim.S0.b
        void e(i iVar, Thread thread) {
            this.a.lazySet(iVar, thread);
        }
    }

    private static final class g implements Runnable {
        final S0 a;
        final InterfaceFutureC15215jC3 b;

        g(S0 s0, InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
            this.a = s0;
            this.b = interfaceFutureC15215jC3;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.a != this) {
                return;
            }
            if (S0.f.b(this.a, this, S0.i(this.b))) {
                S0.f(this.a);
            }
        }
    }

    private static final class h extends b {
        h() {
            super();
        }

        @Override // ir.nasim.S0.b
        boolean a(S0 s0, e eVar, e eVar2) {
            synchronized (s0) {
                try {
                    if (s0.b != eVar) {
                        return false;
                    }
                    s0.b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.S0.b
        boolean b(S0 s0, Object obj, Object obj2) {
            synchronized (s0) {
                try {
                    if (s0.a != obj) {
                        return false;
                    }
                    s0.a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.S0.b
        boolean c(S0 s0, i iVar, i iVar2) {
            synchronized (s0) {
                try {
                    if (s0.c != iVar) {
                        return false;
                    }
                    s0.c = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.S0.b
        void d(i iVar, i iVar2) {
            iVar.b = iVar2;
        }

        @Override // ir.nasim.S0.b
        void e(i iVar, Thread thread) {
            iVar.a = thread;
        }
    }

    private static final class i {
        static final i c = new i(false);
        volatile Thread a;
        volatile i b;

        i(boolean z) {
        }

        void a(i iVar) {
            S0.f.d(this, iVar);
        }

        void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            S0.f.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(S0.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(S0.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(S0.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f = hVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        g = new Object();
    }

    protected S0() {
    }

    private void a(StringBuilder sb) {
        try {
            Object objK = k(this);
            sb.append("SUCCESS, result=[");
            sb.append(s(objK));
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

    static void f(S0 s0) {
        e eVar = null;
        while (true) {
            s0.n();
            s0.b();
            e eVarE = s0.e(eVar);
            while (eVarE != null) {
                eVar = eVarE.c;
                Runnable runnable = eVarE.a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    s0 = gVar.a;
                    if (s0.a == gVar) {
                        if (f.b(s0, gVar, i(gVar.b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, eVarE.b);
                }
                eVarE = eVar;
            }
            return;
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

    static Object i(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        if (interfaceFutureC15215jC3 instanceof S0) {
            Object obj = ((S0) interfaceFutureC15215jC3).a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.a ? cVar.b != null ? new c(false, cVar.b) : c.d : obj;
        }
        boolean zIsCancelled = interfaceFutureC15215jC3.isCancelled();
        if ((!d) && zIsCancelled) {
            return c.d;
        }
        try {
            Object objK = k(interfaceFutureC15215jC3);
            return objK == null ? g : objK;
        } catch (CancellationException e2) {
            if (zIsCancelled) {
                return new c(false, e2);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC15215jC3, e2));
        } catch (ExecutionException e3) {
            return new d(e3.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    private static Object k(Future future) {
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

    private void n() {
        i iVar;
        do {
            iVar = this.c;
        } while (!f.c(this, iVar, i.c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.b;
        }
    }

    private void o(i iVar) {
        iVar.a = null;
        while (true) {
            i iVar2 = this.c;
            if (iVar2 == i.c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.b;
                if (iVar2.a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.b = iVar4;
                    if (iVar3.a == null) {
                        break;
                    }
                } else if (!f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = d ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.c : c.d;
        S0 s0 = this;
        boolean z2 = false;
        while (true) {
            if (f.b(s0, obj, cVar)) {
                if (z) {
                    s0.l();
                }
                f(s0);
                if (!(obj instanceof g)) {
                    return true;
                }
                InterfaceFutureC15215jC3 interfaceFutureC15215jC3 = ((g) obj).b;
                if (!(interfaceFutureC15215jC3 instanceof S0)) {
                    interfaceFutureC15215jC3.cancel(z);
                    return true;
                }
                s0 = (S0) interfaceFutureC15215jC3;
                obj = s0.a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z2 = true;
            } else {
                obj = s0.a;
                if (!(obj instanceof g)) {
                    return z2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && (!(obj instanceof g))) {
            return h(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.c;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return h(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        o(iVar2);
                    } else {
                        iVar = this.c;
                    }
                } while (iVar != i.c);
            }
            return h(this.a);
        }
        while (nanos > 0) {
            Object obj3 = this.a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
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
        return (!(r0 instanceof g)) & (this.a != null);
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
    protected String m() {
        Object obj = this.a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    protected boolean p(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean q(Throwable th) {
        if (!f.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    protected boolean r(InterfaceFutureC15215jC3 interfaceFutureC15215jC3) {
        d dVar;
        d(interfaceFutureC15215jC3);
        Object obj = this.a;
        if (obj == null) {
            if (interfaceFutureC15215jC3.isDone()) {
                if (!f.b(this, null, i(interfaceFutureC15215jC3))) {
                    return false;
                }
                f(this);
                return true;
            }
            g gVar = new g(this, interfaceFutureC15215jC3);
            if (f.b(this, null, gVar)) {
                try {
                    interfaceFutureC15215jC3.j(gVar, LT1.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.b;
                    }
                    f.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.a;
        }
        if (obj instanceof c) {
            interfaceFutureC15215jC3.cancel(((c) obj).a);
        }
        return false;
    }

    public String toString() {
        String strM;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strM = m();
            } catch (RuntimeException e2) {
                strM = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strM != null && !strM.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strM);
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

    protected void l() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.c;
            if (iVar != i.c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                o(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.c;
                } while (iVar != i.c);
            }
            return h(this.a);
        }
        throw new InterruptedException();
    }
}
