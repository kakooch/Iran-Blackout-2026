package ir.nasim;

/* loaded from: classes2.dex */
public final class UZ0 implements InterfaceC18081o32 {
    private final C13245fu a;
    private final int b;

    public UZ0(C13245fu c13245fu, int i) {
        this.a = c13245fu;
        this.b = i;
    }

    @Override // ir.nasim.InterfaceC18081o32
    public void a(M42 m42) {
        if (m42.l()) {
            m42.m(m42.f(), m42.e(), c());
        } else {
            m42.m(m42.k(), m42.j(), c());
        }
        int iG = m42.g();
        int i = this.b;
        m42.o(AbstractC23053wG5.m(i > 0 ? (iG + i) - 1 : (iG + i) - c().length(), 0, m42.h()));
    }

    public final int b() {
        return this.b;
    }

    public final String c() {
        return this.a.k();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UZ0)) {
            return false;
        }
        UZ0 uz0 = (UZ0) obj;
        return AbstractC13042fc3.d(c(), uz0.c()) && this.b == uz0.b;
    }

    public int hashCode() {
        return (c().hashCode() * 31) + this.b;
    }

    public String toString() {
        return "CommitTextCommand(text='" + c() + "', newCursorPosition=" + this.b + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UZ0(String str, int i) {
        this(new C13245fu(str, null, 2, 0 == true ? 1 : 0), i);
    }
}
