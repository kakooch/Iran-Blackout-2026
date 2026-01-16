package ir.nasim;

/* renamed from: ir.nasim.Qd1, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC7068Qd1 {
    private final Object a;

    public AbstractC7068Qd1(Object obj) {
        this.a = obj;
    }

    public abstract AbstractC4099Dr3 a(InterfaceC8507Wg4 interfaceC8507Wg4);

    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            Object objB = b();
            AbstractC7068Qd1 abstractC7068Qd1 = obj instanceof AbstractC7068Qd1 ? (AbstractC7068Qd1) obj : null;
            if (!AbstractC13042fc3.d(objB, abstractC7068Qd1 != null ? abstractC7068Qd1.b() : null)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        Object objB = b();
        if (objB == null) {
            return 0;
        }
        return objB.hashCode();
    }

    public String toString() {
        return String.valueOf(b());
    }
}
