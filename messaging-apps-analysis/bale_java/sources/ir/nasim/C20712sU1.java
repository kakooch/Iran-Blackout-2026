package ir.nasim;

/* renamed from: ir.nasim.sU1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C20712sU1 extends AbstractC5117Hy7 {
    public static final a e = new a(null);
    private final AbstractC5117Hy7 c;
    private final AbstractC5117Hy7 d;

    /* renamed from: ir.nasim.sU1$a */
    public static final class a {
        private a() {
        }

        public final AbstractC5117Hy7 a(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5117Hy7 abstractC5117Hy72) {
            AbstractC13042fc3.i(abstractC5117Hy7, "first");
            AbstractC13042fc3.i(abstractC5117Hy72, "second");
            return abstractC5117Hy7.f() ? abstractC5117Hy72 : abstractC5117Hy72.f() ? abstractC5117Hy7 : new C20712sU1(abstractC5117Hy7, abstractC5117Hy72, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C20712sU1(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5117Hy7 abstractC5117Hy72, ED1 ed1) {
        this(abstractC5117Hy7, abstractC5117Hy72);
    }

    public static final AbstractC5117Hy7 h(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5117Hy7 abstractC5117Hy72) {
        return e.a(abstractC5117Hy7, abstractC5117Hy72);
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean a() {
        return this.c.a() || this.d.a();
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean b() {
        return this.c.b() || this.d.b();
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC4356Eu d(InterfaceC4356Eu interfaceC4356Eu) {
        AbstractC13042fc3.i(interfaceC4356Eu, "annotations");
        return this.d.d(this.c.d(interfaceC4356Eu));
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public InterfaceC3932Cy7 e(AbstractC4099Dr3 abstractC4099Dr3) {
        AbstractC13042fc3.i(abstractC4099Dr3, "key");
        InterfaceC3932Cy7 interfaceC3932Cy7E = this.c.e(abstractC4099Dr3);
        return interfaceC3932Cy7E == null ? this.d.e(abstractC4099Dr3) : interfaceC3932Cy7E;
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public boolean f() {
        return false;
    }

    @Override // ir.nasim.AbstractC5117Hy7
    public AbstractC4099Dr3 g(AbstractC4099Dr3 abstractC4099Dr3, KQ7 kq7) {
        AbstractC13042fc3.i(abstractC4099Dr3, "topLevelType");
        AbstractC13042fc3.i(kq7, "position");
        return this.d.g(this.c.g(abstractC4099Dr3, kq7), kq7);
    }

    private C20712sU1(AbstractC5117Hy7 abstractC5117Hy7, AbstractC5117Hy7 abstractC5117Hy72) {
        this.c = abstractC5117Hy7;
        this.d = abstractC5117Hy72;
    }
}
