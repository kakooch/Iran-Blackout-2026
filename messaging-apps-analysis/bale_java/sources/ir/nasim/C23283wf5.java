package ir.nasim;

/* renamed from: ir.nasim.wf5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23283wf5 {
    private final C19620qf5 a;
    private final C17847nf5 b;

    public /* synthetic */ C23283wf5(int i, ED1 ed1) {
        this(i);
    }

    public final C17847nf5 a() {
        return this.b;
    }

    public final C19620qf5 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23283wf5)) {
            return false;
        }
        C23283wf5 c23283wf5 = (C23283wf5) obj;
        return AbstractC13042fc3.d(this.b, c23283wf5.b) && AbstractC13042fc3.d(this.a, c23283wf5.a);
    }

    public int hashCode() {
        C19620qf5 c19620qf5 = this.a;
        int iHashCode = (c19620qf5 != null ? c19620qf5.hashCode() : 0) * 31;
        C17847nf5 c17847nf5 = this.b;
        return iHashCode + (c17847nf5 != null ? c17847nf5.hashCode() : 0);
    }

    public String toString() {
        return "PlatformTextStyle(spanStyle=" + this.a + ", paragraphSyle=" + this.b + ')';
    }

    public C23283wf5(C19620qf5 c19620qf5, C17847nf5 c17847nf5) {
        this.a = c19620qf5;
        this.b = c17847nf5;
    }

    public C23283wf5(boolean z) {
        this((C19620qf5) null, new C17847nf5(z));
    }

    private C23283wf5(int i) {
        this((C19620qf5) null, new C17847nf5(i, (ED1) null));
    }
}
