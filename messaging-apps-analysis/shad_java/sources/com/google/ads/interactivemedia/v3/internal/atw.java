package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class atw<V> extends atk implements RunnableFuture<V> {
    private volatile atq<?> a;

    atw(Callable<V> callable) {
        super(null);
        this.a = new atq<>(this, callable);
    }

    static <V> atw<V> p(Callable<V> callable) {
        return new atw<>(callable);
    }

    static <V> atw<V> q(Runnable runnable, V v) {
        return new atw<>(Executors.callable(runnable, v));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ati
    protected final void c() {
        atq<?> atqVar;
        if (a() && (atqVar = this.a) != null) {
            atqVar.a();
        }
        this.a = null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ati
    protected final String e() {
        atq<?> atqVar = this.a;
        if (atqVar == null) {
            return super.e();
        }
        String strValueOf = String.valueOf(atqVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
        sb.append("task=[");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        atq<?> atqVar = this.a;
        if (atqVar != null) {
            atqVar.run();
        }
        this.a = null;
    }
}
