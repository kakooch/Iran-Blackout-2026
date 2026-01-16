package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.VirtualLayout;
import androidx.constraintlayout.widget.c;
import ir.nasim.C16651le1;
import ir.nasim.C18931pV2;
import ir.nasim.C4323Eq2;
import ir.nasim.DY7;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class Flow extends VirtualLayout {
    private C4323Eq2 l;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    protected void o(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.o(attributeSet);
        this.l = new C4323Eq2();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, SE5.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintLayout_Layout_android_orientation) {
                    this.l.C2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_padding) {
                    this.l.H1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingStart) {
                    this.l.M1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingEnd) {
                    this.l.J1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingLeft) {
                    this.l.K1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingTop) {
                    this.l.N1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingRight) {
                    this.l.L1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_android_paddingBottom) {
                    this.l.I1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_wrapMode) {
                    this.l.H2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.l.w2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.l.G2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.l.q2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.l.y2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.l.s2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.l.A2(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.l.u2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.l.p2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.l.x2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.l.r2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.l.z2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_verticalBias) {
                    this.l.E2(typedArrayObtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == SE5.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.l.t2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == SE5.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.l.D2(typedArrayObtainStyledAttributes.getInt(index, 2));
                } else if (index == SE5.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.l.v2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_verticalGap) {
                    this.l.F2(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == SE5.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.l.B2(typedArrayObtainStyledAttributes.getInt(index, -1));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.d = this.l;
        w();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onMeasure(int i, int i2) {
        x(this.l, i, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void p(c.a aVar, C18931pV2 c18931pV2, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        super.p(aVar, c18931pV2, layoutParams, sparseArray);
        if (c18931pV2 instanceof C4323Eq2) {
            C4323Eq2 c4323Eq2 = (C4323Eq2) c18931pV2;
            int i = layoutParams.Y;
            if (i != -1) {
                c4323Eq2.C2(i);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void q(C16651le1 c16651le1, boolean z) {
        this.l.s1(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.l.p2(f);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.l.q2(i);
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.l.r2(f);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.l.s2(i);
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.l.t2(i);
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.l.u2(f);
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.l.v2(i);
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.l.w2(i);
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.l.x2(f);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.l.y2(i);
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.l.z2(f);
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.l.A2(i);
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.l.B2(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        this.l.C2(i);
        requestLayout();
    }

    public void setPadding(int i) {
        this.l.H1(i);
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.l.I1(i);
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.l.K1(i);
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.l.L1(i);
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.l.N1(i);
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.l.D2(i);
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.l.E2(f);
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.l.F2(i);
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.l.G2(i);
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.l.H2(i);
        requestLayout();
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

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
