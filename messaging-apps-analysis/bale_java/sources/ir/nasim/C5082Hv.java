package ir.nasim;

/* renamed from: ir.nasim.Hv, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C5082Hv extends AbstractC17902nl0 {
    private int a;
    private String b;
    private C4626Fy c;

    public C5082Hv(int i, String str, C4626Fy c4626Fy) {
        this.a = i;
        this.b = str;
        this.c = c4626Fy;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.A(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        c19675ql0.f(1, this.a);
        String str = this.b;
        if (str != null) {
            c19675ql0.o(2, str);
        }
        C4626Fy c4626Fy = this.c;
        if (c4626Fy != null) {
            c19675ql0.i(3, c4626Fy);
        }
    }

    public String toString() {
        return "struct AnimatedStickerDescriptor{}";
    }

    public C5082Hv() {
    }
}
