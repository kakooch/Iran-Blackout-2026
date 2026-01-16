package ir.nasim;

/* renamed from: ir.nasim.jV1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C15384jV1 implements U33 {
    public static final a a = new a(null);
    private static final InterfaceC9173Yu3 b = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.fV1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15384jV1.f();
        }
    });
    private static final InterfaceC9173Yu3 c = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.gV1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15384jV1.g();
        }
    });
    private static final InterfaceC9173Yu3 d = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.hV1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15384jV1.h();
        }
    });
    private static final InterfaceC9173Yu3 e = AbstractC13269fw3.a(new SA2() { // from class: ir.nasim.iV1
        @Override // ir.nasim.SA2
        public final Object invoke() {
            return C15384jV1.i();
        }
    });

    /* renamed from: ir.nasim.jV1$a */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AbstractC11830dd2 e() {
            return (AbstractC11830dd2) C15384jV1.b.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AbstractC11830dd2 f() {
            return (AbstractC11830dd2) C15384jV1.c.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AbstractC11830dd2 g() {
            return (AbstractC11830dd2) C15384jV1.d.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AbstractC11830dd2 h() {
            return (AbstractC11830dd2) C15384jV1.e.getValue();
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jV1$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ Runnable c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = runnable;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new b(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            this.c.run();
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC11830dd2 f() {
        return AbstractC14260hd2.c(SZ.m("D_db", 10, 0L, false, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC11830dd2 g() {
        return AbstractC14260hd2.c(SZ.m("FILE_PATH_db", 10, 0L, false, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC11830dd2 h() {
        return AbstractC14260hd2.c(SZ.m("D_network", 1, 0L, false, 12, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC11830dd2 i() {
        return AbstractC14260hd2.c(SZ.m("D_voice_capture", 1, 0L, false, 12, null));
    }

    @Override // ir.nasim.U33
    public void a(String str, Runnable runnable) {
        AbstractC13042fc3.i(str, "dispatcher");
        AbstractC13042fc3.i(runnable, "runnable");
        InterfaceC11938do1 interfaceC11938do1A = AbstractC20153rZ6.S(str, "D_db", false, 2, null) ? a.e() : AbstractC20153rZ6.S(str, "FILE_PATH_db", false, 2, null) ? a.f() : AbstractC20153rZ6.S(str, "D_network", false, 2, null) ? a.g() : AbstractC20153rZ6.S(str, "D_voice_capture", false, 2, null) ? a.h() : AbstractC20153rZ6.S(str, "D_default", false, 2, null) ? C12366eV1.a() : AbstractC20153rZ6.S(str, "D_heavy", false, 2, null) ? C12366eV1.b() : (!AbstractC20153rZ6.S(str, "D_display_list", false, 2, null) && AbstractC20153rZ6.S(str, "D_update", false, 2, null)) ? C12366eV1.a() : C12366eV1.a();
        AbstractC10533bm0.d(C17050mJ2.a, interfaceC11938do1A, null, new b(runnable, null), 2, null);
    }
}
