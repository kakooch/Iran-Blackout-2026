package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.C11523d90;
import ir.nasim.C16651le1;
import ir.nasim.C17242me1;
import ir.nasim.C18931pV2;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class Barrier extends ConstraintHelper {
    private int j;
    private int k;
    private C11523d90 l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void x(C16651le1 c16651le1, int i, boolean z) {
        this.k = i;
        if (z) {
            int i2 = this.j;
            if (i2 == 5) {
                this.k = 1;
            } else if (i2 == 6) {
                this.k = 0;
            }
        } else {
            int i3 = this.j;
            if (i3 == 5) {
                this.k = 0;
            } else if (i3 == 6) {
                this.k = 1;
            }
        }
        if (c16651le1 instanceof C11523d90) {
            ((C11523d90) c16651le1).z1(this.k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.l.t1();
    }

    public int getMargin() {
        return this.l.v1();
    }

    public int getType() {
        return this.j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        this.l = new C11523d90();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.l.y1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == SE5.ConstraintLayout_Layout_barrierMargin) {
                    this.l.A1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.d = this.l;
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(c.a aVar, C18931pV2 c18931pV2, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        super.p(aVar, c18931pV2, layoutParams, sparseArray);
        if (c18931pV2 instanceof C11523d90) {
            C11523d90 c11523d90 = (C11523d90) c18931pV2;
            x(c11523d90, aVar.e.g0, ((C17242me1) c18931pV2.N()).O1());
            c11523d90.y1(aVar.e.o0);
            c11523d90.A1(aVar.e.h0);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(C16651le1 c16651le1, boolean z) {
        x(c16651le1, this.j, z);
    }

    public void setAllowsGoneWidget(boolean z) {
        this.l.y1(z);
    }

    public void setDpMargin(int i) {
        this.l.A1((int) ((i * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i) {
        this.l.A1(i);
    }

    public void setType(int i) {
        this.j = i;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        super.setVisibility(8);
    }
}
