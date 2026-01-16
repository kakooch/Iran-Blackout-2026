package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes8.dex */
public final class J95 implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static final e B = new e(null);
    private Float A;
    private final ImageView a;
    private Interpolator b;
    private int c;
    private float d;
    private float e;
    private float f;
    private boolean g;
    private boolean h;
    private final GestureDetector i;
    private C10643bx1 j;
    private final Matrix k;
    private final Matrix l;
    private final Matrix m;
    private final RectF n;
    private final float[] o;
    private InterfaceC17652nK4 p;
    private View.OnClickListener q;
    private View.OnLongClickListener r;
    private f s;
    private int t;
    private int u;
    private float v;
    private boolean w;
    private ImageView.ScaleType x;
    private final InterfaceC15870kJ4 y;
    private Float z;

    public static final class a implements InterfaceC15870kJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC15870kJ4
        public void a(float f, float f2) {
            C10643bx1 c10643bx1 = J95.this.j;
            C10643bx1 c10643bx12 = null;
            if (c10643bx1 == null) {
                AbstractC13042fc3.y("mScaleDragDetector");
                c10643bx1 = null;
            }
            if (c10643bx1.e()) {
                return;
            }
            J95.this.m.postTranslate(f, f2);
            J95.this.A();
            ViewParent parent = J95.this.a.getParent();
            if (J95.this.g) {
                C10643bx1 c10643bx13 = J95.this.j;
                if (c10643bx13 == null) {
                    AbstractC13042fc3.y("mScaleDragDetector");
                } else {
                    c10643bx12 = c10643bx13;
                }
                if (!c10643bx12.e() && !J95.this.h) {
                    if ((J95.this.I() == 2 || ((J95.this.I() == 0 && f >= 1.0f) || ((J95.this.I() == 1 && f <= -1.0f) || ((J95.this.J() == 0 && f2 >= 1.0f) || (J95.this.J() == 1 && f2 <= -1.0f))))) && parent != null) {
                        parent.requestDisallowInterceptTouchEvent(false);
                        return;
                    }
                    return;
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // ir.nasim.InterfaceC15870kJ4
        public void c(float f, float f2, float f3, float f4) {
            J95 j95 = J95.this;
            f fVar = j95.new f(j95.a.getContext());
            J95 j952 = J95.this;
            fVar.b(j952.H(j952.a), j952.G(j952.a), (int) f3, (int) f4);
            j95.s = fVar;
            J95.this.a.post(J95.this.s);
        }

        @Override // ir.nasim.InterfaceC15870kJ4
        public void d(float f, float f2, float f3, boolean z) {
            if (J95.this.M() < J95.this.f || f < 1.0f) {
                if (!z) {
                    J95.this.z = Float.valueOf(f2);
                    J95.this.A = Float.valueOf(f3);
                }
                J95.n(J95.this);
                J95.this.m.postScale(f, f, f2, f3);
                J95.this.A();
            }
        }
    }

    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AbstractC13042fc3.i(motionEvent2, "e2");
            if (motionEvent == null) {
                return false;
            }
            J95.p(J95.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            View.OnLongClickListener onLongClickListener = J95.this.r;
            if (onLongClickListener != null) {
                onLongClickListener.onLongClick(J95.this.a);
            }
        }
    }

    public static final class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "ev");
            try {
                float fM = J95.this.M();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (fM < J95.this.K()) {
                    J95 j95 = J95.this;
                    j95.g0(j95.K(), x, y, true);
                } else {
                    J95 j952 = J95.this;
                    j952.g0(j952.L(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AbstractC13042fc3.i(motionEvent, "e");
            View.OnClickListener onClickListener = J95.this.q;
            if (onClickListener != null) {
                onClickListener.onClick(J95.this.a);
            }
            RectF rectFC = J95.this.C();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            InterfaceC17652nK4 interfaceC17652nK4 = J95.this.p;
            if (interfaceC17652nK4 != null) {
                interfaceC17652nK4.a(J95.this.a, x, y);
            }
            if (rectFC == null) {
                return false;
            }
            if (!rectFC.contains(x, y)) {
                J95.k(J95.this);
                return false;
            }
            rectFC.width();
            rectFC.height();
            J95.m(J95.this);
            return true;
        }
    }

    private final class d implements Runnable {
        private final float a;
        private final float b;
        private final float c;
        private final float d;
        private final long e = System.currentTimeMillis();

        public d(float f, float f2, float f3, float f4) {
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        private final float a() {
            return J95.this.b.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.e) * 1.0f) / J95.this.c));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f = this.a;
            J95.this.y.d((f + ((this.b - f) * fA)) / J95.this.M(), this.c, this.d, true);
            if (fA < 1.0f) {
                AbstractC19823r01.a(J95.this.a, this);
            }
        }
    }

    public static final class e {
        private e() {
        }

        public /* synthetic */ e(ED1 ed1) {
            this();
        }
    }

    private final class f implements Runnable {
        private final OverScroller a;
        private int b;
        private int c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public final void a() {
            this.a.forceFinished(true);
        }

        public final void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFC = J95.this.C();
            if (rectFC == null) {
                return;
            }
            int iRound3 = Math.round(-rectFC.left);
            float f = i;
            if (f < rectFC.width()) {
                iRound = Math.round(rectFC.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFC.top);
            float f2 = i2;
            if (f2 < rectFC.height()) {
                iRound2 = Math.round(rectFC.height() - f2);
                i6 = 0;
            } else {
                i6 = iRound4;
                iRound2 = i6;
            }
            this.b = iRound3;
            this.c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.a.fling(iRound3, iRound4, i3, i4, i5, iRound, i6, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                J95.this.m.postTranslate(this.b - currX, this.c - currY);
                J95.this.A();
                this.b = currX;
                this.c = currY;
                AbstractC19823r01.a(J95.this.a, this);
            }
        }
    }

    public /* synthetic */ class g {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = iArr;
        }
    }

    public J95(ImageView imageView) {
        AbstractC13042fc3.i(imageView, "mImageView");
        this.a = imageView;
        this.b = new AccelerateDecelerateInterpolator();
        this.c = 200;
        this.d = 1.0f;
        this.e = 3.0f;
        this.f = 12.0f;
        this.g = true;
        this.k = new Matrix();
        this.l = new Matrix();
        this.m = new Matrix();
        this.n = new RectF();
        this.o = new float[9];
        this.t = 2;
        this.u = 2;
        this.w = true;
        this.x = ImageView.ScaleType.FIT_CENTER;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        this.v = 0.0f;
        a aVar = new a();
        this.y = aVar;
        this.j = new C10643bx1(imageView.getContext(), aVar);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A() {
        if (B()) {
            R(E());
        }
    }

    private final boolean B() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF rectFD = D(E());
        if (rectFD == null) {
            return false;
        }
        float fHeight = rectFD.height();
        float fWidth = rectFD.width();
        float fG = G(this.a);
        float f7 = 0.0f;
        if (fHeight <= fG) {
            int i = g.a[this.x.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (fG - fHeight) / 2;
                    f6 = rectFD.top;
                } else {
                    f5 = fG - fHeight;
                    f6 = rectFD.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -rectFD.top;
            }
            this.u = 2;
        } else {
            float f8 = rectFD.top;
            if (f8 > 0.0f) {
                this.u = 0;
                f2 = -f8;
            } else {
                float f9 = rectFD.bottom;
                if (f9 < fG) {
                    this.u = 1;
                    f2 = fG - f9;
                } else {
                    this.u = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fH = H(this.a);
        if (fWidth <= fH) {
            int i2 = g.a[this.x.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (fH - fWidth) / 2;
                    f4 = rectFD.left;
                } else {
                    f3 = fH - fWidth;
                    f4 = rectFD.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -rectFD.left;
            }
            this.t = 2;
        } else {
            float f10 = rectFD.left;
            if (f10 > 0.0f) {
                this.t = 0;
                f7 = -f10;
            } else {
                float f11 = rectFD.right;
                if (f11 < fH) {
                    f7 = fH - f11;
                    this.t = 1;
                } else {
                    this.t = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    private final RectF D(Matrix matrix) {
        if (this.a.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private final Matrix E() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int G(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int H(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private final float O(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    private final void R(Matrix matrix) {
        this.a.setImageMatrix(matrix);
    }

    public static final /* synthetic */ IJ4 k(J95 j95) {
        j95.getClass();
        return null;
    }

    public static final /* synthetic */ MJ4 m(J95 j95) {
        j95.getClass();
        return null;
    }

    private final void m0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fH = H(this.a);
        float fG = G(this.a);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fH / f2;
        float f4 = intrinsicHeight;
        float f5 = fG / f4;
        ImageView.ScaleType scaleType = this.x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fH - f2) / 2.0f, (fG - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.k.postScale(fMax, fMax);
            this.k.postTranslate((fH - (f2 * fMax)) / 2.0f, (fG - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fH - (f2 * fMin)) / 2.0f, (fG - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fH, fG);
            if (((int) this.v) % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = g.a[this.x.ordinal()];
            if (i == 1) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i == 2) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i == 3) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i == 4) {
                this.k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        P();
    }

    public static final /* synthetic */ WJ4 n(J95 j95) {
        j95.getClass();
        return null;
    }

    public static final /* synthetic */ InterfaceC10247bK4 p(J95 j95) {
        j95.getClass();
        return null;
    }

    private final void z() {
        f fVar = this.s;
        if (fVar != null) {
            AbstractC13042fc3.f(fVar);
            fVar.a();
            this.s = null;
        }
    }

    public final RectF C() {
        B();
        return D(E());
    }

    public final Matrix F() {
        return this.l;
    }

    public final int I() {
        return this.t;
    }

    public final int J() {
        return this.u;
    }

    public final float K() {
        return this.e;
    }

    public final float L() {
        return this.d;
    }

    public final float M() {
        return (float) Math.sqrt(((float) Math.pow(O(this.m, 0), 2.0d)) + ((float) Math.pow(O(this.m, 3), 2.0d)));
    }

    public final ImageView.ScaleType N() {
        return this.x;
    }

    public final void P() {
        this.m.reset();
        d0(this.v);
        R(E());
        B();
    }

    public final void Q(boolean z) {
        this.g = z;
    }

    public final void S(float f2) {
        C11657dN7.a(this.d, f2);
        this.e = f2;
    }

    public final void T(float f2) {
        C11657dN7.a(f2, this.e);
        this.d = f2;
    }

    public final void U(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public final void V(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public final void W(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public final void c0(InterfaceC17652nK4 interfaceC17652nK4) {
        this.p = interfaceC17652nK4;
    }

    public final void d0(float f2) {
        this.m.postRotate(f2 % 360);
        A();
    }

    public final void e0(float f2) {
        this.m.setRotate(f2 % 360);
        A();
    }

    public final void f0(float f2) {
        h0(f2, false);
    }

    public final void g0(float f2, float f3, float f4, boolean z) {
        if (f2 < this.d || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale".toString());
        }
        if (z) {
            this.a.post(new d(M(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            A();
        }
    }

    public final void h0(float f2, boolean z) {
        g0(f2, this.a.getRight() / 2, this.a.getBottom() / 2, z);
    }

    public final void i0(ImageView.ScaleType scaleType) {
        AbstractC13042fc3.i(scaleType, "scaleType");
        if (!C11657dN7.d(scaleType) || scaleType == this.x) {
            return;
        }
        this.x = scaleType;
        l0();
    }

    public final void j0(int i) {
        this.c = i;
    }

    public final void k0(boolean z) {
        this.w = z;
        l0();
    }

    public final void l0() {
        if (this.w) {
            m0(this.a.getDrawable());
        } else {
            P();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AbstractC13042fc3.i(view, "v");
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        m0(this.a.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.J95.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public final boolean x(float f2) {
        RectF rectFD = D(E());
        if (rectFD == null) {
            return true;
        }
        float fWidth = rectFD.width();
        float fH = H(this.a);
        return fWidth <= fH || rectFD.left + f2 > 0.0f || rectFD.right + f2 < fH;
    }

    public final boolean y(float f2) {
        RectF rectFD = D(E());
        if (rectFD == null) {
            return true;
        }
        float fHeight = rectFD.height();
        float fG = G(this.a);
        return fHeight <= fG || rectFD.top + f2 > 0.0f || rectFD.bottom + f2 < fG;
    }

    public final void X(BJ4 bj4) {
    }

    public final void Y(IJ4 ij4) {
    }

    public final void Z(MJ4 mj4) {
    }

    public final void a0(WJ4 wj4) {
    }

    public final void b0(InterfaceC10247bK4 interfaceC10247bK4) {
    }
}
