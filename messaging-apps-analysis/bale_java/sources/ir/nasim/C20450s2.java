package ir.nasim;

/* renamed from: ir.nasim.s2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20450s2 {
    private final String a;
    private final InterfaceC18751pB2 b;

    public C20450s2(String str, InterfaceC18751pB2 interfaceC18751pB2) {
        this.a = str;
        this.b = interfaceC18751pB2;
    }

    public final InterfaceC18751pB2 a() {
        return this.b;
    }

    public final String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20450s2)) {
            return false;
        }
        C20450s2 c20450s2 = (C20450s2) obj;
        return AbstractC13042fc3.d(this.a, c20450s2.a) && AbstractC13042fc3.d(this.b, c20450s2.b);
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        InterfaceC18751pB2 interfaceC18751pB2 = this.b;
        return iHashCode + (interfaceC18751pB2 != null ? interfaceC18751pB2.hashCode() : 0);
    }

    public String toString() {
        return "AccessibilityAction(label=" + this.a + ", action=" + this.b + ')';
    }
}
