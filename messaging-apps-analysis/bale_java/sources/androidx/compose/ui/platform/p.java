package androidx.compose.ui.platform;

import android.graphics.Matrix;
import android.view.View;
import ir.nasim.AV3;
import ir.nasim.AbstractC20313ro;
import ir.nasim.AbstractC5964Lp;
import ir.nasim.ED1;

/* loaded from: classes2.dex */
final class p implements o {
    private final float[] a;
    private final int[] b;

    public /* synthetic */ p(float[] fArr, ED1 ed1) {
        this(fArr);
    }

    private final void b(float[] fArr, Matrix matrix) {
        AbstractC5964Lp.b(this.a, matrix);
        AbstractC20313ro.i(fArr, this.a);
    }

    private final void c(float[] fArr, float f, float f2) {
        AbstractC20313ro.j(fArr, f, f2, this.a);
    }

    private final void d(View view, float[] fArr) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            d((View) parent, fArr);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, view.getLeft(), view.getTop());
        } else {
            view.getLocationInWindow(this.b);
            c(fArr, -view.getScrollX(), -view.getScrollY());
            c(fArr, r0[0], r0[1]);
        }
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            return;
        }
        b(fArr, matrix);
    }

    @Override // androidx.compose.ui.platform.o
    public void a(View view, float[] fArr) {
        AV3.h(fArr);
        d(view, fArr);
    }

    private p(float[] fArr) {
        this.a = fArr;
        this.b = new int[2];
    }
}
