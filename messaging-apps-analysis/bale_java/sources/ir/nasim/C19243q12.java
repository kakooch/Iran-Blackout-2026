package ir.nasim;

import android.graphics.Color;
import android.graphics.Matrix;
import ir.nasim.AbstractC24408ya0;

/* renamed from: ir.nasim.q12, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C19243q12 implements AbstractC24408ya0.b {
    private final AbstractC3236Aa0 a;
    private final AbstractC24408ya0.b b;
    private final AbstractC24408ya0 c;
    private final C11959dq2 d;
    private final C11959dq2 e;
    private final C11959dq2 f;
    private final C11959dq2 g;
    private Matrix h;

    /* renamed from: ir.nasim.q12$a */
    class a extends C13505gL3 {
        final /* synthetic */ C13505gL3 d;
        final /* synthetic */ C19243q12 e;

        a(C19243q12 c19243q12, C13505gL3 c13505gL3) {
            this.d = c13505gL3;
            this.e = c19243q12;
        }

        @Override // ir.nasim.C13505gL3
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float a(UK3 uk3) {
            Float f = (Float) this.d.a(uk3);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public C19243q12(AbstractC24408ya0.b bVar, AbstractC3236Aa0 abstractC3236Aa0, C18061o12 c18061o12) {
        this.b = bVar;
        this.a = abstractC3236Aa0;
        AbstractC24408ya0 abstractC24408ya0J = c18061o12.a().j();
        this.c = abstractC24408ya0J;
        abstractC24408ya0J.a(this);
        abstractC3236Aa0.j(abstractC24408ya0J);
        C11959dq2 c11959dq2J = c18061o12.d().j();
        this.d = c11959dq2J;
        c11959dq2J.a(this);
        abstractC3236Aa0.j(c11959dq2J);
        C11959dq2 c11959dq2J2 = c18061o12.b().j();
        this.e = c11959dq2J2;
        c11959dq2J2.a(this);
        abstractC3236Aa0.j(c11959dq2J2);
        C11959dq2 c11959dq2J3 = c18061o12.c().j();
        this.f = c11959dq2J3;
        c11959dq2J3.a(this);
        abstractC3236Aa0.j(c11959dq2J3);
        C11959dq2 c11959dq2J4 = c18061o12.e().j();
        this.g = c11959dq2J4;
        c11959dq2J4.a(this);
        abstractC3236Aa0.j(c11959dq2J4);
    }

    @Override // ir.nasim.AbstractC24408ya0.b
    public void a() {
        this.b.a();
    }

    public C17470n12 b(Matrix matrix, int i) {
        float fR = this.e.r() * 0.017453292f;
        float fFloatValue = ((Float) this.f.h()).floatValue();
        double d = fR;
        float fSin = ((float) Math.sin(d)) * fFloatValue;
        float fCos = ((float) Math.cos(d + 3.141592653589793d)) * fFloatValue;
        float fFloatValue2 = ((Float) this.g.h()).floatValue();
        int iIntValue = ((Integer) this.c.h()).intValue();
        C17470n12 c17470n12 = new C17470n12(fFloatValue2 * 0.33f, fSin, fCos, Color.argb(Math.round((((Float) this.d.h()).floatValue() * i) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        c17470n12.k(matrix);
        if (this.h == null) {
            this.h = new Matrix();
        }
        this.a.x.f().invert(this.h);
        c17470n12.k(this.h);
        return c17470n12;
    }

    public void c(C13505gL3 c13505gL3) {
        this.c.o(c13505gL3);
    }

    public void d(C13505gL3 c13505gL3) {
        this.e.o(c13505gL3);
    }

    public void e(C13505gL3 c13505gL3) {
        this.f.o(c13505gL3);
    }

    public void f(C13505gL3 c13505gL3) {
        if (c13505gL3 == null) {
            this.d.o(null);
        } else {
            this.d.o(new a(this, c13505gL3));
        }
    }

    public void g(C13505gL3 c13505gL3) {
        this.g.o(c13505gL3);
    }
}
