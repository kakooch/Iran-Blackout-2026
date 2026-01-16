package ir.nasim;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;

/* renamed from: ir.nasim.xY6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23806xY6 extends RG1 implements InterfaceC15687k02 {
    private final C8340Vo q;
    private final C10085b32 r;
    private RenderNode s;

    public C23806xY6(JG1 jg1, C8340Vo c8340Vo, C10085b32 c10085b32) {
        this.q = c8340Vo;
        this.r = c10085b32;
        v2(jg1);
    }

    private final boolean B2(EdgeEffect edgeEffect, Canvas canvas) {
        return F2(180.0f, edgeEffect, canvas);
    }

    private final boolean C2(EdgeEffect edgeEffect, Canvas canvas) {
        return F2(270.0f, edgeEffect, canvas);
    }

    private final boolean D2(EdgeEffect edgeEffect, Canvas canvas) {
        return F2(90.0f, edgeEffect, canvas);
    }

    private final boolean E2(EdgeEffect edgeEffect, Canvas canvas) {
        return F2(0.0f, edgeEffect, canvas);
    }

    private final boolean F2(float f, EdgeEffect edgeEffect, Canvas canvas) {
        if (f == 0.0f) {
            return edgeEffect.draw(canvas);
        }
        int iSave = canvas.save();
        canvas.rotate(f);
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    private final RenderNode G2() {
        RenderNode renderNode = this.s;
        if (renderNode != null) {
            return renderNode;
        }
        RenderNode renderNodeA = AbstractC23216wY6.a("AndroidEdgeEffectOverscrollEffect");
        this.s = renderNodeA;
        return renderNodeA;
    }

    private final boolean H2() {
        C10085b32 c10085b32 = this.r;
        return c10085b32.s() || c10085b32.t() || c10085b32.v() || c10085b32.w();
    }

    private final boolean I2() {
        C10085b32 c10085b32 = this.r;
        return c10085b32.z() || c10085b32.A() || c10085b32.p() || c10085b32.q();
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        boolean zC2;
        this.q.q(interfaceC23919xk1.d());
        Canvas canvasD = AbstractC7624Sn.d(interfaceC23919xk1.z1().e());
        this.q.j().getValue();
        if (OD6.k(interfaceC23919xk1.d())) {
            interfaceC23919xk1.N1();
            return;
        }
        if (!canvasD.isHardwareAccelerated()) {
            this.r.f();
            interfaceC23919xk1.N1();
            return;
        }
        float fW1 = interfaceC23919xk1.w1(HV0.b());
        C10085b32 c10085b32 = this.r;
        boolean zI2 = I2();
        boolean zH2 = H2();
        if (zI2 && zH2) {
            G2().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight());
        } else if (zI2) {
            G2().setPosition(0, 0, canvasD.getWidth() + (AbstractC20723sV3.d(fW1) * 2), canvasD.getHeight());
        } else {
            if (!zH2) {
                interfaceC23919xk1.N1();
                return;
            }
            G2().setPosition(0, 0, canvasD.getWidth(), canvasD.getHeight() + (AbstractC20723sV3.d(fW1) * 2));
        }
        RecordingCanvas recordingCanvasBeginRecording = G2().beginRecording();
        if (c10085b32.t()) {
            EdgeEffect edgeEffectJ = c10085b32.j();
            D2(edgeEffectJ, recordingCanvasBeginRecording);
            edgeEffectJ.finish();
        }
        if (c10085b32.s()) {
            EdgeEffect edgeEffectI = c10085b32.i();
            zC2 = C2(edgeEffectI, recordingCanvasBeginRecording);
            if (c10085b32.u()) {
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.q.i() & 4294967295L));
                Z22 z22 = Z22.a;
                z22.e(c10085b32.j(), z22.c(edgeEffectI), 1 - fIntBitsToFloat);
            }
        } else {
            zC2 = false;
        }
        if (c10085b32.A()) {
            EdgeEffect edgeEffectN = c10085b32.n();
            B2(edgeEffectN, recordingCanvasBeginRecording);
            edgeEffectN.finish();
        }
        if (c10085b32.z()) {
            EdgeEffect edgeEffectM = c10085b32.m();
            zC2 = E2(edgeEffectM, recordingCanvasBeginRecording) || zC2;
            if (c10085b32.B()) {
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.q.i() >> 32));
                Z22 z222 = Z22.a;
                z222.e(c10085b32.n(), z222.c(edgeEffectM), fIntBitsToFloat2);
            }
        }
        if (c10085b32.w()) {
            EdgeEffect edgeEffectL = c10085b32.l();
            C2(edgeEffectL, recordingCanvasBeginRecording);
            edgeEffectL.finish();
        }
        if (c10085b32.v()) {
            EdgeEffect edgeEffectK = c10085b32.k();
            zC2 = D2(edgeEffectK, recordingCanvasBeginRecording) || zC2;
            if (c10085b32.x()) {
                float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.q.i() & 4294967295L));
                Z22 z223 = Z22.a;
                z223.e(c10085b32.l(), z223.c(edgeEffectK), fIntBitsToFloat3);
            }
        }
        if (c10085b32.q()) {
            EdgeEffect edgeEffectH = c10085b32.h();
            E2(edgeEffectH, recordingCanvasBeginRecording);
            edgeEffectH.finish();
        }
        if (c10085b32.p()) {
            EdgeEffect edgeEffectG = c10085b32.g();
            boolean z = B2(edgeEffectG, recordingCanvasBeginRecording) || zC2;
            if (c10085b32.r()) {
                float fIntBitsToFloat4 = Float.intBitsToFloat((int) (this.q.i() >> 32));
                Z22 z224 = Z22.a;
                z224.e(c10085b32.h(), z224.c(edgeEffectG), 1 - fIntBitsToFloat4);
            }
            zC2 = z;
        }
        if (zC2) {
            this.q.k();
        }
        float f = zH2 ? 0.0f : fW1;
        if (zI2) {
            fW1 = 0.0f;
        }
        EnumC12613eu3 layoutDirection = interfaceC23919xk1.getLayoutDirection();
        UE0 ue0B = AbstractC7624Sn.b(recordingCanvasBeginRecording);
        long jD = interfaceC23919xk1.d();
        WH1 density = interfaceC23919xk1.z1().getDensity();
        EnumC12613eu3 layoutDirection2 = interfaceC23919xk1.z1().getLayoutDirection();
        UE0 ue0E = interfaceC23919xk1.z1().e();
        long jD2 = interfaceC23919xk1.z1().d();
        C21226tK2 c21226tK2I = interfaceC23919xk1.z1().i();
        YZ1 yz1Z1 = interfaceC23919xk1.z1();
        yz1Z1.f(interfaceC23919xk1);
        yz1Z1.c(layoutDirection);
        yz1Z1.a(ue0B);
        yz1Z1.g(jD);
        yz1Z1.h(null);
        ue0B.n();
        try {
            interfaceC23919xk1.z1().b().c(f, fW1);
            try {
                interfaceC23919xk1.N1();
                float f2 = -f;
                float f3 = -fW1;
                interfaceC23919xk1.z1().b().c(f2, f3);
                ue0B.i();
                YZ1 yz1Z12 = interfaceC23919xk1.z1();
                yz1Z12.f(density);
                yz1Z12.c(layoutDirection2);
                yz1Z12.a(ue0E);
                yz1Z12.g(jD2);
                yz1Z12.h(c21226tK2I);
                G2().endRecording();
                int iSave = canvasD.save();
                canvasD.translate(f2, f3);
                canvasD.drawRenderNode(G2());
                canvasD.restoreToCount(iSave);
            } catch (Throwable th) {
                interfaceC23919xk1.z1().b().c(-f, -fW1);
                throw th;
            }
        } catch (Throwable th2) {
            ue0B.i();
            YZ1 yz1Z13 = interfaceC23919xk1.z1();
            yz1Z13.f(density);
            yz1Z13.c(layoutDirection2);
            yz1Z13.a(ue0E);
            yz1Z13.g(jD2);
            yz1Z13.h(c21226tK2I);
            throw th2;
        }
    }
}
