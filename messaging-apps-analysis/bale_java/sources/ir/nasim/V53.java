package ir.nasim;

/* loaded from: classes8.dex */
public final class V53 {
    private final Object a;
    private final Object b;
    private final String c;
    private final C24948zU0 d;

    public V53(Object obj, Object obj2, String str, C24948zU0 c24948zU0) {
        AbstractC13042fc3.i(str, "filePath");
        AbstractC13042fc3.i(c24948zU0, "classId");
        this.a = obj;
        this.b = obj2;
        this.c = str;
        this.d = c24948zU0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof V53)) {
            return false;
        }
        V53 v53 = (V53) obj;
        return AbstractC13042fc3.d(this.a, v53.a) && AbstractC13042fc3.d(this.b, v53.b) && AbstractC13042fc3.d(this.c, v53.c) && AbstractC13042fc3.d(this.d, v53.d);
    }

    public int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return ((((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.a + ", expectedVersion=" + this.b + ", filePath=" + this.c + ", classId=" + this.d + ')';
    }
}
