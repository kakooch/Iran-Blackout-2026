package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: io.appmetrica.analytics.impl.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2766p extends AbstractC2965x7 {
    public Application a;
    public volatile EnumC2742o b = EnumC2742o.d;
    public final C2633ja c = new C2633ja(true);

    public final synchronized void a(Context context) {
        if (this.a == null) {
            try {
                this.a = (Application) context.getApplicationContext();
            } catch (Throwable unused) {
            }
        }
        b();
    }

    public final synchronized void b() {
        EnumC2742o enumC2742o = this.b;
        EnumC2742o enumC2742o2 = EnumC2742o.b;
        if (enumC2742o != enumC2742o2 && !this.c.a.isEmpty()) {
            if (this.a == null) {
                this.b = EnumC2742o.c;
            } else {
                this.b = enumC2742o2;
                this.a.registerActivityLifecycleCallbacks(this);
            }
        }
    }

    public final synchronized void c() {
        if (this.b == EnumC2742o.b && this.c.a.isEmpty()) {
            this.b = EnumC2742o.d;
            Application application = this.a;
            if (application != null) {
                application.unregisterActivityLifecycleCallbacks(this);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(activity, EnumC2694m.CREATED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(activity, EnumC2694m.DESTROYED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(activity, EnumC2694m.PAUSED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(activity, EnumC2694m.RESUMED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(activity, EnumC2694m.STARTED);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(activity, EnumC2694m.STOPPED);
    }

    public final synchronized void a(Application application) {
        try {
            if (this.a == null) {
                this.a = application;
            }
            b();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final EnumC2742o a() {
        return this.b;
    }

    public final void a(Activity activity, EnumC2694m enumC2694m) {
        Collection collection;
        synchronized (this) {
            collection = (Collection) this.c.a.get(enumC2694m);
        }
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                ((InterfaceC2718n) it.next()).a(activity, enumC2694m);
            }
        }
    }

    public final synchronized void b(InterfaceC2718n interfaceC2718n, EnumC2694m... enumC2694mArr) {
        if (enumC2694mArr != null) {
            try {
                if (enumC2694mArr.length == 0) {
                    enumC2694mArr = EnumC2694m.values();
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            enumC2694mArr = EnumC2694m.values();
        }
        for (EnumC2694m enumC2694m : enumC2694mArr) {
            C2633ja c2633ja = this.c;
            Collection collection = (Collection) c2633ja.a.get(enumC2694m);
            if (collection != null && collection.remove(interfaceC2718n)) {
                if (collection.isEmpty() && c2633ja.b) {
                    c2633ja.a.remove(enumC2694m);
                }
                new ArrayList(collection);
            }
        }
        c();
    }

    public final synchronized void a(InterfaceC2718n interfaceC2718n, EnumC2694m... enumC2694mArr) {
        if (enumC2694mArr != null) {
            try {
                if (enumC2694mArr.length == 0) {
                    enumC2694mArr = EnumC2694m.values();
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            enumC2694mArr = EnumC2694m.values();
        }
        for (EnumC2694m enumC2694m : enumC2694mArr) {
            this.c.a(enumC2694m, interfaceC2718n);
        }
        b();
    }
}
