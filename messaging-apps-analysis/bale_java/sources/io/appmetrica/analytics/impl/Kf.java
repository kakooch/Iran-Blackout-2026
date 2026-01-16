package io.appmetrica.analytics.impl;

import android.content.Context;
import com.android.installreferrer.api.InstallReferrerClient;
import io.appmetrica.analytics.coreapi.internal.executors.IHandlerExecutor;
import io.appmetrica.analytics.coreutils.internal.reflection.ReflectionUtils;

/* loaded from: classes3.dex */
public final class Kf {
    public Kf(Ia ia) {
    }

    public static Ia a(Context context, IHandlerExecutor iHandlerExecutor) {
        C2973xf c2973xf;
        if (ReflectionUtils.detectClassExists("com.android.installreferrer.api.InstallReferrerClient")) {
            try {
                c2973xf = new C2973xf(InstallReferrerClient.newBuilder(context).build(), iHandlerExecutor);
            } catch (Throwable unused) {
            }
        } else {
            c2973xf = null;
        }
        return c2973xf == null ? new Jf() : c2973xf;
    }
}
