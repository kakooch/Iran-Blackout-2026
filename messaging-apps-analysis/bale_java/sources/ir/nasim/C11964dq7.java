package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: ir.nasim.dq7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11964dq7 implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        AbstractC13042fc3.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        C13213fq7.a.h();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
        C13213fq7.a.b();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AbstractC13042fc3.i(activity, "activity");
        AbstractC13042fc3.i(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        AbstractC13042fc3.i(activity, "activity");
    }
}
