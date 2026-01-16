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

/* loaded from: classes2.dex */
public class K95 implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float A = 1.75f;
    private static float B = 1.0f;
    private static int D = 200;
    private static float z = 3.0f;
    private ImageView h;
    private GestureDetector i;
    private C11406cx1 j;
    private InterfaceC18243oK4 p;
    private View.OnClickListener q;
    private View.OnLongClickListener r;
    private f s;
    private float v;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = D;
    private float c = B;
    private float d = A;
    private float e = z;
    private boolean f = true;
    private boolean g = false;
    private final Matrix k = new Matrix();
    private final Matrix l = new Matrix();
    private final Matrix m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int t = 2;
    private int u = 2;
    private boolean w = true;
    private ImageView.ScaleType x = ImageView.ScaleType.FIT_CENTER;
    private InterfaceC16461lJ4 y = new a();

    class a implements InterfaceC16461lJ4 {
        a() {
        }

        @Override // ir.nasim.InterfaceC16461lJ4
        public void a(float f, float f2) {
            if (K95.this.j.e()) {
                return;
            }
            K95.b(K95.this);
            K95.this.m.postTranslate(f, f2);
            K95.this.z();
            ViewParent parent = K95.this.h.getParent();
            if (!K95.this.f || K95.this.j.e() || K95.this.g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((K95.this.t == 2 || ((K95.this.t == 0 && f >= 1.0f) || ((K95.this.t == 1 && f <= -1.0f) || ((K95.this.u == 0 && f2 >= 1.0f) || (K95.this.u == 1 && f2 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // ir.nasim.InterfaceC16461lJ4
        public void c(float f, float f2, float f3, float f4) {
            K95 k95 = K95.this;
            k95.s = k95.new f(k95.h.getContext());
            f fVar = K95.this.s;
            K95 k952 = K95.this;
            int iG = k952.G(k952.h);
            K95 k953 = K95.this;
            fVar.b(iG, k953.F(k953.h), (int) f3, (int) f4);
            K95.this.h.post(K95.this.s);
        }

        @Override // ir.nasim.InterfaceC16461lJ4
        public void d(float f, float f2, float f3) {
            if (K95.this.K() < K95.this.e || f < 1.0f) {
                K95.f(K95.this);
                K95.this.m.postScale(f, f, f2, f3);
                K95.this.z();
            }
        }
    }

    class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            K95.h(K95.this);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (K95.this.r != null) {
                K95.this.r.onLongClick(K95.this.h);
            }
        }
    }

    class c implements GestureDetector.OnDoubleTapListener {
        c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fK = K95.this.K();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (fK < K95.this.I()) {
                    K95 k95 = K95.this;
                    k95.g0(k95.I(), x, y, true);
                } else if (fK < K95.this.I() || fK >= K95.this.H()) {
                    K95 k952 = K95.this;
                    k952.g0(k952.J(), x, y, true);
                } else {
                    K95 k953 = K95.this;
                    k953.g0(k953.H(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (K95.this.q != null) {
                K95.this.q.onClick(K95.this.h);
            }
            RectF rectFB = K95.this.B();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (K95.this.p != null) {
                K95.this.p.a(K95.this.h, x, y);
            }
            if (rectFB == null) {
                return false;
            }
            if (!rectFB.contains(x, y)) {
                K95.m(K95.this);
                return false;
            }
            rectFB.width();
            rectFB.height();
            K95.l(K95.this);
            return true;
        }
    }

    static /* synthetic */ class d {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private class e implements Runnable {
        private final float a;
        private final float b;
        private final long c = System.currentTimeMillis();
        private final float d;
        private final float e;

        public e(float f, float f2, float f3, float f4) {
            this.a = f3;
            this.b = f4;
            this.d = f;
            this.e = f2;
        }

        private float a() {
            return K95.this.a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.c) * 1.0f) / K95.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f = this.d;
            K95.this.y.d((f + ((this.e - f) * fA)) / K95.this.K(), this.a, this.b);
            if (fA < 1.0f) {
                AbstractC20432s01.a(K95.this.h, this);
            }
        }
    }

    private class f implements Runnable {
        private final OverScroller a;
        private int b;
        private int c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        public void b(int i, int i2, int i3, int i4) {
            int i5;
            int iRound;
            int i6;
            int iRound2;
            RectF rectFB = K95.this.B();
            if (rectFB == null) {
                return;
            }
            int iRound3 = Math.round(-rectFB.left);
            float f = i;
            if (f < rectFB.width()) {
                iRound = Math.round(rectFB.width() - f);
                i5 = 0;
            } else {
                i5 = iRound3;
                iRound = i5;
            }
            int iRound4 = Math.round(-rectFB.top);
            float f2 = i2;
            if (f2 < rectFB.height()) {
                iRound2 = Math.round(rectFB.height() - f2);
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
                K95.this.m.postTranslate(this.b - currX, this.c - currY);
                K95.this.z();
                this.b = currX;
                this.c = currY;
                AbstractC20432s01.a(K95.this.h, this);
            }
        }
    }

    public K95(ImageView imageView) {
        this.h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.v = 0.0f;
        this.j = new C11406cx1(imageView.getContext(), this.y);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private boolean A() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF rectFC = C(D());
        if (rectFC == null) {
            return false;
        }
        float fHeight = rectFC.height();
        float fWidth = rectFC.width();
        float F = F(this.h);
        float f7 = 0.0f;
        if (fHeight <= F) {
            int i = d.a[this.x.ordinal()];
            if (i != 2) {
                if (i != 3) {
                    f5 = (F - fHeight) / 2.0f;
                    f6 = rectFC.top;
                } else {
                    f5 = F - fHeight;
                    f6 = rectFC.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -rectFC.top;
            }
            this.u = 2;
        } else {
            float f8 = rectFC.top;
            if (f8 > 0.0f) {
                this.u = 0;
                f2 = -f8;
            } else {
                float f9 = rectFC.bottom;
                if (f9 < F) {
                    this.u = 1;
                    f2 = F - f9;
                } else {
                    this.u = -1;
                    f2 = 0.0f;
                }
            }
        }
        float fG = G(this.h);
        if (fWidth <= fG) {
            int i2 = d.a[this.x.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f3 = (fG - fWidth) / 2.0f;
                    f4 = rectFC.left;
                } else {
                    f3 = fG - fWidth;
                    f4 = rectFC.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -rectFC.left;
            }
            this.t = 2;
        } else {
            float f10 = rectFC.left;
            if (f10 > 0.0f) {
                this.t = 0;
                f7 = -f10;
            } else {
                float f11 = rectFC.right;
                if (f11 < fG) {
                    f7 = fG - f11;
                    this.t = 1;
                } else {
                    this.t = -1;
                }
            }
        }
        this.m.postTranslate(f7, f2);
        return true;
    }

    private RectF C(Matrix matrix) {
        if (this.h.getDrawable() == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    private Matrix D() {
        this.l.set(this.k);
        this.l.postConcat(this.m);
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int F(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float M(Matrix matrix, int i) {
        matrix.getValues(this.o);
        return this.o[i];
    }

    private void N() {
        this.m.reset();
        d0(this.v);
        P(D());
        A();
    }

    private void P(Matrix matrix) {
        this.h.setImageMatrix(matrix);
    }

    static /* synthetic */ InterfaceC17061mK4 b(K95 k95) {
        k95.getClass();
        return null;
    }

    static /* synthetic */ XJ4 f(K95 k95) {
        k95.getClass();
        return null;
    }

    static /* synthetic */ InterfaceC10863cK4 h(K95 k95) {
        k95.getClass();
        return null;
    }

    static /* synthetic */ NJ4 l(K95 k95) {
        k95.getClass();
        return null;
    }

    static /* synthetic */ JJ4 m(K95 k95) {
        k95.getClass();
        return null;
    }

    private void n0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fG = G(this.h);
        float F = F(this.h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.k.reset();
        float f2 = intrinsicWidth;
        float f3 = fG / f2;
        float f4 = intrinsicHeight;
        float f5 = F / f4;
        ImageView.ScaleType scaleType = this.x;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.k.postTranslate((fG - f2) / 2.0f, (F - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f3, f5);
            this.k.postScale(fMax, fMax);
            this.k.postTranslate((fG - (f2 * fMax)) / 2.0f, (F - (f4 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f3, f5));
            this.k.postScale(fMin, fMin);
            this.k.postTranslate((fG - (f2 * fMin)) / 2.0f, (F - (f4 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, fG, F);
            if (((int) this.v) % SetRpcStruct$ComposedRpc.JOIN_GROUP_FIELD_NUMBER != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i = d.a[this.x.ordinal()];
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
        N();
    }

    private void y() {
        f fVar = this.s;
        if (fVar != null) {
            fVar.a();
            this.s = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (A()) {
            P(D());
        }
    }

    public RectF B() {
        A();
        return C(D());
    }

    public Matrix E() {
        return this.l;
    }

    public float H() {
        return this.e;
    }

    public float I() {
        return this.d;
    }

    public float J() {
        return this.c;
    }

    public float K() {
        return (float) Math.sqrt(((float) Math.pow(M(this.m, 0), 2.0d)) + ((float) Math.pow(M(this.m, 3), 2.0d)));
    }

    public ImageView.ScaleType L() {
        return this.x;
    }

    public void O(boolean z2) {
        this.f = z2;
    }

    public void Q(float f2) {
        ZM7.a(this.c, this.d, f2);
        this.e = f2;
    }

    public void R(float f2) {
        ZM7.a(this.c, f2, this.e);
        this.d = f2;
    }

    public void S(float f2) {
        ZM7.a(f2, this.d, this.e);
        this.c = f2;
    }

    public void T(View.OnClickListener onClickListener) {
        this.q = onClickListener;
    }

    public void U(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void V(View.OnLongClickListener onLongClickListener) {
        this.r = onLongClickListener;
    }

    public void c0(InterfaceC18243oK4 interfaceC18243oK4) {
        this.p = interfaceC18243oK4;
    }

    public void d0(float f2) {
        this.m.postRotate(f2 % 360.0f);
        z();
    }

    public void e0(float f2) {
        this.m.setRotate(f2 % 360.0f);
        z();
    }

    public void f0(float f2) {
        h0(f2, false);
    }

    public void g0(float f2, float f3, float f4, boolean z2) {
        if (f2 < this.c || f2 > this.e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z2) {
            this.h.post(new e(K(), f2, f3, f4));
        } else {
            this.m.setScale(f2, f2, f3, f4);
            z();
        }
    }

    public void h0(float f2, boolean z2) {
        g0(f2, this.h.getRight() / 2, this.h.getBottom() / 2, z2);
    }

    public void i0(float f2, float f3, float f4) {
        ZM7.a(f2, f3, f4);
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public void j0(ImageView.ScaleType scaleType) {
        if (!ZM7.d(scaleType) || scaleType == this.x) {
            return;
        }
        this.x = scaleType;
        m0();
    }

    public void k0(int i) {
        this.b = i;
    }

    public void l0(boolean z2) {
        this.w = z2;
        m0();
    }

    public void m0() {
        if (this.w) {
            n0(this.h.getDrawable());
        } else {
            N();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i == i5 && i2 == i6 && i3 == i7 && i4 == i8) {
            return;
        }
        n0(this.h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.w
            r1 = 0
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = ir.nasim.ZM7.c(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            r2 = 1
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.K()
            float r3 = r10.c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.B()
            if (r0 == 0) goto L7a
            ir.nasim.K95$e r9 = new ir.nasim.K95$e
            float r5 = r10.K()
            float r6 = r10.c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.K()
            float r3 = r10.e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.B()
            if (r0 == 0) goto L7a
            ir.nasim.K95$e r9 = new ir.nasim.K95$e
            float r5 = r10.K()
            float r6 = r10.e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = r2
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.y()
        L7a:
            r11 = r1
        L7b:
            ir.nasim.cx1 r0 = r10.j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.e()
            ir.nasim.cx1 r0 = r10.j
            boolean r0 = r0.d()
            ir.nasim.cx1 r3 = r10.j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L9b
            ir.nasim.cx1 r11 = r10.j
            boolean r11 = r11.e()
            if (r11 != 0) goto L9b
            r11 = r2
            goto L9c
        L9b:
            r11 = r1
        L9c:
            if (r0 != 0) goto La8
            ir.nasim.cx1 r0 = r10.j
            boolean r0 = r0.d()
            if (r0 != 0) goto La8
            r0 = r2
            goto La9
        La8:
            r0 = r1
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = r2
        Lae:
            r10.g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = r2
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.K95.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void W(CJ4 cj4) {
    }

    public void X(JJ4 jj4) {
    }

    public void Y(NJ4 nj4) {
    }

    public void Z(XJ4 xj4) {
    }

    public void a0(InterfaceC10863cK4 interfaceC10863cK4) {
    }

    public void b0(InterfaceC17061mK4 interfaceC17061mK4) {
    }
}
