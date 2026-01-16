package io.sentry.android.core;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* renamed from: io.sentry.android.core.l0, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C3062l0 {
    private static final C3062l0 b = new C3062l0();
    private WeakReference a;

    private C3062l0() {
    }

    public static C3062l0 c() {
        return b;
    }

    public void a(Activity activity) {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() == activity) {
            this.a = null;
        }
    }

    public Activity b() {
        WeakReference weakReference = this.a;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public void d(Activity activity) {
        WeakReference weakReference = this.a;
        if (weakReference == null || weakReference.get() != activity) {
            this.a = new WeakReference(activity);
        }
    }
}
