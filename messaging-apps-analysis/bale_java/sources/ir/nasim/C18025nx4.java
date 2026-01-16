package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC24003xs5;
import ir.nasim.LP;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.nx4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18025nx4 extends VW7 {
    public static final a j = new a(null);
    public static final int k = 8;
    private final C15346jR b;
    private final MQ c;
    private final InterfaceC11621dJ7 d;
    private final InterfaceC3570Bk5 e;
    private final InterfaceC21014sz3 f;
    private final C17039mI0 g;
    private final InterfaceC9336Zm4 h;
    private final InterfaceC10258bL6 i;

    /* renamed from: ir.nasim.nx4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.nx4$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC24003xs5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC24003xs5 abstractC24003xs5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC24003xs5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18025nx4.this.new b(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17039mI0 c17039mI0 = C18025nx4.this.g;
                String strA = ((AbstractC24003xs5.c) this.d).a();
                this.b = 1;
                if (c17039mI0.b(strA, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nx4$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C12056dy d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C12056dy c12056dy, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = c12056dy;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18025nx4.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC11621dJ7 interfaceC11621dJ7 = C18025nx4.this.d;
                long fileId = this.d.getFileId();
                long accessHash = this.d.getAccessHash();
                this.b = 1;
                if (interfaceC11621dJ7.b(fileId, accessHash, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.nx4$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ AbstractC24003xs5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, AbstractC24003xs5 abstractC24003xs5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
            this.f = abstractC24003xs5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C18025nx4.this.new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MQ mq = C18025nx4.this.c;
                String str = this.d;
                String str2 = this.e;
                boolean zH = C18025nx4.this.e.h("PREF_KEY_SYNC_CONTACT", true);
                this.b = 1;
                objA = mq.a(str, str2, zH, this);
                if (objA == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                objA = ((C9475a16) obj).l();
            }
            C18025nx4 c18025nx4 = C18025nx4.this;
            AbstractC24003xs5 abstractC24003xs5 = this.f;
            if (C9475a16.j(objA)) {
                c18025nx4.j1();
                c18025nx4.b1((PQ) objA, abstractC24003xs5);
            }
            C18025nx4 c18025nx42 = C18025nx4.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c18025nx42.h;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, false, LP.a.a(thE, EnumC10415ba2.d), false, 0L, null, 28, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C18025nx4(C15346jR c15346jR, MQ mq, InterfaceC11621dJ7 interfaceC11621dJ7, InterfaceC3570Bk5 interfaceC3570Bk5, InterfaceC21014sz3 interfaceC21014sz3, C17039mI0 c17039mI0) {
        Object value;
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(mq, "authRepository");
        AbstractC13042fc3.i(interfaceC11621dJ7, "userRepository");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferences");
        AbstractC13042fc3.i(interfaceC21014sz3, "lifecycleRuntime");
        AbstractC13042fc3.i(c17039mI0, "changeAvatarUseCase");
        this.b = c15346jR;
        this.c = mq;
        this.d = interfaceC11621dJ7;
        this.e = interfaceC3570Bk5;
        this.f = interfaceC21014sz3;
        this.g = c17039mI0;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new C13427gC6(false, null, false, 0L, null, 31, null));
        this.h = interfaceC9336Zm4A;
        this.i = interfaceC9336Zm4A;
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, C13427gC6.b((C13427gC6) value, false, null, false, this.b.h(), null, 23, null)));
    }

    private final void a1(SettingsModule settingsModule) {
        settingsModule.L6(false);
        settingsModule.K6(false);
        settingsModule.M6(false);
        settingsModule.N6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1(PQ pq, final AbstractC24003xs5 abstractC24003xs5) {
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.b.f(pq).m0(new InterfaceC24449ye1() { // from class: ir.nasim.lx4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C18025nx4.c1(this.a, abstractC24003xs5, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.mx4
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C18025nx4.d1(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(C18025nx4 c18025nx4, AbstractC24003xs5 abstractC24003xs5, Boolean bool) {
        Object value;
        AbstractC13042fc3.i(c18025nx4, "this$0");
        AbstractC13042fc3.i(abstractC24003xs5, "$selectAvatar");
        c18025nx4.e.g("PREF_KEY_IS_IN_SING_UP", false);
        c18025nx4.i1(abstractC24003xs5);
        AbstractC5969Lp4.d().E("");
        SettingsModule settingsModuleS = AbstractC5969Lp4.d().o2().S();
        AbstractC13042fc3.f(settingsModuleS);
        c18025nx4.e1(settingsModuleS);
        c18025nx4.a1(settingsModuleS);
        if (!(abstractC24003xs5 instanceof AbstractC24003xs5.c) || ((AbstractC24003xs5.c) abstractC24003xs5).a() == null) {
            C12056dy c12056dy = (C12056dy) JP.a.a().get(abstractC24003xs5);
            if (c12056dy == null) {
                return;
            } else {
                AbstractC10533bm0.d(AbstractC9773aX7.a(c18025nx4), null, null, c18025nx4.new c(c12056dy, null), 3, null);
            }
        } else {
            AbstractC10533bm0.d(AbstractC9773aX7.a(c18025nx4), null, null, c18025nx4.new b(abstractC24003xs5, null), 3, null);
        }
        InterfaceC9336Zm4 interfaceC9336Zm4 = c18025nx4.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, false, null, true, 0L, null, 26, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(C18025nx4 c18025nx4, Exception exc) {
        Object value;
        AbstractC13042fc3.i(c18025nx4, "this$0");
        AbstractC13042fc3.i(exc, "e");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c18025nx4.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, false, LP.a.a(exc, EnumC10415ba2.c), false, 0L, null, 28, null)));
    }

    private final void e1(SettingsModule settingsModule) {
        settingsModule.k6(true);
        settingsModule.l6(true);
        settingsModule.j6(true);
        settingsModule.m6(true);
        settingsModule.p6(true);
        settingsModule.q6(true);
        settingsModule.o6(true);
        settingsModule.r6(true);
    }

    private final void g1(AbstractC24003xs5 abstractC24003xs5) {
        int i;
        if (abstractC24003xs5 instanceof AbstractC24003xs5.c) {
            i = 0;
        } else if (AbstractC13042fc3.d(abstractC24003xs5, AbstractC24003xs5.d.a)) {
            i = 1;
        } else if (AbstractC13042fc3.d(abstractC24003xs5, AbstractC24003xs5.e.a)) {
            i = 2;
        } else if (AbstractC13042fc3.d(abstractC24003xs5, AbstractC24003xs5.i.a)) {
            i = 3;
        } else if (!AbstractC13042fc3.d(abstractC24003xs5, AbstractC24003xs5.j.a)) {
            return;
        } else {
            i = 4;
        }
        C17213mb2.a.f("user_profile", AbstractC19460qO3.g(AbstractC4616Fw7.a("index", Integer.valueOf(i))));
    }

    private final void i1(AbstractC24003xs5 abstractC24003xs5) {
        if (((C13427gC6) this.i.getValue()).c() % 2 == 0) {
            C3343Am.g("signup_avatar_pack1");
            if (abstractC24003xs5 instanceof AbstractC24003xs5.c) {
                C3343Am.g("signup_avatar_pack1_picture_selected");
                return;
            }
            return;
        }
        C3343Am.g("signup_avatar_pack2");
        if (abstractC24003xs5 instanceof AbstractC24003xs5.c) {
            C3343Am.g("signup_avatar_pack2_picture_selected");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        String name;
        try {
            String version = this.f.getVersion();
            if (version != null && version.length() != 0) {
                String strK = new C20644sM5("-").k(version, "");
                String strSubstring = strK.substring(AbstractC20762sZ6.l0(strK, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(strK, Separators.RPAREN, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                C17213mb2.i("First_version_displayed", strSubstring + " signUp");
            }
        } catch (Exception e) {
            if (C18025nx4.class.isAnonymousClass()) {
                name = C18025nx4.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C18025nx4.class.getSimpleName();
                int length2 = name.length();
                AbstractC13042fc3.f(name);
                if (length2 > 23) {
                    name = name.substring(0, 23);
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            }
            C19406qI3.d(name, e);
        }
    }

    public final void Z0() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, false, LP.c.b, false, 0L, null, 29, null)));
    }

    public final InterfaceC10258bL6 f1() {
        return this.i;
    }

    public final void h1(AbstractC24003xs5 abstractC24003xs5) {
        Object value;
        AbstractC13042fc3.i(abstractC24003xs5, "avatar");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, false, null, false, 0L, abstractC24003xs5, 15, null)));
    }

    public final void k1(String str, String str2) {
        Object value;
        AbstractC13042fc3.i(str, "name");
        AbstractC13042fc3.i(str2, "transactionHash");
        AbstractC24003xs5 abstractC24003xs5E = ((C13427gC6) this.h.getValue()).e();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.h;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, C13427gC6.b((C13427gC6) value, true, LP.c.b, false, 0L, null, 28, null)));
        g1(abstractC24003xs5E);
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str, str2, abstractC24003xs5E, null), 3, null);
    }
}
