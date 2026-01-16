package ir.nasim;

/* renamed from: ir.nasim.td6, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C21421td6 {
    public static final a e = new a(null);
    static final /* synthetic */ InterfaceC5239Im3[] f = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(C21421td6.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    private final InterfaceC21331tU0 a;
    private final UA2 b;
    private final AbstractC5284Ir3 c;
    private final InterfaceC23016wC4 d;

    /* renamed from: ir.nasim.td6$a */
    public static final class a {
        private a() {
        }

        public final C21421td6 a(InterfaceC21331tU0 interfaceC21331tU0, ON6 on6, AbstractC5284Ir3 abstractC5284Ir3, UA2 ua2) {
            AbstractC13042fc3.i(interfaceC21331tU0, "classDescriptor");
            AbstractC13042fc3.i(on6, "storageManager");
            AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefinerForOwnerModule");
            AbstractC13042fc3.i(ua2, "scopeFactory");
            return new C21421td6(interfaceC21331tU0, on6, ua2, abstractC5284Ir3, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.td6$b */
    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ AbstractC5284Ir3 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(AbstractC5284Ir3 abstractC5284Ir3) {
            super(0);
            this.f = abstractC5284Ir3;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24 invoke() {
            return (W24) C21421td6.this.b.invoke(this.f);
        }
    }

    /* renamed from: ir.nasim.td6$c */
    static final class c extends AbstractC8614Ws3 implements SA2 {
        c() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24 invoke() {
            return (W24) C21421td6.this.b.invoke(C21421td6.this.c);
        }
    }

    public /* synthetic */ C21421td6(InterfaceC21331tU0 interfaceC21331tU0, ON6 on6, UA2 ua2, AbstractC5284Ir3 abstractC5284Ir3, ED1 ed1) {
        this(interfaceC21331tU0, on6, ua2, abstractC5284Ir3);
    }

    private final W24 d() {
        return (W24) MN6.a(this.d, this, f[0]);
    }

    public final W24 c(AbstractC5284Ir3 abstractC5284Ir3) {
        AbstractC13042fc3.i(abstractC5284Ir3, "kotlinTypeRefiner");
        if (!abstractC5284Ir3.c(PI1.l(this.a))) {
            return d();
        }
        InterfaceC13882gy7 interfaceC13882gy7J = this.a.j();
        AbstractC13042fc3.h(interfaceC13882gy7J, "classDescriptor.typeConstructor");
        return !abstractC5284Ir3.d(interfaceC13882gy7J) ? d() : abstractC5284Ir3.b(this.a, new b(abstractC5284Ir3));
    }

    private C21421td6(InterfaceC21331tU0 interfaceC21331tU0, ON6 on6, UA2 ua2, AbstractC5284Ir3 abstractC5284Ir3) {
        this.a = interfaceC21331tU0;
        this.b = ua2;
        this.c = abstractC5284Ir3;
        this.d = on6.c(new c());
    }
}
