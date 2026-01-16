package ir.nasim;

import ir.nasim.AbstractC10274bN4;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.fx6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC13281fx6 {
    private static final boolean a(I46 i46) {
        return Float.intBitsToFloat((int) (i46.h() >> 32)) + Float.intBitsToFloat((int) (i46.i() >> 32)) <= i46.j() && Float.intBitsToFloat((int) (i46.b() >> 32)) + Float.intBitsToFloat((int) (i46.c() >> 32)) <= i46.j() && Float.intBitsToFloat((int) (i46.h() & 4294967295L)) + Float.intBitsToFloat((int) (i46.b() & 4294967295L)) <= i46.d() && Float.intBitsToFloat((int) (i46.i() & 4294967295L)) + Float.intBitsToFloat((int) (i46.c() & 4294967295L)) <= i46.d();
    }

    public static final boolean b(AbstractC10274bN4 abstractC10274bN4, float f, float f2, V05 v05, V05 v052) {
        if (abstractC10274bN4 instanceof AbstractC10274bN4.b) {
            return e(((AbstractC10274bN4.b) abstractC10274bN4).b(), f, f2);
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.c) {
            return f((AbstractC10274bN4.c) abstractC10274bN4, f, f2, v05, v052);
        }
        if (abstractC10274bN4 instanceof AbstractC10274bN4.a) {
            return d(((AbstractC10274bN4.a) abstractC10274bN4).b(), f, f2, v05, v052);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ boolean c(AbstractC10274bN4 abstractC10274bN4, float f, float f2, V05 v05, V05 v052, int i, Object obj) {
        if ((i & 8) != 0) {
            v05 = null;
        }
        if ((i & 16) != 0) {
            v052 = null;
        }
        return b(abstractC10274bN4, f, f2, v05, v052);
    }

    private static final boolean d(V05 v05, float f, float f2, V05 v052, V05 v053) {
        CK5 ck5 = new CK5(f - 0.005f, f2 - 0.005f, f + 0.005f, f2 + 0.005f);
        if (v052 == null) {
            v052 = AbstractC21611tq.a();
        }
        V05.o(v052, ck5, null, 2, null);
        if (v053 == null) {
            v053 = AbstractC21611tq.a();
        }
        v053.m(v05, v052, AbstractC19837r15.a.b());
        boolean zIsEmpty = v053.isEmpty();
        v053.reset();
        v052.reset();
        return !zIsEmpty;
    }

    private static final boolean e(CK5 ck5, float f, float f2) {
        return ck5.i() <= f && f < ck5.j() && ck5.l() <= f2 && f2 < ck5.e();
    }

    private static final boolean f(AbstractC10274bN4.c cVar, float f, float f2, V05 v05, V05 v052) {
        I46 i46B = cVar.b();
        if (f < i46B.e() || f >= i46B.f() || f2 < i46B.g() || f2 >= i46B.a()) {
            return false;
        }
        if (!a(i46B)) {
            V05 v05A = v052 == null ? AbstractC21611tq.a() : v052;
            V05.p(v05A, i46B, null, 2, null);
            return d(v05A, f, f2, v05, v052);
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (i46B.h() >> 32)) + i46B.e();
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (i46B.h() & 4294967295L)) + i46B.g();
        float f3 = i46B.f() - Float.intBitsToFloat((int) (i46B.i() >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (i46B.i() & 4294967295L)) + i46B.g();
        float f4 = i46B.f() - Float.intBitsToFloat((int) (i46B.c() >> 32));
        float fA = i46B.a() - Float.intBitsToFloat((int) (i46B.c() & 4294967295L));
        float fA2 = i46B.a() - Float.intBitsToFloat((int) (4294967295L & i46B.b()));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (i46B.b() >> 32)) + i46B.e();
        if (f < fIntBitsToFloat && f2 < fIntBitsToFloat2) {
            return g(f, f2, i46B.h(), fIntBitsToFloat, fIntBitsToFloat2);
        }
        if (f < fIntBitsToFloat4 && f2 > fA2) {
            return g(f, f2, i46B.b(), fIntBitsToFloat4, fA2);
        }
        if (f > f3 && f2 < fIntBitsToFloat3) {
            return g(f, f2, i46B.i(), f3, fIntBitsToFloat3);
        }
        if (f <= f4 || f2 <= fA) {
            return true;
        }
        return g(f, f2, i46B.c(), f4, fA);
    }

    private static final boolean g(float f, float f2, long j, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return ((f5 * f5) / (fIntBitsToFloat * fIntBitsToFloat)) + ((f6 * f6) / (fIntBitsToFloat2 * fIntBitsToFloat2)) <= 1.0f;
    }
}
