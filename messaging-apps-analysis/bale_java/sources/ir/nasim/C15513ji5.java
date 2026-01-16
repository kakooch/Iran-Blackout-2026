package ir.nasim;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import ir.nasim.AbstractC24408ya0;
import ir.nasim.C16104ki5;
import ir.nasim.C4156Dx6;
import java.util.List;

/* renamed from: ir.nasim.ji5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C15513ji5 implements InterfaceC13318g15, AbstractC24408ya0.b, InterfaceC5491Jo3 {
    private final String e;
    private final com.airbnb.lottie.q f;
    private final C16104ki5.a g;
    private final boolean h;
    private final boolean i;
    private final AbstractC24408ya0 j;
    private final AbstractC24408ya0 k;
    private final AbstractC24408ya0 l;
    private final AbstractC24408ya0 m;
    private final AbstractC24408ya0 n;
    private final AbstractC24408ya0 o;
    private final AbstractC24408ya0 p;
    private boolean r;
    private final Path a = new Path();
    private final Path b = new Path();
    private final PathMeasure c = new PathMeasure();
    private final float[] d = new float[2];
    private final C17813nc1 q = new C17813nc1();

    /* renamed from: ir.nasim.ji5$a */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[C16104ki5.a.values().length];
            a = iArr;
            try {
                iArr[C16104ki5.a.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[C16104ki5.a.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C15513ji5(com.airbnb.lottie.q qVar, AbstractC3236Aa0 abstractC3236Aa0, C16104ki5 c16104ki5) {
        this.f = qVar;
        this.e = c16104ki5.d();
        C16104ki5.a aVarJ = c16104ki5.j();
        this.g = aVarJ;
        this.h = c16104ki5.k();
        this.i = c16104ki5.l();
        C11959dq2 c11959dq2J = c16104ki5.g().j();
        this.j = c11959dq2J;
        AbstractC24408ya0 abstractC24408ya0J = c16104ki5.h().j();
        this.k = abstractC24408ya0J;
        C11959dq2 c11959dq2J2 = c16104ki5.i().j();
        this.l = c11959dq2J2;
        C11959dq2 c11959dq2J3 = c16104ki5.e().j();
        this.n = c11959dq2J3;
        C11959dq2 c11959dq2J4 = c16104ki5.f().j();
        this.p = c11959dq2J4;
        C16104ki5.a aVar = C16104ki5.a.STAR;
        if (aVarJ == aVar) {
            this.m = c16104ki5.b().j();
            this.o = c16104ki5.c().j();
        } else {
            this.m = null;
            this.o = null;
        }
        abstractC3236Aa0.j(c11959dq2J);
        abstractC3236Aa0.j(abstractC24408ya0J);
        abstractC3236Aa0.j(c11959dq2J2);
        abstractC3236Aa0.j(c11959dq2J3);
        abstractC3236Aa0.j(c11959dq2J4);
        if (aVarJ == aVar) {
            abstractC3236Aa0.j(this.m);
            abstractC3236Aa0.j(this.o);
        }
        c11959dq2J.a(this);
        abstractC24408ya0J.a(this);
        c11959dq2J2.a(this);
        c11959dq2J3.a(this);
        c11959dq2J4.a(this);
        if (aVarJ == aVar) {
            this.m.a(this);
            this.o.a(this);
        }
    }

    private void h() {
        double d;
        float f;
        C15513ji5 c15513ji5;
        C15513ji5 c15513ji52 = this;
        int iFloor = (int) Math.floor(((Float) c15513ji52.j.h()).floatValue());
        double radians = Math.toRadians((c15513ji52.l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d2 = iFloor;
        float fFloatValue = ((Float) c15513ji52.p.h()).floatValue() / 100.0f;
        float fFloatValue2 = ((Float) c15513ji52.n.h()).floatValue();
        double d3 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d3);
        float fSin = (float) (Math.sin(radians) * d3);
        c15513ji52.a.moveTo(fCos, fSin);
        double d4 = (float) (6.283185307179586d / d2);
        double dCeil = Math.ceil(d2);
        double d5 = radians + d4;
        int i = 0;
        while (true) {
            double d6 = i;
            if (d6 >= dCeil) {
                C15513ji5 c15513ji53 = c15513ji52;
                PointF pointF = (PointF) c15513ji53.k.h();
                c15513ji53.a.offset(pointF.x, pointF.y);
                c15513ji53.a.close();
                return;
            }
            int i2 = i;
            float fCos2 = (float) (d3 * Math.cos(d5));
            double d7 = d4;
            float fSin2 = (float) (d3 * Math.sin(d5));
            if (fFloatValue != 0.0f) {
                d = d3;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                f = fSin2;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f2 = fFloatValue2 * fFloatValue * 0.25f;
                float f3 = fCos3 * f2;
                float f4 = fSin3 * f2;
                float fCos4 = ((float) Math.cos(dAtan22)) * f2;
                float fSin4 = f2 * ((float) Math.sin(dAtan22));
                if (d6 == dCeil - 1.0d) {
                    c15513ji5 = this;
                    c15513ji5.b.reset();
                    c15513ji5.b.moveTo(fCos, fSin);
                    float f5 = fCos - f3;
                    float f6 = fSin - f4;
                    float f7 = fCos2 + fCos4;
                    float f8 = fSin4 + f;
                    c15513ji5.b.cubicTo(f5, f6, f7, f8, fCos2, f);
                    c15513ji5.c.setPath(c15513ji5.b, false);
                    PathMeasure pathMeasure = c15513ji5.c;
                    pathMeasure.getPosTan(pathMeasure.getLength() * 0.9999f, c15513ji5.d, null);
                    Path path = c15513ji5.a;
                    float[] fArr = c15513ji5.d;
                    path.cubicTo(f5, f6, f7, f8, fArr[0], fArr[1]);
                } else {
                    c15513ji5 = this;
                    c15513ji5.a.cubicTo(fCos - f3, fSin - f4, fCos2 + fCos4, f + fSin4, fCos2, f);
                }
            } else {
                d = d3;
                f = fSin2;
                c15513ji5 = c15513ji52;
                if (d6 == dCeil - 1.0d) {
                    fSin = f;
                    fCos = fCos2;
                    d4 = d7;
                    i = i2 + 1;
                    c15513ji52 = c15513ji5;
                    d3 = d;
                } else {
                    c15513ji5.a.lineTo(fCos2, f);
                }
            }
            d5 += d7;
            fSin = f;
            fCos = fCos2;
            d4 = d7;
            i = i2 + 1;
            c15513ji52 = c15513ji5;
            d3 = d;
        }
    }

    private void j() {
        int i;
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        double d3;
        float fFloatValue = ((Float) this.j.h()).floatValue();
        double radians = Math.toRadians((this.l == null ? 0.0d : ((Float) r2.h()).floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f9 = (float) (6.283185307179586d / d4);
        if (this.i) {
            f9 *= -1.0f;
        }
        float f10 = f9 / 2.0f;
        float f11 = fFloatValue - ((int) fFloatValue);
        int i2 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (1.0f - f11) * f10;
        }
        float fFloatValue2 = ((Float) this.n.h()).floatValue();
        float fFloatValue3 = ((Float) this.m.h()).floatValue();
        AbstractC24408ya0 abstractC24408ya0 = this.o;
        float fFloatValue4 = abstractC24408ya0 != null ? ((Float) abstractC24408ya0.h()).floatValue() / 100.0f : 0.0f;
        AbstractC24408ya0 abstractC24408ya02 = this.p;
        float fFloatValue5 = abstractC24408ya02 != null ? ((Float) abstractC24408ya02.h()).floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((fFloatValue2 - fFloatValue3) * f11) + fFloatValue3;
            i = i2;
            double d5 = f3;
            float fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.a.moveTo(fCos, fSin);
            d = radians + ((f9 * f11) / 2.0f);
            f = fCos;
            f2 = f10;
        } else {
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.a.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f10;
            d = radians + f2;
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f12 = f2;
        float f13 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 >= dCeil) {
                PointF pointF = (PointF) this.k.h();
                this.a.offset(pointF.x, pointF.y);
                this.a.close();
                return;
            }
            float f14 = z ? fFloatValue2 : fFloatValue3;
            if (f3 == 0.0f || d7 != dCeil - 2.0d) {
                f4 = f9;
                f5 = f12;
            } else {
                f4 = f9;
                f5 = (f9 * f11) / 2.0f;
            }
            if (f3 == 0.0f || d7 != dCeil - 1.0d) {
                d2 = d7;
                f6 = f3;
                f3 = f14;
            } else {
                d2 = d7;
                f6 = f3;
            }
            double d8 = f3;
            double d9 = dCeil;
            float fCos3 = (float) (d8 * Math.cos(d));
            float fSin3 = (float) (d8 * Math.sin(d));
            if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                this.a.lineTo(fCos3, fSin3);
                d3 = d;
                f7 = fFloatValue4;
                f8 = fFloatValue5;
            } else {
                f7 = fFloatValue4;
                double dAtan2 = (float) (Math.atan2(fSin, f13) - 1.5707963267948966d);
                float fCos4 = (float) Math.cos(dAtan2);
                float fSin4 = (float) Math.sin(dAtan2);
                f8 = fFloatValue5;
                d3 = d;
                double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                float fCos5 = (float) Math.cos(dAtan22);
                float fSin5 = (float) Math.sin(dAtan22);
                float f15 = z ? f7 : f8;
                float f16 = z ? f8 : f7;
                float f17 = (z ? fFloatValue3 : fFloatValue2) * f15 * 0.47829f;
                float f18 = fCos4 * f17;
                float f19 = f17 * fSin4;
                float f20 = (z ? fFloatValue2 : fFloatValue3) * f16 * 0.47829f;
                float f21 = fCos5 * f20;
                float f22 = f20 * fSin5;
                if (i != 0) {
                    if (i3 == 0) {
                        f18 *= f11;
                        f19 *= f11;
                    } else if (d2 == d9 - 1.0d) {
                        f21 *= f11;
                        f22 *= f11;
                    }
                }
                this.a.cubicTo(f13 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
            }
            d = d3 + f5;
            z = !z;
            i3++;
            f13 = fCos3;
            fSin = fSin3;
            fFloatValue5 = f8;
            fFloatValue4 = f7;
            f3 = f6;
            f9 = f4;
            dCeil = d9;
        }
    }

    private void k() {
        this.r = false;
        this.f.invalidateSelf();
    }

    @Override // ir.nasim.InterfaceC13318g15
    public Path A() {
        if (this.r) {
            return this.a;
        }
        this.a.reset();
        if (this.h) {
            this.r = true;
            return this.a;
        }
        int i = a.a[this.g.ordinal()];
        if (i == 1) {
            j();
        } else if (i == 2) {
            h();
        }
        this.a.close();
        this.q.b(this.a);
        this.r = true;
        return this.a;
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        k();
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public void b(List list, List list2) {
        for (int i = 0; i < list.size(); i++) {
            InterfaceC14939ik1 interfaceC14939ik1 = (InterfaceC14939ik1) list.get(i);
            if (interfaceC14939ik1 instanceof C16837lw7) {
                C16837lw7 c16837lw7 = (C16837lw7) interfaceC14939ik1;
                if (c16837lw7.k() == C4156Dx6.a.SIMULTANEOUSLY) {
                    this.q.a(c16837lw7);
                    c16837lw7.c(this);
                }
            }
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void c(Object obj, C13505gL3 c13505gL3) {
        AbstractC24408ya0 abstractC24408ya0;
        AbstractC24408ya0 abstractC24408ya02;
        if (obj == InterfaceC9661aL3.w) {
            this.j.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.x) {
            this.l.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.n) {
            this.k.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.y && (abstractC24408ya02 = this.m) != null) {
            abstractC24408ya02.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.z) {
            this.n.o(c13505gL3);
            return;
        }
        if (obj == InterfaceC9661aL3.A && (abstractC24408ya0 = this.o) != null) {
            abstractC24408ya0.o(c13505gL3);
        } else if (obj == InterfaceC9661aL3.B) {
            this.p.o(c13505gL3);
        }
    }

    @Override // ir.nasim.InterfaceC5257Io3
    public void f(C5023Ho3 c5023Ho3, int i, List list, C5023Ho3 c5023Ho32) {
        AbstractC7323Rf4.k(c5023Ho3, i, list, c5023Ho32, this);
    }

    @Override // ir.nasim.InterfaceC14939ik1
    public String getName() {
        return this.e;
    }
}
