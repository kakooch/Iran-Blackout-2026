package io.sentry.android.ndk;

import io.sentry.C3155n3;
import io.sentry.android.core.InterfaceC3079u0;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.ndk.NativeModuleListLoader;
import io.sentry.util.C3202a;
import io.sentry.util.u;

/* loaded from: classes3.dex */
public final class a implements InterfaceC3079u0 {
    protected static final C3202a c = new C3202a();
    private final C3155n3 a;
    private final NativeModuleListLoader b;

    public a(SentryAndroidOptions sentryAndroidOptions, NativeModuleListLoader nativeModuleListLoader) {
        this.a = (C3155n3) u.c(sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.b = (NativeModuleListLoader) u.c(nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
}
