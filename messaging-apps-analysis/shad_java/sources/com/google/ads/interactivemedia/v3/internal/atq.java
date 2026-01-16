package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class atq<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable b = new atp(null);
    private static final Runnable c = new atp(null);
    private static final Runnable d = new atp(null);
    final /* synthetic */ atw a;
    private final Callable e;

    atq() {
    }

    final void a() {
        Runnable runnable = get();
        if ((runnable instanceof Thread) && compareAndSet(runnable, c)) {
            try {
                Thread thread = (Thread) runnable;
                thread.interrupt();
                if (getAndSet(b) == d) {
                    LockSupport.unpark(thread);
                }
            } catch (Throwable th) {
                if (getAndSet(b) == d) {
                    LockSupport.unpark((Thread) runnable);
                }
                throw th;
            }
        }
    }

    boolean b() {
        return this.a.isDone();
    }

    Object c() throws Exception {
        return this.e.call();
    }

    void d(Object obj, Throwable th) {
        if (th == null) {
            this.a.n(obj);
        } else {
            this.a.o(th);
        }
    }

    String e() {
        return this.e.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object objC;
        Thread threadCurrentThread = Thread.currentThread();
        if (compareAndSet(null, threadCurrentThread)) {
            boolean z = !b();
            if (z) {
                try {
                    objC = c();
                } catch (Throwable th) {
                    if (!compareAndSet(threadCurrentThread, b)) {
                        Runnable runnable = get();
                        boolean z2 = false;
                        int i = 0;
                        while (true) {
                            Runnable runnable2 = c;
                            if (runnable != runnable2 && runnable != d) {
                                break;
                            }
                            i++;
                            if (i > 1000) {
                                Runnable runnable3 = d;
                                if (runnable == runnable3 || compareAndSet(runnable2, runnable3)) {
                                    z2 = Thread.interrupted() || z2;
                                    LockSupport.park(this);
                                }
                            } else {
                                Thread.yield();
                            }
                            runnable = get();
                        }
                        if (z2) {
                            threadCurrentThread.interrupt();
                        }
                    }
                    d(null, th);
                    return;
                }
            } else {
                objC = null;
            }
            if (!compareAndSet(threadCurrentThread, b)) {
                Runnable runnable4 = get();
                boolean z3 = false;
                int i2 = 0;
                while (true) {
                    Runnable runnable5 = c;
                    if (runnable4 != runnable5 && runnable4 != d) {
                        break;
                    }
                    i2++;
                    if (i2 > 1000) {
                        Runnable runnable6 = d;
                        if (runnable4 == runnable6 || compareAndSet(runnable5, runnable6)) {
                            z3 = Thread.interrupted() || z3;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable4 = get();
                }
                if (z3) {
                    threadCurrentThread.interrupt();
                }
            }
            if (z) {
                d(objC, null);
            }
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String string;
        Runnable runnable = get();
        if (runnable == b) {
            string = "running=[DONE]";
        } else if (runnable == c) {
            string = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 21);
            sb.append("running=[RUNNING ON ");
            sb.append(name);
            sb.append("]");
            string = sb.toString();
        } else {
            string = "running=[NOT STARTED YET]";
        }
        String strE = e();
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 2 + String.valueOf(strE).length());
        sb2.append(string);
        sb2.append(", ");
        sb2.append(strE);
        return sb2.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    atq(atw atwVar, Callable callable) {
        this();
        this.a = atwVar;
        aqd.j(callable);
        this.e = callable;
    }
}
