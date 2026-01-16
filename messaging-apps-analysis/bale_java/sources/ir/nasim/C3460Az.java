package ir.nasim;

/* renamed from: ir.nasim.Az, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C3460Az extends AbstractC17902nl0 {
    private long a;
    private long b;
    private long c;

    public C3460Az(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public long h() {
        return this.a;
    }

    public long i() {
        return this.b;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.i(1);
        this.b = c19084pl0.i(2);
        this.c = c19084pl0.i(3);
    }

    public long q() {
        return this.c;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.g(1, this.a);
        c19675ql0.g(2, this.b);
        c19675ql0.g(3, this.c);
    }

    public String toString() {
        return "struct MessageId{}";
    }

    public C3460Az() {
    }
}
