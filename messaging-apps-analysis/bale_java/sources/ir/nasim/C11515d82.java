package ir.nasim;

/* renamed from: ir.nasim.d82, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C11515d82 {
    private final String a;

    private C11515d82(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.a = str;
    }

    public static C11515d82 b(String str) {
        return new C11515d82(str);
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11515d82) {
            return this.a.equals(((C11515d82) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Encoding{name=\"" + this.a + "\"}";
    }
}
