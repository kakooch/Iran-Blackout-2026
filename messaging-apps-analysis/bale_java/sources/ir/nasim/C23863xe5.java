package ir.nasim;

/* renamed from: ir.nasim.xe5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23863xe5 {
    private final long a;
    private final long b;
    private final int c;

    public /* synthetic */ C23863xe5(long j, long j2, int i, ED1 ed1) {
        this(j, j2, i);
    }

    public final long a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final long c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23863xe5)) {
            return false;
        }
        C23863xe5 c23863xe5 = (C23863xe5) obj;
        return C13193fo7.e(this.a, c23863xe5.a) && C13193fo7.e(this.b, c23863xe5.b) && AbstractC4701Ge5.i(this.c, c23863xe5.c);
    }

    public int hashCode() {
        return (((C13193fo7.i(this.a) * 31) + C13193fo7.i(this.b)) * 31) + AbstractC4701Ge5.j(this.c);
    }

    public String toString() {
        return "Placeholder(width=" + ((Object) C13193fo7.j(this.a)) + ", height=" + ((Object) C13193fo7.j(this.b)) + ", placeholderVerticalAlign=" + ((Object) AbstractC4701Ge5.k(this.c)) + ')';
    }

    private C23863xe5(long j, long j2, int i) {
        this.a = j;
        this.b = j2;
        this.c = i;
        if (!(!(C13193fo7.f(j) == 0))) {
            N73.a("width cannot be TextUnit.Unspecified");
        }
        if (!(C13193fo7.f(j2) == 0)) {
            return;
        }
        N73.a("height cannot be TextUnit.Unspecified");
    }
}
