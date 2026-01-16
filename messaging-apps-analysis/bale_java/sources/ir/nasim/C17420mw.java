package ir.nasim;

/* renamed from: ir.nasim.mw, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C17420mw extends AbstractC17902nl0 {
    private C19811qz a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C19811qz) c19084pl0.z(1, new C19811qz());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C19811qz c19811qz = this.a;
        if (c19811qz != null) {
            c19675ql0.i(1, c19811qz);
        }
    }

    public String toString() {
        return "struct BillParameters{}";
    }
}
