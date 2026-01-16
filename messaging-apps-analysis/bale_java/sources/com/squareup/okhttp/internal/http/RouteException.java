package com.squareup.okhttp.internal.http;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class RouteException extends Exception {
    private static final Method a;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        a = declaredMethod;
    }
}
