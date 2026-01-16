package ir.nasim;

import ir.nasim.AbstractC7094Qg0;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class TQ7 {
    private static final List a = AbstractC10360bX0.m();
    private static final int b = AbstractC24405yZ6.a.a();
    private static final int c = AZ6.a.b();
    private static final int d = AbstractC7094Qg0.a.z();
    private static final long e = C24381yX0.b.h();
    private static final int f = AbstractC14502i15.a.b();

    public static final int a() {
        return f;
    }

    public static final int b() {
        return b;
    }

    public static final int c() {
        return c;
    }

    public static final List d() {
        return a;
    }

    public static final boolean e(long j, long j2) {
        return C24381yX0.v(j) == C24381yX0.v(j2) && C24381yX0.u(j) == C24381yX0.u(j2) && C24381yX0.s(j) == C24381yX0.s(j2);
    }

    public static final boolean f(AbstractC24975zX0 abstractC24975zX0) {
        if (abstractC24975zX0 instanceof C7328Rg0) {
            C7328Rg0 c7328Rg0 = (C7328Rg0) abstractC24975zX0;
            int iB = c7328Rg0.b();
            AbstractC7094Qg0.a aVar = AbstractC7094Qg0.a;
            if (AbstractC7094Qg0.E(iB, aVar.z()) || AbstractC7094Qg0.E(c7328Rg0.b(), aVar.B())) {
                return true;
            }
        } else if (abstractC24975zX0 == null) {
            return true;
        }
        return false;
    }
}
