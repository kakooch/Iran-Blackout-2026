package ir.nasim;

/* renamed from: ir.nasim.mY2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C17185mY2 {
    private final long a;
    private final long b;
    private long c;

    public /* synthetic */ C17185mY2(long j, long j2, long j3, ED1 ed1) {
        this(j, j2, j3);
    }

    public final long a() {
        return this.c;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
        return this.a;
    }

    public String toString() {
        return "HistoricalChange(uptimeMillis=" + this.a + ", position=" + ((Object) ZG4.s(this.b)) + ')';
    }

    public /* synthetic */ C17185mY2(long j, long j2, ED1 ed1) {
        this(j, j2);
    }

    private C17185mY2(long j, long j2) {
        this.a = j;
        this.b = j2;
        this.c = ZG4.b.c();
    }

    private C17185mY2(long j, long j2, long j3) {
        this(j, j2, (ED1) null);
        this.c = j3;
    }
}
