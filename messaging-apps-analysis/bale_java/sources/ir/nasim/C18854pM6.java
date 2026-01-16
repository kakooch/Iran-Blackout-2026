package ir.nasim;

/* renamed from: ir.nasim.pM6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C18854pM6 implements InterfaceC18300oQ7 {
    private final Object a;

    public C18854pM6(Object obj) {
        this.a = obj;
    }

    @Override // ir.nasim.InterfaceC18300oQ7
    public Object a(Y45 y45) {
        return this.a;
    }

    public final Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C18854pM6) && AbstractC13042fc3.d(this.a, ((C18854pM6) obj).a);
    }

    public int hashCode() {
        Object obj = this.a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "StaticValueHolder(value=" + this.a + ')';
    }
}
