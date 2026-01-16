package ir.nasim;

/* renamed from: ir.nasim.pR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C18900pR7 {
    float a;
    float b;
    float c;
    float d;
    float e;
    float f;

    public void a(float f, float f2, int i, int i2, float[] fArr) {
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = (f2 - 0.5f) * 2.0f;
        float f6 = f3 + this.c;
        float f7 = f4 + this.d;
        float f8 = f6 + (this.a * (f - 0.5f) * 2.0f);
        float f9 = f7 + (this.b * f5);
        float radians = (float) Math.toRadians(this.f);
        float radians2 = (float) Math.toRadians(this.e);
        double d = radians;
        double d2 = i2 * f5;
        float fSin = f8 + (((float) ((((-i) * r7) * Math.sin(d)) - (Math.cos(d) * d2))) * radians2);
        float fCos = f9 + (radians2 * ((float) (((i * r7) * Math.cos(d)) - (d2 * Math.sin(d)))));
        fArr[0] = fSin;
        fArr[1] = fCos;
    }

    public void b() {
        this.e = 0.0f;
        this.d = 0.0f;
        this.c = 0.0f;
        this.b = 0.0f;
        this.a = 0.0f;
    }

    public void c(AbstractC19708qo3 abstractC19708qo3, float f) {
        if (abstractC19708qo3 != null) {
            this.e = abstractC19708qo3.b(f);
        }
    }

    public void d(MI6 mi6, float f) {
        if (mi6 != null) {
            this.e = mi6.b(f);
            this.f = mi6.a(f);
        }
    }

    public void e(AbstractC19708qo3 abstractC19708qo3, AbstractC19708qo3 abstractC19708qo32, float f) {
        if (abstractC19708qo3 != null) {
            this.a = abstractC19708qo3.b(f);
        }
        if (abstractC19708qo32 != null) {
            this.b = abstractC19708qo32.b(f);
        }
    }

    public void f(MI6 mi6, MI6 mi62, float f) {
        if (mi6 != null) {
            this.a = mi6.b(f);
        }
        if (mi62 != null) {
            this.b = mi62.b(f);
        }
    }

    public void g(AbstractC19708qo3 abstractC19708qo3, AbstractC19708qo3 abstractC19708qo32, float f) {
        if (abstractC19708qo3 != null) {
            this.c = abstractC19708qo3.b(f);
        }
        if (abstractC19708qo32 != null) {
            this.d = abstractC19708qo32.b(f);
        }
    }

    public void h(MI6 mi6, MI6 mi62, float f) {
        if (mi6 != null) {
            this.c = mi6.b(f);
        }
        if (mi62 != null) {
            this.d = mi62.b(f);
        }
    }
}
