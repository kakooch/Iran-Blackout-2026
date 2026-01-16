package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class aom implements Application.ActivityLifecycleCallbacks {
    private final Application a;
    private final List<aol> b = new ArrayList();

    public aom(Application application) {
        this.a = application;
        application.registerActivityLifecycleCallbacks(this);
    }

    public final void a(aol aolVar) {
        this.b.add(aolVar);
    }

    public final void b() {
        this.a.unregisterActivityLifecycleCallbacks(this);
        this.b.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Iterator<aol> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Iterator<aol> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().k();
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
