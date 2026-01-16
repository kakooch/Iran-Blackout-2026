package ir.nasim;

import android.gov.nist.javax.sip.header.ParameterNames;

/* renamed from: ir.nasim.bI1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C10226bI1 {
    private final Class a;
    private final int b;
    private final int c;

    private C10226bI1(Class cls, int i, int i2) {
        this.a = (Class) AbstractC4263Ej5.c(cls, "Null dependency anInterface.");
        this.b = i;
        this.c = i2;
    }

    private static String a(int i) {
        if (i == 0) {
            return "direct";
        }
        if (i == 1) {
            return "provider";
        }
        if (i == 2) {
            return "deferred";
        }
        throw new AssertionError("Unsupported injection: " + i);
    }

    public static C10226bI1 g(Class cls) {
        return new C10226bI1(cls, 0, 0);
    }

    public static C10226bI1 h(Class cls) {
        return new C10226bI1(cls, 0, 1);
    }

    public static C10226bI1 i(Class cls) {
        return new C10226bI1(cls, 1, 0);
    }

    public static C10226bI1 j(Class cls) {
        return new C10226bI1(cls, 1, 1);
    }

    public static C10226bI1 k(Class cls) {
        return new C10226bI1(cls, 2, 0);
    }

    public Class b() {
        return this.a;
    }

    public boolean c() {
        return this.c == 2;
    }

    public boolean d() {
        return this.c == 0;
    }

    public boolean e() {
        return this.b == 1;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C10226bI1)) {
            return false;
        }
        C10226bI1 c10226bI1 = (C10226bI1) obj;
        return this.a == c10226bI1.a && this.b == c10226bI1.b && this.c == c10226bI1.c;
    }

    public boolean f() {
        return this.b == 2;
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.a);
        sb.append(", type=");
        int i = this.b;
        sb.append(i == 1 ? ParameterNames.REQUIRED : i == 0 ? ParameterNames.OPTIONAL : "set");
        sb.append(", injection=");
        sb.append(a(this.c));
        sb.append("}");
        return sb.toString();
    }
}
