package ir.nasim;

import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* renamed from: ir.nasim.zJ2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C24851zJ2 extends RG1 implements InterfaceC15687k02 {
    private final C8340Vo q;
    private final C10085b32 r;
    private final TS4 s;

    public C24851zJ2(JG1 jg1, C8340Vo c8340Vo, C10085b32 c10085b32, TS4 ts4) {
        this.q = c8340Vo;
        this.r = c10085b32;
        this.s = ts4;
        v2(jg1);
    }

    private final boolean B2(InterfaceC17460n02 interfaceC17460n02, EdgeEffect edgeEffect, Canvas canvas) {
        float fW1 = interfaceC17460n02.w1(this.s.a());
        float f = -Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
        float f2 = (-Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L))) + fW1;
        return F2(180.0f, ZG4.e((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)), edgeEffect, canvas);
    }

    private final boolean C2(InterfaceC17460n02 interfaceC17460n02, EdgeEffect edgeEffect, Canvas canvas) {
        float f = -Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
        float fW1 = interfaceC17460n02.w1(this.s.d(interfaceC17460n02.getLayoutDirection()));
        return F2(270.0f, ZG4.e((Float.floatToRawIntBits(f) << 32) | (4294967295L & Float.floatToRawIntBits(fW1))), edgeEffect, canvas);
    }

    private final boolean D2(InterfaceC17460n02 interfaceC17460n02, EdgeEffect edgeEffect, Canvas canvas) {
        float fW1 = (-AbstractC20723sV3.d(Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32)))) + interfaceC17460n02.w1(this.s.b(interfaceC17460n02.getLayoutDirection()));
        return F2(90.0f, ZG4.e((Float.floatToRawIntBits(fW1) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32)), edgeEffect, canvas);
    }

    private final boolean E2(InterfaceC17460n02 interfaceC17460n02, EdgeEffect edgeEffect, Canvas canvas) {
        float fW1 = interfaceC17460n02.w1(this.s.c());
        return F2(0.0f, ZG4.e((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(fW1) & 4294967295L)), edgeEffect, canvas);
    }

    private final boolean F2(float f, long j, EdgeEffect edgeEffect, Canvas canvas) {
        int iSave = canvas.save();
        canvas.rotate(f);
        canvas.translate(Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)));
        boolean zDraw = edgeEffect.draw(canvas);
        canvas.restoreToCount(iSave);
        return zDraw;
    }

    @Override // ir.nasim.InterfaceC15687k02
    public void o(InterfaceC23919xk1 interfaceC23919xk1) {
        this.q.q(interfaceC23919xk1.d());
        if (OD6.k(interfaceC23919xk1.d())) {
            interfaceC23919xk1.N1();
            return;
        }
        interfaceC23919xk1.N1();
        this.q.j().getValue();
        Canvas canvasD = AbstractC7624Sn.d(interfaceC23919xk1.z1().e());
        C10085b32 c10085b32 = this.r;
        boolean zC2 = c10085b32.s() ? C2(interfaceC23919xk1, c10085b32.i(), canvasD) : false;
        if (c10085b32.z()) {
            zC2 = E2(interfaceC23919xk1, c10085b32.m(), canvasD) || zC2;
        }
        if (c10085b32.v()) {
            zC2 = D2(interfaceC23919xk1, c10085b32.k(), canvasD) || zC2;
        }
        if (c10085b32.p()) {
            zC2 = B2(interfaceC23919xk1, c10085b32.g(), canvasD) || zC2;
        }
        if (zC2) {
            this.q.k();
        }
    }
}
