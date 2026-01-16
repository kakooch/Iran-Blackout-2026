package ir.nasim;

import ir.nasim.EF2;

/* loaded from: classes5.dex */
public final class QE {
    private final C9057Yh4 a;
    private final C8512Wh0 b;
    private final C8512Wh0 c;
    private final C8512Wh0 d;
    private final C8512Wh0 e;
    private final C20094rT1 f;
    private boolean g;
    private final boolean h;
    private boolean i;
    private boolean j;
    private final InterfaceC9336Zm4 k;
    private final InterfaceC9336Zm4 l;
    private final InterfaceC9336Zm4 m;
    private final InterfaceC9336Zm4 n;
    private final InterfaceC10258bL6 o;

    public QE(C9057Yh4 c9057Yh4) {
        AbstractC13042fc3.i(c9057Yh4, "context");
        this.a = c9057Yh4;
        this.k = AbstractC12281eL6.a(new C16110kj1(null, false, false, false, false, 31, null));
        this.l = AbstractC12281eL6.a(EF2.b.a);
        this.b = new C8512Wh0("app.dialogs.empty", Boolean.valueOf(c9057Yh4.c().h("app.dialogs.empty", true)));
        this.c = new C8512Wh0("app.contacts.empty", Boolean.valueOf(c9057Yh4.c().h("app.contacts.empty", true)));
        this.d = new C8512Wh0("app.empty", Boolean.valueOf(c9057Yh4.c().h("app.empty", true)));
        this.g = c9057Yh4.c().h("app.contacts.imported", false);
        boolean zH = c9057Yh4.c().h("app.dialogs.loaded", false);
        this.h = zH;
        this.i = c9057Yh4.c().h("app.contacts.loaded", false);
        this.j = c9057Yh4.c().h("settings_sync_state_loaded_v2", false);
        this.e = new C8512Wh0("app.loaded", Boolean.valueOf(this.g && zH && this.i));
        this.f = new C20094rT1(c9057Yh4.c());
        this.m = AbstractC12281eL6.a(Boolean.valueOf(this.j));
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(Boolean.FALSE);
        this.n = interfaceC9336Zm4A;
        this.o = AbstractC6459Nq2.c(interfaceC9336Zm4A);
    }

    private final void s() {
        boolean z = this.g && this.h && this.i;
        if (AbstractC13042fc3.d(this.e.b(), Boolean.valueOf(z))) {
            return;
        }
        this.e.i(Boolean.valueOf(z));
    }

    public final O92 a() {
        O92 o92A = this.f.a();
        AbstractC13042fc3.h(o92A, "getAllDialogsState(...)");
        return o92A;
    }

    public final InterfaceC10258bL6 b() {
        return this.k;
    }

    public final O92 c() {
        O92 o92B = this.f.b();
        AbstractC13042fc3.h(o92B, "getBotDialogsState(...)");
        return o92B;
    }

    public final O92 d() {
        O92 o92C = this.f.c();
        AbstractC13042fc3.h(o92C, "getChannelDialogsState(...)");
        return o92C;
    }

    public final InterfaceC10258bL6 e() {
        return this.l;
    }

    public final O92 f() {
        O92 o92D = this.f.d();
        AbstractC13042fc3.h(o92D, "getGroupDialogsState(...)");
        return o92D;
    }

    public final O92 g() {
        O92 o92E = this.f.e();
        AbstractC13042fc3.h(o92E, "getPrivateDialogsState(...)");
        return o92E;
    }

    public final InterfaceC10258bL6 h() {
        return this.o;
    }

    public final C8512Wh0 i() {
        return this.c;
    }

    public final InterfaceC10258bL6 j() {
        return this.m;
    }

    public final synchronized void k(C16110kj1 c16110kj1) {
        Object value;
        C16110kj1 c16110kj1L;
        AbstractC13042fc3.i(c16110kj1, "newState");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.k;
        do {
            value = interfaceC9336Zm4.getValue();
            c16110kj1L = ((C16110kj1) value).l(c16110kj1);
            if (c16110kj1L == null) {
                c16110kj1L = c16110kj1;
            }
        } while (!interfaceC9336Zm4.f(value, c16110kj1L));
    }

    public final synchronized void l(boolean z) {
        try {
            if (!AbstractC13042fc3.d(this.c.b(), Boolean.valueOf(z))) {
                this.a.c().g("app.contacts.empty", z);
                this.c.i(Boolean.valueOf(z));
            }
            if (!z && ((Boolean) this.d.b()).booleanValue()) {
                this.a.c().g("app.empty", false);
                this.d.i(Boolean.FALSE);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m() {
        if (!this.i) {
            this.i = true;
            this.a.c().g("app.contacts.loaded", true);
            s();
        }
    }

    public final synchronized void n(OP1 op1, EnumC12820fE enumC12820fE) {
        try {
            AbstractC13042fc3.i(op1, "dialogType");
            AbstractC13042fc3.i(enumC12820fE, "state");
            C19406qI3.a("AppStateVM", "on dialogs changed: " + op1 + ", " + enumC12820fE, new Object[0]);
            if (enumC12820fE == EnumC12820fE.LOADED && ((Boolean) this.b.b()).booleanValue()) {
                this.b.i(Boolean.FALSE);
            }
            this.f.f(op1, enumC12820fE);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void o(OP1 op1, boolean z) {
        try {
            this.f.f(op1, z ? EnumC12820fE.EMPTY : EnumC12820fE.LOADED);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void p(EF2 ef2) {
        Object value;
        AbstractC13042fc3.i(ef2, "state");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.l;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, ef2));
    }

    public final synchronized void q() {
        if (!this.g) {
            this.g = true;
            this.a.c().g("app.contacts.imported", true);
            s();
        }
    }

    public final synchronized void r() {
        Object value;
        Object value2;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.n;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.TRUE));
        InterfaceC9336Zm4 interfaceC9336Zm42 = this.m;
        do {
            value2 = interfaceC9336Zm42.getValue();
            ((Boolean) value2).booleanValue();
        } while (!interfaceC9336Zm42.f(value2, Boolean.TRUE));
    }
}
