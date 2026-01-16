package io.appmetrica.analytics.impl;

import android.app.Activity;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class r {
    public final WeakHashMap a = new WeakHashMap();

    public final boolean a(Activity activity, EnumC2790q enumC2790q) {
        if (activity != null && this.a.get(activity) == enumC2790q) {
            return false;
        }
        if (activity == null) {
            return true;
        }
        this.a.put(activity, enumC2790q);
        return true;
    }
}
