package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ato<V> implements Runnable {
    final Future<V> a;
    final atn<? super V> b;

    ato(Future<V> future, atn<? super V> atnVar) {
        this.a = future;
        this.b = atnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V v;
        Throwable thA;
        Future<V> future = this.a;
        if ((future instanceof atx) && (thA = aty.a((atx) future)) != null) {
            this.b.a(thA);
            return;
        }
        try {
            Future<V> future2 = this.a;
            boolean z = false;
            if (!future2.isDone()) {
                throw new IllegalStateException(aqd.c("Future was expected to be done: %s", future2));
            }
            while (true) {
                try {
                    v = future2.get();
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
            this.b.b(v);
        } catch (Error e) {
            e = e;
            this.b.a(e);
        } catch (RuntimeException e2) {
            e = e2;
            this.b.a(e);
        } catch (ExecutionException e3) {
            this.b.a(e3.getCause());
        }
    }

    public final String toString() {
        return apz.a(this).a(this.b).toString();
    }
}
