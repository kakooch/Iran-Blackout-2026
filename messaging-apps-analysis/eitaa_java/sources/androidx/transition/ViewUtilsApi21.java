package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class ViewUtilsApi21 extends ViewUtilsApi19 {
    private static Method sTransformMatrixToGlobalMethod;
    private static boolean sTransformMatrixToGlobalMethodFetched;
    private static Method sTransformMatrixToLocalMethod;
    private static boolean sTransformMatrixToLocalMethodFetched;

    ViewUtilsApi21() {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(View view, Matrix matrix) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        fetchTransformMatrixToGlobalMethod();
        Method method = sTransformMatrixToGlobalMethod;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(View view, Matrix matrix) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        fetchTransformMatrixToLocalMethod();
        Method method = sTransformMatrixToLocalMethod;
        if (method != null) {
            try {
                method.invoke(view, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    private void fetchTransformMatrixToGlobalMethod() throws NoSuchMethodException, SecurityException {
        if (sTransformMatrixToGlobalMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", Matrix.class);
            sTransformMatrixToGlobalMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", e);
        }
        sTransformMatrixToGlobalMethodFetched = true;
    }

    private void fetchTransformMatrixToLocalMethod() throws NoSuchMethodException, SecurityException {
        if (sTransformMatrixToLocalMethodFetched) {
            return;
        }
        try {
            Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", Matrix.class);
            sTransformMatrixToLocalMethod = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", e);
        }
        sTransformMatrixToLocalMethodFetched = true;
    }
}
