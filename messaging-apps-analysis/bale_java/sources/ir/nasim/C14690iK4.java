package ir.nasim;

/* renamed from: ir.nasim.iK4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
final class C14690iK4 {
    private final long a;

    /* renamed from: ir.nasim.iK4$a */
    public static final class a implements Runnable {
        final /* synthetic */ InterfaceC16145km6 a;
        final /* synthetic */ C14690iK4 b;

        public a(InterfaceC16145km6 interfaceC16145km6, C14690iK4 c14690iK4) {
            this.a = interfaceC16145km6;
            this.b = c14690iK4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.f(this.b, C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.iK4$b */
    /* synthetic */ class b extends EB2 implements InterfaceC15796kB2 {
        public static final b a = new b();

        b() {
            super(3, C14690iK4.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            y((C14690iK4) obj, (InterfaceC16145km6) obj2, obj3);
            return C19938rB7.a;
        }

        public final void y(C14690iK4 c14690iK4, InterfaceC16145km6 interfaceC16145km6, Object obj) {
            c14690iK4.c(interfaceC16145km6, obj);
        }
    }

    public C14690iK4(long j) {
        this.a = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(InterfaceC16145km6 interfaceC16145km6, Object obj) {
        if (this.a <= 0) {
            interfaceC16145km6.b(C19938rB7.a);
            return;
        }
        a aVar = new a(interfaceC16145km6, this);
        AbstractC13042fc3.g(interfaceC16145km6, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
        InterfaceC11938do1 context = interfaceC16145km6.getContext();
        interfaceC16145km6.c(HG1.d(context).J(this.a, aVar, context));
    }

    public final InterfaceC12536em6 b() {
        b bVar = b.a;
        AbstractC13042fc3.g(bVar, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        return new C13172fm6(this, (InterfaceC15796kB2) AbstractC19810qy7.g(bVar, 3), null, 4, null);
    }
}
