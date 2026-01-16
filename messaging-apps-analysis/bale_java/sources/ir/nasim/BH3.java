package ir.nasim;

/* loaded from: classes5.dex */
public final class BH3 extends OG3 {
    private int g;
    private String h;

    public BH3(String str, String str2, String str3, int i, String str4, int i2, String str5) {
        super(str, str2, str3, i, str4, null);
        this.g = i2;
        this.h = str5;
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        super.parse(c19084pl0);
        this.g = c19084pl0.g(10);
        this.h = c19084pl0.A(11);
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        super.serialize(c19675ql0);
        c19675ql0.f(10, this.g);
        String str = this.h;
        if (str != null) {
            c19675ql0.o(11, str);
        }
    }

    public final int y() {
        return this.g;
    }

    public final String z() {
        return this.h;
    }

    public BH3(byte[] bArr) {
        super(bArr);
    }
}
