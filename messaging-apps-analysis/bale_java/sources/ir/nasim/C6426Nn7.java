package ir.nasim;

/* renamed from: ir.nasim.Nn7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C6426Nn7 {
    private final long a;
    private final long b;

    public /* synthetic */ C6426Nn7(long j, long j2, ED1 ed1) {
        this(j, j2);
    }

    public final long a() {
        return this.b;
    }

    public final long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C6426Nn7)) {
            return false;
        }
        C6426Nn7 c6426Nn7 = (C6426Nn7) obj;
        return C24381yX0.q(this.a, c6426Nn7.a) && C24381yX0.q(this.b, c6426Nn7.b);
    }

    public int hashCode() {
        return (C24381yX0.w(this.a) * 31) + C24381yX0.w(this.b);
    }

    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) C24381yX0.x(this.a)) + ", selectionBackgroundColor=" + ((Object) C24381yX0.x(this.b)) + ')';
    }

    private C6426Nn7(long j, long j2) {
        this.a = j;
        this.b = j2;
    }
}
