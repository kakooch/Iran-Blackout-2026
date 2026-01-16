package ir.nasim;

import ir.nasim.C23811xZ2;
import ir.nasim.C4171Dz3;
import ir.nasim.C6399Nk7;

/* renamed from: ir.nasim.kW4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC15987kW4 {
    private static final long a = C13193fo7.b.a();

    public static final C15396jW4 a(C15396jW4 c15396jW4, int i, int i2, long j, C5477Jm7 c5477Jm7, C17847nf5 c17847nf5, C4888Gz3 c4888Gz3, int i3, int i4, C22179un7 c22179un7) {
        long j2;
        int iH = i;
        C5477Jm7 c5477Jm7J = c5477Jm7;
        C6399Nk7.a aVar = C6399Nk7.b;
        if (C6399Nk7.k(iH, aVar.g()) || C6399Nk7.k(iH, c15396jW4.h())) {
            if (!(C13193fo7.f(j) == 0)) {
                j2 = j;
                if (C13193fo7.e(j2, c15396jW4.e())) {
                }
            } else {
                j2 = j;
            }
            if ((c5477Jm7J == null || AbstractC13042fc3.d(c5477Jm7J, c15396jW4.j())) && ((C4049Dl7.j(i2, C4049Dl7.b.f()) || C4049Dl7.j(i2, c15396jW4.i())) && ((c17847nf5 == null || AbstractC13042fc3.d(c17847nf5, c15396jW4.g())) && ((c4888Gz3 == null || AbstractC13042fc3.d(c4888Gz3, c15396jW4.f())) && ((C4171Dz3.f(i3, C4171Dz3.b.b()) || C4171Dz3.f(i3, c15396jW4.d())) && ((C23811xZ2.g(i4, C23811xZ2.b.c()) || C23811xZ2.g(i4, c15396jW4.c())) && (c22179un7 == null || AbstractC13042fc3.d(c22179un7, c15396jW4.k())))))))) {
                return c15396jW4;
            }
        } else {
            j2 = j;
        }
        long jE = C13193fo7.f(j) == 0 ? c15396jW4.e() : j2;
        if (c5477Jm7J == null) {
            c5477Jm7J = c15396jW4.j();
        }
        C5477Jm7 c5477Jm72 = c5477Jm7J;
        if (C6399Nk7.k(iH, aVar.g())) {
            iH = c15396jW4.h();
        }
        return new C15396jW4(iH, !C4049Dl7.j(i2, C4049Dl7.b.f()) ? i2 : c15396jW4.i(), jE, c5477Jm72, d(c15396jW4, c17847nf5), c4888Gz3 == null ? c15396jW4.f() : c4888Gz3, !C4171Dz3.f(i3, C4171Dz3.b.b()) ? i3 : c15396jW4.d(), !C23811xZ2.g(i4, C23811xZ2.b.c()) ? i4 : c15396jW4.c(), c22179un7 == null ? c15396jW4.k() : c22179un7, null);
    }

    public static final C15396jW4 b(C15396jW4 c15396jW4, C15396jW4 c15396jW42, float f) {
        int iN = ((C6399Nk7) AbstractC13481gI6.d(C6399Nk7.h(c15396jW4.h()), C6399Nk7.h(c15396jW42.h()), f)).n();
        int iM = ((C4049Dl7) AbstractC13481gI6.d(C4049Dl7.g(c15396jW4.i()), C4049Dl7.g(c15396jW42.i()), f)).m();
        long jF = AbstractC13481gI6.f(c15396jW4.e(), c15396jW42.e(), f);
        C5477Jm7 c5477Jm7J = c15396jW4.j();
        if (c5477Jm7J == null) {
            c5477Jm7J = C5477Jm7.c.a();
        }
        C5477Jm7 c5477Jm7J2 = c15396jW42.j();
        if (c5477Jm7J2 == null) {
            c5477Jm7J2 = C5477Jm7.c.a();
        }
        return new C15396jW4(iN, iM, jF, AbstractC5711Km7.a(c5477Jm7J, c5477Jm7J2, f), c(c15396jW4.g(), c15396jW42.g(), f), (C4888Gz3) AbstractC13481gI6.d(c15396jW4.f(), c15396jW42.f(), f), ((C4171Dz3) AbstractC13481gI6.d(C4171Dz3.c(c15396jW4.d()), C4171Dz3.c(c15396jW42.d()), f)).l(), ((C23811xZ2) AbstractC13481gI6.d(C23811xZ2.d(c15396jW4.c()), C23811xZ2.d(c15396jW42.c()), f)).j(), (C22179un7) AbstractC13481gI6.d(c15396jW4.k(), c15396jW42.k(), f), null);
    }

    private static final C17847nf5 c(C17847nf5 c17847nf5, C17847nf5 c17847nf52, float f) {
        if (c17847nf5 == null && c17847nf52 == null) {
            return null;
        }
        if (c17847nf5 == null) {
            c17847nf5 = C17847nf5.c.a();
        }
        if (c17847nf52 == null) {
            c17847nf52 = C17847nf5.c.a();
        }
        return AbstractC15007ir.b(c17847nf5, c17847nf52, f);
    }

    private static final C17847nf5 d(C15396jW4 c15396jW4, C17847nf5 c17847nf5) {
        return c15396jW4.g() == null ? c17847nf5 : c17847nf5 == null ? c15396jW4.g() : c15396jW4.g().d(c17847nf5);
    }

    public static final C15396jW4 e(C15396jW4 c15396jW4, EnumC12613eu3 enumC12613eu3) {
        int iH = c15396jW4.h();
        C6399Nk7.a aVar = C6399Nk7.b;
        int iF = C6399Nk7.k(iH, aVar.g()) ? aVar.f() : c15396jW4.h();
        int iE = AbstractC10560bo7.e(enumC12613eu3, c15396jW4.i());
        long jE = C13193fo7.f(c15396jW4.e()) == 0 ? a : c15396jW4.e();
        C5477Jm7 c5477Jm7J = c15396jW4.j();
        if (c5477Jm7J == null) {
            c5477Jm7J = C5477Jm7.c.a();
        }
        C5477Jm7 c5477Jm7 = c5477Jm7J;
        C17847nf5 c17847nf5G = c15396jW4.g();
        C4888Gz3 c4888Gz3F = c15396jW4.f();
        int iD = c15396jW4.d();
        C4171Dz3.a aVar2 = C4171Dz3.b;
        int iA = C4171Dz3.f(iD, aVar2.b()) ? aVar2.a() : c15396jW4.d();
        int iC = c15396jW4.c();
        C23811xZ2.a aVar3 = C23811xZ2.b;
        int iB = C23811xZ2.g(iC, aVar3.c()) ? aVar3.b() : c15396jW4.c();
        C22179un7 c22179un7K = c15396jW4.k();
        if (c22179un7K == null) {
            c22179un7K = C22179un7.c.a();
        }
        return new C15396jW4(iF, iE, jE, c5477Jm7, c17847nf5G, c4888Gz3F, iA, iB, c22179un7K, null);
    }
}
