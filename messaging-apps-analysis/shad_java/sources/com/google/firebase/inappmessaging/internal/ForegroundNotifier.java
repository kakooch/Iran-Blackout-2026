package com.google.firebase.inappmessaging.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import io.reactivex.BackpressureStrategy;
import io.reactivex.flowables.ConnectableFlowable;
import io.reactivex.subjects.BehaviorSubject;

/* loaded from: classes3.dex */
public class ForegroundNotifier implements Application.ActivityLifecycleCallbacks {
    private Runnable check;
    private final Handler handler = new Handler();
    private boolean foreground = false;
    private boolean paused = true;
    private final BehaviorSubject<String> foregroundSubject = BehaviorSubject.create();

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }

    public ConnectableFlowable<String> foregroundFlowable() {
        return this.foregroundSubject.toFlowable(BackpressureStrategy.BUFFER).publish();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        this.paused = false;
        boolean z = !this.foreground;
        this.foreground = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        if (z) {
            Logging.logi("went foreground");
            this.foregroundSubject.onNext("ON_FOREGROUND");
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        this.paused = true;
        Runnable runnable = this.check;
        if (runnable != null) {
            this.handler.removeCallbacks(runnable);
        }
        Handler handler = this.handler;
        Runnable runnable2 = new Runnable() { // from class: com.google.firebase.inappmessaging.internal.ForegroundNotifier$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onActivityPaused$0();
            }
        };
        this.check = runnable2;
        handler.postDelayed(runnable2, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityPaused$0() {
        boolean z = this.foreground;
        this.foreground = !(z && this.paused) && z;
    }
}
