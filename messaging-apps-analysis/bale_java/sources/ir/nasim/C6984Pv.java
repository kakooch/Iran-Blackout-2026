package ir.nasim;

/* renamed from: ir.nasim.Pv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C6984Pv extends AbstractC17902nl0 {
    private C7228Qv a;
    private C7228Qv b;
    private C7228Qv c;
    private Long d;
    private Long e;

    public C6984Pv(C7228Qv c7228Qv, C7228Qv c7228Qv2, C7228Qv c7228Qv3, Long l, Long l2) {
        this.a = c7228Qv;
        this.b = c7228Qv2;
        this.c = c7228Qv3;
        this.d = l;
        this.e = l2;
    }

    public Long getId() {
        return this.d;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C7228Qv) c19084pl0.z(1, new C7228Qv());
        this.b = (C7228Qv) c19084pl0.z(2, new C7228Qv());
        this.c = (C7228Qv) c19084pl0.z(3, new C7228Qv());
        this.d = Long.valueOf(c19084pl0.y(4));
        this.e = Long.valueOf(c19084pl0.y(5));
    }

    public C7228Qv q() {
        return this.c;
    }

    public C7228Qv r() {
        return this.b;
    }

    public C7228Qv s() {
        return this.a;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C7228Qv c7228Qv = this.a;
        if (c7228Qv != null) {
            c19675ql0.i(1, c7228Qv);
        }
        C7228Qv c7228Qv2 = this.b;
        if (c7228Qv2 != null) {
            c19675ql0.i(2, c7228Qv2);
        }
        C7228Qv c7228Qv3 = this.c;
        if (c7228Qv3 != null) {
            c19675ql0.i(3, c7228Qv3);
        }
        Long l = this.d;
        if (l != null) {
            c19675ql0.g(4, l.longValue());
        }
        Long l2 = this.e;
        if (l2 != null) {
            c19675ql0.g(5, l2.longValue());
        }
    }

    public String toString() {
        return "struct Avatar{}";
    }

    public C6984Pv() {
    }
}
