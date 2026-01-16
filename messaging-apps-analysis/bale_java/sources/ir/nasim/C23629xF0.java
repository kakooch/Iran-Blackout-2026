package ir.nasim;

import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: ir.nasim.xF0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23629xF0 {
    public static final C23629xF0 a = new C23629xF0();
    private static Method b;
    private static Method c;
    private static boolean d;

    private C23629xF0() {
    }

    public final void a(Canvas canvas, boolean z) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Method method;
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            AF0.a.a(canvas, z);
            return;
        }
        if (!d) {
            try {
                if (i == 28) {
                    Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, new Class[0].getClass());
                    b = (Method) declaredMethod.invoke(Canvas.class, "insertReorderBarrier", new Class[0]);
                    c = (Method) declaredMethod.invoke(Canvas.class, "insertInorderBarrier", new Class[0]);
                } else {
                    b = Canvas.class.getDeclaredMethod("insertReorderBarrier", null);
                    c = Canvas.class.getDeclaredMethod("insertInorderBarrier", null);
                }
                Method method2 = b;
                if (method2 != null) {
                    method2.setAccessible(true);
                }
                Method method3 = c;
                if (method3 != null) {
                    method3.setAccessible(true);
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            d = true;
        }
        if (z) {
            try {
                Method method4 = b;
                if (method4 != null) {
                    AbstractC13042fc3.f(method4);
                    method4.invoke(canvas, null);
                }
            } catch (IllegalAccessException | InvocationTargetException unused2) {
                return;
            }
        }
        if (z || (method = c) == null) {
            return;
        }
        AbstractC13042fc3.f(method);
        method.invoke(canvas, null);
    }
}
