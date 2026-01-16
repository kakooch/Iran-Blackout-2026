package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.github.inflationx.calligraphy3.BuildConfig;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class alf implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ ali a;

    alf(ali aliVar) {
        this.a = aliVar;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        if (this.a.f == activity) {
            this.a.f = null;
            Application applicationH = yy.h(this.a.c.getContext());
            if (applicationH != null) {
                applicationH.unregisterActivityLifecycleCallbacks(this.a.e);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        if (this.a.f == null || this.a.f == activity) {
            this.a.f = activity;
            this.a.a.n(new amx(amv.activityMonitor, amw.appStateChanged, this.a.b, this.a.f(BuildConfig.FLAVOR, BuildConfig.FLAVOR, "inactive")));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        if (this.a.f == activity) {
            this.a.a.n(new amx(amv.activityMonitor, amw.appStateChanged, this.a.b, this.a.f(BuildConfig.FLAVOR, BuildConfig.FLAVOR, "active")));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
