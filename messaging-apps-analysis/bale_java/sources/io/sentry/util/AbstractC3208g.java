package io.sentry.util;

import java.util.Set;

/* renamed from: io.sentry.util.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3208g {
    public static Throwable a(Throwable th) {
        u.c(th, "throwable cannot be null");
        while (th.getCause() != null && th.getCause() != th) {
            th = th.getCause();
        }
        return th;
    }

    public static boolean b(Set set, Throwable th) {
        return set.contains(th.getClass());
    }
}
