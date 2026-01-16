package ir.nasim;

import java.util.Objects;

/* loaded from: classes5.dex */
public class Q64 extends AbstractC17902nl0 implements Comparable {
    private long a;
    private long b;
    private long c;
    private boolean d;

    public Q64(long j, long j2, long j3, boolean z) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
    }

    public boolean equals(Object obj) {
        Q64 q64 = (Q64) obj;
        return q64.a == this.a && q64.b == this.b && q64.c == this.c;
    }

    public long h() {
        return this.a;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d));
    }

    public long i() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = c19084pl0.i(1);
        this.a = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
        this.d = c19084pl0.b(4);
    }

    @Override // java.lang.Comparable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public int compareTo(Q64 q64) {
        return Long.compare(this.a, q64.h());
    }

    public long r() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.b);
        c19675ql0.g(2, this.a);
        c19675ql0.g(3, this.c);
        c19675ql0.a(4, this.d);
    }

    public String toString() {
        return "MessageId{rid=" + this.b + ", date=" + this.a + '}';
    }

    public Q64(long j, long j2) {
        this.a = j;
        this.b = j2;
        this.c = 0L;
        this.d = false;
    }

    Q64() {
    }
}
