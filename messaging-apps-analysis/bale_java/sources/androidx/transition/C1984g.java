package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: androidx.transition.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1984g implements InterfaceC1982e {
    private static Class b;
    private static boolean c;
    private static Method d;
    private static boolean e;
    private static Method f;
    private static boolean g;
    private final View a;

    private C1984g(View view) {
        this.a = view;
    }

    static InterfaceC1982e b(View view, ViewGroup viewGroup, Matrix matrix) throws NoSuchMethodException, SecurityException {
        c();
        Method method = d;
        if (method != null) {
            try {
                return new C1984g((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void c() throws NoSuchMethodException, SecurityException {
        if (e) {
            return;
        }
        try {
            d();
            Method declaredMethod = b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            d = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e2);
        }
        e = true;
    }

    private static void d() {
        if (c) {
            return;
        }
        try {
            b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e2);
        }
        c = true;
    }

    private static void e() throws NoSuchMethodException, SecurityException {
        if (g) {
            return;
        }
        try {
            d();
            Method declaredMethod = b.getDeclaredMethod("removeGhost", View.class);
            f = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e2);
        }
        g = true;
    }

    static void f(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        e();
        Method method = f;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.InterfaceC1982e
    public void a(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.InterfaceC1982e
    public void setVisibility(int i) {
        this.a.setVisibility(i);
    }
}
