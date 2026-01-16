package com.google.ads.interactivemedia.v3.internal;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class atu extends atj implements ScheduledExecutorService {
    final ScheduledExecutorService a;

    atu(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        aqd.j(scheduledExecutorService);
        this.a = scheduledExecutorService;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        atw atwVarQ = atw.q(runnable, null);
        return new atm(atwVarQ, this.a.schedule(atwVarQ, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        atw atwVarP = atw.p(callable);
        return new atm(atwVarP, this.a.schedule(atwVarP, j, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        att attVar = new att(runnable);
        return new atm(attVar, this.a.scheduleAtFixedRate(attVar, j, j2, timeUnit));
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        att attVar = new att(runnable);
        return new atm(attVar, this.a.scheduleWithFixedDelay(attVar, j, j2, timeUnit));
    }
}
