package ir.nasim;

/* renamed from: ir.nasim.ov7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C18600ov7 {
    private final C13245fu a;
    private final InterfaceC11600dH4 b;

    public C18600ov7(C13245fu c13245fu, InterfaceC11600dH4 interfaceC11600dH4) {
        this.a = c13245fu;
        this.b = interfaceC11600dH4;
    }

    public final InterfaceC11600dH4 a() {
        return this.b;
    }

    public final C13245fu b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18600ov7)) {
            return false;
        }
        C18600ov7 c18600ov7 = (C18600ov7) obj;
        return AbstractC13042fc3.d(this.a, c18600ov7.a) && AbstractC13042fc3.d(this.b, c18600ov7.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TransformedText(text=" + ((Object) this.a) + ", offsetMapping=" + this.b + ')';
    }
}
