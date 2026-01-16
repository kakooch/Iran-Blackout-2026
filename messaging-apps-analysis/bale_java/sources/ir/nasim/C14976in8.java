package ir.nasim;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* renamed from: ir.nasim.in8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C14976in8 implements Application.ActivityLifecycleCallbacks {
    final /* synthetic */ C15566jn8 a;

    C14976in8(C15566jn8 c15566jn8) {
        this.a = c15566jn8;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.a.j(new Hm8(this, bundle, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.a.j(new C14368hn8(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.a.j(new C11936dn8(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.a.j(new Jm8(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Ck8 ck8 = new Ck8();
        this.a.j(new C13775gn8(this, activity, ck8));
        Bundle bundleC2 = ck8.C2(50L);
        if (bundleC2 != null) {
            bundle.putAll(bundleC2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        this.a.j(new Im8(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        this.a.j(new C13184fn8(this, activity));
    }
}
