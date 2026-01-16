package ir.nasim;

/* renamed from: ir.nasim.Ez, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C4401Ez extends AbstractC17902nl0 {
    private C4650Fz a;

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = (C4650Fz) c19084pl0.z(1, new C4650Fz());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        C4650Fz c4650Fz = this.a;
        if (c4650Fz != null) {
            c19675ql0.i(1, c4650Fz);
        }
    }

    public String toString() {
        return "struct MessageSearchItem{}";
    }
}
