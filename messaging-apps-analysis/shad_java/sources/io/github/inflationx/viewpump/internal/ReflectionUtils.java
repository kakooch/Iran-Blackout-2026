package io.github.inflationx.viewpump.internal;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: -ReflectionUtils.kt */
/* renamed from: io.github.inflationx.viewpump.internal.-ReflectionUtils, reason: invalid class name */
/* loaded from: classes3.dex */
public final class ReflectionUtils {
    public static final void setValueQuietly(Field receiver$0, Object obj, Object value) throws IllegalAccessException, IllegalArgumentException {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(obj, "obj");
        Intrinsics.checkParameterIsNotNull(value, "value");
        try {
            receiver$0.set(obj, value);
        } catch (IllegalAccessException unused) {
        }
    }

    public static final Method getAccessibleMethod(Class<?> receiver$0, String methodName) throws SecurityException {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(methodName, "methodName");
        for (Method method : receiver$0.getMethods()) {
            Intrinsics.checkExpressionValueIsNotNull(method, "method");
            if (Intrinsics.areEqual(method.getName(), methodName)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    public static final void invokeMethod(Method method, Object target, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(args, "args");
        if (method == null) {
            return;
        }
        try {
            method.invoke(target, Arrays.copyOf(args, args.length));
        } catch (IllegalAccessException e) {
            Log.d("ReflectionUtils", "Can't access method using reflection", e);
        } catch (InvocationTargetException e2) {
            Log.d("ReflectionUtils", "Can't invoke method using reflection", e2);
        }
    }
}
