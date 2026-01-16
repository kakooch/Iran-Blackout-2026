package ir.nasim;

/* renamed from: ir.nasim.nD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17584nD extends AbstractC19948rD {
    private C18766pD a;
    private Boolean b;
    private Long c;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C18766pD) c19084pl0.z(1, new C18766pD());
        this.b = Boolean.valueOf(c19084pl0.u(2));
        this.c = Long.valueOf(c19084pl0.y(3));
    }

    @Override // ir.nasim.AbstractC19948rD
    public int s() {
        return 2;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C18766pD c18766pD = this.a;
        if (c18766pD != null) {
            c19675ql0.i(1, c18766pD);
        }
        Boolean bool = this.b;
        if (bool != null) {
            c19675ql0.a(2, bool.booleanValue());
        }
        Long l = this.c;
        if (l != null) {
            c19675ql0.g(3, l.longValue());
        }
    }

    public String toString() {
        return "struct UserOffline{}";
    }
}
