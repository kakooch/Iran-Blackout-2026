package ir.nasim;

/* loaded from: classes5.dex */
public final class SG3 extends OG3 {
    private int g;
    private int h;
    private int i;

    public SG3(String str, String str2, String str3, int i, String str4, RG3 rg3, int i2, int i3, int i4) {
        super(str, str2, str3, i, str4, rg3);
        this.g = i2;
        this.h = i3;
        this.i = i4;
    }

    public final int C() {
        return this.g;
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        super.parse(c19084pl0);
        this.g = c19084pl0.g(10);
        this.h = c19084pl0.g(11);
        this.i = c19084pl0.g(12);
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        super.serialize(c19675ql0);
        c19675ql0.f(10, this.g);
        c19675ql0.f(11, this.h);
        c19675ql0.f(12, this.i);
    }

    public final int y() {
        return this.i;
    }

    public final int z() {
        return this.h;
    }

    public SG3(byte[] bArr) {
        super(bArr);
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }
}
