package ir.nasim;

/* renamed from: ir.nasim.c06, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C10675c06 extends AbstractC10365bX5 {
    private GC b;

    public static C10675c06 s(byte[] bArr) {
        return (C10675c06) AbstractC16720ll0.b(new C10675c06(), bArr);
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.b = (GC) c19084pl0.z(1, new GC());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        GC gc = this.b;
        if (gc != null) {
            c19675ql0.i(1, gc);
        }
    }

    public String toString() {
        return "response LoadStickerCollection{}";
    }
}
