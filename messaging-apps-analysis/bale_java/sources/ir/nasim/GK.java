package ir.nasim;

/* loaded from: classes2.dex */
public final class GK {
    private final Object a;
    private final T92 b;
    private final InterfaceC18663p23 c;

    public GK(Object obj, T92 t92, InterfaceC18663p23 interfaceC18663p23) {
        this.a = obj;
        this.b = t92;
        this.c = interfaceC18663p23;
    }

    public final InterfaceC18663p23 a() {
        return this.c;
    }

    public final Object b() {
        return this.a;
    }

    public final T92 c() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GK) {
            GK gk = (GK) obj;
            if (this.b.c(this.a, gk.a) && AbstractC13042fc3.d(this.c, gk.c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.b.b(this.a) * 31) + this.c.hashCode();
    }
}
