package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.i;
import ir.nasim.SE5;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Carousel extends MotionHelper {
    private int A;
    private float B;
    private int D;
    private int G;
    int H;
    Runnable J;
    private final ArrayList n;
    private int o;
    private int p;
    private MotionLayout q;
    private int r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float x;
    private int y;
    private int z;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.this.q.setProgress(0.0f);
            Carousel.this.J();
            Carousel.H(Carousel.this);
            int unused = Carousel.this.p;
            throw null;
        }
    }

    public interface b {
    }

    public Carousel(Context context) {
        super(context);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.D = -1;
        this.G = 200;
        this.H = -1;
        this.J = new a();
    }

    static /* synthetic */ b H(Carousel carousel) {
        carousel.getClass();
        return null;
    }

    private void I(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == SE5.Carousel_carousel_firstView) {
                    this.r = typedArrayObtainStyledAttributes.getResourceId(index, this.r);
                } else if (index == SE5.Carousel_carousel_backwardTransition) {
                    this.t = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                } else if (index == SE5.Carousel_carousel_forwardTransition) {
                    this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                } else if (index == SE5.Carousel_carousel_emptyViewsBehavior) {
                    this.z = typedArrayObtainStyledAttributes.getInt(index, this.z);
                } else if (index == SE5.Carousel_carousel_previousState) {
                    this.v = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                } else if (index == SE5.Carousel_carousel_nextState) {
                    this.w = typedArrayObtainStyledAttributes.getResourceId(index, this.w);
                } else if (index == SE5.Carousel_carousel_touchUp_dampeningFactor) {
                    this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
                } else if (index == SE5.Carousel_carousel_touchUpMode) {
                    this.A = typedArrayObtainStyledAttributes.getInt(index, this.A);
                } else if (index == SE5.Carousel_carousel_touchUp_velocityThreshold) {
                    this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
                } else if (index == SE5.Carousel_carousel_infinite) {
                    this.s = typedArrayObtainStyledAttributes.getBoolean(index, this.s);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.j
    public void a(MotionLayout motionLayout, int i, int i2, float f) {
        this.H = i;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.j
    public void b(MotionLayout motionLayout, int i) {
        int i2 = this.p;
        this.o = i2;
        if (i == this.w) {
            this.p = i2 + 1;
        } else if (i == this.v) {
            this.p = i2 - 1;
        }
        if (!this.s) {
            throw null;
        }
        throw null;
    }

    public int getCount() {
        return 0;
    }

    public int getCurrentIndex() {
        return this.p;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    protected void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            for (int i = 0; i < this.b; i++) {
                int i2 = this.a[i];
                View viewK = motionLayout.K(i2);
                if (this.r == i2) {
                    this.y = i;
                }
                this.n.add(viewK);
            }
            this.q = motionLayout;
            if (this.A == 2) {
                i.b bVarW0 = motionLayout.W0(this.u);
                if (bVarW0 != null) {
                    bVarW0.G(5);
                }
                i.b bVarW02 = this.q.W0(this.t);
                if (bVarW02 != null) {
                    bVarW02.G(5);
                }
            }
            J();
        }
    }

    public void setAdapter(b bVar) {
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.D = -1;
        this.G = 200;
        this.H = -1;
        this.J = new a();
        I(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new ArrayList();
        this.o = 0;
        this.p = 0;
        this.r = -1;
        this.s = false;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = 0.9f;
        this.y = 0;
        this.z = 4;
        this.A = 1;
        this.B = 2.0f;
        this.D = -1;
        this.G = 200;
        this.H = -1;
        this.J = new a();
        I(context, attributeSet);
    }
}
