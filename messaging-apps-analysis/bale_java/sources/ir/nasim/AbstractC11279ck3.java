package ir.nasim;

/* renamed from: ir.nasim.ck3, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC11279ck3 implements HY6 {
    public static final a d = new a(null);
    private final C15531jk3 a;
    private final AbstractC3859Cq6 b;
    private final LI1 c;

    /* renamed from: ir.nasim.ck3$a */
    public static final class a extends AbstractC11279ck3 {
        public /* synthetic */ a(ED1 ed1) {
            this();
        }

        private a() {
            super(new C15531jk3(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, null, 65535, null), AbstractC4327Eq6.a(), null);
        }
    }

    public /* synthetic */ AbstractC11279ck3(C15531jk3 c15531jk3, AbstractC3859Cq6 abstractC3859Cq6, ED1 ed1) {
        this(c15531jk3, abstractC3859Cq6);
    }

    @Override // ir.nasim.InterfaceC19140pq6
    public AbstractC3859Cq6 a() {
        return this.b;
    }

    @Override // ir.nasim.HY6
    public final Object b(XI1 xi1, String str) {
        AbstractC13042fc3.i(xi1, "deserializer");
        AbstractC13042fc3.i(str, "string");
        LY6 ly6 = new LY6(str);
        Object objK = new C17780nY6(this, Gb8.c, ly6, xi1.getDescriptor(), null).k(xi1);
        ly6.v();
        return objK;
    }

    @Override // ir.nasim.HY6
    public final String c(InterfaceC22798vq6 interfaceC22798vq6, Object obj) {
        AbstractC13042fc3.i(interfaceC22798vq6, "serializer");
        C16132kl3 c16132kl3 = new C16132kl3();
        try {
            AbstractC15541jl3.a(this, c16132kl3, interfaceC22798vq6, obj);
            return c16132kl3.toString();
        } finally {
            c16132kl3.g();
        }
    }

    public final C15531jk3 d() {
        return this.a;
    }

    public final LI1 e() {
        return this.c;
    }

    private AbstractC11279ck3(C15531jk3 c15531jk3, AbstractC3859Cq6 abstractC3859Cq6) {
        this.a = c15531jk3;
        this.b = abstractC3859Cq6;
        this.c = new LI1();
    }
}
