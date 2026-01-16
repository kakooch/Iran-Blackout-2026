package io.sentry.util;

/* renamed from: io.sentry.util.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC3203b {
    public static ClassLoader a(ClassLoader classLoader) {
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader : ClassLoader.getSystemClassLoader();
    }
}
