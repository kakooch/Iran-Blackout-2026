package ir.nasim;

import ir.nasim.C15595jq7;

/* renamed from: ir.nasim.mj4, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C17295mj4 {
    public static final C17295mj4 a = new C17295mj4();
    private static final long b = System.nanoTime();

    private C17295mj4() {
    }

    private final long c() {
        return System.nanoTime() - b;
    }

    public final long a(long j, long j2) {
        return AbstractC18824pJ3.c(j, j2, W12.b);
    }

    public long b() {
        return C15595jq7.a.a(c());
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
