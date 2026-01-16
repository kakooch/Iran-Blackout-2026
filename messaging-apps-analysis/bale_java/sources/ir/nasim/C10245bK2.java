package ir.nasim;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import ir.nasim.AbstractC24408ya0;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.bK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C10245bK2 implements V02, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final String a;
    private final boolean b;
    private final AbstractC3236Aa0 c;
    private final C21892uJ3 d = new C21892uJ3();
    private final C21892uJ3 e = new C21892uJ3();
    private final Path f;
    private final Paint g;
    private final RectF h;
    private final List i;
    private final EnumC13495gK2 j;
    private final AbstractC24408ya0 k;
    private final AbstractC24408ya0 l;
    private final AbstractC24408ya0 m;
    private final AbstractC24408ya0 n;
    private AbstractC24408ya0 o;
    private C14145hQ7 p;
    private final com.airbnb.lottie.q q;
    private final int r;
    private AbstractC24408ya0 s;
    float t;

    public C10245bK2(com.airbnb.lottie.q qVar, C23677xK3 c23677xK3, AbstractC3236Aa0 abstractC3236Aa0, C9651aK2 c9651aK2) {
        Path path = new Path();
        this.f = path;
        this.g = new C7430Rr3(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.t = 0.0f;
        this.c = abstractC3236Aa0;
        this.a = c9651aK2.f();
        this.b = c9651aK2.i();
        this.q = qVar;
        this.j = c9651aK2.e();
        path.setFillType(c9651aK2.c());
        this.r = (int) (c23677xK3.d() / 32.0f);
        AbstractC24408ya0 abstractC24408ya0J = c9651aK2.d().j();
        this.k = abstractC24408ya0J;
        abstractC24408ya0J.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J);
        AbstractC24408ya0 abstractC24408ya0J2 = c9651aK2.g().j();
        this.l = abstractC24408ya0J2;
        abstractC24408ya0J2.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J2);
        AbstractC24408ya0 abstractC24408ya0J3 = c9651aK2.h().j();
        this.m = abstractC24408ya0J3;
        abstractC24408ya0J3.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J3);
        AbstractC24408ya0 abstractC24408ya0J4 = c9651aK2.b().j();
        this.n = abstractC24408ya0J4;
        abstractC24408ya0J4.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J4);
        if (abstractC3236Aa0.x() != null) {
            C11959dq2 c11959dq2J = abstractC3236Aa0.x().a().j();
            this.s = c11959dq2J;
            c11959dq2J.a(this);
            abstractC3236Aa0.j(this.s);
        }
    }

    private int[] h(int[] iArr) {
        C14145hQ7 c14145hQ7 = this.p;
        if (c14145hQ7 != null) {
            Integer[] numArr = (Integer[]) c14145hQ7.h();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    private int j() {
        int iRound = Math.round(this.m.f() * this.r);
        int iRound2 = Math.round(this.n.f() * this.r);
        int iRound3 = Math.round(this.k.f() * this.r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private LinearGradient k() {
        float[] fArr;
        int[] iArr;
        long j = j();
        LinearGradient linearGradient = (LinearGradient) this.d.f(j);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        WJ2 wj2 = (WJ2) this.k.h();
        int[] iArrH = h(wj2.d());
        float[] fArrE = wj2.e();
        if (iArrH.length < 2) {
            iArr = new int[]{iArrH[0], iArrH[0]};
            fArr = new float[]{0.0f, 1.0f};
        } else {
            fArr = fArrE;
            iArr = iArrH;
        }
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, iArr, fArr, Shader.TileMode.CLAMP);
        this.d.l(j, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient l() {
        float[] fArr;
        int[] iArr;
        long j = j();
        RadialGradient radialGradient = (RadialGradient) this.e.f(j);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.m.h();
        PointF pointF2 = (PointF) this.n.h();
        WJ2 wj2 = (WJ2) this.k.h();
        int[] iArrH = h(wj2.d());
        float[] fArrE = wj2.e();
        if (iArrH.length < 2) {
            iArr = new int[]{iArrH[0], iArrH[0]};
            fArr = new float[]{0.0f, 1.0f};
        } else {
            fArr = fArrE;
            iArr = iArrH;
        }
        float f = pointF.x;
        float f2 = pointF.y;
        float fHypot = (float) Math.hypot(pointF2.x - f, pointF2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArr, fArr, Shader.TileMode.CLAMP);
        this.e.l(j, radialGradient2);
        return radialGradient2;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        for (int i = 0; i < list2.size(); i++) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) list2.get(i);
            if (interfaceC14939ik1 instanceof InterfaceC13318g15) {
                this.i.add((InterfaceC13318g15) interfaceC14939ik1);
            }
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.d) {
            this.l.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.K) {
            AbstractC24408ya0 abstractC24408ya0 = this.o;
            if (abstractC24408ya0 != null) {
                this.c.J(abstractC24408ya0);
            }
            if (c13505gL3 == null) {
                this.o = null;
                return;
            }
            C14145hQ7 c14145hQ7 = new C14145hQ7(c13505gL3);
            this.o = c14145hQ7;
            c14145hQ7.a(this);
            this.c.j(this.o);
            return;
        }
        if (obj != InterfaceC9661aL3.L) {
            if (obj == InterfaceC9661aL3.j) {
                AbstractC24408ya0 abstractC24408ya02 = this.s;
                if (abstractC24408ya02 != null) {
                    abstractC24408ya02.o(c13505gL3);
                    return;
                }
                C14145hQ7 c14145hQ72 = new C14145hQ7(c13505gL3);
                this.s = c14145hQ72;
                c14145hQ72.a(this);
                this.c.j(this.s);
                return;
            }
            return;
        }
        C14145hQ7 c14145hQ73 = this.p;
        if (c14145hQ73 != null) {
            this.c.J(c14145hQ73);
        }
        if (c13505gL3 == null) {
            this.p = null;
            return;
        }
        this.d.c();
        this.e.c();
        C14145hQ7 c14145hQ74 = new C14145hQ7(c13505gL3);
        this.p = c14145hQ74;
        c14145hQ74.a(this);
        this.c.j(this.p);
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.V02
    public void g(RectF rectF, Matrix matrix, boolean z) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(((InterfaceC13318g15) this.i.get(i)).A(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.a;
    }

    @Override // ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (this.b) {
            return;
        }
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.b("GradientFillContent#draw");
        }
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(((InterfaceC13318g15) this.i.get(i2)).A(), matrix);
        }
        this.f.computeBounds(this.h, false);
        Shader shaderK = this.j == EnumC13495gK2.LINEAR ? k() : l();
        shaderK.setLocalMatrix(matrix);
        this.g.setShader(shaderK);
        AbstractC24408ya0 abstractC24408ya0 = this.o;
        if (abstractC24408ya0 != null) {
            this.g.setColorFilter((ColorFilter) abstractC24408ya0.h());
        }
        AbstractC24408ya0 abstractC24408ya02 = this.s;
        if (abstractC24408ya02 != null) {
            float fFloatValue = ((Float) abstractC24408ya02.h()).floatValue();
            if (fFloatValue == 0.0f) {
                this.g.setMaskFilter(null);
            } else if (fFloatValue != this.t) {
                this.g.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.t = fFloatValue;
        }
        float fIntValue = ((Integer) this.l.h()).intValue() / 100.0f;
        this.g.setAlpha(AbstractC7323Rf4.c((int) (i * fIntValue), 0, 255));
        if (c17470n12 != null) {
            c17470n12.c((int) (fIntValue * 255.0f), this.g);
        }
        canvas.drawPath(this.f, this.g);
        if (AbstractC6219Mr3.h()) {
            AbstractC6219Mr3.c("GradientFillContent#draw");
        }
    }
}
