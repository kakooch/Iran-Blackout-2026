package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.os.Build;
import androidx.compose.ui.graphics.a;
import androidx.compose.ui.platform.AndroidComposeView;

/* renamed from: ir.nasim.eO5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12307eO5 implements InterfaceC23085wK1 {
    private final AndroidComposeView a;
    private final RenderNode b = AbstractC23216wY6.a("Compose");
    private int c = androidx.compose.ui.graphics.a.a.a();

    public C12307eO5(AndroidComposeView androidComposeView) {
        this.a = androidComposeView;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void A(int i) {
        this.b.offsetLeftAndRight(i);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int B() {
        return this.b.getBottom();
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
        RecordingCanvas recordingCanvasBeginRecording = this.b.beginRecording();
        Canvas canvasA = c21853uF0.a().a();
        c21853uF0.a().y(recordingCanvasBeginRecording);
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
        this.b.endRecording();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void G(int i) {
        this.b.setAmbientShadowColor(i);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void H(boolean z) {
        this.b.setClipToOutline(z);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void I(int i) {
        this.b.setSpotShadowColor(i);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public float J() {
        return this.b.getElevation();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public float a() {
        return this.b.getAlpha();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int b() {
        return this.b.getLeft();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void c(float f) {
        this.b.setAlpha(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void d() {
        this.b.discardDisplayList();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void e(float f) {
        this.b.setTranslationY(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void f(ON5 on5) {
        if (Build.VERSION.SDK_INT >= 31) {
            C12916fO5.a.a(this.b, on5);
        }
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void g(float f) {
        this.b.setScaleX(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int getHeight() {
        return this.b.getHeight();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int getWidth() {
        return this.b.getWidth();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean h() {
        return this.b.hasDisplayList();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void i(float f) {
        this.b.setCameraDistance(f);
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
        this.b.setRotationZ(f);
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
        return this.b.getClipToBounds();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int p() {
        return this.b.getRight();
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void q(int i) {
        RenderNode renderNode = this.b;
        a.C0063a c0063a = androidx.compose.ui.graphics.a.a;
        if (androidx.compose.ui.graphics.a.e(i, c0063a.c())) {
            renderNode.setUseCompositingLayer(true, null);
            renderNode.setHasOverlappingRendering(true);
        } else if (androidx.compose.ui.graphics.a.e(i, c0063a.b())) {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(false);
        } else {
            renderNode.setUseCompositingLayer(false, null);
            renderNode.setHasOverlappingRendering(true);
        }
        this.c = i;
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void r(Canvas canvas) {
        canvas.drawRenderNode(this.b);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void s(boolean z) {
        this.b.setClipToBounds(z);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public boolean t(int i, int i2, int i3, int i4) {
        return this.b.setPosition(i, i2, i3, i4);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void u(float f) {
        this.b.setElevation(f);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public void v(int i) {
        this.b.offsetTopAndBottom(i);
    }

    @Override // ir.nasim.InterfaceC23085wK1
    public int w() {
        return this.b.getTop();
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
}
