package org.acra.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.acra.ACRA;
import org.acra.ErrorReporter;

/* loaded from: classes.dex */
public final class StubCreator {
    private StubCreator() {
    }

    public static ErrorReporter createErrorReporterStub() {
        return (ErrorReporter) createStub(ErrorReporter.class, new InvocationHandler() { // from class: org.acra.util.-$$Lambda$StubCreator$f50KYF-KMARqWupOdfHVEdtMB38
            @Override // java.lang.reflect.InvocationHandler
            public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                StubCreator.lambda$createErrorReporterStub$0(obj, method, objArr);
                return null;
            }
        });
    }

    static /* synthetic */ Object lambda$createErrorReporterStub$0(Object obj, Method method, Object[] objArr) throws Throwable {
        ACRA.log.w(ACRA.LOG_TAG, String.format("ErrorReporter#%s called %s. THIS CALL WILL BE IGNORED!", method.getName(), ACRA.isACRASenderServiceProcess() ? "in SenderService process" : "before ACRA#init (if you did call #init, check if your configuration is valid)"));
        return null;
    }

    public static <T> T createStub(Class<T> cls, InvocationHandler invocationHandler) {
        return (T) Proxy.newProxyInstance(StubCreator.class.getClassLoader(), new Class[]{cls}, invocationHandler);
    }
}
