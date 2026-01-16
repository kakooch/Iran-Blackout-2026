package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import ir.nasim.C10255bL3;
import ir.nasim.ExecutorC4596Fu5;
import ir.nasim.JI3;
import ir.nasim.ThreadFactoryC11635dL3;
import ir.nasim.WK3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* loaded from: classes2.dex */
public class s {
    public static Executor e;
    private final Set a;
    private final Set b;
    private final Handler c;
    private volatile C10255bL3 d;

    private static class a extends FutureTask {
        private s a;

        a(s sVar, Callable callable) {
            super(callable);
            this.a = sVar;
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                if (isCancelled()) {
                    return;
                }
                try {
                    this.a.l((C10255bL3) get());
                } catch (InterruptedException | ExecutionException e) {
                    this.a.l(new C10255bL3(e));
                }
            } finally {
                this.a = null;
            }
        }
    }

    static {
        if ("true".equals(System.getProperty("lottie.testing.directExecutor"))) {
            e = new ExecutorC4596Fu5();
        } else {
            e = Executors.newCachedThreadPool(new ThreadFactoryC11635dL3());
        }
    }

    public s(Callable callable) {
        this(callable, false);
    }

    private synchronized void f(Throwable th) {
        ArrayList arrayList = new ArrayList(this.b);
        if (arrayList.isEmpty()) {
            JI3.d("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((WK3) it.next()).a(th);
        }
    }

    private void g() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            h();
        } else {
            this.c.post(new Runnable() { // from class: ir.nasim.cL3
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        C10255bL3 c10255bL3 = this.d;
        if (c10255bL3 == null) {
            return;
        }
        if (c10255bL3.b() != null) {
            i(c10255bL3.b());
        } else {
            f(c10255bL3.a());
        }
    }

    private synchronized void i(Object obj) {
        Iterator it = new ArrayList(this.a).iterator();
        while (it.hasNext()) {
            ((WK3) it.next()).a(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(C10255bL3 c10255bL3) {
        if (this.d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.d = c10255bL3;
        g();
    }

    public synchronized s c(WK3 wk3) {
        try {
            C10255bL3 c10255bL3 = this.d;
            if (c10255bL3 != null && c10255bL3.a() != null) {
                wk3.a(c10255bL3.a());
            }
            this.b.add(wk3);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public synchronized s d(WK3 wk3) {
        try {
            C10255bL3 c10255bL3 = this.d;
            if (c10255bL3 != null && c10255bL3.b() != null) {
                wk3.a(c10255bL3.b());
            }
            this.a.add(wk3);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public C10255bL3 e() {
        return this.d;
    }

    public synchronized s j(WK3 wk3) {
        this.b.remove(wk3);
        return this;
    }

    public synchronized s k(WK3 wk3) {
        this.a.remove(wk3);
        return this;
    }

    public s(Object obj) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        l(new C10255bL3(obj));
    }

    s(Callable callable, boolean z) {
        this.a = new LinkedHashSet(1);
        this.b = new LinkedHashSet(1);
        this.c = new Handler(Looper.getMainLooper());
        this.d = null;
        if (z) {
            try {
                l((C10255bL3) callable.call());
                return;
            } catch (Throwable th) {
                l(new C10255bL3(th));
                return;
            }
        }
        e.execute(new a(this, callable));
    }
}
