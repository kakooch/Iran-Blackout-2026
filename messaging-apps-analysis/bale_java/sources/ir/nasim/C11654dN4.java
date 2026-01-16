package ir.nasim;

import android.graphics.Outline;
import android.os.Build;
import ir.nasim.AbstractC10274bN4;

/* renamed from: ir.nasim.dN4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11654dN4 {
    private boolean a = true;
    private final Outline b;
    private AbstractC10274bN4 c;
    private V05 d;
    private V05 e;
    private boolean f;
    private boolean g;
    private V05 h;
    private I46 i;
    private float j;
    private long k;
    private long l;
    private boolean m;
    private V05 n;
    private V05 o;

    public C11654dN4() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.b = outline;
        this.k = ZG4.b.c();
        this.l = OD6.b.b();
    }

    private final boolean g(I46 i46, long j, long j2, float f) {
        if (i46 == null || !J46.e(i46)) {
            return false;
        }
        int i = (int) (j >> 32);
        if (i46.e() != Float.intBitsToFloat(i)) {
            return false;
        }
        int i2 = (int) (j & 4294967295L);
        return i46.g() == Float.intBitsToFloat(i2) && i46.f() == Float.intBitsToFloat(i) + Float.intBitsToFloat((int) (j2 >> 32)) && i46.a() == Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j2 & 4294967295L)) && Float.intBitsToFloat((int) (i46.h() >> 32)) == f;
    }

    private final void i() {
        if (this.f) {
            this.k = ZG4.b.c();
            this.j = 0.0f;
            this.e = null;
            this.f = false;
            this.g = false;
            AbstractC10274bN4 abstractC10274bN4 = this.c;
            if (abstractC10274bN4 == null || !this.m || Float.intBitsToFloat((int) (this.l >> 32)) <= 0.0f || Float.intBitsToFloat((int) (this.l & 4294967295L)) <= 0.0f) {
                this.b.setEmpty();
                return;
            }
            this.a = true;
            if (abstractC10274bN4 instanceof AbstractC10274bN4.b) {
                k(((AbstractC10274bN4.b) abstractC10274bN4).b());
            } else if (abstractC10274bN4 instanceof AbstractC10274bN4.c) {
                l(((AbstractC10274bN4.c) abstractC10274bN4).b());
            } else if (abstractC10274bN4 instanceof AbstractC10274bN4.a) {
                j(((AbstractC10274bN4.a) abstractC10274bN4).b());
            }
        }
    }

    private final void j(V05 v05) {
        int i = Build.VERSION.SDK_INT;
        if (i > 28 || v05.d()) {
            if (i >= 30) {
                C12906fN4.a.a(this.b, v05);
            } else {
                Outline outline = this.b;
                if (!(v05 instanceof C19724qq)) {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
                outline.setConvexPath(((C19724qq) v05).u());
            }
            this.g = !this.b.canClip();
        } else {
            this.a = false;
            this.b.setEmpty();
            this.g = true;
        }
        this.e = v05;
    }

    private final void k(CK5 ck5) {
        float fI = ck5.i();
        float fL = ck5.l();
        this.k = ZG4.e((Float.floatToRawIntBits(fL) & 4294967295L) | (Float.floatToRawIntBits(fI) << 32));
        float fJ = ck5.j() - ck5.i();
        float fE = ck5.e() - ck5.l();
        this.l = OD6.d((Float.floatToRawIntBits(fE) & 4294967295L) | (Float.floatToRawIntBits(fJ) << 32));
        this.b.setRect(Math.round(ck5.i()), Math.round(ck5.l()), Math.round(ck5.j()), Math.round(ck5.e()));
    }

    private final void l(I46 i46) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i46.h() >> 32));
        float fE = i46.e();
        float fG = i46.g();
        this.k = ZG4.e((Float.floatToRawIntBits(fE) << 32) | (Float.floatToRawIntBits(fG) & 4294967295L));
        float fJ = i46.j();
        float fD = i46.d();
        this.l = OD6.d((Float.floatToRawIntBits(fJ) << 32) | (Float.floatToRawIntBits(fD) & 4294967295L));
        if (J46.e(i46)) {
            this.b.setRoundRect(Math.round(i46.e()), Math.round(i46.g()), Math.round(i46.f()), Math.round(i46.a()), fIntBitsToFloat);
            this.j = fIntBitsToFloat;
            return;
        }
        V05 v05A = this.d;
        if (v05A == null) {
            v05A = AbstractC21611tq.a();
            this.d = v05A;
        }
        v05A.reset();
        V05.p(v05A, i46, null, 2, null);
        j(v05A);
    }

    public final void a(UE0 ue0) {
        int i;
        int i2;
        V05 v05D = d();
        if (v05D != null) {
            UE0.m(ue0, v05D, 0, 2, null);
            return;
        }
        float f = this.j;
        if (f <= 0.0f) {
            UE0.g(ue0, Float.intBitsToFloat((int) (this.k >> 32)), Float.intBitsToFloat((int) (this.k & 4294967295L)), Float.intBitsToFloat((int) (this.k >> 32)) + Float.intBitsToFloat((int) (this.l >> 32)), Float.intBitsToFloat((int) (this.k & 4294967295L)) + Float.intBitsToFloat((int) (this.l & 4294967295L)), 0, 16, null);
            return;
        }
        V05 v05A = this.h;
        I46 i46 = this.i;
        if (v05A == null || !g(i46, this.k, this.l, f)) {
            float fIntBitsToFloat = Float.intBitsToFloat((int) (this.k >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.k & 4294967295L));
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (this.l >> 32)) + Float.intBitsToFloat((int) (this.k >> 32));
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (this.l & 4294967295L)) + Float.intBitsToFloat((int) (this.k & 4294967295L));
            float f2 = this.j;
            I46 i46C = J46.c(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, AbstractC8567Wn1.b((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)));
            if (v05A == null) {
                v05A = AbstractC21611tq.a();
            } else {
                v05A.reset();
            }
            i = 2;
            V05.p(v05A, i46C, null, 2, null);
            this.i = i46C;
            this.h = v05A;
            i2 = 0;
        } else {
            i2 = 0;
            i = 2;
        }
        UE0.m(ue0, v05A, i2, i, null);
    }

    public final Outline b() {
        i();
        if (this.m && this.a) {
            return this.b;
        }
        return null;
    }

    public final boolean c() {
        return this.f;
    }

    public final V05 d() {
        i();
        return this.e;
    }

    public final boolean e() {
        return !this.g;
    }

    public final boolean f(long j) {
        AbstractC10274bN4 abstractC10274bN4;
        if (this.m && (abstractC10274bN4 = this.c) != null) {
            return AbstractC13281fx6.b(abstractC10274bN4, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (j & 4294967295L)), this.n, this.o);
        }
        return true;
    }

    public final boolean h(AbstractC10274bN4 abstractC10274bN4, float f, boolean z, float f2, long j) {
        this.b.setAlpha(f);
        boolean z2 = !AbstractC13042fc3.d(this.c, abstractC10274bN4);
        if (z2) {
            this.c = abstractC10274bN4;
            this.f = true;
        }
        this.l = j;
        boolean z3 = abstractC10274bN4 != null && (z || f2 > 0.0f);
        if (this.m != z3) {
            this.m = z3;
            this.f = true;
        }
        return z2;
    }
}
