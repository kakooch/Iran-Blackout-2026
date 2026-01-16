package ir.nasim;

/* renamed from: ir.nasim.Be6, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3517Be6 {
    private final String a;

    public C3517Be6(String str) {
        AbstractC13042fc3.i(str, "value");
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3517Be6) && AbstractC13042fc3.d(this.a, ((C3517Be6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SdpMsid(value=" + this.a + ')';
    }
}
