package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.widget.NestedScrollView;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.OA1;
import ir.nasim.SE5;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
class j {
    private static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private float r;
    private float s;
    private final MotionLayout t;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private float g = 0.5f;
    private float h = 0.5f;
    float i = 0.5f;
    float j = 0.5f;
    private int k = -1;
    boolean l = false;
    private float m = 0.0f;
    private float n = 1.0f;
    private boolean o = false;
    private float[] p = new float[2];
    private int[] q = new int[2];
    private float u = 4.0f;
    private float v = 1.2f;
    private boolean w = true;
    private float x = 1.0f;
    private int y = 0;
    private float z = 10.0f;
    private float A = 10.0f;
    private float B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    class a implements View.OnTouchListener {
        a(j jVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    class b implements NestedScrollView.d {
        b(j jVar) {
        }

        @Override // androidx.core.widget.NestedScrollView.d
        public void a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        }
    }

    j(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == SE5.OnSwipe_touchAnchorId) {
                this.d = typedArray.getResourceId(index, this.d);
            } else if (index == SE5.OnSwipe_touchAnchorSide) {
                int i2 = typedArray.getInt(index, this.a);
                this.a = i2;
                float[] fArr = G[i2];
                this.h = fArr[0];
                this.g = fArr[1];
            } else if (index == SE5.OnSwipe_dragDirection) {
                int i3 = typedArray.getInt(index, this.b);
                this.b = i3;
                float[][] fArr2 = H;
                if (i3 < fArr2.length) {
                    float[] fArr3 = fArr2[i3];
                    this.m = fArr3[0];
                    this.n = fArr3[1];
                } else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.l = true;
                }
            } else if (index == SE5.OnSwipe_maxVelocity) {
                this.u = typedArray.getFloat(index, this.u);
            } else if (index == SE5.OnSwipe_maxAcceleration) {
                this.v = typedArray.getFloat(index, this.v);
            } else if (index == SE5.OnSwipe_moveWhenScrollAtTop) {
                this.w = typedArray.getBoolean(index, this.w);
            } else if (index == SE5.OnSwipe_dragScale) {
                this.x = typedArray.getFloat(index, this.x);
            } else if (index == SE5.OnSwipe_dragThreshold) {
                this.z = typedArray.getFloat(index, this.z);
            } else if (index == SE5.OnSwipe_touchRegionId) {
                this.e = typedArray.getResourceId(index, this.e);
            } else if (index == SE5.OnSwipe_onTouchUp) {
                this.c = typedArray.getInt(index, this.c);
            } else if (index == SE5.OnSwipe_nestedScrollFlags) {
                this.y = typedArray.getInteger(index, 0);
            } else if (index == SE5.OnSwipe_limitBoundsTo) {
                this.f = typedArray.getResourceId(index, 0);
            } else if (index == SE5.OnSwipe_rotationCenterId) {
                this.k = typedArray.getResourceId(index, this.k);
            } else if (index == SE5.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == SE5.OnSwipe_springMass) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == SE5.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == SE5.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == SE5.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == SE5.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SE5.OnSwipe);
        b(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    void A() {
        View viewFindViewById;
        int i = this.d;
        if (i != -1) {
            viewFindViewById = this.t.findViewById(i);
            if (viewFindViewById == null) {
                String strValueOf = String.valueOf(OA1.c(this.t.getContext(), this.d));
                Log.e("TouchResponse", strValueOf.length() != 0 ? "cannot find TouchAnchorId @id/".concat(strValueOf) : new String("cannot find TouchAnchorId @id/"));
            }
        } else {
            viewFindViewById = null;
        }
        if (viewFindViewById instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) viewFindViewById;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    float a(float f, float f2) {
        return (f * this.m) + (f2 * this.n);
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.y;
    }

    RectF f(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i = this.f;
        if (i == -1 || (viewFindViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    float g() {
        return this.v;
    }

    public float h() {
        return this.u;
    }

    boolean i() {
        return this.w;
    }

    float j(float f, float f2) throws Resources.NotFoundException {
        this.t.T0(this.d, this.t.getProgress(), this.h, this.g, this.p);
        float f3 = this.m;
        if (f3 != 0.0f) {
            float[] fArr = this.p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * f3) / fArr[0];
        }
        float[] fArr2 = this.p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    RectF p(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i = this.e;
        if (i == -1 || (viewFindViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    int q() {
        return this.e;
    }

    boolean r() {
        return this.o;
    }

    void s(MotionEvent motionEvent, MotionLayout.g gVar, int i, i iVar) throws Resources.NotFoundException {
        int i2;
        if (this.l) {
            t(motionEvent, gVar, i, iVar);
            return;
        }
        gVar.b(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
            return;
        }
        if (action == 1) {
            this.o = false;
            gVar.e(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
            float fD = gVar.d();
            float fC = gVar.c();
            float progress = this.t.getProgress();
            int i3 = this.d;
            if (i3 != -1) {
                this.t.T0(i3, progress, this.h, this.g, this.p);
            } else {
                float fMin = Math.min(this.t.getWidth(), this.t.getHeight());
                float[] fArr = this.p;
                fArr[1] = this.n * fMin;
                fArr[0] = fMin * this.m;
            }
            float f = this.m;
            float[] fArr2 = this.p;
            float fAbs = f != 0.0f ? fD / fArr2[0] : fC / fArr2[1];
            float f2 = !Float.isNaN(fAbs) ? (fAbs / 3.0f) + progress : progress;
            if (f2 == 0.0f || f2 == 1.0f || (i2 = this.c) == 3) {
                if (0.0f >= f2 || 1.0f <= f2) {
                    this.t.setState(MotionLayout.k.FINISHED);
                    return;
                }
                return;
            }
            float f3 = ((double) f2) < 0.5d ? 0.0f : 1.0f;
            if (i2 == 6) {
                if (progress + fAbs < 0.0f) {
                    fAbs = Math.abs(fAbs);
                }
                f3 = 1.0f;
            }
            if (this.c == 7) {
                if (progress + fAbs > 1.0f) {
                    fAbs = -Math.abs(fAbs);
                }
                f3 = 0.0f;
            }
            this.t.h1(this.c, f3, fAbs);
            if (0.0f >= progress || 1.0f <= progress) {
                this.t.setState(MotionLayout.k.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.s;
        float rawX = motionEvent.getRawX() - this.r;
        if (Math.abs((this.m * rawX) + (this.n * rawY)) > this.z || this.o) {
            float progress2 = this.t.getProgress();
            if (!this.o) {
                this.o = true;
                this.t.setProgress(progress2);
            }
            int i4 = this.d;
            if (i4 != -1) {
                this.t.T0(i4, progress2, this.h, this.g, this.p);
            } else {
                float fMin2 = Math.min(this.t.getWidth(), this.t.getHeight());
                float[] fArr3 = this.p;
                fArr3[1] = this.n * fMin2;
                fArr3[0] = fMin2 * this.m;
            }
            float f4 = this.m;
            float[] fArr4 = this.p;
            if (Math.abs(((f4 * fArr4[0]) + (this.n * fArr4[1])) * this.x) < 0.01d) {
                float[] fArr5 = this.p;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float fMax = Math.max(Math.min(progress2 + (this.m != 0.0f ? rawX / this.p[0] : rawY / this.p[1]), 1.0f), 0.0f);
            if (this.c == 6) {
                fMax = Math.max(fMax, 0.01f);
            }
            if (this.c == 7) {
                fMax = Math.min(fMax, 0.99f);
            }
            float progress3 = this.t.getProgress();
            if (fMax != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.t.K0(progress3 == 0.0f);
                }
                this.t.setProgress(fMax);
                gVar.e(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT);
                this.t.B = this.m != 0.0f ? gVar.d() / this.p[0] : gVar.c() / this.p[1];
            } else {
                this.t.B = 0.0f;
            }
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.g r25, int r26, androidx.constraintlayout.motion.widget.i r27) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.j.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$g, int, androidx.constraintlayout.motion.widget.i):void");
    }

    public String toString() {
        if (Float.isNaN(this.m)) {
            return "rotation";
        }
        float f = this.m;
        float f2 = this.n;
        StringBuilder sb = new StringBuilder(33);
        sb.append(f);
        sb.append(" , ");
        sb.append(f2);
        return sb.toString();
    }

    void u(float f, float f2) throws Resources.NotFoundException {
        float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.T0(this.d, progress, this.h, this.g, this.p);
        float f3 = this.m;
        float[] fArr = this.p;
        if (Math.abs((f3 * fArr[0]) + (this.n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f4 = this.m;
        float fMax = Math.max(Math.min(progress + (f4 != 0.0f ? (f * f4) / this.p[0] : (f2 * this.n) / this.p[1]), 1.0f), 0.0f);
        if (fMax != this.t.getProgress()) {
            this.t.setProgress(fMax);
        }
    }

    void v(float f, float f2) throws Resources.NotFoundException {
        this.o = false;
        float progress = this.t.getProgress();
        this.t.T0(this.d, progress, this.h, this.g, this.p);
        float f3 = this.m;
        float[] fArr = this.p;
        float f4 = f3 != 0.0f ? (f * f3) / fArr[0] : (f2 * this.n) / fArr[1];
        if (!Float.isNaN(f4)) {
            progress += f4 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z = progress != 1.0f;
            int i = this.c;
            if ((i != 3) && z) {
                this.t.h1(i, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f4);
            }
        }
    }

    void w(float f, float f2) {
        this.r = f;
        this.s = f2;
    }

    public void x(boolean z) {
        if (z) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.a];
        this.h = fArr5[0];
        this.g = fArr5[1];
        int i = this.b;
        float[][] fArr6 = H;
        if (i >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i];
        this.m = fArr7[0];
        this.n = fArr7[1];
    }

    public void y(int i) {
        this.c = i;
    }

    void z(float f, float f2) {
        this.r = f;
        this.s = f2;
        this.o = false;
    }
}
