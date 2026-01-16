package io.github.inflationx.calligraphy3;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    ReflectionUtils() {
    }

    static Method getMethod(Class cls, String str) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str)) {
                method.setAccessible(true);
                return method;
            }
        }
        return null;
    }

    static void invokeMethod(Object obj, Method method, Object... objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (method == null) {
            return;
        }
        try {
            method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Log.d(TAG, "Can't access method using reflection", e);
        } catch (InvocationTargetException e2) {
            Log.d(TAG, "Can't invoke method using reflection", e2);
        }
    }
}
