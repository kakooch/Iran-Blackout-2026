package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import ir.nasim.AbstractC6567Ob1;
import ir.nasim.C24381yX0;

/* loaded from: classes2.dex */
public final class WK2 implements androidx.compose.ui.graphics.layer.a {
    private boolean A;
    private int B;
    private boolean C;
    private final long b;
    private final C21853uF0 c;
    private final C20576sF0 d;
    private final RenderNode e;
    private long f;
    private Paint g;
    private Matrix h;
    private boolean i;
    private float j;
    private int k;
    private AbstractC24975zX0 l;
    private long m;
    private float n;
    private float o;
    private float p;
    private float q;
    private float r;
    private long s;
    private long t;
    private float u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private boolean z;

    public WK2(long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0) {
        this.b = j;
        this.c = c21853uF0;
        this.d = c20576sF0;
        RenderNode renderNodeA = AbstractC23216wY6.a("graphicsLayer");
        this.e = renderNodeA;
        this.f = OD6.b.b();
        renderNodeA.setClipToBounds(false);
        AbstractC6567Ob1.a aVar = AbstractC6567Ob1.a;
        Q(renderNodeA, aVar.a());
        this.j = 1.0f;
        this.k = AbstractC7094Qg0.a.B();
        this.m = ZG4.b.b();
        this.n = 1.0f;
        this.o = 1.0f;
        C24381yX0.a aVar2 = C24381yX0.b;
        this.s = aVar2.a();
        this.t = aVar2.a();
        this.x = 8.0f;
        this.B = aVar.a();
        this.C = true;
    }

    private final void P() {
        boolean z = false;
        boolean z2 = R() && !this.i;
        if (R() && this.i) {
            z = true;
        }
        if (z2 != this.z) {
            this.z = z2;
            this.e.setClipToBounds(z2);
        }
        if (z != this.A) {
            this.A = z;
            this.e.setClipToOutline(z);
        }
    }

    private final void Q(RenderNode renderNode, int i) {
        AbstractC6567Ob1.a aVar = AbstractC6567Ob1.a;
        if (AbstractC6567Ob1.e(i, aVar.c())) {
            renderNode.setUseCompositingLayer(true, this.g);
            renderNode.setHasOverlappingRendering(true);
        } else if (AbstractC6567Ob1.e(i, aVar.b())) {
            renderNode.setUseCompositingLayer(false, this.g);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, this.g);
            renderNode.setHasOverlappingRendering(true);
        }
    }

    private final boolean S() {
        if (AbstractC6567Ob1.e(q(), AbstractC6567Ob1.a.c()) || T()) {
            return true;
        }
        p();
        return false;
    }

    private final boolean T() {
        return (AbstractC7094Qg0.E(o(), AbstractC7094Qg0.a.B()) && b() == null) ? false : true;
    }

    private final void U() {
        if (S()) {
            Q(this.e, AbstractC6567Ob1.a.c());
        } else {
            Q(this.e, q());
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float A() {
        return this.n;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void B(float f) {
        this.r = f;
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
        this.C = z;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void F(Outline outline, long j) {
        this.e.setOutline(outline);
        this.i = outline != null;
        P();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float G() {
        return this.q;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float H() {
        return this.p;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float I() {
        return this.u;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void J(WH1 wh1, EnumC12613eu3 enumC12613eu3, C21226tK2 c21226tK2, UA2 ua2) {
        RecordingCanvas recordingCanvasBeginRecording = this.e.beginRecording();
        try {
            C21853uF0 c21853uF0 = this.c;
            Canvas canvasA = c21853uF0.a().a();
            c21853uF0.a().y(recordingCanvasBeginRecording);
            C7390Rn c7390RnA = c21853uF0.a();
            YZ1 yz1Z1 = this.d.z1();
            yz1Z1.f(wh1);
            yz1Z1.c(enumC12613eu3);
            yz1Z1.h(c21226tK2);
            yz1Z1.g(this.f);
            yz1Z1.a(c7390RnA);
            ua2.invoke(this.d);
            c21853uF0.a().y(canvasA);
            this.e.endRecording();
            E(false);
        } catch (Throwable th) {
            this.e.endRecording();
            throw th;
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float K() {
        return this.o;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void L(long j) {
        this.m = j;
        if ((9223372034707292159L & j) == 9205357640488583168L) {
            this.e.resetPivot();
        } else {
            this.e.setPivotX(Float.intBitsToFloat((int) (j >> 32)));
            this.e.setPivotY(Float.intBitsToFloat((int) (j & 4294967295L)));
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void M(UE0 ue0) {
        AbstractC7624Sn.d(ue0).drawRenderNode(this.e);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void N(int i) {
        this.B = i;
        U();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float O() {
        return this.r;
    }

    public boolean R() {
        return this.y;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float a() {
        return this.j;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public AbstractC24975zX0 b() {
        return this.l;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void c(float f) {
        this.j = f;
        this.e.setAlpha(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void d() {
        this.e.discardDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void e(float f) {
        this.q = f;
        this.e.setTranslationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void f(ON5 on5) {
        if (Build.VERSION.SDK_INT >= 31) {
            C17098mO5.a.a(this.e, on5);
        }
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void g(float f) {
        this.n = f;
        this.e.setScaleX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public boolean h() {
        return this.e.hasDisplayList();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void i(float f) {
        this.x = f;
        this.e.setCameraDistance(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void j(float f) {
        this.u = f;
        this.e.setRotationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void k(float f) {
        this.v = f;
        this.e.setRotationY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void l(float f) {
        this.w = f;
        this.e.setRotationZ(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void m(float f) {
        this.o = f;
        this.e.setScaleY(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void n(float f) {
        this.p = f;
        this.e.setTranslationX(f);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int o() {
        return this.k;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public ON5 p() {
        return null;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public int q() {
        return this.B;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float r() {
        return this.v;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float s() {
        return this.w;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void t(int i, int i2, long j) {
        this.e.setPosition(i, i2, ((int) (j >> 32)) + i, ((int) (4294967295L & j)) + i2);
        this.f = AbstractC4663Ga3.d(j);
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long u() {
        return this.s;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void v(long j) {
        this.s = j;
        this.e.setAmbientShadowColor(DX0.k(j));
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public float w() {
        return this.x;
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void x(boolean z) {
        this.y = z;
        P();
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public void y(long j) {
        this.t = j;
        this.e.setSpotShadowColor(DX0.k(j));
    }

    @Override // androidx.compose.ui.graphics.layer.a
    public long z() {
        return this.t;
    }

    public /* synthetic */ WK2(long j, C21853uF0 c21853uF0, C20576sF0 c20576sF0, int i, ED1 ed1) {
        this(j, (i & 2) != 0 ? new C21853uF0() : c21853uF0, (i & 4) != 0 ? new C20576sF0() : c20576sF0);
    }
}
