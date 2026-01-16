package ir.nasim;

/* loaded from: classes5.dex */
public final class GG3 extends OG3 {
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private byte[] l;

    public GG3(String str, String str2, String str3, int i, String str4, String str5, String str6, String str7, String str8, RG3 rg3, byte[] bArr, int i2) {
        super(str, str2, str3, i, str4, rg3);
        this.g = str5;
        this.h = str6;
        this.i = str7;
        this.j = str8;
        this.l = bArr;
        this.k = i2;
    }

    public final byte[] C() {
        return this.l;
    }

    public final int D() {
        return this.k;
    }

    public final String E() {
        return this.j;
    }

    public final String F() {
        return this.i;
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void parse(C19084pl0 c19084pl0) {
        AbstractC13042fc3.i(c19084pl0, "values");
        super.parse(c19084pl0);
        this.g = c19084pl0.r(10);
        this.h = c19084pl0.r(11);
        this.i = c19084pl0.r(12);
        this.j = c19084pl0.r(13);
        this.l = c19084pl0.v(14);
        this.k = c19084pl0.g(15);
    }

    @Override // ir.nasim.OG3, ir.nasim.AbstractC17902nl0
    public void serialize(C19675ql0 c19675ql0) {
        AbstractC13042fc3.i(c19675ql0, "writer");
        super.serialize(c19675ql0);
        String str = this.g;
        AbstractC13042fc3.f(str);
        c19675ql0.o(10, str);
        String str2 = this.h;
        AbstractC13042fc3.f(str2);
        c19675ql0.o(11, str2);
        String str3 = this.i;
        AbstractC13042fc3.f(str3);
        c19675ql0.o(12, str3);
        String str4 = this.j;
        AbstractC13042fc3.f(str4);
        c19675ql0.o(13, str4);
        byte[] bArr = this.l;
        if (bArr != null) {
            AbstractC13042fc3.f(bArr);
            c19675ql0.b(14, bArr);
        }
        c19675ql0.f(15, this.k);
    }

    public final String y() {
        return this.h;
    }

    public final String z() {
        return this.g;
    }

    public GG3(byte[] bArr) {
        super(bArr);
    }
}
