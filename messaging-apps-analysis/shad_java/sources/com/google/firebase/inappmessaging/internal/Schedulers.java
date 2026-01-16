package com.google.firebase.inappmessaging.internal;

import io.reactivex.Scheduler;

/* loaded from: classes3.dex */
public class Schedulers {
    private final Scheduler ioScheduler;
    private final Scheduler mainThreadScheduler;

    Schedulers(Scheduler scheduler, Scheduler scheduler2, Scheduler scheduler3) {
        this.ioScheduler = scheduler;
        this.mainThreadScheduler = scheduler3;
    }

    public Scheduler io() {
        return this.ioScheduler;
    }

    public Scheduler mainThread() {
        return this.mainThreadScheduler;
    }
}
