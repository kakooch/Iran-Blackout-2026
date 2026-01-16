package ir.nasim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import ir.nasim.YG4;

/* renamed from: ir.nasim.e23, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12099e23 extends AbstractC3236Aa0 {
    private final Paint E;
    private final Rect F;
    private final Rect G;
    private final RectF H;
    private final VK3 I;
    private AbstractC24408ya0 J;
    private AbstractC24408ya0 K;
    private C19243q12 L;
    private YG4 M;
    private YG4.a N;

    C12099e23(com.airbnb.lottie.q qVar, C6970Pt3 c6970Pt3) {
        super(qVar, c6970Pt3);
        this.E = new C7430Rr3(3);
        this.F = new Rect();
        this.G = new Rect();
        this.H = new RectF();
        this.I = qVar.T(c6970Pt3.n());
        if (z() != null) {
            this.L = new C19243q12(this, this, z());
        }
    }

    private Bitmap R() {
        Bitmap bitmap;
        AbstractC24408ya0 abstractC24408ya0 = this.K;
        if (abstractC24408ya0 != null && (bitmap = (Bitmap) abstractC24408ya0.h()) != null) {
            return bitmap;
        }
        Bitmap bitmapK = this.p.K(this.q.n());
        if (bitmapK != null) {
            return bitmapK;
        }
        VK3 vk3 = this.I;
        if (vk3 != null) {
            return vk3.b();
        }
        return null;
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        C19243q12 c19243q12;
        C19243q12 c19243q122;
        C19243q12 c19243q123;
        C19243q12 c19243q124;
        C19243q12 c19243q125;
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
        if (obj == InterfaceC9661aL3.N) {
            if (c13505gL3 == null) {
                this.K = null;
                return;
            } else {
                this.K = new C14145hQ7(c13505gL3);
                return;
            }
        }
        if (obj == InterfaceC9661aL3.e && (c19243q125 = this.L) != null) {
            c19243q125.c(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.G && (c19243q124 = this.L) != null) {
            c19243q124.f(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.H && (c19243q123 = this.L) != null) {
            c19243q123.d(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.I && (c19243q122 = this.L) != null) {
            c19243q122.e(c13505gL3);
        } else {
            if (obj != InterfaceC9661aL3.J || (c19243q12 = this.L) == null) {
                return;
            }
            c19243q12.g(c13505gL3);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0, ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        Bitmap bitmapR;
        super.g(rectF, matrix, z);
        if (this.I != null) {
            float fE = AbstractC16500lN7.e();
            if (this.p.U() || (bitmapR = R()) == null) {
                rectF.set(0.0f, 0.0f, this.I.f() * fE, this.I.d() * fE);
            } else {
                rectF.set(0.0f, 0.0f, bitmapR.getWidth() * fE, bitmapR.getHeight() * fE);
            }
            this.o.mapRect(rectF);
        }
    }

    @Override // ir.nasim.AbstractC3236Aa0
    public void u(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        Bitmap bitmapR = R();
        if (bitmapR == null || bitmapR.isRecycled() || this.I == null) {
            return;
        }
        float fE = AbstractC16500lN7.e();
        this.E.setAlpha(i);
        AbstractC24408ya0 abstractC24408ya0 = this.J;
        if (abstractC24408ya0 != null) {
            this.E.setColorFilter((ColorFilter) abstractC24408ya0.h());
        }
        C19243q12 c19243q12 = this.L;
        if (c19243q12 != null) {
            c17470n12 = c19243q12.b(matrix, i);
        }
        this.F.set(0, 0, bitmapR.getWidth(), bitmapR.getHeight());
        if (this.p.U()) {
            this.G.set(0, 0, (int) (this.I.f() * fE), (int) (this.I.d() * fE));
        } else {
            this.G.set(0, 0, (int) (bitmapR.getWidth() * fE), (int) (bitmapR.getHeight() * fE));
        }
        boolean z = c17470n12 != null;
        if (z) {
            if (this.M == null) {
                this.M = new YG4();
            }
            if (this.N == null) {
                this.N = new YG4.a();
            }
            this.N.f();
            c17470n12.d(i, this.N);
            RectF rectF = this.H;
            Rect rect = this.G;
            rectF.set(rect.left, rect.top, rect.right, rect.bottom);
            matrix.mapRect(this.H);
            canvas = this.M.j(canvas, this.H, this.N);
        }
        canvas.save();
        canvas.concat(matrix);
        canvas.drawBitmap(bitmapR, this.F, this.G, this.E);
        if (z) {
            this.M.e();
            if (this.M.f()) {
                return;
            }
        }
        canvas.restore();
    }
}
