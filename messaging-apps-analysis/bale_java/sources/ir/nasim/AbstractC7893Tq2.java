package ir.nasim;

/* renamed from: ir.nasim.Tq2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
abstract /* synthetic */ class AbstractC7893Tq2 {
    private static final UA2 a = b.e;
    private static final InterfaceC14603iB2 b = a.e;

    /* renamed from: ir.nasim.Tq2$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(AbstractC13042fc3.d(obj, obj2));
        }
    }

    public static final InterfaceC4557Fq2 a(InterfaceC4557Fq2 interfaceC4557Fq2) {
        return interfaceC4557Fq2 instanceof InterfaceC10258bL6 ? interfaceC4557Fq2 : d(interfaceC4557Fq2, a, b);
    }

    public static final InterfaceC4557Fq2 b(InterfaceC4557Fq2 interfaceC4557Fq2, InterfaceC14603iB2 interfaceC14603iB2) {
        UA2 ua2 = a;
        AbstractC13042fc3.g(interfaceC14603iB2, "null cannot be cast to non-null type kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Boolean>");
        return d(interfaceC4557Fq2, ua2, (InterfaceC14603iB2) AbstractC19810qy7.g(interfaceC14603iB2, 2));
    }

    public static final InterfaceC4557Fq2 c(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2) {
        return d(interfaceC4557Fq2, ua2, b);
    }

    private static final InterfaceC4557Fq2 d(InterfaceC4557Fq2 interfaceC4557Fq2, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2) {
        if (interfaceC4557Fq2 instanceof VV1) {
            VV1 vv1 = (VV1) interfaceC4557Fq2;
            if (vv1.b == ua2 && vv1.c == interfaceC14603iB2) {
                return interfaceC4557Fq2;
            }
        }
        return new VV1(interfaceC4557Fq2, ua2, interfaceC14603iB2);
    }

    /* renamed from: ir.nasim.Tq2$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public final Object invoke(Object obj) {
            return obj;
        }
    }
}
