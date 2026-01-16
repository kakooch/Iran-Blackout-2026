package ir.nasim;

/* renamed from: ir.nasim.v22, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22320v22 implements InterfaceC18300oQ7 {
    private final InterfaceC9102Ym4 a;

    public C22320v22(InterfaceC9102Ym4 interfaceC9102Ym4) {
        this.a = interfaceC9102Ym4;
    }

    @Override // ir.nasim.InterfaceC18300oQ7
    public Object a(Y45 y45) {
        return this.a.getValue();
    }

    public final InterfaceC9102Ym4 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22320v22) && AbstractC13042fc3.d(this.a, ((C22320v22) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DynamicValueHolder(state=" + this.a + ')';
    }
}
