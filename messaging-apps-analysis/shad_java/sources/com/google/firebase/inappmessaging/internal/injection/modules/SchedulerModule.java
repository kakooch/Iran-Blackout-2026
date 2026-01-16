package com.google.firebase.inappmessaging.internal.injection.modules;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/* loaded from: classes3.dex */
public class SchedulerModule {
    public Scheduler providesIOScheduler() {
        return Schedulers.io();
    }

    public Scheduler providesComputeScheduler() {
        return Schedulers.computation();
    }

    public Scheduler providesMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
