package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import android.view.View;
import ir.nasim.AbstractC6567Ob1;
import ir.nasim.C24381yX0;
import ir.nasim.C4414Fa3;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ir.nasim.yK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C24266yK2 implements androidx.compose.ui.graphics.layer.a {
    private static boolean G;
    private float A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private final long b;
    private final C21853uF0 c;
    private final C20576sF0 d;
    private final RenderNode e;
    private long f;
    private Paint g;
    private Matrix h;
    private boolean i;
    private long j;
    private int k;
    private int l;
    private AbstractC24975zX0 m;
    private float n;
    private boolean o;
    private long p;
    private float q;
    private float r;
    private float s;
    private float t;
    private float u;
    private long v;
    private long w;
    private float x;
    private float y;
    private float z;
    public static final a F = new a(null);
    private static final AtomicBoolean H = new AtomicBoolean(true);

    /* renamed from: ir.nasim.yK2$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C24266yK2(View view, long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0) {
        this.b = j;
        this.c = c21853uF0;
        this.d = c20576sF0;
        RenderNode renderNodeCreate = RenderNode.create("Compose", view);
        this.e = renderNodeCreate;
        C4414Fa3.a aVar = C4414Fa3.b;
        this.f = aVar.a();
        this.j = aVar.a();
        if (H.getAndSet(false)) {
            renderNodeCreate.setScaleX(renderNodeCreate.getScaleX());
            renderNodeCreate.setScaleY(renderNodeCreate.getScaleY());
            renderNodeCreate.setTranslationX(renderNodeCreate.getTranslationX());
            renderNodeCreate.setTranslationY(renderNodeCreate.getTranslationY());
            renderNodeCreate.setElevation(renderNodeCreate.getElevation());
            renderNodeCreate.setRotation(renderNodeCreate.getRotation());
            renderNodeCreate.setRotationX(renderNodeCreate.getRotationX());
            renderNodeCreate.setRotationY(renderNodeCreate.getRotationY());
            renderNodeCreate.setCameraDistance(renderNodeCreate.getCameraDistance());
            renderNodeCreate.setPivotX(renderNodeCreate.getPivotX());
            renderNodeCreate.setPivotY(renderNodeCreate.getPivotY());
            renderNodeCreate.setClipToOutline(renderNodeCreate.getClipToOutline());
            renderNodeCreate.setClipToBounds(false);
            renderNodeCreate.setAlpha(renderNodeCreate.getAlpha());
            renderNodeCreate.isValid();
            renderNodeCreate.setLeftTopRightBottom(0, 0, 0, 0);
            renderNodeCreate.offsetLeftAndRight(0);
            renderNodeCreate.offsetTopAndBottom(0);
            V(renderNodeCreate);
            R();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
        }
        if (G) {
            throw new NoClassDefFoundError();
        }
        renderNodeCreate.setClipToBounds(false);
        AbstractC6567Ob1.a aVar2 = AbstractC6567Ob1.a;
        Q(aVar2.a());
        this.k = aVar2.a();
        this.l = AbstractC7094Qg0.a.B();
        this.n = 1.0f;
        this.p = ZG4.b.b();
        this.q = 1.0f;
        this.r = 1.0f;
        C24381yX0.a aVar3 = C24381yX0.b;
        this.v = aVar3.a();
        this.w = aVar3.a();
        this.A = 8.0f;
        this.E = true;
    }

    private final void P() {
        boolean z = false;
        boolean z2 = S() && !this.i;
        if (S() && this.i) {
            z = true;
        }
        if (z2 != this.C) {
            this.C = z2;
            this.e.setClipToBounds(z2);
        }
        if (z != this.D) {
            this.D = z;
            this.e.setClipToOutline(z);
        }
    }

    private final void Q(int i) {
        RenderNode renderNode = this.e;
        AbstractC6567Ob1.a aVar = AbstractC6567Ob1.a;
        if (AbstractC6567Ob1.e(i, aVar.c())) {
            renderNode.setLayerType(2);
            renderNode.setLayerPaint(this.g);
            renderNode.setHasOverlappingRendering(true);
        } else if (AbstractC6567Ob1.e(i, aVar.b())) {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setLayerType(0);
            renderNode.setLayerPaint(this.g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean T() {
        return (!AbstractC6567Ob1.e(q(), AbstractC6567Ob1.a.c()) && AbstractC7094Qg0.E(o(), AbstractC7094Qg0.a.B()) && b() == null) ? false : true;
    }

    private final void U() {
        if (T()) {
            Q(AbstractC6567Ob1.a.c());
        } else {
            Q(q());
        }
    }

    private final void V(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            C16507lO5 c16507lO5 = C16507lO5.a;
            c16507lO5.c(renderNode, c16507lO5.a(renderNode));
            c16507lO5.d(renderNode, c16507lO5.b(renderNode));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float A() {
        return this.q;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void B(float f) {
        this.u = f;
        this.e.setElevation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public Matrix C() {
        Matrix matrix = this.h;
        if (matrix == null) {
            matrix = new Matrix();
            this.h = matrix;
        }
        this.e.getMatrix(matrix);
        return matrix;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void E(boolean z) {
        this.E = z;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void F(Outline outline, long j) {
        this.j = j;
        this.e.setOutline(outline);
        this.i = outline != null;
        P();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float G() {
        return this.t;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float H() {
        return this.s;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float I() {
        return this.x;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void J(WH1 wh1, EnumC12613eu3 enumC12613eu3, C21226tK2 c21226tK2, UA2 ua2) {
        Canvas canvasStart = this.e.start(Math.max((int) (this.f >> 32), (int) (this.j >> 32)), Math.max((int) (this.f & 4294967295L), (int) (this.j & 4294967295L)));
        try {
            C21853uF0 c21853uF0 = this.c;
            Canvas canvasA = c21853uF0.a().a();
            c21853uF0.a().y(canvasStart);
            C7390Rn c7390RnA = c21853uF0.a();
            C20576sF0 c20576sF0 = this.d;
            long jD = AbstractC4663Ga3.d(this.f);
            WH1 density = c20576sF0.z1().getDensity();
            EnumC12613eu3 layoutDirection = c20576sF0.z1().getLayoutDirection();
            UE0 ue0E = c20576sF0.z1().e();
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
                c21853uF0.a().y(canvasA);
                this.e.end(canvasStart);
                E(false);
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
        } catch (Throwable th2) {
            this.e.end(canvasStart);
            throw th2;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float K() {
        return this.r;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void L(long j) {
        this.p = j;
        if ((9223372034707292159L & j) == 9205357640488583168L) {
            this.o = true;
            this.e.setPivotX(((int) (this.f >> 32)) / 2.0f);
            this.e.setPivotY(((int) (4294967295L & this.f)) / 2.0f);
        } else {
            this.o = false;
            this.e.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            this.e.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void M(UE0 ue0) {
        DisplayListCanvas displayListCanvasD = AbstractC7624Sn.d(ue0);
        AbstractC13042fc3.g(displayListCanvasD, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        displayListCanvasD.drawRenderNode(this.e);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void N(int i) {
        this.k = i;
        U();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float O() {
        return this.u;
    }

    public final void R() {
        C15325jO5.a.a(this.e);
    }

    public boolean S() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float a() {
        return this.n;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public AbstractC24975zX0 b() {
        return this.m;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void c(float f) {
        this.n = f;
        this.e.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void d() {
        R();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void e(float f) {
        this.t = f;
        this.e.setTranslationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void g(float f) {
        this.q = f;
        this.e.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public boolean h() {
        return this.e.isValid();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void i(float f) {
        this.A = f;
        this.e.setCameraDistance(-f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void j(float f) {
        this.x = f;
        this.e.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void k(float f) {
        this.y = f;
        this.e.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void l(float f) {
        this.z = f;
        this.e.setRotation(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void m(float f) {
        this.r = f;
        this.e.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void n(float f) {
        this.s = f;
        this.e.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int o() {
        return this.l;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public ON5 p() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int q() {
        return this.k;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float r() {
        return this.y;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float s() {
        return this.z;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void t(int i, int i2, long j) {
        int i3 = (int) (j >> 32);
        int i4 = (int) (4294967295L & j);
        this.e.setLeftTopRightBottom(i, i2, i + i3, i2 + i4);
        if (C4414Fa3.e(this.f, j)) {
            return;
        }
        if (this.o) {
            this.e.setPivotX(i3 / 2.0f);
            this.e.setPivotY(i4 / 2.0f);
        }
        this.f = j;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long u() {
        return this.v;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void v(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.v = j;
            C16507lO5.a.c(this.e, DX0.k(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float w() {
        return this.A;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void x(boolean z) {
        this.B = z;
        P();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void y(long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.w = j;
            C16507lO5.a.d(this.e, DX0.k(j));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long z() {
        return this.w;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void f(ON5 on5) {
    }

    public /* synthetic */ C24266yK2(View view, long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0, int i, ED1 ed1) {
        this(view, j, (i & 4) != 0 ? new C21853uF0() : c21853uF0, (i & 8) != 0 ? new C20576sF0() : c20576sF0);
    }
}
