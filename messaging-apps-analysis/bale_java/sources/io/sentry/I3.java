package io.sentry;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public abstract class I3 {
    public static InterfaceC3122h0 a(io.sentry.util.r rVar, ILogger iLogger) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Class clsC;
        if (io.sentry.util.w.c() && rVar.a("io.sentry.opentelemetry.OtelSpanFactory", iLogger) && (clsC = rVar.c("io.sentry.opentelemetry.OtelSpanFactory", iLogger)) != null) {
            try {
                Object objNewInstance = clsC.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance != null && (objNewInstance instanceof InterfaceC3122h0)) {
                    return (InterfaceC3122h0) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new C3175q();
    }
}
