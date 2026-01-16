package ir.nasim;

import ir.nasim.C5032Hp3;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* renamed from: ir.nasim.Kp3, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5734Kp3 {
    private final C5032Hp3.b a;

    private C5734Kp3(C5032Hp3.b bVar) {
        this.a = bVar;
    }

    private synchronized C5032Hp3.c c(C20317ro3 c20317ro3, FN4 fn4) {
        int iG;
        iG = g();
        if (fn4 == FN4.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return (C5032Hp3.c) C5032Hp3.c.b0().p(c20317ro3).q(iG).s(EnumC6192Mo3.ENABLED).r(fn4).e();
    }

    private synchronized boolean e(int i) {
        Iterator it = this.a.s().iterator();
        while (it.hasNext()) {
            if (((C5032Hp3.c) it.next()).X() == i) {
                return true;
            }
        }
        return false;
    }

    private synchronized C5032Hp3.c f(C6691Oo3 c6691Oo3) {
        return c(AbstractC24881zM5.g(c6691Oo3), c6691Oo3.W());
    }

    private synchronized int g() {
        int iF;
        iF = AbstractC10893cN7.f();
        while (e(iF)) {
            iF = AbstractC10893cN7.f();
        }
        return iF;
    }

    public static C5734Kp3 i() {
        return new C5734Kp3(C5032Hp3.a0());
    }

    public static C5734Kp3 j(C5266Ip3 c5266Ip3) {
        return new C5734Kp3((C5032Hp3.b) c5266Ip3.h().Q());
    }

    public synchronized C5734Kp3 a(C6925Po3 c6925Po3) {
        b(c6925Po3.b(), false);
        return this;
    }

    public synchronized int b(C6691Oo3 c6691Oo3, boolean z) {
        C5032Hp3.c cVarF;
        try {
            cVarF = f(c6691Oo3);
            this.a.p(cVarF);
            if (z) {
                this.a.t(cVarF.X());
            }
        } catch (Throwable th) {
            throw th;
        }
        return cVarF.X();
    }

    public synchronized C5266Ip3 d() {
        return C5266Ip3.e((C5032Hp3) this.a.e());
    }

    public synchronized C5734Kp3 h(int i) {
        for (int i2 = 0; i2 < this.a.r(); i2++) {
            C5032Hp3.c cVarQ = this.a.q(i2);
            if (cVarQ.X() == i) {
                if (!cVarQ.Z().equals(EnumC6192Mo3.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.a.t(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }
}
