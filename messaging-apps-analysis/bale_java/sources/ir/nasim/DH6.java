package ir.nasim;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public class DH6 extends AbstractC3236Aa0 {
    private final RectF E;
    private final Paint F;
    private final float[] G;
    private final Path H;
    private final C6970Pt3 I;
    private AbstractC24408ya0 J;
    private AbstractC24408ya0 K;

    DH6(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3) {
        super(qVar, c6970Pt3);
        this.E = new RectF();
        C7430Rr3 c7430Rr3 = new C7430Rr3();
        this.F = c7430Rr3;
        this.G = new float[8];
        this.H = new Path();
        this.I = c6970Pt3;
        c7430Rr3.setAlpha(0);
        c7430Rr3.setStyle(Paint.Style.FILL);
        c7430Rr3.setColor(c6970Pt3.p());
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.K) {
            if (c13505gL3 == null) {
                this.J = null;
                return;
            } else {
                this.J = new C14145hQ7(c13505gL3);
                return;
            }
        }
        if (obj == InterfaceC9661aL3.a) {
            if (c13505gL3 != null) {
                this.K = new C14145hQ7(c13505gL3);
            } else {
                this.K = null;
                this.F.setColor(this.I.p());
            }
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        super.g(rectF, matrix, z);
        this.E.set(0.0f, 0.0f, this.I.r(), this.I.q());
        this.o.mapRect(this.E);
        rectF.set(this.E);
    }

    @Override // ir.nasim.AbstractC3236Aa0
    public void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        int iAlpha = Color.alpha(this.I.p());
        if (iAlpha == 0) {
            return;
        }
        AbstractC24408ya0 abstractC24408ya0 = this.K;
        Integer num = abstractC24408ya0 == null ? null : (Integer) abstractC24408ya0.h();
        if (num != null) {
            this.F.setColor(num.intValue());
        } else {
            this.F.setColor(this.I.p());
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.x.h() == null ? 100 : ((Integer) this.x.h().h()).intValue())) / 100.0f) * 255.0f);
        this.F.setAlpha(iIntValue);
        if (c17470n12 != null) {
            c17470n12.a(this.F);
        } else {
            this.F.clearShadowLayer();
        }
        AbstractC24408ya0 abstractC24408ya02 = this.J;
        if (abstractC24408ya02 != null) {
            this.F.setColorFilter((ColorFilter) abstractC24408ya02.h());
        }
        if (iIntValue > 0) {
            float[] fArr = this.G;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.I.r();
            float[] fArr2 = this.G;
            fArr2[3] = 0.0f;
            fArr2[4] = this.I.r();
            this.G[5] = this.I.q();
            float[] fArr3 = this.G;
            fArr3[6] = 0.0f;
            fArr3[7] = this.I.q();
            matrix.mapPoints(this.G);
            this.H.reset();
            Path path = this.H;
            float[] fArr4 = this.G;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.H;
            float[] fArr5 = this.G;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.H;
            float[] fArr6 = this.G;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.H;
            float[] fArr7 = this.G;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.H;
            float[] fArr8 = this.G;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.H.close();
            canvas.drawPath(this.H, this.F);
        }
    }
}
