package ir.nasim;

import android.gov.nist.core.Separators;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
public abstract class U0 extends AbstractC4672Gb3 implements InterfaceFutureC15215jC3 {
    private static final boolean d;
    private static final Logger e;
    private static final b f;
    private static final Object g;
    private volatile Object a;
    private volatile e b;
    private volatile j c;

    private static abstract class b {
        private b() {
        }

        abstract boolean a(U0 u0, e eVar, e eVar2);

        abstract boolean b(U0 u0, Object obj, Object obj2);

        abstract boolean c(U0 u0, j jVar, j jVar2);

        abstract void d(j jVar, j jVar2);

        abstract void e(j jVar, Thread thread);
    }

    private static final class c {
        static final c c;
        static final c d;
        final boolean a;
        final Throwable b;

        static {
            if (U0.d) {
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
            this.a = (Throwable) AbstractC4029Dj5.j(th);
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

        @Override // ir.nasim.U0.b
        boolean a(U0 u0, e eVar, e eVar2) {
            return F1.a(this.d, u0, eVar, eVar2);
        }

        @Override // ir.nasim.U0.b
        boolean b(U0 u0, Object obj, Object obj2) {
            return F1.a(this.e, u0, obj, obj2);
        }

        @Override // ir.nasim.U0.b
        boolean c(U0 u0, j jVar, j jVar2) {
            return F1.a(this.c, u0, jVar, jVar2);
        }

        @Override // ir.nasim.U0.b
        void d(j jVar, j jVar2) {
            this.b.lazySet(jVar, jVar2);
        }

        @Override // ir.nasim.U0.b
        void e(j jVar, Thread thread) {
            this.a.lazySet(jVar, thread);
        }
    }

    private static final class g extends b {
        private g() {
            super();
        }

        @Override // ir.nasim.U0.b
        boolean a(U0 u0, e eVar, e eVar2) {
            synchronized (u0) {
                try {
                    if (u0.b != eVar) {
                        return false;
                    }
                    u0.b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.U0.b
        boolean b(U0 u0, Object obj, Object obj2) {
            synchronized (u0) {
                try {
                    if (u0.a != obj) {
                        return false;
                    }
                    u0.a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.U0.b
        boolean c(U0 u0, j jVar, j jVar2) {
            synchronized (u0) {
                try {
                    if (u0.c != jVar) {
                        return false;
                    }
                    u0.c = jVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // ir.nasim.U0.b
        void d(j jVar, j jVar2) {
            jVar.b = jVar2;
        }

        @Override // ir.nasim.U0.b
        void e(j jVar, Thread thread) {
            jVar.a = thread;
        }
    }

    static abstract class h extends U0 implements InterfaceFutureC15215jC3 {
        h() {
        }

        @Override // ir.nasim.U0, java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // ir.nasim.U0, java.util.concurrent.Future
        public Object get() {
            return super.get();
        }

        @Override // ir.nasim.U0, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // ir.nasim.U0, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // ir.nasim.U0, ir.nasim.InterfaceFutureC15215jC3
        public final void j(Runnable runnable, Executor executor) {
            super.j(runnable, executor);
        }

        @Override // ir.nasim.U0, java.util.concurrent.Future
        public final Object get(long j, TimeUnit timeUnit) {
            return super.get(j, timeUnit);
        }
    }

    private static final class i extends b {
        static final Unsafe a;
        static final long b;
        static final long c;
        static final long d;
        static final long e;
        static final long f;

        class a implements PrivilegedExceptionAction {
            a() {
            }

            @Override // java.security.PrivilegedExceptionAction
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws IllegalAccessException, SecurityException, IllegalArgumentException {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e2) {
                    throw new RuntimeException("Could not initialize intrinsics", e2.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new a());
            }
            try {
                c = unsafe.objectFieldOffset(U0.class.getDeclaredField("c"));
                b = unsafe.objectFieldOffset(U0.class.getDeclaredField("b"));
                d = unsafe.objectFieldOffset(U0.class.getDeclaredField("a"));
                e = unsafe.objectFieldOffset(j.class.getDeclaredField("a"));
                f = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
                a = unsafe;
            } catch (Exception e3) {
                AbstractC20922sp7.e(e3);
                throw new RuntimeException(e3);
            }
        }

        private i() {
            super();
        }

        @Override // ir.nasim.U0.b
        boolean a(U0 u0, e eVar, e eVar2) {
            return T0.a(a, u0, b, eVar, eVar2);
        }

        @Override // ir.nasim.U0.b
        boolean b(U0 u0, Object obj, Object obj2) {
            return T0.a(a, u0, d, obj, obj2);
        }

        @Override // ir.nasim.U0.b
        boolean c(U0 u0, j jVar, j jVar2) {
            return T0.a(a, u0, c, jVar, jVar2);
        }

        @Override // ir.nasim.U0.b
        void d(j jVar, j jVar2) {
            a.putObject(jVar, f, jVar2);
        }

        @Override // ir.nasim.U0.b
        void e(j jVar, Thread thread) {
            a.putObject(jVar, e, thread);
        }
    }

    private static final class j {
        static final j c = new j(false);
        volatile Thread a;
        volatile j b;

        j(boolean z) {
        }

        void a(j jVar) {
            U0.f.d(this, jVar);
        }

        void b() {
            Thread thread = this.a;
            if (thread != null) {
                this.a = null;
                LockSupport.unpark(thread);
            }
        }

        j() {
            U0.f.e(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r12v0, types: [ir.nasim.U0$f] */
    /* JADX WARN: Type inference failed for: r4v2, types: [ir.nasim.U0$a] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v2, types: [ir.nasim.U0$i] */
    static {
        boolean z;
        g gVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        d = z;
        e = Logger.getLogger(U0.class.getName());
        ?? r4 = 0;
        r4 = 0;
        try {
            gVar = new i();
            th = null;
        } catch (Throwable th) {
            th = th;
            try {
                gVar = new f(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "b"), AtomicReferenceFieldUpdater.newUpdater(U0.class, j.class, "c"), AtomicReferenceFieldUpdater.newUpdater(U0.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(U0.class, Object.class, "a"));
            } catch (Throwable th2) {
                gVar = new g();
                r4 = th2;
            }
        }
        f = gVar;
        if (r4 != 0) {
            ?? r0 = e;
            Level level = Level.SEVERE;
            r0.log(level, "UnsafeAtomicHelper is broken!", th);
            r0.log(level, "SafeAtomicHelper is broken!", r4);
        }
        g = new Object();
    }

    protected U0() {
    }

    private void i(StringBuilder sb) {
        try {
            Object objS = s(this);
            sb.append("SUCCESS, result=[");
            m(sb, objS);
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

    private void k(StringBuilder sb) {
        String string;
        int length = sb.length();
        sb.append("PENDING");
        try {
            string = AbstractC13634gZ6.a(u());
        } catch (RuntimeException | StackOverflowError e2) {
            String strValueOf = String.valueOf(e2.getClass());
            StringBuilder sb2 = new StringBuilder(strValueOf.length() + 38);
            sb2.append("Exception thrown from implementation: ");
            sb2.append(strValueOf);
            string = sb2.toString();
        }
        if (string != null) {
            sb.append(", info=[");
            sb.append(string);
            sb.append("]");
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            i(sb);
        }
    }

    private void m(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else {
            if (obj == this) {
                sb.append("this future");
                return;
            }
            sb.append(obj.getClass().getName());
            sb.append(Separators.AT);
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private static CancellationException n(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private e o(e eVar) {
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

    private static void p(U0 u0) {
        u0.v();
        u0.l();
        e eVarO = u0.o(null);
        while (eVarO != null) {
            e eVar = eVarO.c;
            Runnable runnable = eVarO.a;
            Objects.requireNonNull(runnable);
            Executor executor = eVarO.b;
            Objects.requireNonNull(executor);
            q(runnable, executor);
            eVarO = eVar;
        }
    }

    private static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = e;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.log(level, sb.toString(), (Throwable) e2);
        }
    }

    private Object r(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw n("Task was cancelled.", ((c) obj).b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).a);
        }
        return obj == g ? AbstractC23043wF4.a() : obj;
    }

    private static Object s(Future future) {
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

    private void v() {
        j jVar;
        do {
            jVar = this.c;
        } while (!f.c(this, jVar, j.c));
        while (jVar != null) {
            jVar.b();
            jVar = jVar.b;
        }
    }

    private void w(j jVar) {
        jVar.a = null;
        while (true) {
            j jVar2 = this.c;
            if (jVar2 == j.c) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.b;
                if (jVar2.a != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.b = jVar4;
                    if (jVar3.a == null) {
                        break;
                    }
                } else if (!f.c(this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        c cVar;
        Object obj = this.a;
        if (obj == null) {
            if (d) {
                cVar = new c(z, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z ? c.c : c.d;
                Objects.requireNonNull(cVar);
            }
            if (f.b(this, obj, cVar)) {
                if (z) {
                    t();
                }
                p(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.a;
        if ((obj != null) && true) {
            return r(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            j jVar = this.c;
            if (jVar != j.c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (f.c(this, jVar, jVar2)) {
                        do {
                            NN4.a(this, nanos);
                            if (Thread.interrupted()) {
                                w(jVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.a;
                            if ((obj2 != null) && true) {
                                return r(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        w(jVar2);
                    } else {
                        jVar = this.c;
                    }
                } while (jVar != j.c);
            }
            Object obj3 = this.a;
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.a;
            if ((obj4 != null) && true) {
                return r(obj4);
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
        String lowerCase2 = timeUnit.toString().toLowerCase(locale);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
        sb.append("Waited ");
        sb.append(j2);
        sb.append(Separators.SP);
        sb.append(lowerCase2);
        String string3 = sb.toString();
        if (nanos + 1000 < 0) {
            String strConcat = String.valueOf(string3).concat(" (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strValueOf = String.valueOf(strConcat);
                StringBuilder sb2 = new StringBuilder(strValueOf.length() + 21 + String.valueOf(lowerCase).length());
                sb2.append(strValueOf);
                sb2.append(jConvert);
                sb2.append(Separators.SP);
                sb2.append(lowerCase);
                String string4 = sb2.toString();
                if (z) {
                    string4 = String.valueOf(string4).concat(",");
                }
                strConcat = String.valueOf(string4).concat(Separators.SP);
            }
            if (z) {
                String strValueOf2 = String.valueOf(strConcat);
                StringBuilder sb3 = new StringBuilder(strValueOf2.length() + 33);
                sb3.append(strValueOf2);
                sb3.append(nanos2);
                sb3.append(" nanoseconds ");
                strConcat = sb3.toString();
            }
            string3 = String.valueOf(strConcat).concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(String.valueOf(string3).concat(" but future completed as timeout expired"));
        }
        StringBuilder sb4 = new StringBuilder(String.valueOf(string3).length() + 5 + String.valueOf(string).length());
        sb4.append(string3);
        sb4.append(" for ");
        sb4.append(string);
        throw new TimeoutException(sb4.toString());
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (this.a != null) & true;
    }

    @Override // ir.nasim.InterfaceFutureC15215jC3
    public void j(Runnable runnable, Executor executor) {
        e eVar;
        AbstractC4029Dj5.k(runnable, "Runnable was null.");
        AbstractC4029Dj5.k(executor, "Executor was null.");
        if (!isDone() && (eVar = this.b) != e.d) {
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
        q(runnable, executor);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            i(sb);
        } else {
            k(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String u() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        StringBuilder sb = new StringBuilder(41);
        sb.append("remaining delay=[");
        sb.append(delay);
        sb.append(" ms]");
        return sb.toString();
    }

    protected boolean x(Object obj) {
        if (obj == null) {
            obj = g;
        }
        if (!f.b(this, null, obj)) {
            return false;
        }
        p(this);
        return true;
    }

    protected boolean y(Throwable th) {
        if (!f.b(this, null, new d((Throwable) AbstractC4029Dj5.j(th)))) {
            return false;
        }
        p(this);
        return true;
    }

    private static final class e {
        static final e d = new e();
        final Runnable a;
        final Executor b;
        e c;

        e(Runnable runnable, Executor executor) {
            this.a = runnable;
            this.b = executor;
        }

        e() {
            this.a = null;
            this.b = null;
        }
    }

    protected void l() {
    }

    protected void t() {
    }

    public Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.a;
            if ((obj2 != null) & true) {
                return r(obj2);
            }
            j jVar = this.c;
            if (jVar != j.c) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (f.c(this, jVar, jVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.a;
                            } else {
                                w(jVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & true));
                        return r(obj);
                    }
                    jVar = this.c;
                } while (jVar != j.c);
            }
            Object obj3 = this.a;
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
        throw new InterruptedException();
    }
}
