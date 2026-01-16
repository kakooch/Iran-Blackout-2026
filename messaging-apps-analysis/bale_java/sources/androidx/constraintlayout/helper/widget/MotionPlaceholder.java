package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.VirtualLayout;
import ir.nasim.C17242me1;
import ir.nasim.C23273we5;
import ir.nasim.DY7;
import ir.nasim.InterfaceC17158mV2;

/* loaded from: classes2.dex */
public class MotionPlaceholder extends VirtualLayout {
    C23273we5 l;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        this.d = new C23273we5();
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i, int i2) {
        x(this.l, i, i2);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void x(DY7 dy7, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (dy7 == null) {
            setMeasuredDimension(0, 0);
        } else {
            dy7.B1(mode, size, mode2, size2);
            setMeasuredDimension(dy7.w1(), dy7.v1());
        }
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void v(C17242me1 c17242me1, InterfaceC17158mV2 interfaceC17158mV2, SparseArray sparseArray) {
    }
}
