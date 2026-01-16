package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import ir.nasim.SE5;

/* loaded from: classes2.dex */
public class MotionEffect extends MotionHelper {
    private float n;
    private int o;
    private int p;
    private int q;
    private int r;
    private boolean s;
    private int t;
    private int u;

    public MotionEffect(Context context) {
        super(context);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
    }

    private void E(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.MotionEffect_motionEffect_start) {
                    int i2 = typedArrayObtainStyledAttributes.getInt(index, this.o);
                    this.o = i2;
                    this.o = Math.max(Math.min(i2, 99), 0);
                } else if (index == SE5.MotionEffect_motionEffect_end) {
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, this.p);
                    this.p = i3;
                    this.p = Math.max(Math.min(i3, 99), 0);
                } else if (index == SE5.MotionEffect_motionEffect_translationX) {
                    this.q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.q);
                } else if (index == SE5.MotionEffect_motionEffect_translationY) {
                    this.r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.r);
                } else if (index == SE5.MotionEffect_motionEffect_alpha) {
                    this.n = typedArrayObtainStyledAttributes.getFloat(index, this.n);
                } else if (index == SE5.MotionEffect_motionEffect_move) {
                    this.u = typedArrayObtainStyledAttributes.getInt(index, this.u);
                } else if (index == SE5.MotionEffect_motionEffect_strict) {
                    this.s = typedArrayObtainStyledAttributes.getBoolean(index, this.s);
                } else if (index == SE5.MotionEffect_motionEffect_viewTransition) {
                    this.t = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                }
            }
            int i4 = this.o;
            int i5 = this.p;
            if (i4 == i5) {
                if (i4 > 0) {
                    this.o = i4 - 1;
                } else {
                    this.p = i5 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x017e, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0192, code lost:
    
        if (r14 == 0.0f) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01a2, code lost:
    
        if (r15 == 0.0f) goto L58;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01dd  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(androidx.constraintlayout.motion.widget.MotionLayout r23, java.util.HashMap r24) {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.D(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    public boolean x() {
        return true;
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        E(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        E(context, attributeSet);
    }
}
