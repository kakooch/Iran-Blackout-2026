package ir.nasim;

/* renamed from: ir.nasim.mw5, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C17426mw5 {
    private final String a;

    C17426mw5(String str) {
        this.a = str;
    }

    public static C17426mw5 b(String str) {
        return new C17426mw5(str);
    }

    public Object a(InterfaceC17689nO5 interfaceC17689nO5) {
        return interfaceC17689nO5.a(this);
    }

    public Object c(InterfaceC17689nO5 interfaceC17689nO5) {
        Object objA = a(interfaceC17689nO5);
        if (objA != null) {
            return objA;
        }
        throw new NullPointerException(this.a);
    }

    public void d(InterfaceC17689nO5 interfaceC17689nO5, Object obj) {
        interfaceC17689nO5.b(this, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((C17426mw5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.a + "'}";
    }
}
