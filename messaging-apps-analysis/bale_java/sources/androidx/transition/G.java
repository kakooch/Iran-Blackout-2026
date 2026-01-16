package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes2.dex */
class G extends F {
    G() {
    }

    @Override // androidx.transition.C, androidx.transition.H
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.D, androidx.transition.H
    public void d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.E, androidx.transition.H
    public void e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // androidx.transition.C, androidx.transition.H
    public void f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // androidx.transition.F, androidx.transition.H
    public void g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // androidx.transition.D, androidx.transition.H
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.D, androidx.transition.H
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
