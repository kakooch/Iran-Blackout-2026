package com.google.ads.interactivemedia.v3.internal;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.rbmain.messenger.ImageLoader;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class ati<V> extends atx implements atr<V> {
    private static final boolean a;
    private static final Logger b;
    private static final asv c;
    private static final Object d;
    private volatile Object e;
    private volatile asz f;
    private volatile ath g;

    static {
        boolean z;
        Throwable th;
        Throwable th2;
        asv atcVar;
        try {
            z = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        } catch (SecurityException unused) {
            z = false;
        }
        a = z;
        b = Logger.getLogger(ati.class.getName());
        byte[] bArr = null;
        try {
            atcVar = new atg(bArr);
            th2 = null;
            th = null;
        } catch (Throwable th3) {
            try {
                th2 = th3;
                atcVar = new ata(AtomicReferenceFieldUpdater.newUpdater(ath.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(ath.class, ath.class, "c"), AtomicReferenceFieldUpdater.newUpdater(ati.class, ath.class, ImageLoader.AUTOPLAY_FILTER), AtomicReferenceFieldUpdater.newUpdater(ati.class, asz.class, "f"), AtomicReferenceFieldUpdater.newUpdater(ati.class, Object.class, "e"));
                th = null;
            } catch (Throwable th4) {
                th = th4;
                th2 = th3;
                atcVar = new atc(bArr);
            }
        }
        c = atcVar;
        if (th != null) {
            Logger logger = b;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
        d = new Object();
    }

    protected ati() {
    }

    ati(byte[] bArr) {
        this();
    }

    private final void p(ath athVar) {
        athVar.b = null;
        while (true) {
            ath athVar2 = this.g;
            if (athVar2 != ath.a) {
                ath athVar3 = null;
                while (athVar2 != null) {
                    ath athVar4 = athVar2.c;
                    if (athVar2.b != null) {
                        athVar3 = athVar2;
                    } else if (athVar3 != null) {
                        athVar3.c = athVar4;
                        if (athVar3.b == null) {
                            break;
                        }
                    } else if (!c.c(this, athVar2, athVar4)) {
                        break;
                    }
                    athVar2 = athVar4;
                }
                return;
            }
            return;
        }
    }

    private static void q(ati<?> atiVar) {
        ath athVar;
        asz aszVar;
        asz aszVar2;
        asz aszVar3;
        do {
            athVar = ((ati) atiVar).g;
        } while (!c.c(atiVar, athVar, ath.a));
        while (true) {
            aszVar = null;
            if (athVar == null) {
                break;
            }
            Thread thread = athVar.b;
            if (thread != null) {
                athVar.b = null;
                LockSupport.unpark(thread);
            }
            athVar = athVar.c;
        }
        atiVar.c();
        do {
            aszVar2 = ((ati) atiVar).f;
        } while (!c.d(atiVar, aszVar2, asz.a));
        while (true) {
            aszVar3 = aszVar;
            aszVar = aszVar2;
            if (aszVar == null) {
                break;
            }
            aszVar2 = aszVar.d;
            aszVar.d = aszVar3;
        }
        while (aszVar3 != null) {
            asz aszVar4 = aszVar3.d;
            t(aszVar3.b, aszVar3.c);
            aszVar3 = aszVar4;
        }
    }

    private final void r(StringBuilder sb) {
        String string;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.e;
        if (obj instanceof atb) {
            sb.append(", setFuture=[");
            atr<? extends V> atrVar = ((atb) obj).a;
            u(sb);
            sb.append("]");
        } else {
            try {
                string = aqd.a(e());
            } catch (RuntimeException | StackOverflowError e) {
                String strValueOf = String.valueOf(e.getClass());
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
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            s(sb);
        }
    }

    private final void s(StringBuilder sb) {
        V v;
        boolean z = false;
        while (true) {
            try {
                try {
                    v = get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                sb.append("CANCELLED");
                return;
            } catch (RuntimeException e) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e.getClass());
                sb.append(" thrown from get()]");
                return;
            } catch (ExecutionException e2) {
                sb.append("FAILURE, cause=[");
                sb.append(e2.getCause());
                sb.append("]");
                return;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        if (v == null) {
            sb.append("null");
        } else if (v == this) {
            sb.append("this future");
        } else {
            sb.append(v.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(v)));
        }
        sb.append("]");
    }

    private static void t(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            Logger logger = b;
            Level level = Level.SEVERE;
            String strValueOf = String.valueOf(runnable);
            String strValueOf2 = String.valueOf(executor);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 57 + strValueOf2.length());
            sb.append("RuntimeException while executing runnable ");
            sb.append(strValueOf);
            sb.append(" with executor ");
            sb.append(strValueOf2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", sb.toString(), (Throwable) e);
        }
    }

    private static final void u(StringBuilder sb) {
        try {
            sb.append((Object) null);
        } catch (RuntimeException | StackOverflowError e) {
            sb.append("Exception thrown from implementation: ");
            sb.append(e.getClass());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final V v(Object obj) throws ExecutionException {
        if (obj instanceof asw) {
            Throwable th = ((asw) obj).d;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof asy) {
            throw new ExecutionException(((asy) obj).a);
        }
        if (obj == d) {
            return null;
        }
        return obj;
    }

    protected final boolean a() {
        Object obj = this.e;
        return (obj instanceof asw) && ((asw) obj).c;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atr
    public void b(Runnable runnable, Executor executor) {
        asz aszVar;
        aqd.k(executor, "Executor was null.");
        if (!isDone() && (aszVar = this.f) != asz.a) {
            asz aszVar2 = new asz(runnable, executor);
            do {
                aszVar2.d = aszVar;
                if (c.d(this, aszVar, aszVar2)) {
                    return;
                } else {
                    aszVar = this.f;
                }
            } while (aszVar != asz.a);
        }
        t(runnable, executor);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        Object obj = this.e;
        if ((obj == null) | (obj instanceof atb)) {
            asw aswVar = a ? new asw(z, new CancellationException("Future.cancel() was called.")) : z ? asw.a : asw.b;
            while (!c.e(this, obj, aswVar)) {
                obj = this.e;
                if (!(obj instanceof atb)) {
                }
            }
            q(this);
            if (!(obj instanceof atb)) {
                return true;
            }
            atr<? extends V> atrVar = ((atb) obj).a;
            throw null;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atx
    protected final Throwable d() {
        if (!(this instanceof atd)) {
            return null;
        }
        Object obj = this.e;
        if (obj instanceof asy) {
            return ((asy) obj).a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected String e() {
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

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.e;
        if ((obj2 != null) && (!(obj2 instanceof atb))) {
            return (V) v(obj2);
        }
        ath athVar = this.g;
        if (athVar != ath.a) {
            ath athVar2 = new ath();
            do {
                athVar2.a(athVar);
                if (c.c(this, athVar, athVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            p(athVar2);
                            throw new InterruptedException();
                        }
                        obj = this.e;
                    } while (!((obj != null) & (!(obj instanceof atb))));
                    return (V) v(obj);
                }
                athVar = this.g;
            } while (athVar != ath.a);
        }
        return (V) v(this.e);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.e instanceof asw;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return (!(r0 instanceof atb)) & (this.e != null);
    }

    protected final void n(V v) {
        if (v == null) {
            v = (V) d;
        }
        if (c.e(this, null, v)) {
            q(this);
        }
    }

    protected final void o(Throwable th) {
        if (c.e(this, null, new asy(th))) {
            q(this);
        }
    }

    public final String toString() {
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
            s(sb);
        } else {
            r(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (!Thread.interrupted()) {
            Object obj = this.e;
            boolean z = true;
            if ((obj != null) & (!(obj instanceof atb))) {
                return (V) v(obj);
            }
            long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                ath athVar = this.g;
                if (athVar != ath.a) {
                    ath athVar2 = new ath();
                    do {
                        athVar2.a(athVar);
                        if (c.c(this, athVar, athVar2)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (Thread.interrupted()) {
                                    p(athVar2);
                                    throw new InterruptedException();
                                }
                                Object obj2 = this.e;
                                if (!((obj2 != null) & (!(obj2 instanceof atb)))) {
                                    nanos = jNanoTime - System.nanoTime();
                                } else {
                                    return (V) v(obj2);
                                }
                            } while (nanos >= 1000);
                            p(athVar2);
                        } else {
                            athVar = this.g;
                        }
                    } while (athVar != ath.a);
                }
                return (V) v(this.e);
            }
            while (nanos > 0) {
                Object obj3 = this.e;
                if (!((obj3 != null) & (!(obj3 instanceof atb)))) {
                    if (!Thread.interrupted()) {
                        nanos = jNanoTime - System.nanoTime();
                    } else {
                        throw new InterruptedException();
                    }
                } else {
                    return (V) v(obj3);
                }
            }
            String string = toString();
            String string2 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string2.toLowerCase(locale);
            String lowerCase2 = timeUnit.toString().toLowerCase(locale);
            StringBuilder sb = new StringBuilder(String.valueOf(lowerCase2).length() + 28);
            sb.append("Waited ");
            sb.append(j);
            sb.append(" ");
            sb.append(lowerCase2);
            String string3 = sb.toString();
            if (nanos + 1000 < 0) {
                String strConcat = String.valueOf(string3).concat(" (plus ");
                long j2 = -nanos;
                long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
                long nanos2 = j2 - timeUnit.toNanos(jConvert);
                if (jConvert != 0 && nanos2 <= 1000) {
                    z = false;
                }
                if (jConvert > 0) {
                    String strValueOf = String.valueOf(strConcat);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 21 + String.valueOf(lowerCase).length());
                    sb2.append(strValueOf);
                    sb2.append(jConvert);
                    sb2.append(" ");
                    sb2.append(lowerCase);
                    String string4 = sb2.toString();
                    if (z) {
                        string4 = String.valueOf(string4).concat(",");
                    }
                    strConcat = String.valueOf(string4).concat(" ");
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
        throw new InterruptedException();
    }
}
