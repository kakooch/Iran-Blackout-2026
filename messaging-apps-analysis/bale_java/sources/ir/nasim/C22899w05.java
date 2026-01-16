package ir.nasim;

import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.w05, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C22899w05 extends VW7 {
    public static final a l = new a(null);
    public static final int m = 8;
    private final NR b;
    private final SettingsModule c;
    private final InterfaceC3570Bk5 d;
    private final InterfaceC9336Zm4 e;
    private final InterfaceC10258bL6 f;
    private final InterfaceC9336Zm4 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;
    private final InterfaceC9336Zm4 j;
    private final InterfaceC10258bL6 k;

    /* renamed from: ir.nasim.w05$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.w05$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        Object b;
        int c;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C22899w05.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC9336Zm4 interfaceC9336Zm4;
            Object objE = AbstractC14862ic3.e();
            int i = this.c;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                interfaceC9336Zm4 = C22899w05.this.j;
                NR nr = C22899w05.this.b;
                this.b = interfaceC9336Zm4;
                this.c = 1;
                obj = nr.g(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                interfaceC9336Zm4 = (InterfaceC9336Zm4) this.b;
                AbstractC10685c16.b(obj);
            }
            C19493qS0 c19493qS0 = (C19493qS0) ((QR) obj).a();
            Boolean boolA = AbstractC6392Nk0.a(c19493qS0 != null ? c19493qS0.a() : false);
            this.b = null;
            this.c = 2;
            if (interfaceC9336Zm4.a(boolA, this) == objE) {
                return objE;
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C22899w05(NR nr, SettingsModule settingsModule) {
        AbstractC13042fc3.i(nr, "authenticatorRepository");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        this.b = nr;
        this.c = settingsModule;
        this.d = C7183Qq.p();
        Boolean bool = Boolean.FALSE;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(bool);
        this.e = interfaceC9336Zm4A;
        this.f = interfaceC9336Zm4A;
        this.g = AbstractC12281eL6.a(Boolean.valueOf(settingsModule.i5()));
        InterfaceC9336Zm4 interfaceC9336Zm4A2 = AbstractC12281eL6.a(null);
        this.h = interfaceC9336Zm4A2;
        this.i = interfaceC9336Zm4A2;
        InterfaceC9336Zm4 interfaceC9336Zm4A3 = AbstractC12281eL6.a(bool);
        this.j = interfaceC9336Zm4A3;
        this.k = interfaceC9336Zm4A3;
        S0();
        T0();
    }

    private final void T0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(this.d.h("finger_print_enabled", false))));
    }

    public final InterfaceC13730gj3 S0() {
        return AbstractC10533bm0.d(AbstractC9773aX7.a(this), C12366eV1.b(), null, new b(null), 2, null);
    }

    public final InterfaceC10258bL6 U0() {
        return this.i;
    }

    public final InterfaceC9336Zm4 V0() {
        return this.g;
    }

    public final InterfaceC10258bL6 W0() {
        return this.f;
    }

    public final InterfaceC10258bL6 X0() {
        return this.k;
    }

    public final void Y0() {
        Object value;
        boolean zH = this.d.h("finger_print_enabled", false);
        this.d.g("finger_print_enabled", !zH);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(!zH)));
    }

    public final void Z0(boolean z) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.e;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
        this.d.g("finger_print_enabled", z);
    }

    public final void a1() {
        Object value;
        this.c.g6(!r0.i5());
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(this.c.i5())));
    }

    public final void b1(boolean z) {
        Object value;
        this.c.g6(z);
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.g;
        do {
            value = interfaceC9336Zm4.getValue();
            ((Boolean) value).booleanValue();
        } while (!interfaceC9336Zm4.f(value, Boolean.valueOf(z)));
    }

    public final void c1(Integer num) {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, num));
    }
}
