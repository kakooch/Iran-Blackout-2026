package ir.nasim;

/* renamed from: ir.nasim.Uj3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C8065Uj3 {
    private final Object a;
    private final Object b;

    public C8065Uj3(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    private final int a(Object obj) {
        if (obj instanceof Enum) {
            return ((Enum) obj).ordinal();
        }
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C8065Uj3)) {
            return false;
        }
        C8065Uj3 c8065Uj3 = (C8065Uj3) obj;
        return AbstractC13042fc3.d(this.a, c8065Uj3.a) && AbstractC13042fc3.d(this.b, c8065Uj3.b);
    }

    public int hashCode() {
        return (a(this.a) * 31) + a(this.b);
    }

    public String toString() {
        return "JoinedKey(left=" + this.a + ", right=" + this.b + ')';
    }
}
