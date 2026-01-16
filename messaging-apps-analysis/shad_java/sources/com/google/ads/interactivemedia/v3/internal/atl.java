package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public abstract class atl<V> extends aqx implements Future<V>, atr {
    protected atl() {
    }

    protected atl(byte[] bArr) {
        this();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.aqx
    protected /* bridge */ /* synthetic */ Object a() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atr
    public void b(Runnable runnable, Executor executor) {
        c().b(runnable, executor);
    }

    protected abstract atr c();

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return d().cancel(z);
    }

    protected /* bridge */ /* synthetic */ Future d() {
        throw null;
    }

    @Override // java.util.concurrent.Future
    public final V get() throws ExecutionException, InterruptedException {
        return (V) d().get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return d().isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return d().isDone();
    }

    @Override // java.util.concurrent.Future
    public final V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (V) d().get(j, timeUnit);
    }
}
