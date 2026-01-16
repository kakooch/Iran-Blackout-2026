package ir.nasim;

/* loaded from: classes2.dex */
public final class II5 implements ZD6 {
    private final PD6 b;

    public II5(PD6 pd6) {
        this.b = pd6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof II5) && AbstractC13042fc3.d(this.b, ((II5) obj).b);
    }

    @Override // ir.nasim.ZD6
    public Object f(InterfaceC20295rm1 interfaceC20295rm1) {
        return this.b;
    }

    public int hashCode() {
        return this.b.hashCode();
    }
}
