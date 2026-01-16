package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.services.SafePackageManager;
import io.appmetrica.analytics.networktasks.internal.BaseRequestConfig;

/* loaded from: classes3.dex */
public abstract class N5 extends BaseRequestConfig.ComponentLoader {
    public final SafePackageManager a;

    public N5(Context context, String str) {
        this(context, str, new SafePackageManager());
    }

    @Override // io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.ComponentLoader, io.appmetrica.analytics.networktasks.internal.BaseRequestConfig.RequestConfigLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public O5 load(M5 m5) {
        O5 o5 = (O5) super.load((N5) m5);
        String packageName = getContext().getPackageName();
        ApplicationInfo applicationInfo = this.a.getApplicationInfo(getContext(), getPackageName(), 0);
        if (applicationInfo != null) {
            int i = applicationInfo.flags;
            o5.a = (i & 2) != 0 ? "1" : "0";
            o5.b = (i & 1) == 0 ? "0" : "1";
        } else if (TextUtils.equals(packageName, getPackageName())) {
            o5.a = (getContext().getApplicationInfo().flags & 2) != 0 ? "1" : "0";
            o5.b = (getContext().getApplicationInfo().flags & 1) == 0 ? "0" : "1";
        } else {
            o5.a = "0";
            o5.b = "0";
        }
        C2549fl c2549fl = m5.a;
        o5.c = c2549fl;
        o5.setRetryPolicyConfig(c2549fl.t);
        return o5;
    }

    public N5(Context context, String str, SafePackageManager safePackageManager) {
        super(context, str);
        this.a = safePackageManager;
    }
}
