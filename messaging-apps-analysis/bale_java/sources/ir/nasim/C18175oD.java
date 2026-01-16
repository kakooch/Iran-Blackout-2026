package ir.nasim;

/* renamed from: ir.nasim.oD, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C18175oD extends AbstractC19948rD {
    private C18766pD a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C18766pD) c19084pl0.z(1, new C18766pD());
    }

    @Override // ir.nasim.AbstractC19948rD
    public int s() {
        return 1;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C18766pD c18766pD = this.a;
        if (c18766pD != null) {
            c19675ql0.i(1, c18766pD);
        }
    }

    public String toString() {
        return "struct UserOnline{}";
    }
}
