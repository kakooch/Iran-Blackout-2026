package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
abstract class H {
    private static Field a;
    private static boolean b;

    H() {
    }

    public abstract void a(View view);

    public abstract float b(View view);

    public abstract void c(View view);

    public abstract void d(View view, Matrix matrix);

    public abstract void e(View view, int i, int i2, int i3, int i4);

    public abstract void f(View view, float f);

    public void g(View view, int i) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            b = true;
        }
        Field field = a;
        if (field != null) {
            try {
                a.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public abstract void h(View view, Matrix matrix);

    public abstract void i(View view, Matrix matrix);
}
