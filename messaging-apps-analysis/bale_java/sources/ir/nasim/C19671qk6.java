package ir.nasim;

import ir.nasim.ZF6;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.qk6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C19671qk6 extends VW7 {
    private final C11941do4 b;
    private final SettingsModule c;
    private final C8054Ui1 d;
    private final NR e;
    private final AbstractC13778go1 f;
    private final InterfaceC3570Bk5 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;
    private final InterfaceC9336Zm4 j;
    private boolean k;
    private final InterfaceC10258bL6 l;
    private final InterfaceC9336Zm4 m;
    private final InterfaceC10258bL6 n;

    /* renamed from: ir.nasim.qk6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19671qk6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            C19671qk6 c19671qk6;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C19671qk6 c19671qk62 = C19671qk6.this;
                NR nr = c19671qk62.e;
                this.b = c19671qk62;
                this.c = 1;
                Object objG = nr.g(this);
                if (objG == objE) {
                    return objE;
                }
                c19671qk6 = c19671qk62;
                obj = objG;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c19671qk6 = (C19671qk6) this.b;
                AbstractC10685c16.b(obj);
            }
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) obj).a();
            c19671qk6.k = c19493qS0 != null ? c19493qS0.a() : false;
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qk6$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19671qk6.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objD;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C19671qk6.this.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C16115kj6.b((C16115kj6) value, false, true, false, 1, null)));
                C6517Nv5 c6517Nv5C = C19671qk6.this.b.C();
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5C, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C19671qk6 c19671qk6 = C19671qk6.this;
            if (C9475a16.e(objD) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c19671qk6.j;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, C16115kj6.b((C16115kj6) value3, false, false, false, 4, null)));
                c19671qk6.h1(ZF6.c.a);
            }
            C19671qk6 c19671qk62 = C19671qk6.this;
            if (C9475a16.j(objD)) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c19671qk62.j;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, C16115kj6.b((C16115kj6) value2, true, false, false, 4, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qk6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C19671qk6.this.new c(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object value;
            Object objD;
            Object value2;
            Object value3;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC9336Zm4 interfaceC9336Zm4 = C19671qk6.this.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C16115kj6.b((C16115kj6) value, false, true, false, 1, null)));
                C6517Nv5 c6517Nv5E = C19671qk6.this.b.E();
                this.b = 1;
                objD = AbstractC6756Ov5.d(c6517Nv5E, null, this, 1, null);
                if (objD == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objD = ((C9475a16) obj).l();
            }
            C19671qk6 c19671qk6 = C19671qk6.this;
            if (C9475a16.e(objD) != null) {
                InterfaceC9336Zm4 interfaceC9336Zm42 = c19671qk6.j;
                do {
                    value3 = interfaceC9336Zm42.getValue();
                } while (!interfaceC9336Zm42.f(value3, C16115kj6.b((C16115kj6) value3, true, false, false, 4, null)));
                c19671qk6.h1(ZF6.c.a);
            }
            C19671qk6 c19671qk62 = C19671qk6.this;
            if (C9475a16.j(objD)) {
                InterfaceC9336Zm4 interfaceC9336Zm43 = c19671qk62.j;
                do {
                    value2 = interfaceC9336Zm43.getValue();
                } while (!interfaceC9336Zm43.f(value2, C16115kj6.b((C16115kj6) value2, false, false, false, 4, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C19671qk6(C11941do4 c11941do4, SettingsModule settingsModule, C8054Ui1 c8054Ui1, NR nr, AbstractC13778go1 abstractC13778go1) {
        AbstractC13042fc3.i(c11941do4, "mxpModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c8054Ui1, "contactsModule");
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(abstractC13778go1, "ioDispatcher");
        this.b = c11941do4;
        this.c = settingsModule;
        this.d = c8054Ui1;
        this.e = nr;
        this.f = abstractC13778go1;
        W0();
        this.g = C7183Qq.p();
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(null);
        this.h = interfaceC9336Zm4A;
        this.i = AbstractC6459Nq2.c(interfaceC9336Zm4A);
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(new C16115kj6(b1(), false, false));
        this.j = interfaceC9336Zm4A2;
        this.l = AbstractC6459Nq2.c(interfaceC9336Zm4A2);
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(Boolean.valueOf(a1()));
        this.m = interfaceC9336Zm4A3;
        this.n = AbstractC6459Nq2.c(interfaceC9336Zm4A3);
    }

    private final boolean a1() {
        return C13923h3.a.k().getSyncContacts();
    }

    private final boolean b1() {
        return this.c.K5();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h1(ZF6 zf6) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, zf6));
    }

    private final void k1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(null), 3, null);
    }

    public final void V0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C16115kj6.b((C16115kj6) value, false, false, false, 3, null)));
    }

    public final InterfaceC13730gj3 W0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), this.f, null, new a(null), 2, null);
    }

    public final InterfaceC10258bL6 X0() {
        return this.l;
    }

    public final InterfaceC10258bL6 Y0() {
        return this.i;
    }

    public final InterfaceC10258bL6 Z0() {
        return this.n;
    }

    public final boolean c1() {
        return this.k;
    }

    public final void d1() {
        Object value;
        if (((C16115kj6) this.j.getValue()).c()) {
            k1();
            return;
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C16115kj6.b((C16115kj6) value, false, false, true, 3, null)));
    }

    public final void e1() {
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new b(null), 3, null);
    }

    public final void f1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, null));
    }

    public final void g1(boolean z) {
        this.c.g6(z);
    }

    public final void i1(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.m;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
        if (z) {
            this.d.q0();
        }
        C13923h3.a.y(z);
    }

    public final void j1(boolean z) {
        this.g.g("finger_print_enabled", z);
    }
}
