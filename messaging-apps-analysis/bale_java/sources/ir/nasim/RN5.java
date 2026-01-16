package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.os.Build;
import android.view.DisplayListCanvas;
import android.view.RenderNode;
import androidx.compose.ui.graphics.a;
import androidx.compose.ui.platform.AndroidComposeView;

/* loaded from: classes2.dex */
public final class RN5 implements InterfaceC23085wK1 {
    private static boolean k;
    private final AndroidComposeView a;
    private final RenderNode b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    public static final a i = new a(null);
    public static final int j = 8;
    private static boolean l = true;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public RN5(AndroidComposeView androidComposeView) {
        this.a = androidComposeView;
        RenderNode renderNodeCreate = RenderNode.create("Compose", androidComposeView);
        this.b = renderNodeCreate;
        this.c = androidx.compose.ui.graphics.a.a.a();
        if (l) {
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
            P(renderNodeCreate);
            K();
            renderNodeCreate.setLayerType(0);
            renderNodeCreate.setHasOverlappingRendering(renderNodeCreate.hasOverlappingRendering());
            l = false;
        }
        if (k) {
            throw new NoClassDefFoundError();
        }
    }

    private final void K() {
        C14736iO5.a.a(this.b);
    }

    private final void P(RenderNode renderNode) {
        if (Build.VERSION.SDK_INT >= 28) {
            C15916kO5 c15916kO5 = C15916kO5.a;
            c15916kO5.c(renderNode, c15916kO5.a(renderNode));
            c15916kO5.d(renderNode, c15916kO5.b(renderNode));
        }
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void A(int i2) {
        M(b() + i2);
        N(p() + i2);
        this.b.offsetLeftAndRight(i2);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int B() {
        return this.g;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void C(float f) {
        this.b.setPivotX(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void D(float f) {
        this.b.setPivotY(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void E(Outline outline) {
        this.b.setOutline(outline);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void F(C21853uF0 c21853uF0, V05 v05, UA2 ua2) {
        DisplayListCanvas displayListCanvasStart = this.b.start(getWidth(), getHeight());
        Canvas canvasA = c21853uF0.a().a();
        c21853uF0.a().y((Canvas) displayListCanvasStart);
        C7390Rn c7390RnA = c21853uF0.a();
        if (v05 != null) {
            c7390RnA.n();
            UE0.m(c7390RnA, v05, 0, 2, null);
        }
        ua2.invoke(c7390RnA);
        if (v05 != null) {
            c7390RnA.i();
        }
        c21853uF0.a().y(canvasA);
        this.b.end(displayListCanvasStart);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void G(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            C15916kO5.a.c(this.b, i2);
        }
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void H(boolean z) {
        this.b.setClipToOutline(z);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void I(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            C15916kO5.a.d(this.b, i2);
        }
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public float J() {
        return this.b.getElevation();
    }

    public void L(int i2) {
        this.g = i2;
    }

    public void M(int i2) {
        this.d = i2;
    }

    public void N(int i2) {
        this.f = i2;
    }

    public void O(int i2) {
        this.e = i2;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public float a() {
        return this.b.getAlpha();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int b() {
        return this.d;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void c(float f) {
        this.b.setAlpha(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void d() {
        K();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void e(float f) {
        this.b.setTranslationY(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void g(float f) {
        this.b.setScaleX(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int getHeight() {
        return B() - w();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int getWidth() {
        return p() - b();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean h() {
        return this.b.isValid();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void i(float f) {
        this.b.setCameraDistance(-f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void j(float f) {
        this.b.setRotationX(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void k(float f) {
        this.b.setRotationY(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void l(float f) {
        this.b.setRotation(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void m(float f) {
        this.b.setScaleY(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void n(float f) {
        this.b.setTranslationX(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean o() {
        return this.h;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int p() {
        return this.f;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void q(int i2) {
        a.C0063a c0063a = androidx.compose.ui.graphics.a.a;
        if (androidx.compose.ui.graphics.a.e(i2, c0063a.c())) {
            this.b.setLayerType(2);
            this.b.setHasOverlappingRendering(true);
        } else if (androidx.compose.ui.graphics.a.e(i2, c0063a.b())) {
            this.b.setLayerType(0);
            this.b.setHasOverlappingRendering(false);
        } else {
            this.b.setLayerType(0);
            this.b.setHasOverlappingRendering(true);
        }
        this.c = i2;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void r(Canvas canvas) {
        AbstractC13042fc3.g(canvas, "null cannot be cast to non-null type android.view.DisplayListCanvas");
        ((DisplayListCanvas) canvas).drawRenderNode(this.b);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void s(boolean z) {
        this.h = z;
        this.b.setClipToBounds(z);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean t(int i2, int i3, int i4, int i5) {
        M(i2);
        O(i3);
        N(i4);
        L(i5);
        return this.b.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void u(float f) {
        this.b.setElevation(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void v(int i2) {
        O(w() + i2);
        L(B() + i2);
        this.b.offsetTopAndBottom(i2);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int w() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean x() {
        return this.b.getClipToOutline();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean y(boolean z) {
        return this.b.setHasOverlappingRendering(z);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void z(Matrix matrix) {
        this.b.getMatrix(matrix);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void f(ON5 on5) {
    }
}
