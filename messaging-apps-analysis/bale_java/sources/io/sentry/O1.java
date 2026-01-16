package io.sentry;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public abstract class O1 {
    public static InterfaceC3032a0 a(io.sentry.util.r rVar, ILogger iLogger) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        InterfaceC3032a0 interfaceC3032a0B = b(rVar, iLogger);
        interfaceC3032a0B.init();
        return interfaceC3032a0B;
    }

    private static InterfaceC3032a0 b(io.sentry.util.r rVar, ILogger iLogger) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Class clsC;
        if (io.sentry.util.w.c() && rVar.a("io.sentry.opentelemetry.OtelContextScopesStorage", iLogger) && (clsC = rVar.c("io.sentry.opentelemetry.OtelContextScopesStorage", iLogger)) != null) {
            try {
                Object objNewInstance = clsC.getDeclaredConstructor(null).newInstance(null);
                if (objNewInstance != null && (objNewInstance instanceof InterfaceC3032a0)) {
                    return (InterfaceC3032a0) objNewInstance;
                }
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return new C3161p();
    }
}
