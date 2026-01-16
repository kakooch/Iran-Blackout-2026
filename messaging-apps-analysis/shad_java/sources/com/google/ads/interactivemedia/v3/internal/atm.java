package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Delayed;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX WARN: Unexpected interfaces in signature: [com.google.ads.interactivemedia.v3.internal.atr] */
/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class atm<V> extends atl implements ScheduledFuture {
    private final atr<V> a;
    private final ScheduledFuture b;

    protected atm(atr<V> atrVar) {
        super(null);
        this.a = atrVar;
    }

    public atm(atr atrVar, ScheduledFuture scheduledFuture) {
        this(atrVar);
        this.b = scheduledFuture;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atl, com.google.ads.interactivemedia.v3.internal.aqx
    protected final /* bridge */ /* synthetic */ Object a() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atl
    protected final atr<V> c() {
        return this.a;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atl, java.util.concurrent.Future
    public boolean cancel(boolean z) {
        boolean zCancel = d().cancel(z);
        if (zCancel) {
            this.b.cancel(z);
        }
        return zCancel;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Delayed delayed) {
        return this.b.compareTo(delayed);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.atl
    protected final /* bridge */ /* synthetic */ Future d() {
        return this.a;
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.b.getDelay(timeUnit);
    }
}
