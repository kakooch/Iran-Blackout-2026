package ir.nasim.tgwidgets.editor.ui.Components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import ir.nasim.AbstractC11500d67;
import ir.nasim.C10743c74;
import ir.nasim.C24687z23;
import ir.nasim.InterpolatorC12631ew1;
import ir.nasim.W57;
import ir.nasim.tgwidgets.editor.messenger.AbstractC21455b;
import ir.nasim.tgwidgets.editor.messenger.ImageReceiver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class GroupedPhotosListView extends View implements GestureDetector.OnGestureListener {
    private boolean A;
    private ValueAnimator A0;
    private boolean B;
    private ValueAnimator B0;
    private float C0;
    private boolean D;
    private int G;
    private boolean H;
    private boolean J;
    private Paint a;
    private ArrayList b;
    private ArrayList c;
    public ArrayList d;
    private ArrayList e;
    private int f;
    private long g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private int p;
    private long q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private boolean w;
    private Scroller x;
    private GestureDetector y;
    private boolean z;
    private c z0;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (GroupedPhotosListView.this.B0 == animator) {
                GroupedPhotosListView.this.B0 = null;
                GroupedPhotosListView.this.j();
            }
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (GroupedPhotosListView.this.A0 == animator) {
                GroupedPhotosListView.this.A0 = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (GroupedPhotosListView.this.z0 != null) {
                GroupedPhotosListView.this.z0.d();
            }
        }
    }

    public interface c {
        ArrayList a();

        int b();

        void c(int i);

        void d();

        ArrayList e();

        Object f();

        int g();

        int h();

        List i();

        void j();

        long k();
    }

    public GroupedPhotosListView(Context context) {
        this(context, AbstractC21455b.F(3.0f));
    }

    private ImageReceiver getFreeReceiver() {
        ImageReceiver imageReceiver;
        if (this.b.isEmpty()) {
            imageReceiver = new ImageReceiver(this);
            imageReceiver.v0(false);
        } else {
            imageReceiver = (ImageReceiver) this.b.get(0);
            this.b.remove(0);
        }
        this.c.add(imageReceiver);
        imageReceiver.F0(this.z0.g());
        return imageReceiver;
    }

    private int getMaxScrollX() {
        return this.f * (this.h + (this.k * 2));
    }

    private int getMinScrollX() {
        return (-((this.d.size() - this.f) - 1)) * (this.h + (this.k * 2));
    }

    private void i(boolean z, int i) throws InterruptedException {
        int iMax;
        int iMin;
        Object objF;
        Object objF2;
        if (!z && !this.c.isEmpty()) {
            this.b.addAll(this.c);
            this.c.clear();
            this.r = false;
            this.m = 1.0f;
            this.n = 1.0f;
            this.o = 0.0f;
        }
        invalidate();
        if (getMeasuredWidth() == 0 || this.d.isEmpty()) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (this.h / 2);
        if (z) {
            int size = this.c.size();
            int i2 = 0;
            iMin = Integer.MAX_VALUE;
            iMax = Integer.MIN_VALUE;
            while (i2 < size) {
                ImageReceiver imageReceiver = (ImageReceiver) this.c.get(i2);
                int iR = imageReceiver.R();
                int i3 = iR - this.f;
                int i4 = this.h;
                int i5 = (i3 * (this.k + i4)) + measuredWidth2 + i;
                if (i5 > measuredWidth || i5 + i4 < 0) {
                    this.b.add(imageReceiver);
                    this.c.remove(i2);
                    size--;
                    i2--;
                }
                iMin = Math.min(iMin, iR - 1);
                iMax = Math.max(iMax, iR + 1);
                i2++;
            }
        } else {
            iMax = this.f;
            iMin = iMax - 1;
        }
        if (iMax != Integer.MIN_VALUE) {
            int size2 = this.d.size();
            while (iMax < size2) {
                int i6 = ((iMax - this.f) * (this.h + this.k)) + measuredWidth2 + i;
                if (i6 >= measuredWidth) {
                    break;
                }
                C24687z23 c24687z23 = (C24687z23) this.d.get(iMax);
                ImageReceiver freeReceiver = getFreeReceiver();
                freeReceiver.Y0(i6, this.j, this.h, this.i);
                if (this.e.get(0) instanceof C10743c74) {
                    objF2 = this.e.get(iMax);
                } else if (this.e.get(0) instanceof W57) {
                    objF2 = this.z0.f();
                } else {
                    objF2 = "avatar_" + this.z0.k();
                }
                freeReceiver.P0(null, null, c24687z23, "80_80", 0L, null, objF2, 1);
                freeReceiver.i1(iMax);
                iMax++;
            }
        }
        if (iMin != Integer.MAX_VALUE) {
            while (iMin >= 0) {
                int i7 = iMin - this.f;
                int i8 = this.h;
                int i9 = (i7 * (this.k + i8)) + measuredWidth2 + i + i8;
                if (i9 <= 0) {
                    break;
                }
                C24687z23 c24687z232 = (C24687z23) this.d.get(iMin);
                ImageReceiver freeReceiver2 = getFreeReceiver();
                freeReceiver2.Y0(i9, this.j, this.h, this.i);
                if (this.e.get(0) instanceof C10743c74) {
                    objF = this.e.get(iMin);
                } else if (this.e.get(0) instanceof W57) {
                    objF = this.z0.f();
                } else {
                    objF = "avatar_" + this.z0.k();
                }
                freeReceiver2.P0(null, null, c24687z232, "80_80", 0L, null, objF, 1);
                freeReceiver2.i1(iMin);
                iMin--;
            }
        }
        ValueAnimator valueAnimator = this.A0;
        if (valueAnimator == null || valueAnimator.isStarted()) {
            return;
        }
        this.A0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(ValueAnimator valueAnimator) {
        this.C0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        this.C0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    private void o() {
        this.z = false;
        if (!this.x.isFinished()) {
            this.x.abortAnimation();
        }
        int i = this.G;
        if (i >= 0 && i < this.e.size()) {
            this.A = true;
            this.w = false;
            int i2 = this.G;
            this.v = i2;
            this.p = i2;
            this.t = (this.f - i2) * (this.h + this.k);
            this.u = this.l;
            this.m = 1.0f;
            this.G = -1;
            c cVar = this.z0;
            if (cVar != null) {
                cVar.j();
            }
        }
        invalidate();
    }

    private void p() throws InterruptedException {
        int i;
        int i2;
        int i3;
        int i4 = this.l;
        int iAbs = Math.abs(i4);
        int i5 = this.h;
        int i6 = this.k;
        int iIndexOf = -1;
        if (iAbs > (i5 / 2) + i6) {
            if (i4 > 0) {
                i2 = i4 - ((i5 / 2) + i6);
                i3 = 1;
            } else {
                i2 = i4 + (i5 / 2) + i6;
                i3 = -1;
            }
            i = i3 + (i2 / (i5 + (i6 * 2)));
        } else {
            i = 0;
        }
        this.G = this.f - i;
        int iH = this.z0.h();
        ArrayList arrayListA = this.z0.a();
        ArrayList arrayListE = this.z0.e();
        List listI = this.z0.i();
        int i7 = this.G;
        if (iH != i7 && i7 >= 0 && i7 < this.d.size()) {
            Object obj = this.e.get(this.G);
            if (arrayListE != null && !arrayListE.isEmpty()) {
                iIndexOf = arrayListE.indexOf((C10743c74) obj);
            } else if (listI != null && !listI.isEmpty()) {
                iIndexOf = listI.indexOf((W57) obj);
            } else if (arrayListA != null && !arrayListA.isEmpty()) {
                iIndexOf = arrayListA.indexOf((C24687z23) obj);
            }
            if (iIndexOf >= 0) {
                this.B = true;
                this.z0.c(iIndexOf);
            }
        }
        if (!this.z) {
            this.z = true;
            this.A = false;
        }
        i(true, this.l);
    }

    public int getCount() {
        return this.d.size();
    }

    public int getIndex() {
        return this.f;
    }

    public void h() {
        this.d.clear();
        this.e.clear();
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013f  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v13, types: [ir.nasim.z23] */
    /* JADX WARN: Type inference failed for: r13v14 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v2, types: [ir.nasim.W57] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v7, types: [ir.nasim.c74] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r2v55, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j() {
        /*
            Method dump skipped, instructions count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.tgwidgets.editor.ui.Components.GroupedPhotosListView.j():void");
    }

    public boolean k() {
        ValueAnimator valueAnimator;
        return this.H && this.B0 == null && (this.C0 > 0.0f || !this.J || ((valueAnimator = this.A0) != null && valueAnimator.isStarted()));
    }

    public void n() {
        this.H = false;
        if (this.D) {
            this.C0 = 0.0f;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (!this.x.isFinished()) {
            this.x.abortAnimation();
        }
        this.v = -1;
        this.w = false;
        return true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) throws InterruptedException {
        int iMax;
        AbstractC11500d67 abstractC11500d67;
        AbstractC11500d67 abstractC11500d672;
        if (this.H || !this.c.isEmpty()) {
            float f = this.C0;
            if (!this.J) {
                f = this.H ? 1.0f : 0.0f;
            }
            this.a.setAlpha((int) (f * 127.0f));
            canvas.drawRect(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), this.a);
            if (this.c.isEmpty()) {
                return;
            }
            int size = this.c.size();
            int i = this.l;
            int i2 = (int) (this.h * 2.0f);
            int iF = AbstractC21455b.F(8.0f);
            C24687z23 c24687z23 = (C24687z23) this.d.get(this.f);
            int iMin = Math.min(i2, (c24687z23 == null || (abstractC11500d672 = c24687z23.j) == null) ? this.i : Math.max(this.h, (int) (abstractC11500d672.d * (this.i / abstractC11500d672.e))));
            float f2 = iF * 2;
            float f3 = this.n;
            int i3 = (int) (f2 * f3);
            int i4 = this.h + ((int) ((iMin - r11) * f3)) + i3;
            int i5 = this.p;
            if (i5 < 0 || i5 >= this.d.size()) {
                iMax = this.h;
            } else {
                C24687z23 c24687z232 = (C24687z23) this.d.get(this.p);
                iMax = (c24687z232 == null || (abstractC11500d67 = c24687z232.j) == null) ? this.i : Math.max(this.h, (int) (abstractC11500d67.d * (this.i / abstractC11500d67.e)));
            }
            int iMin2 = Math.min(i2, iMax);
            float f4 = this.o;
            int i6 = (int) (f2 * f4);
            float f5 = i;
            int i7 = (int) (f5 + ((((iMin2 + i6) - r12) / 2) * f4 * (this.p > this.f ? -1 : 1)));
            int i8 = this.h + ((int) ((iMin2 - r12) * f4)) + i6;
            int measuredWidth = (getMeasuredWidth() - i4) / 2;
            for (int i9 = 0; i9 < size; i9++) {
                ImageReceiver imageReceiver = (ImageReceiver) this.c.get(i9);
                int iR = imageReceiver.R();
                int i10 = this.f;
                if (iR == i10) {
                    imageReceiver.b1(measuredWidth + i7 + (i3 / 2));
                    imageReceiver.a1(i4 - i3);
                } else {
                    int i11 = this.p;
                    if (i11 < i10) {
                        if (iR >= i10) {
                            imageReceiver.b1(measuredWidth + i4 + this.k + (((imageReceiver.R() - this.f) - 1) * (this.h + this.k)) + i7);
                        } else if (iR <= i11) {
                            int iR2 = (imageReceiver.R() - this.f) + 1;
                            int i12 = this.h;
                            int i13 = this.k;
                            imageReceiver.b1((((iR2 * (i12 + i13)) + measuredWidth) - (i13 + i8)) + i7);
                        } else {
                            imageReceiver.b1(((imageReceiver.R() - this.f) * (this.h + this.k)) + measuredWidth + i7);
                        }
                    } else if (iR < i10) {
                        imageReceiver.b1(((imageReceiver.R() - this.f) * (this.h + this.k)) + measuredWidth + i7);
                    } else if (iR <= i11) {
                        imageReceiver.b1(measuredWidth + i4 + this.k + (((imageReceiver.R() - this.f) - 1) * (this.h + this.k)) + i7);
                    } else {
                        int i14 = measuredWidth + i4 + this.k;
                        int iR3 = (imageReceiver.R() - this.f) - 2;
                        int i15 = this.h;
                        int i16 = this.k;
                        imageReceiver.b1(i14 + (iR3 * (i15 + i16)) + i16 + i8 + i7);
                    }
                    if (iR == this.p) {
                        imageReceiver.a1(i8 - i6);
                        imageReceiver.b1((int) (imageReceiver.F() + (i6 / 2)));
                    } else {
                        imageReceiver.a1(this.h);
                    }
                }
                imageReceiver.setAlpha(this.C0);
                imageReceiver.k1(AbstractC21455b.F(2.0f));
                imageReceiver.e(canvas);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - this.q;
            if (j > 17) {
                j = 17;
            }
            this.q = jCurrentTimeMillis;
            int i17 = this.v;
            if (i17 >= 0) {
                float f6 = this.m;
                if (f6 > 0.0f) {
                    float f7 = j;
                    float f8 = f6 - (f7 / (this.w ? 100.0f : 200.0f));
                    this.m = f8;
                    if (i17 == this.f) {
                        float f9 = this.n;
                        if (f9 < 1.0f) {
                            float f10 = f9 + (f7 / 200.0f);
                            this.n = f10;
                            if (f10 > 1.0f) {
                                this.n = 1.0f;
                            }
                        }
                        this.l = this.u + ((int) Math.ceil(this.n * (this.t - r1)));
                    } else {
                        InterpolatorC12631ew1 interpolatorC12631ew1 = InterpolatorC12631ew1.g;
                        this.o = interpolatorC12631ew1.getInterpolation(1.0f - f8);
                        if (this.A) {
                            float f11 = this.n;
                            if (f11 > 0.0f) {
                                float f12 = f11 - (f7 / 200.0f);
                                this.n = f12;
                                if (f12 < 0.0f) {
                                    this.n = 0.0f;
                                }
                            }
                            this.l = this.u + ((int) Math.ceil(r5 * (this.t - r1)));
                        } else {
                            this.n = interpolatorC12631ew1.getInterpolation(this.m);
                            this.l = (int) Math.ceil(this.o * this.t);
                        }
                    }
                    if (this.m <= 0.0f) {
                        this.f = this.v;
                        this.m = 1.0f;
                        this.n = 1.0f;
                        this.o = 0.0f;
                        this.r = false;
                        this.A = false;
                        this.l = 0;
                        this.v = -1;
                        this.w = false;
                    }
                }
                i(true, this.l);
                invalidate();
            }
            if (this.z) {
                float f13 = this.n;
                if (f13 > 0.0f) {
                    float f14 = f13 - (j / 200.0f);
                    this.n = f14;
                    if (f14 < 0.0f) {
                        this.n = 0.0f;
                    }
                    invalidate();
                }
            }
            if (this.x.isFinished()) {
                return;
            }
            if (this.x.computeScrollOffset()) {
                this.l = this.x.getCurrX();
                p();
                invalidate();
            }
            if (this.x.isFinished()) {
                o();
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.x.abortAnimation();
        if (this.d.size() < 10) {
            return false;
        }
        this.x.fling(this.l, 0, Math.round(f), 0, getMinScrollX(), getMaxScrollX(), 0, 0);
        return false;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) throws InterruptedException {
        super.onLayout(z, i, i2, i3, i4);
        i(false, 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) throws InterruptedException {
        this.l = (int) (this.l - f);
        int minScrollX = getMinScrollX();
        int maxScrollX = getMaxScrollX();
        int i = this.l;
        if (i < minScrollX) {
            this.l = minScrollX;
        } else if (i > maxScrollX) {
            this.l = maxScrollX;
        }
        p();
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int iH = this.z0.h();
        ArrayList arrayListA = this.z0.a();
        ArrayList arrayListE = this.z0.e();
        List listI = this.z0.i();
        o();
        int size = this.c.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            ImageReceiver imageReceiver = (ImageReceiver) this.c.get(i);
            if (imageReceiver.m0(motionEvent.getX(), motionEvent.getY())) {
                int iR = imageReceiver.R();
                if (iR < 0 || iR >= this.e.size()) {
                    return true;
                }
                if (arrayListE != null && !arrayListE.isEmpty()) {
                    int iIndexOf = arrayListE.indexOf((C10743c74) this.e.get(iR));
                    if (iH == iIndexOf) {
                        return true;
                    }
                    this.m = 1.0f;
                    this.s = true;
                    this.z0.c(iIndexOf);
                } else if (listI != null && !listI.isEmpty()) {
                    int iIndexOf2 = listI.indexOf((W57) this.e.get(iR));
                    if (iH == iIndexOf2) {
                        return true;
                    }
                    this.m = 1.0f;
                    this.s = true;
                    this.z0.c(iIndexOf2);
                } else if (arrayListA != null && !arrayListA.isEmpty()) {
                    int iIndexOf3 = arrayListA.indexOf((C24687z23) this.e.get(iR));
                    if (iH == iIndexOf3) {
                        return true;
                    }
                    this.m = 1.0f;
                    this.s = true;
                    this.z0.c(iIndexOf3);
                }
            } else {
                i++;
            }
        }
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.d.isEmpty() && getAlpha() == 1.0f) {
            z = this.y.onTouchEvent(motionEvent) || super.onTouchEvent(motionEvent);
            if (this.z && motionEvent.getAction() == 1 && this.x.isFinished()) {
                o();
            }
        }
        return z;
    }

    public void setAnimateBackground(boolean z) {
        this.J = z;
    }

    public void setAnimationsEnabled(boolean z) {
        if (this.D != z) {
            this.D = z;
            if (z) {
                return;
            }
            ValueAnimator valueAnimator = this.A0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.A0 = null;
            }
            ValueAnimator valueAnimator2 = this.B0;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.B0 = null;
            }
            this.C0 = 0.0f;
            invalidate();
        }
    }

    public void setDelegate(c cVar) {
        this.z0 = cVar;
    }

    public void setMoveProgress(float f) {
        if (this.z || this.v >= 0) {
            return;
        }
        if (f > 0.0f) {
            this.p = this.f - 1;
        } else {
            this.p = this.f + 1;
        }
        int i = this.p;
        if (i < 0 || i >= this.d.size()) {
            this.n = 1.0f;
        } else {
            this.n = 1.0f - Math.abs(f);
        }
        this.o = 1.0f - this.n;
        this.r = f != 0.0f;
        invalidate();
        if (this.d.isEmpty()) {
            return;
        }
        if (f >= 0.0f || this.f != this.d.size() - 1) {
            if (f <= 0.0f || this.f != 0) {
                int i2 = (int) (f * (this.h + this.k));
                this.l = i2;
                i(true, i2);
            }
        }
    }

    public GroupedPhotosListView(Context context, int i) {
        super(context);
        this.a = new Paint();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.n = 1.0f;
        this.o = 0.0f;
        this.v = -1;
        this.D = true;
        this.G = -1;
        this.J = true;
        this.y = new GestureDetector(context, this);
        this.x = new Scroller(context);
        this.h = AbstractC21455b.F(42.0f);
        this.i = AbstractC21455b.F(56.0f);
        this.k = AbstractC21455b.F(1.0f);
        this.j = i;
        this.a.setColor(2130706432);
    }
}
