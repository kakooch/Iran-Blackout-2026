package androidx.core.util;

import android.os.Build;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ObjectsCompat {
    public static boolean equals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.equals(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hash(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Api19Impl.hash(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static <T> T requireNonNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    static class Api19Impl {
        static boolean equals(Object obj, Object obj2) {
            return ObjectsCompat$Api19Impl$$ExternalSynthetic0.m0(obj, obj2);
        }

        static int hash(Object... objArr) {
            return Arrays.hashCode(objArr);
        }
    }
}
