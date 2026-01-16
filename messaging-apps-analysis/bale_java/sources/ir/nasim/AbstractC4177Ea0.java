package ir.nasim;

/* renamed from: ir.nasim.Ea0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4177Ea0 {
    public static final a d = new a(null);
    public static final int e = 8;
    private final InterfaceC4411Fa0 a;
    private final C20919sp4 b;
    private boolean c;

    /* renamed from: ir.nasim.Ea0$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public AbstractC4177Ea0(InterfaceC4411Fa0 interfaceC4411Fa0) {
        AbstractC13042fc3.i(interfaceC4411Fa0, "presenterImp");
        this.a = interfaceC4411Fa0;
        this.b = new C20919sp4();
    }

    protected final void a(C19482qQ7 c19482qQ7, InterfaceC14756iQ7 interfaceC14756iQ7) {
        AbstractC13042fc3.i(c19482qQ7, "value");
        AbstractC13042fc3.i(interfaceC14756iQ7, "listener");
        this.b.r(c19482qQ7, interfaceC14756iQ7);
    }

    public void b() {
        if (this.c) {
            return;
        }
        this.b.d0();
    }

    public final void c() {
        if (this.c) {
            this.b.d0();
        }
    }

    protected final void d(boolean z) {
        this.c = z;
    }

    protected final void e() {
        this.b.d0();
    }
}
