package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;

/* renamed from: androidx.transition.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
abstract class AbstractC1986i {
    static InterfaceC1982e a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? C1984g.b(view, viewGroup, matrix) : C1985h.b(view, viewGroup, matrix);
    }

    static void b(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (Build.VERSION.SDK_INT == 28) {
            C1984g.f(view);
        } else {
            C1985h.f(view);
        }
    }
}
