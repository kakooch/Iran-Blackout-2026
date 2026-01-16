package ir.nasim;

/* renamed from: ir.nasim.uc1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22063uc1 implements InterfaceC18300oQ7 {
    private final UA2 a;

    public C22063uc1(UA2 ua2) {
        this.a = ua2;
    }

    @Override // ir.nasim.InterfaceC18300oQ7
    public Object a(Y45 y45) {
        return this.a.invoke(y45);
    }

    public final UA2 b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22063uc1) && AbstractC13042fc3.d(this.a, ((C22063uc1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ComputedValueHolder(compute=" + this.a + ')';
    }
}
