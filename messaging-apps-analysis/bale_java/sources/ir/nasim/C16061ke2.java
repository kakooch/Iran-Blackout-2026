package ir.nasim;

/* renamed from: ir.nasim.ke2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class C16061ke2 {
    private final boolean a;
    private final C7491Ry1 b;
    private final C7491Ry1 c;
    private final C24550yo2 d;

    C16061ke2(C7491Ry1 c7491Ry1, C7491Ry1 c7491Ry12, C24550yo2 c24550yo2, boolean z) {
        this.b = c7491Ry1;
        this.c = c7491Ry12;
        this.d = c24550yo2;
        this.a = z;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    C24550yo2 b() {
        return this.d;
    }

    C7491Ry1 c() {
        return this.b;
    }

    C7491Ry1 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C16061ke2)) {
            return false;
        }
        C16061ke2 c16061ke2 = (C16061ke2) obj;
        return a(this.b, c16061ke2.b) && a(this.c, c16061ke2.c) && a(this.d, c16061ke2.d);
    }

    public boolean f() {
        return this.c == null;
    }

    public int hashCode() {
        return (e(this.b) ^ e(this.c)) ^ e(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.b);
        sb.append(" , ");
        sb.append(this.c);
        sb.append(" : ");
        C24550yo2 c24550yo2 = this.d;
        sb.append(c24550yo2 == null ? "null" : Integer.valueOf(c24550yo2.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
