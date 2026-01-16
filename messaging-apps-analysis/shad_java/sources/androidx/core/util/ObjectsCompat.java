package androidx.core.util;

import android.os.Build;
import androidMessenger.proxy.CallProxy$$ExternalSyntheticBackport0;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ObjectsCompat {
    public static boolean equals(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return CallProxy$$ExternalSyntheticBackport0.m(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hash(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Arrays.hashCode(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static <T> T requireNonNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
