package ir.nasim;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC6747Ou5;
import ir.nasim.LP;
import ir.nasim.core.modules.settings.SettingsModule;

/* renamed from: ir.nasim.jC6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C15218jC6 extends VW7 {
    public static final b k = new b(null);
    public static final int l = 8;
    private final WF2 b;
    private final InterfaceC3570Bk5 c;
    private final C15346jR d;
    private final SettingsModule e;
    private final C17039mI0 f;
    private final InterfaceC19567qa2 g;
    private final InterfaceC19567qa2 h;
    private final MQ i;
    private final InterfaceC9336Zm4 j;

    /* renamed from: ir.nasim.jC6$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        /* renamed from: ir.nasim.jC6$a$a, reason: collision with other inner class name */
        static final class C1310a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ C15218jC6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1310a(C15218jC6 c15218jC6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = c15218jC6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                C1310a c1310a = new C1310a(this.d, interfaceC20295rm1);
                c1310a.c = obj;
                return c1310a;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object value;
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                C19951rD2 c19951rD2 = (C19951rD2) this.c;
                InterfaceC9336Zm4 interfaceC9336Zm4 = this.d.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, null, false, 0L, null, new AbstractC6747Ou5.a(((KW3) AbstractC15401jX0.q0(c19951rD2.a())).b()), 31, null)));
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C19951rD2 c19951rD2, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1310a) create(c19951rD2, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15218jC6.this.new a(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC4557Fq2 interfaceC4557Fq2A = C15218jC6.this.b.a("GALLERY_RES_KEY");
                C1310a c1310a = new C1310a(C15218jC6.this, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(interfaceC4557Fq2A, c1310a, this) == objE) {
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
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jC6$b */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jC6$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ AbstractC6747Ou5 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(AbstractC6747Ou5 abstractC6747Ou5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = abstractC6747Ou5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15218jC6.this.new c(this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C17039mI0 c17039mI0 = C15218jC6.this.f;
                String strA = ((AbstractC6747Ou5.a) this.d).a();
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.jC6$d */
    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ AbstractC6747Ou5 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(String str, String str2, AbstractC6747Ou5 abstractC6747Ou5, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = str;
            this.e = str2;
            this.f = abstractC6747Ou5;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C15218jC6.this.new d(this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objA;
            Object value;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                MQ mq = C15218jC6.this.i;
                String str = this.d;
                String str2 = this.e;
                boolean zH = C15218jC6.this.c.h("PREF_KEY_SYNC_CONTACT", true);
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
            C15218jC6 c15218jC6 = C15218jC6.this;
            AbstractC6747Ou5 abstractC6747Ou5 = this.f;
            if (C9475a16.j(objA)) {
                c15218jC6.j1();
                c15218jC6.a1((PQ) objA, abstractC6747Ou5);
            }
            C15218jC6 c15218jC62 = C15218jC6.this;
            Throwable thE = C9475a16.e(objA);
            if (thE != null) {
                InterfaceC9336Zm4 interfaceC9336Zm4 = c15218jC62.j;
                do {
                    value = interfaceC9336Zm4.getValue();
                } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, LP.a.a(thE, EnumC10415ba2.d), false, 0L, null, null, 60, null)));
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C15218jC6(WF2 wf2, InterfaceC3570Bk5 interfaceC3570Bk5, C15346jR c15346jR, SettingsModule settingsModule, C17039mI0 c17039mI0, InterfaceC19567qa2 interfaceC19567qa2, InterfaceC19567qa2 interfaceC19567qa22, MQ mq) {
        Object value;
        AbstractC13042fc3.i(wf2, "galleryResultUseCase");
        AbstractC13042fc3.i(interfaceC3570Bk5, "preferencesStorage");
        AbstractC13042fc3.i(c15346jR, "authModule");
        AbstractC13042fc3.i(settingsModule, "settingsModule");
        AbstractC13042fc3.i(c17039mI0, "changeAvatarUseCase");
        AbstractC13042fc3.i(interfaceC19567qa2, "yandexMetric");
        AbstractC13042fc3.i(interfaceC19567qa22, "serajMetric");
        AbstractC13042fc3.i(mq, "authRepository");
        this.b = wf2;
        this.c = interfaceC3570Bk5;
        this.d = c15346jR;
        this.e = settingsModule;
        this.f = c17039mI0;
        this.g = interfaceC19567qa2;
        this.h = interfaceC19567qa22;
        this.i = mq;
        InterfaceC9336Zm4 interfaceC9336Zm4A = AbstractC12281eL6.a(new TB6(false, null, false, 0L, null, null, 63, null));
        this.j = interfaceC9336Zm4A;
        AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new a(null), 3, null);
        do {
            value = interfaceC9336Zm4A.getValue();
        } while (!interfaceC9336Zm4A.f(value, TB6.b((TB6) value, false, null, false, this.d.h(), null, null, 55, null)));
        this.c.g("show_invite_code_fragment", true);
    }

    private final void Z0(SettingsModule settingsModule) {
        settingsModule.L6(false);
        settingsModule.K6(false);
        settingsModule.M6(false);
        settingsModule.N6(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(PQ pq, final AbstractC6747Ou5 abstractC6747Ou5) {
        if ((abstractC6747Ou5 instanceof AbstractC6747Ou5.a) && ((AbstractC6747Ou5.a) abstractC6747Ou5).a() != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new c(abstractC6747Ou5, null), 3, null);
        }
        if (C13923h3.a.o().size() > 1) {
            AbstractC20507s76.d.d();
        } else {
            this.d.f(pq).m0(new InterfaceC24449ye1() { // from class: ir.nasim.hC6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15218jC6.b1(this.a, abstractC6747Ou5, (Boolean) obj);
                }
            }).E(new InterfaceC24449ye1() { // from class: ir.nasim.iC6
                @Override // ir.nasim.InterfaceC24449ye1
                public final void apply(Object obj) {
                    C15218jC6.c1(this.a, (Exception) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(C15218jC6 c15218jC6, AbstractC6747Ou5 abstractC6747Ou5, Boolean bool) {
        Object value;
        AbstractC13042fc3.i(c15218jC6, "this$0");
        AbstractC13042fc3.i(abstractC6747Ou5, "$selectAvatar");
        c15218jC6.c.g("PREF_KEY_IS_IN_SING_UP", false);
        c15218jC6.i1(abstractC6747Ou5);
        SettingsModule settingsModule = c15218jC6.e;
        c15218jC6.d1(settingsModule);
        c15218jC6.Z0(settingsModule);
        InterfaceC9336Zm4 interfaceC9336Zm4 = c15218jC6.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, null, true, 0L, null, null, 58, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(C15218jC6 c15218jC6, Exception exc) {
        Object value;
        AbstractC13042fc3.i(c15218jC6, "this$0");
        AbstractC13042fc3.i(exc, "e");
        InterfaceC9336Zm4 interfaceC9336Zm4 = c15218jC6.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, LP.a.a(exc, EnumC10415ba2.c), false, 0L, null, null, 60, null)));
    }

    private final void d1(SettingsModule settingsModule) {
        settingsModule.k6(true);
        settingsModule.l6(true);
        settingsModule.j6(true);
        settingsModule.m6(true);
        settingsModule.p6(true);
        settingsModule.q6(true);
        settingsModule.o6(true);
        settingsModule.r6(true);
    }

    private final void f1(AbstractC6747Ou5 abstractC6747Ou5) {
        if (abstractC6747Ou5 instanceof AbstractC6747Ou5.a) {
            this.g.a("user_profile", AbstractC19460qO3.g(AbstractC4616Fw7.a("index", 0)));
        }
    }

    private final void i1(AbstractC6747Ou5 abstractC6747Ou5) {
        if (((TB6) e1().getValue()).c() % 2 == 0) {
            this.h.b("signup_avatar_pack1");
            if (abstractC6747Ou5 instanceof AbstractC6747Ou5.a) {
                this.h.b("signup_avatar_pack1_picture_selected");
                return;
            }
            return;
        }
        this.h.b("signup_avatar_pack2");
        if (abstractC6747Ou5 instanceof AbstractC6747Ou5.a) {
            this.h.b("signup_avatar_pack2_picture_selected");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        String name;
        try {
            String version = AbstractC20507s76.d.getVersion();
            if (version != null && version.length() != 0) {
                String strK = new C20644sM5("-").k(version, "");
                String strSubstring = strK.substring(AbstractC20762sZ6.l0(strK, Separators.LPAREN, 0, false, 6, null) + 1, AbstractC20762sZ6.l0(strK, Separators.RPAREN, 0, false, 6, null));
                AbstractC13042fc3.h(strSubstring, "substring(...)");
                C17213mb2.i("First_version_displayed", strSubstring + " signUp");
            }
        } catch (Exception e) {
            if (C15218jC6.class.isAnonymousClass()) {
                name = C15218jC6.class.getName();
                int length = name.length();
                AbstractC13042fc3.f(name);
                if (length > 23) {
                    name = name.substring(name.length() - 23, name.length());
                    AbstractC13042fc3.h(name, "substring(...)");
                }
            } else {
                name = C15218jC6.class.getSimpleName();
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

    public final InterfaceC10258bL6 e1() {
        return AbstractC6459Nq2.c(this.j);
    }

    public final void g1() {
        Object value;
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, null, false, 0L, null, null, 59, null)));
    }

    public final void h1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "path");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, null, false, 0L, null, new AbstractC6747Ou5.a(str), 31, null)));
    }

    public final void k1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "name");
        AbstractC6747Ou5 abstractC6747Ou5F = ((TB6) this.j.getValue()).f();
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, true, LP.c.b, false, 0L, null, null, 60, null)));
        f1(abstractC6747Ou5F);
        String strE = this.c.e("PREF_KEY_TRANSACTION_HASH");
        if (strE != null) {
            AbstractC10533bm0.d(AbstractC9773aX7.a(this), null, null, new d(str, strE, abstractC6747Ou5F, null), 3, null);
        }
    }

    public final void l1(String str) {
        Object value;
        AbstractC13042fc3.i(str, "name");
        InterfaceC9336Zm4 interfaceC9336Zm4 = this.j;
        do {
            value = interfaceC9336Zm4.getValue();
        } while (!interfaceC9336Zm4.f(value, TB6.b((TB6) value, false, null, false, 0L, str, null, 47, null)));
    }
}
