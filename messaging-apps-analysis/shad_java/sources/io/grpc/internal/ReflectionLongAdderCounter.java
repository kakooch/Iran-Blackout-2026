package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class ReflectionLongAdderCounter implements LongCounter {
    private static final Method addMethod;
    private static final Constructor<?> defaultConstructor;
    private static final RuntimeException initializationException;
    private static final Logger logger = Logger.getLogger(ReflectionLongAdderCounter.class.getName());
    private static final Object[] one;
    private final Object instance;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    static {
        /*
            java.lang.Class<io.grpc.internal.ReflectionLongAdderCounter> r0 = io.grpc.internal.ReflectionLongAdderCounter.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            io.grpc.internal.ReflectionLongAdderCounter.logger = r0
            r0 = 1
            r1 = 0
            r2 = 0
            java.lang.String r3 = "java.util.concurrent.atomic.LongAdder"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = "add"
            java.lang.Class[] r5 = new java.lang.Class[r0]     // Catch: java.lang.Throwable -> L42
            java.lang.Class r6 = java.lang.Long.TYPE     // Catch: java.lang.Throwable -> L42
            r5[r1] = r6     // Catch: java.lang.Throwable -> L42
            java.lang.reflect.Method r4 = r3.getMethod(r4, r5)     // Catch: java.lang.Throwable -> L42
            java.lang.String r5 = "sum"
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L40
            r3.getMethod(r5, r6)     // Catch: java.lang.Throwable -> L40
            java.lang.reflect.Constructor[] r3 = r3.getConstructors()     // Catch: java.lang.Throwable -> L40
            int r5 = r3.length     // Catch: java.lang.Throwable -> L40
            r6 = 0
        L2e:
            if (r6 >= r5) goto L3d
            r7 = r3[r6]     // Catch: java.lang.Throwable -> L40
            java.lang.Class[] r8 = r7.getParameterTypes()     // Catch: java.lang.Throwable -> L40
            int r8 = r8.length     // Catch: java.lang.Throwable -> L40
            if (r8 != 0) goto L3a
            goto L3e
        L3a:
            int r6 = r6 + 1
            goto L2e
        L3d:
            r7 = r2
        L3e:
            r3 = r2
            goto L4e
        L40:
            r3 = move-exception
            goto L44
        L42:
            r3 = move-exception
            r4 = r2
        L44:
            java.util.logging.Logger r5 = io.grpc.internal.ReflectionLongAdderCounter.logger
            java.util.logging.Level r6 = java.util.logging.Level.FINE
            java.lang.String r7 = "LongAdder can not be found via reflection, this is normal for JDK7 and below"
            r5.log(r6, r7, r3)
            r7 = r2
        L4e:
            if (r3 != 0) goto L59
            if (r7 == 0) goto L59
            io.grpc.internal.ReflectionLongAdderCounter.defaultConstructor = r7
            io.grpc.internal.ReflectionLongAdderCounter.addMethod = r4
            io.grpc.internal.ReflectionLongAdderCounter.initializationException = r2
            goto L64
        L59:
            io.grpc.internal.ReflectionLongAdderCounter.defaultConstructor = r2
            io.grpc.internal.ReflectionLongAdderCounter.addMethod = r2
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r3)
            io.grpc.internal.ReflectionLongAdderCounter.initializationException = r2
        L64:
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r2 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r0[r1] = r2
            io.grpc.internal.ReflectionLongAdderCounter.one = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.ReflectionLongAdderCounter.<clinit>():void");
    }

    ReflectionLongAdderCounter() {
        RuntimeException runtimeException = initializationException;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.instance = defaultConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    static boolean isAvailable() {
        return initializationException == null;
    }

    @Override // io.grpc.internal.LongCounter
    public void add(long j) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            addMethod.invoke(this.instance, j == 1 ? one : new Object[]{Long.valueOf(j)});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }
}
