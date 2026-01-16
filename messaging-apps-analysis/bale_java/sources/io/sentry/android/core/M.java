package io.sentry.android.core;

import android.content.Context;
import io.sentry.InterfaceC3157o0;

/* loaded from: classes3.dex */
public abstract class M {
    public static InterfaceC3157o0 a(Context context, Y y) {
        return y.d() >= 30 ? new AnrV2Integration(context) : new AnrIntegration(context);
    }
}
