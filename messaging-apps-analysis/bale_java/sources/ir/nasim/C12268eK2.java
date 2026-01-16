package ir.nasim;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;

/* renamed from: ir.nasim.eK2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C12268eK2 extends AbstractC9242Zc0 {
    private C14145hQ7 A;
    private final String q;
    private final boolean r;
    private final C21892uJ3 s;
    private final C21892uJ3 t;
    private final RectF u;
    private final EnumC13495gK2 v;
    private final int w;
    private final AbstractC24408ya0 x;
    private final AbstractC24408ya0 y;
    private final AbstractC24408ya0 z;

    public C12268eK2(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C11625dK2 c11625dK2) {
        super(qVar, abstractC3236Aa0, c11625dK2.b().j(), c11625dK2.g().j(), c11625dK2.i(), c11625dK2.k(), c11625dK2.m(), c11625dK2.h(), c11625dK2.c());
        this.s = new C21892uJ3();
        this.t = new C21892uJ3();
        this.u = new RectF();
        this.q = c11625dK2.j();
        this.v = c11625dK2.f();
        this.r = c11625dK2.n();
        this.w = (int) (qVar.N().d() / 32.0f);
        AbstractC24408ya0 abstractC24408ya0J = c11625dK2.e().j();
        this.x = abstractC24408ya0J;
        abstractC24408ya0J.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J);
        AbstractC24408ya0 abstractC24408ya0J2 = c11625dK2.l().j();
        this.y = abstractC24408ya0J2;
        abstractC24408ya0J2.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J2);
        AbstractC24408ya0 abstractC24408ya0J3 = c11625dK2.d().j();
        this.z = abstractC24408ya0J3;
        abstractC24408ya0J3.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J3);
    }

    private int[] k(int[] iArr) {
        C14145hQ7 c14145hQ7 = this.A;
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

    private int l() {
        int iRound = Math.round(this.y.f() * this.w);
        int iRound2 = Math.round(this.z.f() * this.w);
        int iRound3 = Math.round(this.x.f() * this.w);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private LinearGradient m() {
        long jL = l();
        LinearGradient linearGradient = (LinearGradient) this.s.f(jL);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointF = (PointF) this.y.h();
        PointF pointF2 = (PointF) this.z.h();
        WJ2 wj2 = (WJ2) this.x.h();
        LinearGradient linearGradient2 = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, k(wj2.d()), wj2.e(), Shader.TileMode.CLAMP);
        this.s.l(jL, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient n() {
        long jL = l();
        RadialGradient radialGradient = (RadialGradient) this.t.f(jL);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointF = (PointF) this.y.h();
        PointF pointF2 = (PointF) this.z.h();
        WJ2 wj2 = (WJ2) this.x.h();
        int[] iArrK = k(wj2.d());
        float[] fArrE = wj2.e();
        RadialGradient radialGradient2 = new RadialGradient(pointF.x, pointF.y, (float) Math.hypot(pointF2.x - r7, pointF2.y - r8), iArrK, fArrE, Shader.TileMode.CLAMP);
        this.t.l(jL, radialGradient2);
        return radialGradient2;
    }

    @Override // ir.nasim.AbstractC9242Zc0, ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        super.c(obj, c13505gL3);
        if (obj == InterfaceC9661aL3.L) {
            C14145hQ7 c14145hQ7 = this.A;
            if (c14145hQ7 != null) {
                this.f.J(c14145hQ7);
            }
            if (c13505gL3 == null) {
                this.A = null;
                return;
            }
            C14145hQ7 c14145hQ72 = new C14145hQ7(c13505gL3);
            this.A = c14145hQ72;
            c14145hQ72.a(this);
            this.f.j(this.A);
        }
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.q;
    }

    @Override // ir.nasim.AbstractC9242Zc0, ir.nasim.V02
    public void i(Canvas canvas, Matrix matrix, int i, C17470n12 c17470n12) {
        if (this.r) {
            return;
        }
        g(this.u, matrix, false);
        this.i.setShader(this.v == EnumC13495gK2.LINEAR ? m() : n());
        super.i(canvas, matrix, i, c17470n12);
    }
}
