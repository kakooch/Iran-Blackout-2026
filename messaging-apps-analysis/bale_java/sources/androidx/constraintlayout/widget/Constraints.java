package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class Constraints extends ViewGroup {
    c a;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void c(AttributeSet attributeSet) {
        Log.v("Constraints", " ################# init");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.a == null) {
            this.a = new c();
        }
        this.a.r(this);
        return this.a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c(attributeSet);
        super.setVisibility(8);
    }

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float H0;
        public float I0;
        public float w0;
        public boolean x0;
        public float y0;
        public float z0;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.w0 = 1.0f;
            this.x0 = false;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 1.0f;
            this.D0 = 1.0f;
            this.E0 = 0.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.w0 = 1.0f;
            this.x0 = false;
            this.y0 = 0.0f;
            this.z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 1.0f;
            this.D0 = 1.0f;
            this.E0 = 0.0f;
            this.F0 = 0.0f;
            this.G0 = 0.0f;
            this.H0 = 0.0f;
            this.I0 = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.ConstraintSet);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.ConstraintSet_android_alpha) {
                    this.w0 = typedArrayObtainStyledAttributes.getFloat(index, this.w0);
                } else if (index == SE5.ConstraintSet_android_elevation) {
                    this.y0 = typedArrayObtainStyledAttributes.getFloat(index, this.y0);
                    this.x0 = true;
                } else if (index == SE5.ConstraintSet_android_rotationX) {
                    this.A0 = typedArrayObtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == SE5.ConstraintSet_android_rotationY) {
                    this.B0 = typedArrayObtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == SE5.ConstraintSet_android_rotation) {
                    this.z0 = typedArrayObtainStyledAttributes.getFloat(index, this.z0);
                } else if (index == SE5.ConstraintSet_android_scaleX) {
                    this.C0 = typedArrayObtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == SE5.ConstraintSet_android_scaleY) {
                    this.D0 = typedArrayObtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == SE5.ConstraintSet_android_transformPivotX) {
                    this.E0 = typedArrayObtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == SE5.ConstraintSet_android_transformPivotY) {
                    this.F0 = typedArrayObtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == SE5.ConstraintSet_android_translationX) {
                    this.G0 = typedArrayObtainStyledAttributes.getFloat(index, this.G0);
                } else if (index == SE5.ConstraintSet_android_translationY) {
                    this.H0 = typedArrayObtainStyledAttributes.getFloat(index, this.H0);
                } else if (index == SE5.ConstraintSet_android_translationZ) {
                    this.I0 = typedArrayObtainStyledAttributes.getFloat(index, this.I0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
