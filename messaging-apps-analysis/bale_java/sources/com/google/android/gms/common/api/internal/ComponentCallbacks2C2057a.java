package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import ir.nasim.AbstractC3993Df5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.google.android.gms.common.api.internal.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ComponentCallbacks2C2057a implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private static final ComponentCallbacks2C2057a e = new ComponentCallbacks2C2057a();
    private final AtomicBoolean a = new AtomicBoolean();
    private final AtomicBoolean b = new AtomicBoolean();
    private final ArrayList c = new ArrayList();
    private boolean d = false;

    /* renamed from: com.google.android.gms.common.api.internal.a$a, reason: collision with other inner class name */
    public interface InterfaceC0172a {
        void a(boolean z);
    }

    private ComponentCallbacks2C2057a() {
    }

    public static ComponentCallbacks2C2057a b() {
        return e;
    }

    public static void c(Application application) {
        ComponentCallbacks2C2057a componentCallbacks2C2057a = e;
        synchronized (componentCallbacks2C2057a) {
            try {
                if (!componentCallbacks2C2057a.d) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C2057a);
                    application.registerComponentCallbacks(componentCallbacks2C2057a);
                    componentCallbacks2C2057a.d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void f(boolean z) {
        synchronized (e) {
            try {
                Iterator it = this.c.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0172a) it.next()).a(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(InterfaceC0172a interfaceC0172a) {
        synchronized (e) {
            this.c.add(interfaceC0172a);
        }
    }

    public boolean d() {
        return this.a.get();
    }

    public boolean e(boolean z) {
        if (!this.b.get()) {
            if (!AbstractC3993Df5.b()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.b;
        boolean zCompareAndSet = this.a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.b;
        boolean zCompareAndSet = this.a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            f(false);
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

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.a.compareAndSet(false, true)) {
            this.b.set(true);
            f(true);
        }
    }
}
