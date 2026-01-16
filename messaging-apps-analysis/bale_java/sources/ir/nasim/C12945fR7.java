package ir.nasim;

/* renamed from: ir.nasim.fR7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C12945fR7 implements InterfaceC10313bR7 {
    private final InterfaceC10575bq2 a;
    private AbstractC8151Ut b;
    private AbstractC8151Ut c;
    private AbstractC8151Ut d;
    private final float e;

    public C12945fR7(InterfaceC10575bq2 interfaceC10575bq2) {
        this.a = interfaceC10575bq2;
        this.e = interfaceC10575bq2.a();
    }

    @Override // ir.nasim.InterfaceC10313bR7
    public float a() {
        return this.e;
    }

    @Override // ir.nasim.InterfaceC10313bR7
    public AbstractC8151Ut b(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2) {
        if (this.c == null) {
            this.c = AbstractC8385Vt.g(abstractC8151Ut);
        }
        AbstractC8151Ut abstractC8151Ut3 = this.c;
        if (abstractC8151Ut3 == null) {
            AbstractC13042fc3.y("velocityVector");
            abstractC8151Ut3 = null;
        }
        int iB = abstractC8151Ut3.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut4 = this.c;
            if (abstractC8151Ut4 == null) {
                AbstractC13042fc3.y("velocityVector");
                abstractC8151Ut4 = null;
            }
            abstractC8151Ut4.e(i, this.a.b(j, abstractC8151Ut.a(i), abstractC8151Ut2.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut5 = this.c;
        if (abstractC8151Ut5 != null) {
            return abstractC8151Ut5;
        }
        AbstractC13042fc3.y("velocityVector");
        return null;
    }

    @Override // ir.nasim.InterfaceC10313bR7
    public AbstractC8151Ut c(long j, AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2) {
        if (this.b == null) {
            this.b = AbstractC8385Vt.g(abstractC8151Ut);
        }
        AbstractC8151Ut abstractC8151Ut3 = this.b;
        if (abstractC8151Ut3 == null) {
            AbstractC13042fc3.y("valueVector");
            abstractC8151Ut3 = null;
        }
        int iB = abstractC8151Ut3.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut4 = this.b;
            if (abstractC8151Ut4 == null) {
                AbstractC13042fc3.y("valueVector");
                abstractC8151Ut4 = null;
            }
            abstractC8151Ut4.e(i, this.a.e(j, abstractC8151Ut.a(i), abstractC8151Ut2.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut5 = this.b;
        if (abstractC8151Ut5 != null) {
            return abstractC8151Ut5;
        }
        AbstractC13042fc3.y("valueVector");
        return null;
    }

    @Override // ir.nasim.InterfaceC10313bR7
    public AbstractC8151Ut d(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2) {
        if (this.d == null) {
            this.d = AbstractC8385Vt.g(abstractC8151Ut);
        }
        AbstractC8151Ut abstractC8151Ut3 = this.d;
        if (abstractC8151Ut3 == null) {
            AbstractC13042fc3.y("targetVector");
            abstractC8151Ut3 = null;
        }
        int iB = abstractC8151Ut3.b();
        for (int i = 0; i < iB; i++) {
            AbstractC8151Ut abstractC8151Ut4 = this.d;
            if (abstractC8151Ut4 == null) {
                AbstractC13042fc3.y("targetVector");
                abstractC8151Ut4 = null;
            }
            abstractC8151Ut4.e(i, this.a.d(abstractC8151Ut.a(i), abstractC8151Ut2.a(i)));
        }
        AbstractC8151Ut abstractC8151Ut5 = this.d;
        if (abstractC8151Ut5 != null) {
            return abstractC8151Ut5;
        }
        AbstractC13042fc3.y("targetVector");
        return null;
    }

    @Override // ir.nasim.InterfaceC10313bR7
    public long e(AbstractC8151Ut abstractC8151Ut, AbstractC8151Ut abstractC8151Ut2) {
        if (this.c == null) {
            this.c = AbstractC8385Vt.g(abstractC8151Ut);
        }
        AbstractC8151Ut abstractC8151Ut3 = this.c;
        if (abstractC8151Ut3 == null) {
            AbstractC13042fc3.y("velocityVector");
            abstractC8151Ut3 = null;
        }
        int iB = abstractC8151Ut3.b();
        long jMax = 0;
        for (int i = 0; i < iB; i++) {
            jMax = Math.max(jMax, this.a.c(abstractC8151Ut.a(i), abstractC8151Ut2.a(i)));
        }
        return jMax;
    }
}
