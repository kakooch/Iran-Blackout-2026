package ir.nasim;

import android.os.Bundle;
import android.os.IBinder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.zm0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC25122zm0 {
    private static Method a;
    private static Method b;

    public static IBinder a(Bundle bundle, String str) {
        return AbstractC9683aN7.a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    private static IBinder b(Bundle bundle, String str) throws NoSuchMethodException, SecurityException {
        Method method = a;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", String.class);
                a = method2;
                method2.setAccessible(true);
                method = a;
            } catch (NoSuchMethodException e) {
                AbstractC18815pI3.g("BundleUtil", "Failed to retrieve getIBinder method", e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            AbstractC18815pI3.g("BundleUtil", "Failed to invoke getIBinder via reflection", e2);
            return null;
        }
    }

    public static void c(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (AbstractC9683aN7.a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    private static void d(Bundle bundle, String str, IBinder iBinder) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method = b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                b = method2;
                method2.setAccessible(true);
                method = b;
            } catch (NoSuchMethodException e) {
                AbstractC18815pI3.g("BundleUtil", "Failed to retrieve putIBinder method", e);
                return;
            }
        }
        try {
            method.invoke(bundle, str, iBinder);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
            AbstractC18815pI3.g("BundleUtil", "Failed to invoke putIBinder via reflection", e2);
        }
    }
}
