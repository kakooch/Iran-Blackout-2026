package ir.nasim;

import android.graphics.Matrix;
import android.graphics.PointF;
import ir.nasim.AbstractC24408ya0;
import java.util.Collections;

/* renamed from: ir.nasim.fv7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C13263fv7 {
    private final Matrix a = new Matrix();
    private final Matrix b;
    private final Matrix c;
    private final Matrix d;
    private final float[] e;
    private AbstractC24408ya0 f;
    private AbstractC24408ya0 g;
    private AbstractC24408ya0 h;
    private AbstractC24408ya0 i;
    private AbstractC24408ya0 j;
    private C11959dq2 k;
    private C11959dq2 l;
    private AbstractC24408ya0 m;
    private AbstractC24408ya0 n;
    private final boolean o;

    public C13263fv7(C3636Bs c3636Bs) {
        this.f = c3636Bs.c() == null ? null : c3636Bs.c().j();
        this.g = c3636Bs.f() == null ? null : c3636Bs.f().j();
        this.h = c3636Bs.h() == null ? null : c3636Bs.h().j();
        this.i = c3636Bs.g() == null ? null : c3636Bs.g().j();
        this.k = c3636Bs.i() == null ? null : c3636Bs.i().j();
        this.o = c3636Bs.l();
        if (this.k != null) {
            this.b = new Matrix();
            this.c = new Matrix();
            this.d = new Matrix();
            this.e = new float[9];
        } else {
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
        this.l = c3636Bs.j() == null ? null : c3636Bs.j().j();
        if (c3636Bs.e() != null) {
            this.j = c3636Bs.e().j();
        }
        if (c3636Bs.k() != null) {
            this.m = c3636Bs.k().j();
        } else {
            this.m = null;
        }
        if (c3636Bs.d() != null) {
            this.n = c3636Bs.d().j();
        } else {
            this.n = null;
        }
    }

    private void d() {
        for (int i = 0; i < 9; i++) {
            this.e[i] = 0.0f;
        }
    }

    public void a(AbstractC3236Aa0 abstractC3236Aa0) {
        abstractC3236Aa0.j(this.j);
        abstractC3236Aa0.j(this.m);
        abstractC3236Aa0.j(this.n);
        abstractC3236Aa0.j(this.f);
        abstractC3236Aa0.j(this.g);
        abstractC3236Aa0.j(this.h);
        abstractC3236Aa0.j(this.i);
        abstractC3236Aa0.j(this.k);
        abstractC3236Aa0.j(this.l);
    }

    public void b(AbstractC24408ya0.b bVar) {
        AbstractC24408ya0 abstractC24408ya0 = this.j;
        if (abstractC24408ya0 != null) {
            abstractC24408ya0.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya02 = this.m;
        if (abstractC24408ya02 != null) {
            abstractC24408ya02.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya03 = this.n;
        if (abstractC24408ya03 != null) {
            abstractC24408ya03.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya04 = this.f;
        if (abstractC24408ya04 != null) {
            abstractC24408ya04.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya05 = this.g;
        if (abstractC24408ya05 != null) {
            abstractC24408ya05.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya06 = this.h;
        if (abstractC24408ya06 != null) {
            abstractC24408ya06.a(bVar);
        }
        AbstractC24408ya0 abstractC24408ya07 = this.i;
        if (abstractC24408ya07 != null) {
            abstractC24408ya07.a(bVar);
        }
        C11959dq2 c11959dq2 = this.k;
        if (c11959dq2 != null) {
            c11959dq2.a(bVar);
        }
        C11959dq2 c11959dq22 = this.l;
        if (c11959dq22 != null) {
            c11959dq22.a(bVar);
        }
    }

    public boolean c(Object obj, C13505gL3 c13505gL3) {
        if (obj == InterfaceC9661aL3.f) {
            AbstractC24408ya0 abstractC24408ya0 = this.f;
            if (abstractC24408ya0 == null) {
                this.f = new C14145hQ7(c13505gL3, new PointF());
                return true;
            }
            abstractC24408ya0.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.g) {
            AbstractC24408ya0 abstractC24408ya02 = this.g;
            if (abstractC24408ya02 == null) {
                this.g = new C14145hQ7(c13505gL3, new PointF());
                return true;
            }
            abstractC24408ya02.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.h) {
            AbstractC24408ya0 abstractC24408ya03 = this.g;
            if (abstractC24408ya03 instanceof OI6) {
                ((OI6) abstractC24408ya03).t(c13505gL3);
                return true;
            }
        }
        if (obj == InterfaceC9661aL3.i) {
            AbstractC24408ya0 abstractC24408ya04 = this.g;
            if (abstractC24408ya04 instanceof OI6) {
                ((OI6) abstractC24408ya04).u(c13505gL3);
                return true;
            }
        }
        if (obj == InterfaceC9661aL3.o) {
            AbstractC24408ya0 abstractC24408ya05 = this.h;
            if (abstractC24408ya05 == null) {
                this.h = new C14145hQ7(c13505gL3, new C19591qc6());
                return true;
            }
            abstractC24408ya05.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.p) {
            AbstractC24408ya0 abstractC24408ya06 = this.i;
            if (abstractC24408ya06 == null) {
                this.i = new C14145hQ7(c13505gL3, Float.valueOf(0.0f));
                return true;
            }
            abstractC24408ya06.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.c) {
            AbstractC24408ya0 abstractC24408ya07 = this.j;
            if (abstractC24408ya07 == null) {
                this.j = new C14145hQ7(c13505gL3, 100);
                return true;
            }
            abstractC24408ya07.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.C) {
            AbstractC24408ya0 abstractC24408ya08 = this.m;
            if (abstractC24408ya08 == null) {
                this.m = new C14145hQ7(c13505gL3, Float.valueOf(100.0f));
                return true;
            }
            abstractC24408ya08.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.D) {
            AbstractC24408ya0 abstractC24408ya09 = this.n;
            if (abstractC24408ya09 == null) {
                this.n = new C14145hQ7(c13505gL3, Float.valueOf(100.0f));
                return true;
            }
            abstractC24408ya09.o(c13505gL3);
            return true;
        }
        if (obj == InterfaceC9661aL3.q) {
            if (this.k == null) {
                this.k = new C11959dq2(Collections.singletonList(new C24561yp3(Float.valueOf(0.0f))));
            }
            this.k.o(c13505gL3);
            return true;
        }
        if (obj != InterfaceC9661aL3.r) {
            return false;
        }
        if (this.l == null) {
            this.l = new C11959dq2(Collections.singletonList(new C24561yp3(Float.valueOf(0.0f))));
        }
        this.l.o(c13505gL3);
        return true;
    }

    public AbstractC24408ya0 e() {
        return this.n;
    }

    public Matrix f() {
        PointF pointF;
        C19591qc6 c19591qc6;
        PointF pointF2;
        this.a.reset();
        AbstractC24408ya0 abstractC24408ya0 = this.g;
        if (abstractC24408ya0 != null && (pointF2 = (PointF) abstractC24408ya0.h()) != null) {
            float f = pointF2.x;
            if (f != 0.0f || pointF2.y != 0.0f) {
                this.a.preTranslate(f, pointF2.y);
            }
        }
        if (!this.o) {
            AbstractC24408ya0 abstractC24408ya02 = this.i;
            if (abstractC24408ya02 != null) {
                float fFloatValue = abstractC24408ya02 instanceof C14145hQ7 ? ((Float) abstractC24408ya02.h()).floatValue() : ((C11959dq2) abstractC24408ya02).r();
                if (fFloatValue != 0.0f) {
                    this.a.preRotate(fFloatValue);
                }
            }
        } else if (abstractC24408ya0 != null) {
            float f2 = abstractC24408ya0.f();
            PointF pointF3 = (PointF) abstractC24408ya0.h();
            float f3 = pointF3.x;
            float f4 = pointF3.y;
            abstractC24408ya0.n(1.0E-4f + f2);
            PointF pointF4 = (PointF) abstractC24408ya0.h();
            abstractC24408ya0.n(f2);
            this.a.preRotate((float) Math.toDegrees(Math.atan2(pointF4.y - f4, pointF4.x - f3)));
        }
        if (this.k != null) {
            float fCos = this.l == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.r()) + 90.0f));
            float fSin = this.l == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.r()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(r0.r()));
            d();
            float[] fArr = this.e;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f5 = -fSin;
            fArr[3] = f5;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.b.setValues(fArr);
            d();
            float[] fArr2 = this.e;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.c.setValues(fArr2);
            d();
            float[] fArr3 = this.e;
            fArr3[0] = fCos;
            fArr3[1] = f5;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.d.setValues(fArr3);
            this.c.preConcat(this.b);
            this.d.preConcat(this.c);
            this.a.preConcat(this.d);
        }
        AbstractC24408ya0 abstractC24408ya03 = this.h;
        if (abstractC24408ya03 != null && (c19591qc6 = (C19591qc6) abstractC24408ya03.h()) != null && (c19591qc6.b() != 1.0f || c19591qc6.c() != 1.0f)) {
            this.a.preScale(c19591qc6.b(), c19591qc6.c());
        }
        AbstractC24408ya0 abstractC24408ya04 = this.f;
        if (abstractC24408ya04 != null && (pointF = (PointF) abstractC24408ya04.h()) != null) {
            float f6 = pointF.x;
            if (f6 != 0.0f || pointF.y != 0.0f) {
                this.a.preTranslate(-f6, -pointF.y);
            }
        }
        return this.a;
    }

    public Matrix g(float f) {
        AbstractC24408ya0 abstractC24408ya0 = this.g;
        PointF pointF = abstractC24408ya0 == null ? null : (PointF) abstractC24408ya0.h();
        AbstractC24408ya0 abstractC24408ya02 = this.h;
        C19591qc6 c19591qc6 = abstractC24408ya02 == null ? null : (C19591qc6) abstractC24408ya02.h();
        this.a.reset();
        if (pointF != null) {
            this.a.preTranslate(pointF.x * f, pointF.y * f);
        }
        if (c19591qc6 != null) {
            double d = f;
            this.a.preScale((float) Math.pow(c19591qc6.b(), d), (float) Math.pow(c19591qc6.c(), d));
        }
        AbstractC24408ya0 abstractC24408ya03 = this.i;
        if (abstractC24408ya03 != null) {
            float fFloatValue = ((Float) abstractC24408ya03.h()).floatValue();
            AbstractC24408ya0 abstractC24408ya04 = this.f;
            PointF pointF2 = abstractC24408ya04 != null ? (PointF) abstractC24408ya04.h() : null;
            this.a.preRotate(fFloatValue * f, pointF2 == null ? 0.0f : pointF2.x, pointF2 != null ? pointF2.y : 0.0f);
        }
        return this.a;
    }

    public AbstractC24408ya0 h() {
        return this.j;
    }

    public AbstractC24408ya0 i() {
        return this.m;
    }

    public void j(float f) {
        AbstractC24408ya0 abstractC24408ya0 = this.j;
        if (abstractC24408ya0 != null) {
            abstractC24408ya0.n(f);
        }
        AbstractC24408ya0 abstractC24408ya02 = this.m;
        if (abstractC24408ya02 != null) {
            abstractC24408ya02.n(f);
        }
        AbstractC24408ya0 abstractC24408ya03 = this.n;
        if (abstractC24408ya03 != null) {
            abstractC24408ya03.n(f);
        }
        AbstractC24408ya0 abstractC24408ya04 = this.f;
        if (abstractC24408ya04 != null) {
            abstractC24408ya04.n(f);
        }
        AbstractC24408ya0 abstractC24408ya05 = this.g;
        if (abstractC24408ya05 != null) {
            abstractC24408ya05.n(f);
        }
        AbstractC24408ya0 abstractC24408ya06 = this.h;
        if (abstractC24408ya06 != null) {
            abstractC24408ya06.n(f);
        }
        AbstractC24408ya0 abstractC24408ya07 = this.i;
        if (abstractC24408ya07 != null) {
            abstractC24408ya07.n(f);
        }
        C11959dq2 c11959dq2 = this.k;
        if (c11959dq2 != null) {
            c11959dq2.n(f);
        }
        C11959dq2 c11959dq22 = this.l;
        if (c11959dq22 != null) {
            c11959dq22.n(f);
        }
    }
}
