package ir.nasim;

/* renamed from: ir.nasim.ve5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C22677ve5 implements InterfaceC24304yO4 {
    private final InterfaceC11734dW3 a;
    private final BJ3 b;

    public C22677ve5(InterfaceC11734dW3 interfaceC11734dW3, BJ3 bj3) {
        this.a = interfaceC11734dW3;
        this.b = bj3;
    }

    @Override // ir.nasim.InterfaceC24304yO4
    public boolean Z0() {
        return this.b.k1().b();
    }

    public final BJ3 a() {
        return this.b;
    }

    public final InterfaceC11734dW3 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C22677ve5)) {
            return false;
        }
        C22677ve5 c22677ve5 = (C22677ve5) obj;
        return AbstractC13042fc3.d(this.a, c22677ve5.a) && AbstractC13042fc3.d(this.b, c22677ve5.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "PlaceableResult(result=" + this.a + ", placeable=" + this.b + ')';
    }
}
