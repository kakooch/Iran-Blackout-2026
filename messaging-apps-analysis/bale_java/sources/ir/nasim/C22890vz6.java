package ir.nasim;

/* renamed from: ir.nasim.vz6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22890vz6 {
    private long a;

    public void a() {
        this.a = System.currentTimeMillis();
    }

    public long b() {
        long j = this.a;
        this.a = System.currentTimeMillis();
        return System.currentTimeMillis() - j;
    }
}
