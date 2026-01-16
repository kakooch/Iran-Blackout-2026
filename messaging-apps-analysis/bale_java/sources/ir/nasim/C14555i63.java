package ir.nasim;

/* renamed from: ir.nasim.i63, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C14555i63 {
    private final int a;
    private final Object b;

    public C14555i63(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    public final int a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final int c() {
        return this.a;
    }

    public final Object d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C14555i63)) {
            return false;
        }
        C14555i63 c14555i63 = (C14555i63) obj;
        return this.a == c14555i63.a && AbstractC13042fc3.d(this.b, c14555i63.b);
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        Object obj = this.b;
        return iHashCode + (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return "IndexedValue(index=" + this.a + ", value=" + this.b + ')';
    }
}
