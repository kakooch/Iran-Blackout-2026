package ir.nasim;

/* renamed from: ir.nasim.rr4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C20348rr4 {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    public C20348rr4(boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = z4;
    }

    public boolean a() {
        return this.a;
    }

    public boolean b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public boolean d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C20348rr4)) {
            return false;
        }
        C20348rr4 c20348rr4 = (C20348rr4) obj;
        return this.a == c20348rr4.a && this.b == c20348rr4.b && this.c == c20348rr4.c && this.d == c20348rr4.d;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public int hashCode() {
        ?? r0 = this.a;
        int i = r0;
        if (this.b) {
            i = r0 + 16;
        }
        int i2 = i;
        if (this.c) {
            i2 = i + 256;
        }
        return this.d ? i2 + 4096 : i2;
    }

    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.a), Boolean.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.d));
    }
}
