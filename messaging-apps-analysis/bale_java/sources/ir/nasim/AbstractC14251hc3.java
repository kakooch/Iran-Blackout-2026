package ir.nasim;

/* renamed from: ir.nasim.hc3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract class AbstractC14251hc3 {

    /* renamed from: ir.nasim.hc3$a */
    public static final class a extends U06 {
        private int a;
        final /* synthetic */ InterfaceC14603iB2 b;
        final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC14603iB2 interfaceC14603iB2, Object obj) {
            super(interfaceC20295rm1);
            this.b = interfaceC14603iB2;
            this.c = obj;
            AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // ir.nasim.E90
        protected Object invokeSuspend(Object obj) {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                AbstractC10685c16.b(obj);
                AbstractC13042fc3.g(this.b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC14603iB2) AbstractC19810qy7.g(this.b, 2)).invoke(this.c, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.a = 2;
            AbstractC10685c16.b(obj);
            return obj;
        }
    }

    /* renamed from: ir.nasim.hc3$b */
    public static final class b extends AbstractC22163um1 {
        private int a;
        final /* synthetic */ InterfaceC14603iB2 b;
        final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC11938do1 interfaceC11938do1, InterfaceC14603iB2 interfaceC14603iB2, Object obj) {
            super(interfaceC20295rm1, interfaceC11938do1);
            this.b = interfaceC14603iB2;
            this.c = obj;
            AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // ir.nasim.E90
        protected Object invokeSuspend(Object obj) {
            int i = this.a;
            if (i == 0) {
                this.a = 1;
                AbstractC10685c16.b(obj);
                AbstractC13042fc3.g(this.b, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted$lambda$1>, kotlin.Any?>");
                return ((InterfaceC14603iB2) AbstractC19810qy7.g(this.b, 2)).invoke(this.c, this);
            }
            if (i != 1) {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
            this.a = 2;
            AbstractC10685c16.b(obj);
            return obj;
        }
    }

    /* renamed from: ir.nasim.hc3$c */
    public static final class c extends U06 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC20295rm1 interfaceC20295rm1) {
            super(interfaceC20295rm1);
            AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // ir.nasim.E90
        protected Object invokeSuspend(Object obj) {
            AbstractC10685c16.b(obj);
            return obj;
        }
    }

    /* renamed from: ir.nasim.hc3$d */
    public static final class d extends AbstractC22163um1 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC20295rm1 interfaceC20295rm1, InterfaceC11938do1 interfaceC11938do1) {
            super(interfaceC20295rm1, interfaceC11938do1);
            AbstractC13042fc3.g(interfaceC20295rm1, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }

        @Override // ir.nasim.E90
        protected Object invokeSuspend(Object obj) {
            AbstractC10685c16.b(obj);
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC20295rm1 a(InterfaceC14603iB2 interfaceC14603iB2, Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.i(interfaceC14603iB2, "<this>");
        AbstractC13042fc3.i(interfaceC20295rm1, "completion");
        InterfaceC20295rm1 interfaceC20295rm1A = WA1.a(interfaceC20295rm1);
        if (interfaceC14603iB2 instanceof E90) {
            return ((E90) interfaceC14603iB2).create(obj, interfaceC20295rm1A);
        }
        InterfaceC11938do1 context = interfaceC20295rm1A.getContext();
        return context == C18712p72.a ? new a(interfaceC20295rm1A, interfaceC14603iB2, obj) : new b(interfaceC20295rm1A, context, interfaceC14603iB2, obj);
    }

    private static final InterfaceC20295rm1 b(InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC11938do1 context = interfaceC20295rm1.getContext();
        return context == C18712p72.a ? new c(interfaceC20295rm1) : new d(interfaceC20295rm1, context);
    }

    public static InterfaceC20295rm1 c(InterfaceC20295rm1 interfaceC20295rm1) {
        InterfaceC20295rm1 interfaceC20295rm1Intercepted;
        AbstractC13042fc3.i(interfaceC20295rm1, "<this>");
        AbstractC22163um1 abstractC22163um1 = interfaceC20295rm1 instanceof AbstractC22163um1 ? (AbstractC22163um1) interfaceC20295rm1 : null;
        return (abstractC22163um1 == null || (interfaceC20295rm1Intercepted = abstractC22163um1.intercepted()) == null) ? interfaceC20295rm1 : interfaceC20295rm1Intercepted;
    }

    public static Object d(InterfaceC15796kB2 interfaceC15796kB2, Object obj, Object obj2, InterfaceC20295rm1 interfaceC20295rm1) {
        AbstractC13042fc3.i(interfaceC15796kB2, "<this>");
        AbstractC13042fc3.i(interfaceC20295rm1, "completion");
        return ((InterfaceC15796kB2) AbstractC19810qy7.g(interfaceC15796kB2, 3)).q(obj, obj2, b(WA1.a(interfaceC20295rm1)));
    }
}
