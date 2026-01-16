package ir.nasim;

/* renamed from: ir.nasim.pk4, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C19078pk4 {
    private final C19491qR7 a = new C19491qR7(true);
    private final C19491qR7 b = new C19491qR7(true);

    public final void a(long j, long j2) {
        this.a.a(j, Float.intBitsToFloat((int) (j2 >> 32)));
        this.b.a(j, Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }

    public final long b() {
        return AbstractC18309oR7.a(this.a.d(Float.MAX_VALUE), this.b.d(Float.MAX_VALUE));
    }
}
