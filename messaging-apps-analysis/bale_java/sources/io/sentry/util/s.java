package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.Y2;

/* loaded from: classes3.dex */
public abstract class s {
    public static void a(Class cls, Object obj, ILogger iLogger) {
        iLogger.c(Y2.DEBUG, "%s is not %s", obj != null ? obj.getClass().getCanonicalName() : "Hint", cls.getCanonicalName());
    }
}
