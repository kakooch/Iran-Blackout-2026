package ir.nasim;

/* renamed from: ir.nasim.nH5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17626nH5 {
    private final C10826cG3 a;
    private final String b;
    private final long c;
    private final C11458d25 d;
    private final long e;

    /* renamed from: ir.nasim.nH5$a */
    public interface a {
        C17626nH5 a(String str, long j, C11458d25 c11458d25, long j2);
    }

    /* renamed from: ir.nasim.nH5$b */
    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ int d;
        final /* synthetic */ int e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = i;
            this.e = i2;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return C17626nH5.this.new b(this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C10826cG3 c10826cG3 = C17626nH5.this.a;
                String str = C17626nH5.this.b;
                long j = C17626nH5.this.c;
                C11458d25 c11458d25 = C17626nH5.this.d;
                int i2 = this.d;
                int i3 = this.e;
                long j2 = C17626nH5.this.e;
                this.b = 1;
                obj = c10826cG3.e(str, j, c11458d25, i2, i3, j2, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return obj;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public C17626nH5(C10826cG3 c10826cG3, String str, long j, C11458d25 c11458d25, long j2) {
        AbstractC13042fc3.i(c10826cG3, "loadReactionListRepository");
        AbstractC13042fc3.i(c11458d25, "peer");
        this.a = c10826cG3;
        this.b = str;
        this.c = j;
        this.d = c11458d25;
        this.e = j2;
    }

    public Object f(int i, int i2, InterfaceC20295rm1 interfaceC20295rm1) {
        return AbstractC9323Zl0.g(C12366eV1.b(), new b(i2, i, null), interfaceC20295rm1);
    }
}
