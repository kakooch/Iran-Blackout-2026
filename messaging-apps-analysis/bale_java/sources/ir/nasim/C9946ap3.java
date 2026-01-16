package ir.nasim;

import ir.nasim.S33;

/* renamed from: ir.nasim.ap3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C9946ap3 implements InterfaceC10566bp3 {
    private final InterfaceC20600sH6 a;
    public C11329cp3 b;
    public InterfaceC3630Br2 c;

    public C9946ap3(InterfaceC20600sH6 interfaceC20600sH6) {
        this.a = interfaceC20600sH6;
    }

    public void a(int i) {
        S33.a aVar = S33.b;
        if (S33.m(i, aVar.d())) {
            b().f(androidx.compose.ui.focus.d.b.e());
            return;
        }
        if (S33.m(i, aVar.f())) {
            b().f(androidx.compose.ui.focus.d.b.f());
            return;
        }
        if (!S33.m(i, aVar.b())) {
            if (S33.m(i, aVar.c()) ? true : S33.m(i, aVar.g()) ? true : S33.m(i, aVar.h()) ? true : S33.m(i, aVar.a())) {
                return;
            }
            S33.m(i, aVar.e());
        } else {
            InterfaceC20600sH6 interfaceC20600sH6 = this.a;
            if (interfaceC20600sH6 != null) {
                interfaceC20600sH6.b();
            }
        }
    }

    public final InterfaceC3630Br2 b() {
        InterfaceC3630Br2 interfaceC3630Br2 = this.c;
        if (interfaceC3630Br2 != null) {
            return interfaceC3630Br2;
        }
        AbstractC13042fc3.y("focusManager");
        return null;
    }

    public final C11329cp3 c() {
        C11329cp3 c11329cp3 = this.b;
        if (c11329cp3 != null) {
            return c11329cp3;
        }
        AbstractC13042fc3.y("keyboardActions");
        return null;
    }

    public final void d(int i) {
        UA2 ua2G;
        S33.a aVar = S33.b;
        C19938rB7 c19938rB7 = null;
        if (S33.m(i, aVar.b())) {
            ua2G = c().b();
        } else if (S33.m(i, aVar.c())) {
            ua2G = c().c();
        } else if (S33.m(i, aVar.d())) {
            ua2G = c().d();
        } else if (S33.m(i, aVar.f())) {
            ua2G = c().e();
        } else if (S33.m(i, aVar.g())) {
            ua2G = c().f();
        } else if (S33.m(i, aVar.h())) {
            ua2G = c().g();
        } else {
            if (!(S33.m(i, aVar.a()) ? true : S33.m(i, aVar.e()))) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            ua2G = null;
        }
        if (ua2G != null) {
            ua2G.invoke(this);
            c19938rB7 = C19938rB7.a;
        }
        if (c19938rB7 == null) {
            a(i);
        }
    }

    public final void e(InterfaceC3630Br2 interfaceC3630Br2) {
        this.c = interfaceC3630Br2;
    }

    public final void f(C11329cp3 c11329cp3) {
        this.b = c11329cp3;
    }
}
