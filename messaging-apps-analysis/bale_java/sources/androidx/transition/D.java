package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes2.dex */
abstract class D extends C {
    private static boolean d = true;
    private static boolean e = true;
    private static boolean f = true;

    D() {
    }

    @Override // androidx.transition.H
    public void d(View view, Matrix matrix) {
        if (d) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                d = false;
            }
        }
    }

    @Override // androidx.transition.H
    public void h(View view, Matrix matrix) {
        if (e) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                e = false;
            }
        }
    }

    @Override // androidx.transition.H
    public void i(View view, Matrix matrix) {
        if (f) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f = false;
            }
        }
    }
}
