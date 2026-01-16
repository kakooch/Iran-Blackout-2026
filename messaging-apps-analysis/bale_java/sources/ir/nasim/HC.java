package ir.nasim;

/* loaded from: classes4.dex */
public class HC extends AbstractC17902nl0 {
    private int a;
    private String b;
    private C4626Fy c;
    private C4626Fy d;
    private C4626Fy e;

    public HC(int i, String str, C4626Fy c4626Fy, C4626Fy c4626Fy2, C4626Fy c4626Fy3) {
        this.a = i;
        this.b = str;
        this.c = c4626Fy;
        this.d = c4626Fy2;
        this.e = c4626Fy3;
    }

    @Override // ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        this.a = c19084pl0.g(1);
        this.b = c19084pl0.A(2);
        this.c = (C4626Fy) c19084pl0.z(3, new C4626Fy());
        this.d = (C4626Fy) c19084pl0.z(4, new C4626Fy());
        this.e = (C4626Fy) c19084pl0.z(5, new C4626Fy());
    }

    public String q() {
        return this.b;
    }

    public int r() {
        return this.a;
    }

    public C4626Fy s() {
        return this.c;
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
        C4626Fy c4626Fy2 = this.d;
        if (c4626Fy2 != null) {
            c19675ql0.i(4, c4626Fy2);
        }
        C4626Fy c4626Fy3 = this.e;
        if (c4626Fy3 != null) {
            c19675ql0.i(5, c4626Fy3);
        }
    }

    public String toString() {
        return "struct StickerDescriptor{}";
    }

    public C4626Fy u() {
        return this.e;
    }

    public C4626Fy w() {
        return this.d;
    }

    public HC() {
    }
}
