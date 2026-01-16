package ir.nasim;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import androidx.compose.ui.graphics.layer.ViewLayer;
import androidx.compose.ui.graphics.layer.view.DrawChildContainer;
import ir.nasim.AbstractC6567Ob1;
import ir.nasim.C24381yX0;

/* loaded from: classes2.dex */
public final class XK2 implements androidx.compose.ui.graphics.layer.a {
    public static final b K = new b(null);
    private static final boolean L = !C16904m37.a.a();
    private static final Canvas M = new a();
    private float A;
    private float B;
    private float C;
    private float D;
    private long E;
    private long F;
    private float G;
    private float H;
    private float I;
    private final boolean J;
    private final DrawChildContainer b;
    private final long c;
    private final C21853uF0 d;
    private final ViewLayer e;
    private final Resources f;
    private final Rect g;
    private Paint h;
    private final Picture i;
    private final C20576sF0 j;
    private final C21853uF0 k;
    private int l;
    private int m;
    private long n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private final long s;
    private int t;
    private AbstractC24975zX0 u;
    private int v;
    private float w;
    private boolean x;
    private long y;
    private float z;

    public static final class a extends Canvas {
        a() {
        }

        @Override // android.graphics.Canvas
        public boolean isHardwareAccelerated() {
            return true;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public XK2(DrawChildContainer drawChildContainer, long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0) {
        this.b = drawChildContainer;
        this.c = j;
        this.d = c21853uF0;
        ViewLayer viewLayer = new ViewLayer(drawChildContainer, c21853uF0, c20576sF0);
        this.e = viewLayer;
        this.f = drawChildContainer.getResources();
        this.g = new Rect();
        boolean z = L;
        this.i = z ? new Picture() : null;
        this.j = z ? new C20576sF0() : null;
        this.k = z ? new C21853uF0() : null;
        drawChildContainer.addView(viewLayer);
        viewLayer.setClipBounds(null);
        this.n = C4414Fa3.b.a();
        this.p = true;
        this.s = View.generateViewId();
        this.t = AbstractC7094Qg0.a.B();
        this.v = AbstractC6567Ob1.a.a();
        this.w = 1.0f;
        this.y = ZG4.b.c();
        this.z = 1.0f;
        this.A = 1.0f;
        C24381yX0.a aVar = C24381yX0.b;
        this.E = aVar.a();
        this.F = aVar.a();
        this.J = z;
    }

    private final void P(int i) {
        ViewLayer viewLayer = this.e;
        AbstractC6567Ob1.a aVar = AbstractC6567Ob1.a;
        boolean z = true;
        if (AbstractC6567Ob1.e(i, aVar.c())) {
            this.e.setLayerType(2, this.h);
        } else if (AbstractC6567Ob1.e(i, aVar.b())) {
            this.e.setLayerType(0, this.h);
            z = false;
        } else {
            this.e.setLayerType(0, this.h);
        }
        viewLayer.setCanUseCompositingLayer$ui_graphics_release(z);
    }

    private final void R() {
        try {
            C21853uF0 c21853uF0 = this.d;
            Canvas canvas = M;
            Canvas canvasA = c21853uF0.a().a();
            c21853uF0.a().y(canvas);
            C7390Rn c7390RnA = c21853uF0.a();
            DrawChildContainer drawChildContainer = this.b;
            ViewLayer viewLayer = this.e;
            drawChildContainer.a(c7390RnA, viewLayer, viewLayer.getDrawingTime());
            c21853uF0.a().y(canvasA);
        } catch (Throwable unused) {
        }
    }

    private final boolean S() {
        return AbstractC6567Ob1.e(q(), AbstractC6567Ob1.a.c()) || T();
    }

    private final boolean T() {
        return (AbstractC7094Qg0.E(o(), AbstractC7094Qg0.a.B()) && b() == null) ? false : true;
    }

    private final void U() {
        Rect rect;
        if (this.o) {
            ViewLayer viewLayer = this.e;
            if (!Q() || this.q) {
                rect = null;
            } else {
                rect = this.g;
                rect.left = 0;
                rect.top = 0;
                rect.right = this.e.getWidth();
                rect.bottom = this.e.getHeight();
            }
            viewLayer.setClipBounds(rect);
        }
    }

    private final void V() {
        if (S()) {
            P(AbstractC6567Ob1.a.c());
        } else {
            P(q());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float A() {
        return this.z;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void B(float f) {
        this.D = f;
        this.e.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public Matrix C() {
        return this.e.getMatrix();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public boolean D() {
        return this.J;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void E(boolean z) {
        this.p = z;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void F(Outline outline, long j) {
        boolean z = !this.e.c(outline);
        if (Q() && outline != null) {
            this.e.setClipToOutline(true);
            if (this.r) {
                this.r = false;
                this.o = true;
            }
        }
        this.q = outline != null;
        if (z) {
            this.e.invalidate();
            R();
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float G() {
        return this.C;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float H() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float I() {
        return this.G;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void J(WH1 wh1, EnumC12613eu3 enumC12613eu3, C21226tK2 c21226tK2, UA2 ua2) {
        C21853uF0 c21853uF0;
        Canvas canvas;
        if (this.e.getParent() == null) {
            this.b.addView(this.e);
        }
        this.e.setDrawParams(wh1, enumC12613eu3, c21226tK2, ua2);
        if (this.e.isAttachedToWindow()) {
            this.e.setVisibility(4);
            this.e.setVisibility(0);
            R();
            Picture picture = this.i;
            if (picture != null) {
                long j = this.n;
                Canvas canvasBeginRecording = picture.beginRecording((int) (j >> 32), (int) (j & 4294967295L));
                try {
                    C21853uF0 c21853uF02 = this.k;
                    if (c21853uF02 != null) {
                        Canvas canvasA = c21853uF02.a().a();
                        c21853uF02.a().y(canvasBeginRecording);
                        C7390Rn c7390RnA = c21853uF02.a();
                        C20576sF0 c20576sF0 = this.j;
                        if (c20576sF0 != null) {
                            long jD = AbstractC4663Ga3.d(this.n);
                            WH1 density = c20576sF0.z1().getDensity();
                            EnumC12613eu3 layoutDirection = c20576sF0.z1().getLayoutDirection();
                            UE0 ue0E = c20576sF0.z1().e();
                            c21853uF0 = c21853uF02;
                            canvas = canvasA;
                            long jD2 = c20576sF0.z1().d();
                            C21226tK2 c21226tK2I = c20576sF0.z1().i();
                            YZ1 yz1Z1 = c20576sF0.z1();
                            yz1Z1.f(wh1);
                            yz1Z1.c(enumC12613eu3);
                            yz1Z1.a(c7390RnA);
                            yz1Z1.g(jD);
                            yz1Z1.h(c21226tK2);
                            c7390RnA.n();
                            try {
                                ua2.invoke(c20576sF0);
                                c7390RnA.i();
                                YZ1 yz1Z12 = c20576sF0.z1();
                                yz1Z12.f(density);
                                yz1Z12.c(layoutDirection);
                                yz1Z12.a(ue0E);
                                yz1Z12.g(jD2);
                                yz1Z12.h(c21226tK2I);
                            } catch (Throwable th) {
                                c7390RnA.i();
                                YZ1 yz1Z13 = c20576sF0.z1();
                                yz1Z13.f(density);
                                yz1Z13.c(layoutDirection);
                                yz1Z13.a(ue0E);
                                yz1Z13.g(jD2);
                                yz1Z13.h(c21226tK2I);
                                throw th;
                            }
                        } else {
                            c21853uF0 = c21853uF02;
                            canvas = canvasA;
                        }
                        c21853uF0.a().y(canvas);
                        C19938rB7 c19938rB7 = C19938rB7.a;
                    }
                    picture.endRecording();
                } catch (Throwable th2) {
                    picture.endRecording();
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float K() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void L(long j) {
        this.y = j;
        if ((9223372034707292159L & j) != 9205357640488583168L) {
            this.x = false;
            this.e.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            this.e.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        } else {
            if (Build.VERSION.SDK_INT >= 28) {
                RW7.a.a(this.e);
                return;
            }
            this.x = true;
            this.e.setPivotX(((int) (this.n >> 32)) / 2.0f);
            this.e.setPivotY(((int) (4294967295L & this.n)) / 2.0f);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void M(UE0 ue0) {
        U();
        Canvas canvasD = AbstractC7624Sn.d(ue0);
        if (canvasD.isHardwareAccelerated()) {
            DrawChildContainer drawChildContainer = this.b;
            ViewLayer viewLayer = this.e;
            drawChildContainer.a(ue0, viewLayer, viewLayer.getDrawingTime());
        } else {
            Picture picture = this.i;
            if (picture != null) {
                canvasD.drawPicture(picture);
            }
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void N(int i) {
        this.v = i;
        V();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float O() {
        return this.D;
    }

    public boolean Q() {
        return this.r || this.e.getClipToOutline();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float a() {
        return this.w;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public AbstractC24975zX0 b() {
        return this.u;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void c(float f) {
        this.w = f;
        this.e.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void d() {
        this.b.removeViewInLayout(this.e);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void e(float f) {
        this.C = f;
        this.e.setTranslationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void f(ON5 on5) {
        if (Build.VERSION.SDK_INT >= 31) {
            TW7.a.a(this.e, on5);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void g(float f) {
        this.z = f;
        this.e.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void i(float f) {
        this.e.setCameraDistance(f * this.f.getDisplayMetrics().densityDpi);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void j(float f) {
        this.G = f;
        this.e.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void k(float f) {
        this.H = f;
        this.e.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void l(float f) {
        this.I = f;
        this.e.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void m(float f) {
        this.A = f;
        this.e.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void n(float f) {
        this.B = f;
        this.e.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int o() {
        return this.t;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public ON5 p() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int q() {
        return this.v;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float r() {
        return this.H;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float s() {
        return this.I;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void t(int i, int i2, long j) {
        if (C4414Fa3.e(this.n, j)) {
            int i3 = this.l;
            if (i3 != i) {
                this.e.offsetLeftAndRight(i - i3);
            }
            int i4 = this.m;
            if (i4 != i2) {
                this.e.offsetTopAndBottom(i2 - i4);
            }
        } else {
            if (Q()) {
                this.o = true;
            }
            int i5 = (int) (j >> 32);
            int i6 = (int) (4294967295L & j);
            this.e.layout(i, i2, i + i5, i2 + i6);
            this.n = j;
            if (this.x) {
                this.e.setPivotX(i5 / 2.0f);
                this.e.setPivotY(i6 / 2.0f);
            }
        }
        this.l = i;
        this.m = i2;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long u() {
        return this.E;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void v(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.E = j;
            RW7.a.b(this.e, DX0.k(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float w() {
        return this.e.getCameraDistance() / this.f.getDisplayMetrics().densityDpi;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void x(boolean z) {
        boolean z2 = false;
        this.r = z && !this.q;
        this.o = true;
        ViewLayer viewLayer = this.e;
        if (z && this.q) {
            z2 = true;
        }
        viewLayer.setClipToOutline(z2);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.F = j;
            RW7.a.c(this.e, DX0.k(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long z() {
        return this.F;
    }

    public /* synthetic */ XK2(DrawChildContainer drawChildContainer, long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0, int i, ED1 ed1) {
        this(drawChildContainer, j, (i & 4) != 0 ? new C21853uF0() : c21853uF0, (i & 8) != 0 ? new C20576sF0() : c20576sF0);
    }
}
