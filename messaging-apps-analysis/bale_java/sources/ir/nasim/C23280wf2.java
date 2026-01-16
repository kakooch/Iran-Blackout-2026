package ir.nasim;

/* renamed from: ir.nasim.wf2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C23280wf2 {
    private final Object a;
    private final InterfaceC15796kB2 b;

    public C23280wf2(Object obj, InterfaceC15796kB2 interfaceC15796kB2) {
        this.a = obj;
        this.b = interfaceC15796kB2;
    }

    public final Object a() {
        return this.a;
    }

    public final InterfaceC15796kB2 b() {
        return this.b;
    }

    public final Object c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23280wf2)) {
            return false;
        }
        C23280wf2 c23280wf2 = (C23280wf2) obj;
        return AbstractC13042fc3.d(this.a, c23280wf2.a) && AbstractC13042fc3.d(this.b, c23280wf2.b);
    }

    public int hashCode() {
        Object obj = this.a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "FadeInFadeOutAnimationItem(key=" + this.a + ", transition=" + this.b + ')';
    }
}
