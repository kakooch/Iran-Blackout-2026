package ir.nasim;

/* renamed from: ir.nasim.wx3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C23459wx3 extends H1 {
    private final InterfaceC23016wC4 b;

    /* renamed from: ir.nasim.wx3$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ SA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SA2 sa2) {
            super(0);
            this.e = sa2;
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final W24 invoke() {
            W24 w24 = (W24) this.e.invoke();
            return w24 instanceof H1 ? ((H1) w24).h() : w24;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C23459wx3(SA2 sa2) {
        this(null, sa2, 1, 0 == true ? 1 : 0);
        AbstractC13042fc3.i(sa2, "getScope");
    }

    @Override // ir.nasim.H1
    protected W24 i() {
        return (W24) this.b.invoke();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ C23459wx3(ON6 on6, SA2 sa2, int i, ED1 ed1) {
        if ((i & 1) != 0) {
            on6 = C14671iI3.e;
            AbstractC13042fc3.h(on6, "NO_LOCKS");
        }
        this(on6, sa2);
    }

    public C23459wx3(ON6 on6, SA2 sa2) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(sa2, "getScope");
        this.b = on6.c(new a(sa2));
    }
}
