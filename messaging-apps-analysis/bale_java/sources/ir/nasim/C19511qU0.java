package ir.nasim;

/* renamed from: ir.nasim.qU0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19511qU0 {
    private final InterfaceC6692Oo4 a;
    private final C6526Nw5 b;
    private final AbstractC7310Re0 c;
    private final JH6 d;

    public C19511qU0(InterfaceC6692Oo4 interfaceC6692Oo4, C6526Nw5 c6526Nw5, AbstractC7310Re0 abstractC7310Re0, JH6 jh6) {
        AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
        AbstractC13042fc3.i(c6526Nw5, "classProto");
        AbstractC13042fc3.i(abstractC7310Re0, "metadataVersion");
        AbstractC13042fc3.i(jh6, "sourceElement");
        this.a = interfaceC6692Oo4;
        this.b = c6526Nw5;
        this.c = abstractC7310Re0;
        this.d = jh6;
    }

    public final InterfaceC6692Oo4 a() {
        return this.a;
    }

    public final C6526Nw5 b() {
        return this.b;
    }

    public final AbstractC7310Re0 c() {
        return this.c;
    }

    public final JH6 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C19511qU0)) {
            return false;
        }
        C19511qU0 c19511qU0 = (C19511qU0) obj;
        return AbstractC13042fc3.d(this.a, c19511qU0.a) && AbstractC13042fc3.d(this.b, c19511qU0.b) && AbstractC13042fc3.d(this.c, c19511qU0.c) && AbstractC13042fc3.d(this.d, c19511qU0.d);
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.c + ", sourceElement=" + this.d + ')';
    }
}
