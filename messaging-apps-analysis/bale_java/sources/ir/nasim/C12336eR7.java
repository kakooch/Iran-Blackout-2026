package ir.nasim;

/* renamed from: ir.nasim.eR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C12336eR7 implements InterfaceC11693dR7 {
    private final InterfaceC8619Wt a;
    private AbstractC8151Ut b;
    private AbstractC8151Ut c;
    private AbstractC8151Ut d;

    /* renamed from: ir.nasim.eR7$a */
    public static final class a implements InterfaceC8619Wt {
        final /* synthetic */ InterfaceC8586Wp2 a;

        a(InterfaceC8586Wp2 interfaceC8586Wp2) {
            this.a = interfaceC8586Wp2;
        }

        @Override // ir.nasim.InterfaceC8619Wt
        public InterfaceC8586Wp2 get(int i) {
            return this.a;
        }
    }

    public C12336eR7(InterfaceC8619Wt interfaceC8619Wt) {
        this.a = interfaceC8619Wt;
    }

    @Override // ir.nasim.ZQ7
    public long b(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        int iB = abstractC8151Ut.b();
        long jMax = 0;
        for (int i = 0; i < iB; i++) {
            jMax = Math.max(jMax, this.a.get(i).e(abstractC8151Ut.a(i), abstractC8151Ut2.a(i), abstractC8151Ut3.a(i)));
        }
        return jMax;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        if (this.b == null) {
            this.b = AbstractC8385Vt.g(abstractC8151Ut);
        }
        AbstractC8151Ut abstractC8151Ut4 = this.b;
        if (abstractC8151Ut4 == null) {
            AbstractC13042fc3.y("valueVector");
            abstractC8151Ut4 = null;
        }
        int iB = abstractC8151Ut4.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut5 = this.b;
            if (abstractC8151Ut5 == null) {
                AbstractC13042fc3.y("valueVector");
                abstractC8151Ut5 = null;
            }
            abstractC8151Ut5.e(i, this.a.get(i).c(j, abstractC8151Ut.a(i), abstractC8151Ut2.a(i), abstractC8151Ut3.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut6 = this.b;
        if (abstractC8151Ut6 != null) {
            return abstractC8151Ut6;
        }
        AbstractC13042fc3.y("valueVector");
        return null;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut f(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        if (this.c == null) {
            this.c = AbstractC8385Vt.g(abstractC8151Ut3);
        }
        AbstractC8151Ut abstractC8151Ut4 = this.c;
        if (abstractC8151Ut4 == null) {
            AbstractC13042fc3.y("velocityVector");
            abstractC8151Ut4 = null;
        }
        int iB = abstractC8151Ut4.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut5 = this.c;
            if (abstractC8151Ut5 == null) {
                AbstractC13042fc3.y("velocityVector");
                abstractC8151Ut5 = null;
            }
            abstractC8151Ut5.e(i, this.a.get(i).d(j, abstractC8151Ut.a(i), abstractC8151Ut2.a(i), abstractC8151Ut3.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut6 = this.c;
        if (abstractC8151Ut6 != null) {
            return abstractC8151Ut6;
        }
        AbstractC13042fc3.y("velocityVector");
        return null;
    }

    @Override // ir.nasim.ZQ7
    public AbstractC8151Ut g(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2, AbstractC8151Ut abstractC8151Ut3) {
        if (this.d == null) {
            this.d = AbstractC8385Vt.g(abstractC8151Ut3);
        }
        AbstractC8151Ut abstractC8151Ut4 = this.d;
        if (abstractC8151Ut4 == null) {
            AbstractC13042fc3.y("endVelocityVector");
            abstractC8151Ut4 = null;
        }
        int iB = abstractC8151Ut4.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut5 = this.d;
            if (abstractC8151Ut5 == null) {
                AbstractC13042fc3.y("endVelocityVector");
                abstractC8151Ut5 = null;
            }
            abstractC8151Ut5.e(i, this.a.get(i).b(abstractC8151Ut.a(i), abstractC8151Ut2.a(i), abstractC8151Ut3.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut6 = this.d;
        if (abstractC8151Ut6 != null) {
            return abstractC8151Ut6;
        }
        AbstractC13042fc3.y("endVelocityVector");
        return null;
    }

    public C12336eR7(InterfaceC8586Wp2 interfaceC8586Wp2) {
        this(new a(interfaceC8586Wp2));
    }
}
