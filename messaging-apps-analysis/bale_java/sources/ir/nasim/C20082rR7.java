package ir.nasim;

import ir.nasim.C19491qR7;

/* renamed from: ir.nasim.rR7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C20082rR7 {
    private final C19491qR7.a a;
    private final C19491qR7 b;
    private final C19491qR7 c;
    private long d;
    private long e;

    public C20082rR7() {
        C19491qR7.a aVar = AbstractC21968uR7.h() ? C19491qR7.a.b : C19491qR7.a.a;
        this.a = aVar;
        this.b = new C19491qR7(false, aVar, 1, null);
        this.c = new C19491qR7(false, aVar, 1, null);
        this.d = ZG4.b.c();
    }

    public final void a(long j, long j2) {
        this.b.a(j, Float.intBitsToFloat((int) (j2 >> 32)));
        this.c.a(j, Float.intBitsToFloat((int) (j2 & 4294967295L)));
    }

    public final long b(long j) {
        if (!(C17718nR7.h(j) > 0.0f && C17718nR7.i(j) > 0.0f)) {
            M73.b("maximumVelocity should be a positive value. You specified=" + ((Object) C17718nR7.n(j)));
        }
        return AbstractC18309oR7.a(this.b.d(C17718nR7.h(j)), this.c.d(C17718nR7.i(j)));
    }

    public final long c() {
        return this.d;
    }

    public final long d() {
        return this.e;
    }

    public final void e() {
        this.b.e();
        this.c.e();
        this.e = 0L;
    }

    public final void f(long j) {
        this.d = j;
    }

    public final void g(long j) {
        this.e = j;
    }
}
