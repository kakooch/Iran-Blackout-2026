package ir.nasim;

import ir.nasim.C12700f33;

/* loaded from: classes.dex */
public abstract class TV0 {
    private static C12700f33 a;

    public static final C12700f33 a(B03 b03) {
        C12700f33 c12700f33 = a;
        if (c12700f33 != null) {
            AbstractC13042fc3.f(c12700f33);
            return c12700f33;
        }
        C12700f33.a aVar = new C12700f33.a("Filled.Close", C17784nZ1.q(24.0f), C17784nZ1.q(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int iA = TQ7.a();
        CH6 ch6 = new CH6(C24381yX0.b.a(), null);
        int iA2 = AbstractC24405yZ6.a.a();
        int iA3 = AZ6.a.a();
        C12091e15 c12091e15 = new C12091e15();
        c12091e15.h(19.0f, 6.41f);
        c12091e15.f(17.59f, 5.0f);
        c12091e15.f(12.0f, 10.59f);
        c12091e15.f(6.41f, 5.0f);
        c12091e15.f(5.0f, 6.41f);
        c12091e15.f(10.59f, 12.0f);
        c12091e15.f(5.0f, 17.59f);
        c12091e15.f(6.41f, 19.0f);
        c12091e15.f(12.0f, 13.41f);
        c12091e15.f(17.59f, 19.0f);
        c12091e15.f(19.0f, 17.59f);
        c12091e15.f(13.41f, 12.0f);
        c12091e15.a();
        C12700f33 c12700f33F = aVar.c(c12091e15.d(), (14336 & 2) != 0 ? TQ7.a() : iA, (14336 & 4) != 0 ? "" : "", (14336 & 8) != 0 ? null : ch6, (14336 & 16) != 0 ? 1.0f : 1.0f, (14336 & 32) == 0 ? null : null, (14336 & 64) != 0 ? 1.0f : 1.0f, (14336 & 128) != 0 ? 0.0f : 1.0f, (14336 & 256) != 0 ? TQ7.b() : iA2, (14336 & 512) != 0 ? TQ7.c() : iA3, (14336 & 1024) != 0 ? 4.0f : 1.0f, (14336 & 2048) != 0 ? 0.0f : 0.0f, (14336 & 4096) == 0 ? 0.0f : 1.0f, (14336 & 8192) == 0 ? 0.0f : 0.0f).f();
        a = c12700f33F;
        AbstractC13042fc3.f(c12700f33F);
        return c12700f33F;
    }
}
